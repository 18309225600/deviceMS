package com.lhf.deviceMS.repository.dao;

import com.lhf.deviceMS.domain.entity.TestUser;
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
        Weekend<TestUser> weekend = new Weekend<>(TestUser.class);
        weekend.weekendCriteria().andLike(TestUser::getPhone,"%60011224%");
        List<TestUser> testUsers = userMapper.selectByExample(weekend);
        return testUsers.toString();
    }



    public void insert(TestUser testUser) {
        userMapper.insertSelective(testUser);
    }


    public void update(TestUser testUser) {
        userMapper.updateByPrimaryKeySelective(testUser);
    }
}

