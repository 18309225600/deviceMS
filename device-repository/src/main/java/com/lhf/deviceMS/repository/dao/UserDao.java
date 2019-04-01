package com.lhf.deviceMS.repository.dao;

import com.lhf.deviceMS.common.utils.TimeUtils;
import com.lhf.deviceMS.domain.entity.User;
import com.lhf.deviceMS.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.List;
import java.util.Objects;

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public List<User> queryUserByEmail(String email) {
        Objects.requireNonNull(email);
        Weekend<User> weekend = new Weekend<>(User.class);
        weekend.weekendCriteria().andIsNull(User::getDeletedAt).andEqualTo(User::getEmail,email);
        return userMapper.selectByExample(email);
    }

    public void merge(User user) {
        Objects.requireNonNull(user);
        if (user.getId()==null){
            user.setCreatedAt(TimeUtils.currentTime());
            userMapper.insertSelective(user);
        }else{
            userMapper.updateByPrimaryKeySelective(user);
        }
    }
}
