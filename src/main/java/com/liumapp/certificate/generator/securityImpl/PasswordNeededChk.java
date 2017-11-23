package com.liumapp.certificate.generator.securityImpl;

import com.liumapp.certificate.generator.config.Params;
import com.liumapp.certificate.generator.security.PasswordNeeded;
import com.liumapp.pattern.keystore.KeyStorePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
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
    public boolean chkPassword(KeyStorePattern keyStorePattern) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return encodePassword(params.getGeneratorPd()).equals(keyStorePattern.getGeneratorPd());
    }

    @Override
    public String encodePassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance(params.getMessageDigestType());
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(md.digest(password.getBytes(params.getEncoding())));
    }

}
