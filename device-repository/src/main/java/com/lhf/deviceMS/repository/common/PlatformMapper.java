package com.lhf.deviceMS.repository.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

public interface PlatformMapper<T> extends Mapper<T>
        , InsertListMapper<T> {
}
