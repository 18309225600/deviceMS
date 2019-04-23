package com.lhf.deviceMS.common.dynamicDB;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author mjy
 * @Description
 * @Date 2019/2/20 12:52
 * @Version 1.0
 *
 * 处理TargetDataSource的切面
 **/
@Aspect
@Component
@Order(0)
public class DynamicDataSourceAspect {

    @Autowired
    private DBHelper dbHelper;

    private Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Pointcut("@annotation(com.lhf.deviceMS.common.dynamicDB.TargetDataSource)")
    public void targetDataSource() {
    }

    @Before("targetDataSource()")
    public void before(JoinPoint joinPoint) {
        //获得当前访问的class
        Class<?> className = joinPoint.getTarget().getClass();

        //获得访问的方法名
        String methodName = joinPoint.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature)joinPoint.getSignature()).getParameterTypes();

        try {
            Method m = className.getMethod(methodName, argClass);
            //如果方法上存在切换数据源的注解，则根据注解内容进行数据源切换
            if (m != null && m.isAnnotationPresent(TargetDataSource.class)) {
                TargetDataSource data = m.getAnnotation(TargetDataSource.class);
                String dataSourceName = data.value();
                dbHelper.set(dataSourceName);
                logger.debug("current thread " + Thread.currentThread().getName() + " add " + dataSourceName + " to ThreadLocal");
            } else {
                logger.debug("switch datasource fail,use default");
            }
        } catch (Exception e) {
            logger.error("current thread " + Thread.currentThread().getName() + " add data to ThreadLocal error", e);
        }
    }

    @After("targetDataSource()")
    public void after(JoinPoint joinPoint){
        dbHelper.clean();
    }
}
