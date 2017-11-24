package com.liumapp.certificate.generator.worker;

import com.liumapp.DNSQueen.worker.ready.StandReadyWorker;
import com.liumapp.certificate.generator.config.Params;
import com.liumapp.keystore.entity.Resource;
import com.liumapp.keystore.service.KeyStoreAdapter;
import com.liumapp.keystore.service.KeyTools;
import com.liumapp.pattern.certificate.ExporterPattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.security.cert.Certificate;

/**
 * 证书导出工人
 * Created by liumapp on 11/23/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Component
public class CertificateExporter extends StandReadyWorker {

    @Autowired
    private Params params;

    @Override
    public String doWhatYouShouldDo(String whatQueenSays) {
        try {
            ExporterPattern exporterPattern = ExporterPattern.parse(whatQueenSays);
            Resource resource = Resource.from(params.getKeyStoreSavePath() + "/" + exporterPattern.getKeyStore());
            KeyStoreAdapter keyStoreAdapter = KeyTools.keyStoreFrom(resource , exporterPattern.getKeyStorePd());
            Certificate certificate = keyStoreAdapter.getCertificate(exporterPattern.getAlias());
            FileOutputStream out = new FileOutputStream(exporterPattern.getSavePath() + "/" + exporterPattern.getFileName());
            out.write(certificate.getEncoded());
            out.close();
            return "success";
        } catch (Exception e ) {
            e.printStackTrace();
            return null;
        }
    }

}
