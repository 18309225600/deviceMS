package com.lhf.deviceMS.facade.config.oplog.annotations;

import java.lang.annotation.*;

/**
 * 此注解用于记录操作日志
 * 凡是方法上标注了{@Log} 都会自动记录操作日志或者异常日志信息
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OpLog {
    /**
     * 日志操作描述
     * @return
     */
    String value() default "";
}
