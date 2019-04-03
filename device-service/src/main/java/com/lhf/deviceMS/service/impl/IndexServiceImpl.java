package com.lhf.deviceMS.service.impl;

import com.lhf.deviceMS.domain.enums.DeviceStatus;
import com.lhf.deviceMS.domain.vo.IndexTotalVo;
import com.lhf.deviceMS.repository.dao.DeviceDao;
import com.lhf.deviceMS.repository.dao.UserDao;
import com.lhf.deviceMS.service.IndexService;
import com.lhf.deviceMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lhf
 * @Description
 * @Date 2019/4/3 10:12
 * @Version 1.0
 **/
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private DeviceDao deviceDao;

    @Autowired
    private UserDao userDao;

    @Override
    public IndexTotalVo buildIndexData() {
        IndexTotalVo vo = new IndexTotalVo();
        vo.setDeviceNum(deviceDao.queryTotalByStatus(DeviceStatus.NOMAL));
        vo.setDumpNum(deviceDao.queryTotalByStatus(DeviceStatus.DUMPED));
        vo.setRepairNum(deviceDao.queryTotalByStatus(DeviceStatus.REPAIRING));
        vo.setUserNum(userDao.queryTotal());
        return vo;
    }
}
