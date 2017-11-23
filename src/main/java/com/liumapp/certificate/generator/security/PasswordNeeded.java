package com.liumapp.certificate.generator.security;

import com.liumapp.pattern.SocketPattern;

/**
 * Created by liumapp on 11/21/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public interface PasswordNeeded {

    /**
     *
     * @param socketPattern
     * @return boolean true : password success
     */
    public boolean chkPassword (SocketPattern socketPattern) ;


}
