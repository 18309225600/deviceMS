package com.lhf.deviceMS.facade.data.input;


public class RoleMenusInputDto {
    private String role;
    private Long[] menus;


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long[] getMenus() {
        return menus;
    }

    public void setMenus(Long[] menus) {
        this.menus = menus;
    }
}
