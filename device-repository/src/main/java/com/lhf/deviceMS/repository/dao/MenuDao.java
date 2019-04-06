package com.lhf.deviceMS.repository.dao;

import com.lhf.deviceMS.common.utils.TimeUtils;
import com.lhf.deviceMS.domain.entity.Menu;
import com.lhf.deviceMS.domain.entity.RoleMenu;
import com.lhf.deviceMS.repository.mapper.MenuMapper;
import com.lhf.deviceMS.repository.mapper.RoleMenuMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class MenuDao {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    public List<Menu> queryMenus(String role) {
        Objects.requireNonNull(role);

        List<Long> menuIds = this.queryMenuIds(role);
        if (CollectionUtils.isEmpty(menuIds)){
            return Collections.emptyList();
        }

        Weekend<Menu> weekend = new Weekend<>(Menu.class);
        weekend.weekendCriteria().andIsNull(Menu::getDeletedAt).andIn(Menu::getId,menuIds);

        return menuMapper.selectByExample(weekend);
    }

    private List<Long> queryMenuIds(String role) {
        Objects.requireNonNull(role);

        Weekend<RoleMenu> weekend = new Weekend<>(RoleMenu.class);
        weekend.weekendCriteria().andIsNull(RoleMenu::getDeletedAt).andEqualTo(RoleMenu::getRole,role);
        RoleMenu roleMenu = roleMenuMapper.selectOneByExample(weekend);

        if (roleMenu==null){
            return Collections.emptyList();
        }

        String menus = roleMenu.getMenus();
        if (StringUtils.isNotBlank(menus)){
            List<String> strings = Arrays.asList(menus.split(","));
            List<Long> ids = strings.stream().map(s -> Long.valueOf(s)).collect(Collectors.toList());
            return ids;
        }
        return Collections.emptyList();
    }

    public void merge(RoleMenu roleMenu) {
        Objects.requireNonNull(roleMenu);

        if (roleMenu.getId()==null){
            roleMenu.setCreatedAt(TimeUtils.currentTime());
            roleMenuMapper.insertSelective(roleMenu);
        }else{
            roleMenuMapper.updateByPrimaryKeySelective(roleMenu);
        }
    }

    public RoleMenu queryRoleMenuByRole(String role) {
        Weekend<RoleMenu> weekend = new Weekend<>(RoleMenu.class);
        weekend.weekendCriteria().andIsNull(RoleMenu::getDeletedAt).andEqualTo(RoleMenu::getRole,role);
        return roleMenuMapper.selectOneByExample(weekend);
    }
}
