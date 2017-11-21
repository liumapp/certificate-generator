package com.liumapp.certificate.generator.worker;

import com.liumapp.DNSQueen.worker.ready.StandReadyWorker;
import com.liumapp.certificate.generator.config.Params;
import com.liumapp.certificate.generator.security.PasswordNeeded;
import com.liumapp.pattern.keystore.KeyStorePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by liumapp on 11/21/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class KeyStoreGenerator extends StandReadyWorker implements PasswordNeeded{

    @Autowired
    private Params params;

    @Override
    public String doWhatYouShouldDo(String whatWifeSays) {

        return null;
    }

    @Override
    public boolean chkPassword(KeyStorePattern keyStorePattern) {
        return false;
    }
}
