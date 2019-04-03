package com.lhf.deviceMS.facade.config.common;

import com.lhf.deviceMS.common.std.WebException;
import com.lhf.deviceMS.domain.vo.IndexTotalVo;
import com.lhf.deviceMS.service.IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private IndexService indexService;

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(WebException.class)
    public String exceptionHandler(Model model,WebException e) {
        logger.error("invoke api error",e);
        model.addAttribute("msg",e.getMsg());

        IndexTotalVo vo = indexService.buildIndexData();
        model.addAttribute("indexData",vo);

        return "index";
    }


    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Model model,Exception e) {
        logger.error("invoke api error",e);
        model.addAttribute("msg","系统错误!请登录后重试或联系管理员");
        return "login/login";
    }
}
