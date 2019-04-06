package com.lhf.deviceMS.service.task;

import com.lhf.deviceMS.common.utils.LocalInfoUtils;
import com.lhf.deviceMS.common.utils.RandomUtils;
import com.lhf.deviceMS.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;

/**
 * 重置密码邮件任务
 */
public class RepassMailTask implements Runnable {

    private String email;

    private MailService mailService;

    private Integer port;

    private String subject = "设备管理系统重置密码";

    private String url = "http://"+ LocalInfoUtils.ipv4();

    private String content;

    private Long userId;

    protected Logger logger = LoggerFactory.getLogger(RepassMailTask.class);

    public RepassMailTask(String email, MailService mailService,Integer port,Long userId) throws UnknownHostException {
        this.email = email;
        this.mailService = mailService;
        this.port = port;
        this.userId = userId;
        this.content =
                "<body>" +
                    "<h1>" +
                        "你好！您正在"+"<a href='"+url+":"+port+"/index"+"'>"+"设备管理系统"+"</a>"+"中修改密码，如非本人操作，请忽略此邮件!"+
                        "<hr><a href='"+url+":"+port+"/login/"+userId+"/mRepass?id="+ RandomUtils.randomOrderId(15)+"'>"+"点我修改密码"+"</a>"+
                    "</h1>" +
                "</body";
    }

    @Override
    public void run() {
        logger.info("repass mail to email ={}",email);
        mailService.sendHtmlMail(email,subject,content);
    }
}
