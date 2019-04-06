package com.lhf.deviceMS.facade.web;

import com.alibaba.fastjson.JSONObject;
import com.lhf.deviceMS.domain.entity.Menu;
import com.lhf.deviceMS.facade.config.oplog.annotations.OpLog;
import com.lhf.deviceMS.facade.data.input.RoleMenusInputDto;
import com.lhf.deviceMS.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/roleMenu")
public class RoleMenuController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(RoleMenuController.class);

    @GetMapping("/listPage")
    public String listPage(){
        return "modules/role/list";
    }

    /**
     * 角色权限
     * @param role
     * @return
     */
    @ResponseBody
    @GetMapping("/list")
    public List<Menu> list(String role){
        List<Menu> list = userService.menuListByRole(role);
        return list;
    }

    @OpLog("修改权限")
    @ResponseBody
    @PostMapping(value = "/updateRoleMenus",consumes = "application/json")
    public String updateRoleMenus(@RequestBody RoleMenusInputDto inputDto){
        logger.info("修改权限参数={}", JSONObject.toJSONString(inputDto));
        if (StringUtils.isBlank(inputDto.getRole())){
            return "请选择角色！";
        }
        String msg = userService.updateRoleMenus(inputDto.getRole(),inputDto.getMenus());
        return msg;
    }
}
