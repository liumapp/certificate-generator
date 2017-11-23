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

    private String generatorPd = "adminadmin";

    private String messageDigestType = "MD5";

    private String encoding = "utf-8";

    private Integer startDelay = 3000;

    private String keyStoreSavePath = "/usr/local/tomcat/project/working";

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

    public String getGeneratorPd() {
        return generatorPd;
    }

    public void setGeneratorPd(String generatorPd) {
        this.generatorPd = generatorPd;
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

    public String getKeyStoreSavePath() {
        return keyStoreSavePath;
    }

    public void setKeyStoreSavePath(String keyStoreSavePath) {
        this.keyStoreSavePath = keyStoreSavePath;
    }
}
