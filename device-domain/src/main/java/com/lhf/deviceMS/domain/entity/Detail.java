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
     * 最后一次维修时间
     */
    @Column(name = "last_repair_at")
    private Date lastRepairAt;

    /**
     * 是否报废
     */
    private String dumped;

    /**
     * 购买时间
     */
    @Column(name = "buy_at")
    private Date buyAt;

    private String status;

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
     * 获取最后一次维修时间
     *
     * @return last_repair_at - 最后一次维修时间
     */
    public Date getLastRepairAt() {
        return lastRepairAt;
    }

    /**
     * 设置最后一次维修时间
     *
     * @param lastRepairAt 最后一次维修时间
     */
    public void setLastRepairAt(Date lastRepairAt) {
        this.lastRepairAt = lastRepairAt;
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
     * 获取购买时间
     *
     * @return buy_at - 购买时间
     */
    public Date getBuyAt() {
        return buyAt;
    }

    /**
     * 设置购买时间
     *
     * @param buyAt 购买时间
     */
    public void setBuyAt(Date buyAt) {
        this.buyAt = buyAt;
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