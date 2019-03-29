package com.lhf.deviceMS.common.dynamicDB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author lhf
 * @Description
 * @Date 2019/2/20 12:43
 * @Version 1.0
 *
 * 每个线程中存储的当前线程的注解上标注的数据源
 **/
@Component
public class DBHelper {
    private ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    private Logger logger = LoggerFactory.getLogger(DBHelper.class);
    public String get(){
        String dataSource = this.contextHolder.get();
        if (dataSource==null||dataSource.trim().length()<1){
            //默认master
            dataSource = DataSourceType.MASTER;
        }
        logger.info("choose dataSource is {}",dataSource);
        return dataSource;
    }

    public void set(String dataSource){
        this.contextHolder.set(dataSource);
    }

    public void clean(){
        this.contextHolder.remove();
    }

}
