package com.lhf.deviceMS.common.dynamicDB;

import java.lang.annotation.*;

/**
 * @Author mjy
 * @Description
 * @Date 2019/1/29 19:19
 * @Version 1.0
 *
 * 切换数据源注解
 **/
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value() default DataSourceType.MASTER;
}
