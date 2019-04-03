package com.lhf.deviceMS.facade.web;

import com.lhf.deviceMS.domain.vo.IndexTotalVo;
import com.lhf.deviceMS.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    /**
     * 首页
     * @param model
     * @return
     */
    @GetMapping
    public String toIndex(Map model){
        IndexTotalVo vo = indexService.buildIndexData();
        model.put("indexData",vo);
        return "index";
    }

    /**
     * 登录页 废弃
     * @return
     */
    @Deprecated
    @GetMapping("/home")
    public String home(){
        return "login/login";
    }
}
