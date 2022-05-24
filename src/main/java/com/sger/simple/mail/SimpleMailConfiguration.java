package com.sger.simple.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Map;
import java.util.Properties;

/**
 * EmailConfig
 *
 * @author zhangshun
 * @date 2022/5/24
 */
@Configuration
@EnableConfigurationProperties(SimpleMailProperties.class)
@Slf4j
public class SimpleMailConfiguration {

    @Bean
    @ConditionalOnClass(JavaMailSender.class)
    JavaMailSenderImpl mailSender(SimpleMailProperties properties) {
        log.info("开始构造JavaMailSender--->>>");
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        applyProperties(properties, sender);
        return sender;
    }

    @Bean
    @ConditionalOnClass(SimpleMail.class)
    SimpleMail mail(JavaMailSender javaMailSender, SimpleMailProperties properties) {
        SimpleMail mail = new SimpleMail();
        log.info("开始构造Email--->>>");
        mail.setFromEmail(properties.getUsername());
        mail.setJavaMailSender(javaMailSender);
        return mail;
    }

    private void applyProperties(SimpleMailProperties properties, JavaMailSenderImpl sender) {
        sender.setHost(properties.getHost());
        if (properties.getPort() != null) {
            sender.setPort(properties.getPort());
        }
        sender.setUsername(properties.getUsername());
        sender.setPassword(properties.getPassword());
        sender.setProtocol(properties.getProtocol());
        if (properties.getDefaultEncoding() != null) {
            sender.setDefaultEncoding(properties.getDefaultEncoding().name());
        }
        if (!properties.getProperties().isEmpty()) {
            sender.setJavaMailProperties(asProperties(properties.getProperties()));
        }
    }

    private Properties asProperties(Map<String, String> source) {
        Properties properties = new Properties();
        properties.putAll(source);
        return properties;
    }

}
