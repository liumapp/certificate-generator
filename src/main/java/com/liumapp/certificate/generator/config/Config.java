package com.liumapp.certificate.generator.config;

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
    public TCPSocketMonitor tcpSocketMonitor () {
        Integer port = 40214;
        TCPSocketMonitor tcpSocketMonitor = new TCPSocketMonitor(port);
        return tcpSocketMonitor;
    }

}
