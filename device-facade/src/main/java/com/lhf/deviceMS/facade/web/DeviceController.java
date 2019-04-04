package com.lhf.deviceMS.facade.web;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.lhf.deviceMS.common.std.PageIn;
import com.lhf.deviceMS.domain.entity.Detail;
import com.lhf.deviceMS.facade.config.oplog.annotations.OpLog;
import com.lhf.deviceMS.facade.data.input.DeviceAddInputDto;
import com.lhf.deviceMS.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    private Logger logger = LoggerFactory.getLogger(DeviceController.class);

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

    /**
     * 添加设备页面
     * @return
     */
    @GetMapping("/addPage")
    public String addPage(){
        return "modules/deviceList/addPage";
    }

    @ResponseBody
    @PostMapping("/add")
    public String add(DeviceAddInputDto input){
        logger.info("添加设备参数: {}", JSONObject.toJSONString(input));
        
        return "succ";
    }
}
