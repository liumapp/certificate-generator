package com.liumapp.certificate.generator.worker;

import com.liumapp.DNSQueen.worker.ready.StandReadyWorker;
import com.liumapp.certificate.generator.config.Params;
import com.liumapp.keystore.entity.Resource;
import com.liumapp.keystore.service.KeyStoreAdapter;
import com.liumapp.keystore.service.KeyTools;
import com.liumapp.pattern.certificate.PersonalPattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.time.temporal.ChronoUnit;

/**
 * 证书生成
 * Created by liumapp on 11/20/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class CertificateGenerator extends StandReadyWorker {

    @Autowired
    private Params params;

    @Override
    public String doWhatYouShouldDo(String s) {
        try {
            PersonalPattern personalPattern = PersonalPattern.parse(s);
            Resource resource = Resource.from(params.getKeyStoreSavePath() + "/" + personalPattern.getKeystore());
            KeyStoreAdapter keyStoreAdapter = KeyTools.keyStoreFrom(resource , personalPattern.getStorepass());
            keyStoreAdapter.newKeyPair()
                           .keyLength(personalPattern.getKeysize())
                           .generateWithCertificate()
                           .withValidity(1 , ChronoUnit.YEARS)
                           .withDistinguishName()
                               .commonName(personalPattern.getName())
                               .state(personalPattern.getCity())
                               .locality(personalPattern.getProvince())
                               .country(personalPattern.getCountry())
                           .build()
                           .createInKeyStore(personalPattern.getAlias() , personalPattern.getCertPassword());
            FileOutputStream out = new FileOutputStream(params.getKeyStoreSavePath() + "/" + personalPattern.getKeystore());
            keyStoreAdapter.writeTo(out);
            out.close();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
