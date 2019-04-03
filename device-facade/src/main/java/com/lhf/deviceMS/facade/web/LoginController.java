package com.lhf.deviceMS.facade.web;

import com.lhf.deviceMS.common.std.WebException;
import com.lhf.deviceMS.domain.entity.User;
import com.lhf.deviceMS.domain.vo.IndexTotalVo;
import com.lhf.deviceMS.facade.data.input.UserRegistInputDto;
import com.lhf.deviceMS.service.IndexService;
import com.lhf.deviceMS.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private IndexService indexService;

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * 登录页
     * @return
     */
    @GetMapping("/page")
    public String page(){
        return "login/login";
    }

    /**
     * 登录
     * @param request
     * @param email
     * @param password
     * @return
     */
    @PostMapping("/exe")
    public String login(Map model,HttpServletRequest request,String email, String password) throws WebException {
        logger.info("user login email={},pass={}",email,password);
        String message = userService.login(request,email, password);
        if (StringUtils.isBlank(message)){
            IndexTotalVo vo = indexService.buildIndexData();
            model.put("indexData",vo);
            return "index";
        }else{
            model.put("msg",message);
            return "login/login";
        }

    }

    /**
     * 注册页
     * @return
     */
    @GetMapping("/regist")
    public String registPage(){
        return "regist/regist";
    }

    /**
     * 注册
     * @param input
     * @param model
     * @return
     * @throws WebException
     */
    @PostMapping("/regist")
    public String regist(UserRegistInputDto input, Map model) throws WebException {
        User inputUser = input.verify().transform();
        userService.regist(inputUser);
        model.put("msg","regist succ");
        return "login/login";
    }
}
