package com.liumapp.certificate.generator.worker;

import com.liumapp.DNSQueen.worker.ready.StandReadyWorker;
import com.liumapp.pattern.certificate.PersonalPattern;
import com.liumapp.pattern.exception.PatternPropertiesNumberNotEnough;
import org.springframework.stereotype.Component;

/**
 * 证书生成
 * Created by liumapp on 11/20/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class CertificateGenerator extends StandReadyWorker {

    @Override
    public String doWhatYouShouldDo(String s) {
        try {
            PersonalPattern personalPattern = PersonalPattern.parse(s);
            return "success";
        } catch (PatternPropertiesNumberNotEnough e) {
            e.printStackTrace();
            return null;
        }
    }

}
