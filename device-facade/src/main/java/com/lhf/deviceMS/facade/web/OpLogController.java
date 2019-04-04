package com.lhf.deviceMS.facade.web;

import com.github.pagehelper.PageInfo;
import com.lhf.deviceMS.common.std.PageIn;
import com.lhf.deviceMS.domain.entity.Log;
import com.lhf.deviceMS.facade.config.oplog.annotations.OpLog;
import com.lhf.deviceMS.service.OpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/opLog")
public class OpLogController {

    @Autowired
    private OpLogService opLogService;

    /**
     * 操作日志列表
     * @param model
     * @param page
     * @return
     */
    @GetMapping("/list")
    public String list(Map model, PageIn page){
        PageInfo<Log> pageInfo = opLogService.list(page.getPageNo(),page.getPageSize());
        model.put("pageNo",page.getPageNo());
        model.put("list",pageInfo);
        return "modules/opLog/list";
    }
}
