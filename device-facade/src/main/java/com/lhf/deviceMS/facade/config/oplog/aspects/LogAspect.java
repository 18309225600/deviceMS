package com.lhf.deviceMS.facade.config.oplog.aspects;

import com.lhf.deviceMS.common.utils.SessionUtils;
import com.lhf.deviceMS.domain.entity.Log;
import com.lhf.deviceMS.domain.enums.Status;
import com.lhf.deviceMS.facade.config.oplog.annotations.OpLog;
import com.lhf.deviceMS.service.LogService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * {@Log} 注解处理的切面类实现
 */
@Aspect
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    //记录开始时间
    protected ThreadLocal<Instant> start = new ThreadLocal<>();

    //日志
    protected ThreadLocal<Log> log = new ThreadLocal<>();

    //日志持久化客户端
    @Autowired
    private LogService logService;

    //http请求
    @Autowired
    private HttpServletRequest request;

    /**
     * 日志切入点
     */
    @Pointcut(value = "@annotation(com.lhf.deviceMS.facade.config.oplog.annotations.OpLog)")
    public void logPointCut(){}

    /**
     * 前置通知
     * @param joinPoint 切点
     */
    @Before("logPointCut()")
    public void logBefore(JoinPoint joinPoint){
        try{
            cleanRefresh();
            this.start.set(Instant.now());

            Log mergeLog = new Log();
            mergeLog.setCreatedAt(new Date());
            mergeLog.setLogType(Status.NOMAL.toString());
            mergeLog.setUserId(SessionUtils.getUserId());
            mergeLog.setUsername(SessionUtils.getUsername());
            mergeLog.setOperation(getMethodDescription(joinPoint));
            mergeLog.setMethodName(getMethodName(joinPoint));
            mergeLog.setRequestMethod(request.getMethod());
            mergeLog.setRequestParam(getRequestParam(request.getParameterMap()));
            mergeLog.setRemoteIp(request.getRemoteAddr());
            mergeLog.setRequestUri(request.getRequestURI());
            mergeLog.setUserAgent(request.getHeader("user-agent"));

            log.set(mergeLog);
        }catch(Exception e) {
            logger.error("异常信息:{}", e);
        }
    }

    /**
     * 切点在return之后切入内容
     * @param ret
     */
    @AfterReturning(returning = "ret",pointcut = "logPointCut()")
    public void logAfterReturning(Object ret){
        Log mergeLog = log.get();
        mergeLog.setTimeConsuming(Integer.valueOf(String.valueOf(Duration.between(this.start.get(),Instant.now()).toMillis())));
        logService.save(mergeLog);
    }

    /**
     * 异常通知
     * @param joinPoint 切点
     * @param e 异常信息
     */
    @AfterThrowing(pointcut = "logPointCut()",throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint,Throwable e){
        Map<String,String[]> requestParams = new HashMap<>();
        //请求的参数
        Object[] args = joinPoint.getArgs();

        try {
            Log mergeLog = log.get();

            mergeLog.setTimeConsuming(Integer.valueOf(String.valueOf(Duration.between(this.start.get(),Instant.now()).toMillis())));
            mergeLog.setLogType(Status.ABNOMAL.toString());

            mergeLog.setExceptionMsg(e.getMessage());
            mergeLog.setUserAgent(request.getHeader("user-agent"));
            //保存数据库
            logService.save(mergeLog);
        }  catch (Throwable ex) {
            //记录本地异常日志
            logger.error("异常方法全路径:{},异常信息:{},请求参数:{}", getMethodName(joinPoint), ex, args);
        }
    }


    private void cleanRefresh() {
        this.start.remove();
        this.log.remove();
    }

    private String getMethodDescription(JoinPoint joinPoint) {
        String description = "";
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        OpLog opLog = method.getAnnotation(OpLog.class);
        if(null != opLog){
            description = opLog.value();
        }
        return description;
    }

    private String getRequestParam(Map<String, String[]> paramMap) {
        if (paramMap == null) {
            return "";
        }
        StringBuilder params = new StringBuilder();
        for (Map.Entry<String, String[]> param : paramMap.entrySet()) {
            String key = param.getKey();
            String[] value = param.getValue();
            if (StringUtils.isNotBlank(key)){
                params.append(key).append(":").append(Arrays.toString(value)).append(",");
            }
        }
        return params.toString();
    }

    private String getMethodName(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        //请求的方法名全路径
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();

        return className + "." + methodName + "()";
    }


}
