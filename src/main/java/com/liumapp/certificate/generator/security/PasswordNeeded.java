package com.liumapp.certificate.generator.security;

import com.liumapp.pattern.keystore.KeyStorePattern;

/**
 * Created by liumapp on 11/21/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public interface PasswordNeeded {

    /**
     *
     * @param keyStorePattern
     * @return boolean true : password success
     */
    public boolean chkPassword (KeyStorePattern keyStorePattern) ;


}
