package com.liumapp.certificate.generator.worker;

import com.liumapp.DNSQueen.worker.ready.StandReadyWorker;
import com.liumapp.certificate.generator.config.Params;
import com.liumapp.certificate.generator.securityImpl.PasswordNeededChk;
import com.liumapp.keystore.service.KeyTools;
import com.liumapp.pattern.keystore.KeyStorePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.time.temporal.ChronoUnit;

/**
 * KeyStore的生成
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
                return "generator password wrong !";
            }
            String fileName = params.getKeyStoreSavePath() + "/" + keyStorePattern.getKeyStoreName();
            FileOutputStream out = new FileOutputStream(fileName);
            KeyTools.newKeyStore(keyStorePattern.getKeyStorePd())
                    .newKeyPair()
                    .keyLength(keyStorePattern.getKeyLength())
                    .generateWithCertificate()
                    .withValidity(1 , ChronoUnit.YEARS)
                    .withDistinguishName()
                    .commonName(keyStorePattern.getFcName())
                    .state(keyStorePattern.getFcCity())
                    .locality(keyStorePattern.getFcProvince())
                    .country(keyStorePattern.getFcCountry())
                    .build()
                    .createInKeyStore(keyStorePattern.getFcAlias() , keyStorePattern.getFcPassword())
                    .writeTo(out);
            out.close();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
