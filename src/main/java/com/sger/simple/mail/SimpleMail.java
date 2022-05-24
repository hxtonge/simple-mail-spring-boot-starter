package com.sger.simple.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * EmailUtil
 *
 * @author zhangshun
 * @date 2022/5/24
 */
@Slf4j
public class SimpleMail {

    private String fromEmail;

    private JavaMailSender javaMailSender;

    public SimpleMail() {
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    protected void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public boolean send(String title , String content , String toEmail){
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(fromEmail);
            simpleMailMessage.setSubject(title);
            simpleMailMessage.setText(content);
            simpleMailMessage.setTo(toEmail);
            javaMailSender.send(simpleMailMessage);
            log.info("to {} successful!! title: {}, content: {}",toEmail,title,content);
            return true;
        }catch (Exception e){
            log.error("send email failure!",e);
            return false;
        }
    }
}
