package com.liumapp.certificate.generator.securityImpl;

import com.liumapp.certificate.generator.config.Params;
import com.liumapp.certificate.generator.security.PasswordNeeded;
import com.liumapp.pattern.keystore.KeyStorePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by liumapp on 11/23/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class PasswordNeededChk implements PasswordNeeded {

    @Autowired
    private Params params;

    @Override
    public boolean chkPassword(KeyStorePattern keyStorePattern) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(params.getMessageDigestType());
        BASE64Encoder base64Encoder = new BASE64Encoder();
        
        return false;
    }

}
