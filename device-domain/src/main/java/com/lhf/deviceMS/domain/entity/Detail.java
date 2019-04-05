package com.lhf.deviceMS.domain.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "divice_detail")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 设备编号
     */
    private String code;

    /**
     * 设备名称
     */
    private String name;

    /**
     * 更新状态人ID
     */
    @Column(name = "op_user_id")
    private Long opUserId;

    /**
     * 更新状态人
     */
    @Column(name = "op_user_name")
    private String opUserName;

    /**
     * 是否报废
     */
    private String dumped;

    private String status;

    /**
     * 价格
     */
    private Long price;

    /**
     * 设备描述
     */
    private String description;

    /**
     * 设备来源
     */
    private String source;

    /**
     * 数量
     */
    private Integer number;

    private String remark;

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
     * 获取设备编号
     *
     * @return code - 设备编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置设备编号
     *
     * @param code 设备编号
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取设备名称
     *
     * @return name - 设备名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置设备名称
     *
     * @param name 设备名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取更新状态人ID
     *
     * @return op_user_id - 更新状态人ID
     */
    public Long getOpUserId() {
        return opUserId;
    }

    /**
     * 设置更新状态人ID
     *
     * @param opUserId 更新状态人ID
     */
    public void setOpUserId(Long opUserId) {
        this.opUserId = opUserId;
    }

    /**
     * 获取更新状态人
     *
     * @return op_user_name - 更新状态人
     */
    public String getOpUserName() {
        return opUserName;
    }

    /**
     * 设置更新状态人
     *
     * @param opUserName 更新状态人
     */
    public void setOpUserName(String opUserName) {
        this.opUserName = opUserName == null ? null : opUserName.trim();
    }

    /**
     * 获取是否报废
     *
     * @return dumped - 是否报废
     */
    public String getDumped() {
        return dumped;
    }

    /**
     * 设置是否报废
     *
     * @param dumped 是否报废
     */
    public void setDumped(String dumped) {
        this.dumped = dumped == null ? null : dumped.trim();
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取价格
     *
     * @return price - 价格
     */
    public Long getPrice() {
        return price;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * 获取设备描述
     *
     * @return description - 设备描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置设备描述
     *
     * @param description 设备描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取设备来源
     *
     * @return source - 设备来源
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置设备来源
     *
     * @param source 设备来源
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 获取数量
     *
     * @return number - 数量
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置数量
     *
     * @param number 数量
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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