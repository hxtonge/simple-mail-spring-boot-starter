package com.sger.simple.mail;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * EmailProperties
 *
 * @author zhangshun
 * @date 2022/5/24
 */
@ConfigurationProperties(prefix = "simple.mail")
public class SimpleMailProperties {
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    /**
     * SMTP server host. For instance, 'smtp.example.com'.
     */
    private String host = "smtp.nevs.cc";

    /**
     * SMTP server port.
     */
    private Integer port = 25;

    /**
     * Login user of the SMTP server.
     */
    private String username = "ww95@nevs.cc";

    /**
     * Login password of the SMTP server.
     */
    private String password = "ASzs78415";

    /**
     * Protocol used by the SMTP server.
     */
    private String protocol = "smtp";

    /**
     * Default MimeMessage encoding.
     */
    private Charset defaultEncoding = DEFAULT_CHARSET;

    /**
     * Additional JavaMail Session properties.
     */
    private Map<String, String> properties = new HashMap<>();

    /**
     * Session JNDI name. When set, takes precedence over other Session settings.
     */
    private String jndiName;

    public String getHost() {
        return this.host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return this.port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Charset getDefaultEncoding() {
        return this.defaultEncoding;
    }

    public void setDefaultEncoding(Charset defaultEncoding) {
        this.defaultEncoding = defaultEncoding;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public void setJndiName(String jndiName) {
        this.jndiName = jndiName;
    }

    public String getJndiName() {
        return this.jndiName;
    }

}
