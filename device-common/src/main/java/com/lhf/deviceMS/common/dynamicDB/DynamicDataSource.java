package com.lhf.deviceMS.common.dynamicDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author mjy
 * @Description
 * @Date 2019/2/20 12:42
 * @Version 1.0
 *
 * spring提供的动态路由数据源的类，每次都是从AbstractRoutingDataSource中取数据源
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Autowired
    private DBHelper dbHelper;
    @Override
    protected Object determineCurrentLookupKey() {
        String chooseDB = dbHelper.get();
        return chooseDB;
    }
}
