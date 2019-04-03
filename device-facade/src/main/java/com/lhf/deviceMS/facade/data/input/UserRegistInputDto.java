package com.lhf.deviceMS.facade.data.input;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.lhf.deviceMS.common.std.WebException;
import com.lhf.deviceMS.common.std.enums.WebErrCode;
import com.lhf.deviceMS.domain.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

public class UserRegistInputDto {
    private String name;
    private String gender;
    private String phone;
    private String email;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public UserRegistInputDto verify() throws WebException {
        if (StringUtils.isBlank(name)||
            StringUtils.isBlank(gender)||
            StringUtils.isBlank(phone)||
            StringUtils.isBlank(email)||
            StringUtils.isBlank(password)){
            throw new WebException(WebErrCode.DEVICE_COMMON_INVALID_PARAM);
        }
        return this;
    }

    public User transform(){
        User user = new User();
        BeanUtils.copyProperties(this,user);
        return user;
    }
}
