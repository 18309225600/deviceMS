package com.lhf.deviceMS.domain.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "device_menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单CODE
     */
    private String code;

    /**
     * 菜单url
     */
    private String url;

    /**
     * 菜单样式
     */
    private String style;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "deleted_at")
    private Date deletedAt;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取菜单名称
     *
     * @return name - 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名称
     *
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取菜单CODE
     *
     * @return code - 菜单CODE
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置菜单CODE
     *
     * @param code 菜单CODE
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取菜单url
     *
     * @return url - 菜单url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置菜单url
     *
     * @param url 菜单url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取菜单样式
     *
     * @return style - 菜单样式
     */
    public String getStyle() {
        return style;
    }

    /**
     * 设置菜单样式
     *
     * @param style 菜单样式
     */
    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    /**
     * @return created_at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return deleted_at
     */
    public Date getDeletedAt() {
        return deletedAt;
    }

    /**
     * @param deletedAt
     */
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}