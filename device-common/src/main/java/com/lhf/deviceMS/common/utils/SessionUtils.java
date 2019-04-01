package com.lhf.deviceMS.common.utils;

import com.lhf.deviceMS.domain.entity.User;

/**
 * 当前登录用户Session信息
 */
public class SessionUtils {
    //线程本地变量
    private static ThreadLocal<SessionHolder> context = new ThreadLocal<>();


    public static void set(User user){
        clean();
        SessionHolder sessionHolder = new SessionHolder(user);
        context.set(sessionHolder);
    }

    public static void clean(){
        context.remove();
    }

    public static Long getUserId() {
        return context.get().getUserId();
    }

    public static String getUsername() {
        return context.get().getUserName();
    }

    public static class SessionHolder{
        private Long userId;
        private String userName;
        private String gender;
        private String phone;
        private String email;
        private Long role;

        public SessionHolder() {
        }

        public SessionHolder(User user) {
            this.userId = user.getId();
            this.userName = user.getName();
            this.gender = user.getGender();
            this.phone = user.getPhone();
            this.email = user.getEmail();
            this.role = user.getRole();
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
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

        public Long getRole() {
            return role;
        }

        public void setRole(Long role) {
            this.role = role;
        }
    }
}
