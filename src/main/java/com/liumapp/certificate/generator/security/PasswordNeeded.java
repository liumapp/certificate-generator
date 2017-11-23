package com.liumapp.certificate.generator.security;


import com.liumapp.pattern.keystore.KeyStorePattern;

import java.security.NoSuchAlgorithmException;

/**
 * Created by liumapp on 11/21/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public interface PasswordNeeded {

    /**
     * 校验密码
     * @param keyStorePattern
     * @return boolean true : password success
     */
    public boolean chkPassword (KeyStorePattern keyStorePattern) throws NoSuchAlgorithmException;

    /**
     * 加密密码
     * @param password
     * @return string after encode
     */
    public String encodePassword (String password);

}
