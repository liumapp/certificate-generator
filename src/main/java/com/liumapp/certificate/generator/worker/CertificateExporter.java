package com.liumapp.certificate.generator.worker;

import com.liumapp.DNSQueen.worker.ready.StandReadyWorker;
import org.springframework.stereotype.Component;

/**
 * 证书导出工人
 * Created by liumapp on 11/23/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class CertificateExporter extends StandReadyWorker {

    @Override
    public String doWhatYouShouldDo(String whatQueenSays) {
        return null;
    }

}
