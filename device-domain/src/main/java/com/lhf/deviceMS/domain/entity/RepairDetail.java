package com.lhf.deviceMS.domain.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "device_repair_detail")
public class RepairDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 设备ID
     */
    @Column(name = "device_id")
    private Long deviceId;

    /**
     * 维修人员ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 设备CODE
     */
    @Column(name = "device_code")
    private String deviceCode;

    /**
     * 设备名称
     */
    @Column(name = "device_name")
    private String deviceName;

    /**
     * 维修人员名称
     */
    @Column(name = "user_name")
    private String userName;

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
     * 获取设备ID
     *
     * @return device_id - 设备ID
     */
    public Long getDeviceId() {
        return deviceId;
    }

    /**
     * 设置设备ID
     *
     * @param deviceId 设备ID
     */
    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 获取维修人员ID
     *
     * @return user_id - 维修人员ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置维修人员ID
     *
     * @param userId 维修人员ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取设备CODE
     *
     * @return device_code - 设备CODE
     */
    public String getDeviceCode() {
        return deviceCode;
    }

    /**
     * 设置设备CODE
     *
     * @param deviceCode 设备CODE
     */
    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode == null ? null : deviceCode.trim();
    }

    /**
     * 获取设备名称
     *
     * @return device_name - 设备名称
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * 设置设备名称
     *
     * @param deviceName 设备名称
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    /**
     * 获取维修人员名称
     *
     * @return user_name - 维修人员名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置维修人员名称
     *
     * @param userName 维修人员名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
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