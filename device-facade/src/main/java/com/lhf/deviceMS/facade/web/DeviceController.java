package com.lhf.deviceMS.facade.web;

import com.github.pagehelper.PageInfo;
import com.lhf.deviceMS.common.std.PageIn;
import com.lhf.deviceMS.domain.entity.Detail;
import com.lhf.deviceMS.facade.config.oplog.annotations.OpLog;
import com.lhf.deviceMS.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    /**
     * 设备列表
     * @param model
     * @param page
     * @return
     */
    @GetMapping("/list")
    @OpLog("读取设备列表")
    public String list(Map model, PageIn page){
        PageInfo<Detail> pageInfo = deviceService.list(page.getPageNo(),page.getPageSize());
        model.put("pageNo",page.getPageNo());
        model.put("list",pageInfo);
        return "modules/deviceList/list";
    }


    public String addPage(){
        return "";
    }
}
