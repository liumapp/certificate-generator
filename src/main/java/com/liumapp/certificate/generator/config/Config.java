package com.liumapp.certificate.generator.config;

import com.liumapp.DNSQueen.worker.process.WokerEar;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.liumapp.DNSQueen.worker.tcp.TCPSocketMonitor;

/**
 * Created by liumapp on 9/28/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Configuration
public class Config {

    @Bean
    @ConfigurationProperties(prefix = "liumapp.certificate.generator")
    public Params params () {
        return new Params();
    }

    @Bean
    public TCPSocketMonitor tcpSocketMonitor (Params params) {
        Integer port = params.getPort();
        TCPSocketMonitor tcpSocketMonitor = new TCPSocketMonitor(port);
        return tcpSocketMonitor;
    }

    @Bean
    public WokerEar wokerEar (Params params) {
        Integer startDelay = params.getStartDelay();
        WokerEar wokerEar = new WokerEar();
        wokerEar.setStartDelay(startDelay);
        return wokerEar;
    }

}
