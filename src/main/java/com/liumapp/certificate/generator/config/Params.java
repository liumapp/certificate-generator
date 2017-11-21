package com.liumapp.certificate.generator.config;

import org.springframework.stereotype.Component;

/**
 * Created by liumapp on 11/20/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class Params {

    private Integer port = 9999;

    private String password = "adminadmin";

    private String messageDigestType = "MD5";

    private String encoding = "utf-8";

    private Integer startDelay = 3000;

    public Integer getStartDelay() {
        return startDelay;
    }

    public void setStartDelay(Integer startDelay) {
        this.startDelay = startDelay;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessageDigestType() {
        return messageDigestType;
    }

    public void setMessageDigestType(String messageDigestType) {
        this.messageDigestType = messageDigestType;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
}
