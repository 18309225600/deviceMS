package com.lhf.deviceMS.facade.web;

import com.lhf.deviceMS.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by lhf on 2019/2/23
 **/
@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/sendText")
    public void sendMail(String to,String subject,String content){
        mailService.sendSimpleMail(to,subject,content);
    }

    @PostMapping("/sendInlineResource")
    public void sendMail(String to, String subject, String content, String rscPath, String rscId){
        mailService.sendInlineResourceMail(to,subject,content,rscPath,rscId);
    }

    @PostMapping("/sendAttach")
    public void sendMail(String to, String subject, String content, String filePath){
        mailService.sendAttachmentsMail(to,subject,content,filePath);
    }

    @PostMapping("/sendHtml")
    public void sendHtmlMail(String to,String subject,String content){
        mailService.sendHtmlMail(to,subject,content);
    }
}
