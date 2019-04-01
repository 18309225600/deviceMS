package com.lhf.deviceMS.domain.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "device_log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 日志类型：nomal正常   abnomal异常
     */
    @Column(name = "log_type")
    private String logType;

    /**
     * 操作者ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 操作者
     */
    private String username;

    /**
     * 操作内容
     */
    private String operation;

    /**
     * 操作方法名
     */
    @Column(name = "method_name")
    private String methodName;

    /**
     * 请求方式
     */
    @Column(name = "request_method")
    private String requestMethod;

    /**
     * 请求参数
     */
    @Column(name = "request_param")
    private String requestParam;

    /**
     * 远端IP
     */
    @Column(name = "remote_ip")
    private String remoteIp;

    /**
     * 请求uri
     */
    @Column(name = "request_uri")
    private String requestUri;

    /**
     * 异常CODE
     */
    @Column(name = "exception_code")
    private String exceptionCode;

    /**
     * 异常信息
     */
    @Column(name = "exception_msg")
    private String exceptionMsg;

    /**
     * 请求耗时(毫秒）
     */
    @Column(name = "time_consuming")
    private Integer timeConsuming;

    /**
     * 请求者信息
     */
    @Column(name = "user_agent")
    private String userAgent;

    /**
     * 创建时间
     */
    @Column(name = "created_at")
    private Date createdAt;

    /**
     * 删除时间
     */
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
     * 获取日志类型：nomal正常   abnomal异常
     *
     * @return log_type - 日志类型：nomal正常   abnomal异常
     */
    public String getLogType() {
        return logType;
    }

    /**
     * 设置日志类型：nomal正常   abnomal异常
     *
     * @param logType 日志类型：nomal正常   abnomal异常
     */
    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    /**
     * 获取操作者ID
     *
     * @return user_id - 操作者ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置操作者ID
     *
     * @param userId 操作者ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取操作者
     *
     * @return username - 操作者
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置操作者
     *
     * @param username 操作者
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取操作内容
     *
     * @return operation - 操作内容
     */
    public String getOperation() {
        return operation;
    }

    /**
     * 设置操作内容
     *
     * @param operation 操作内容
     */
    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    /**
     * 获取操作方法名
     *
     * @return method_name - 操作方法名
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * 设置操作方法名
     *
     * @param methodName 操作方法名
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    /**
     * 获取请求方式
     *
     * @return request_method - 请求方式
     */
    public String getRequestMethod() {
        return requestMethod;
    }

    /**
     * 设置请求方式
     *
     * @param requestMethod 请求方式
     */
    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod == null ? null : requestMethod.trim();
    }

    /**
     * 获取请求参数
     *
     * @return request_param - 请求参数
     */
    public String getRequestParam() {
        return requestParam;
    }

    /**
     * 设置请求参数
     *
     * @param requestParam 请求参数
     */
    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam == null ? null : requestParam.trim();
    }

    /**
     * 获取远端IP
     *
     * @return remote_ip - 远端IP
     */
    public String getRemoteIp() {
        return remoteIp;
    }

    /**
     * 设置远端IP
     *
     * @param remoteIp 远端IP
     */
    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp == null ? null : remoteIp.trim();
    }

    /**
     * 获取请求uri
     *
     * @return request_uri - 请求uri
     */
    public String getRequestUri() {
        return requestUri;
    }

    /**
     * 设置请求uri
     *
     * @param requestUri 请求uri
     */
    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri == null ? null : requestUri.trim();
    }

    /**
     * 获取异常CODE
     *
     * @return exception_code - 异常CODE
     */
    public String getExceptionCode() {
        return exceptionCode;
    }

    /**
     * 设置异常CODE
     *
     * @param exceptionCode 异常CODE
     */
    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode == null ? null : exceptionCode.trim();
    }

    /**
     * 获取异常信息
     *
     * @return exception_msg - 异常信息
     */
    public String getExceptionMsg() {
        return exceptionMsg;
    }

    /**
     * 设置异常信息
     *
     * @param exceptionMsg 异常信息
     */
    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg == null ? null : exceptionMsg.trim();
    }

    /**
     * 获取请求耗时(毫秒）
     *
     * @return time_consuming - 请求耗时(毫秒）
     */
    public Integer getTimeConsuming() {
        return timeConsuming;
    }

    /**
     * 设置请求耗时(毫秒）
     *
     * @param timeConsuming 请求耗时(毫秒）
     */
    public void setTimeConsuming(Integer timeConsuming) {
        this.timeConsuming = timeConsuming;
    }

    /**
     * 获取请求者信息
     *
     * @return user_agent - 请求者信息
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * 设置请求者信息
     *
     * @param userAgent 请求者信息
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent == null ? null : userAgent.trim();
    }

    /**
     * 获取创建时间
     *
     * @return created_at - 创建时间
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置创建时间
     *
     * @param createdAt 创建时间
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 获取删除时间
     *
     * @return deleted_at - 删除时间
     */
    public Date getDeletedAt() {
        return deletedAt;
    }

    /**
     * 设置删除时间
     *
     * @param deletedAt 删除时间
     */
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}