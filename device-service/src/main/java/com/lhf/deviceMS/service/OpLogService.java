package com.lhf.deviceMS.service;

import com.github.pagehelper.PageInfo;
import com.lhf.deviceMS.domain.entity.Log;

public interface OpLogService {
    PageInfo<Log> list(Integer pageNo, Integer pageSize);
}
