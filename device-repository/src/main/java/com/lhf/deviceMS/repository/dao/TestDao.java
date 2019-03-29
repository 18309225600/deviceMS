package com.lhf.deviceMS.repository.dao;

import com.lhf.deviceMS.domain.entity.User;
import com.lhf.deviceMS.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.List;

@Repository
public class TestDao {

    @Autowired
    private UserMapper userMapper;

    public String search(){
        Weekend<User> weekend = new Weekend<>(User.class);
        weekend.weekendCriteria().andLike(User::getPhone,"%60011224%");
        List<User> users = userMapper.selectByExample(weekend);
        return users.toString();
    }



    public void insert(User user) {
        userMapper.insertSelective(user);
    }


    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
}

