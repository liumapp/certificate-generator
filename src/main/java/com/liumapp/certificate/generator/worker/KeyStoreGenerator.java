package com.liumapp.certificate.generator.worker;

import com.liumapp.DNSQueen.worker.ready.StandReadyWorker;
import com.liumapp.certificate.generator.config.Params;
import com.liumapp.certificate.generator.security.PasswordNeeded;
import com.liumapp.certificate.generator.securityImpl.PasswordNeededChk;
import com.liumapp.pattern.keystore.KeyStorePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Key;

/**
 * Created by liumapp on 11/21/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
class KeyStoreGenerator extends StandReadyWorker {

    @Autowired
    private Params params;

    @Autowired
    private PasswordNeededChk passwordNeededChk;

    @Override
    public String doWhatYouShouldDo(String whatQueenSays) {
        try {
            KeyStorePattern keyStorePattern = KeyStorePattern.parse(whatQueenSays);
            if (!passwordNeededChk.chkPassword(keyStorePattern)) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

}
