package com.liumapp.certificate.generator.worker;

import com.liumapp.DNSQueen.queen.Queen;
import com.liumapp.pattern.keystore.KeyStorePattern;
import org.junit.Test;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by liumapp on 11/23/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class KeyStoreGeneratorTest {

    /**
     * 生成一份keystore
     * 当您需要运行这份Demo的时候，把false改为true即可
     */
    @Test
    public void generateKeyStore () {
        if (false) {
            Queen queen = new Queen();
            queen.setPort(40214);
            try {
                queen.connect();
                KeyStorePattern keyStorePattern = new KeyStorePattern();
                keyStorePattern.setImportant("keystore.ks",
                        "adminadmin",
                        "123456",
                        2048,
                        "zhangsan",
                        "浙江",
                        "杭州",
                        "中国",
                        "430388229353192",
                        "123");
                if (keyStorePattern.chk()) {
                    String line = keyStorePattern.getEncoding();
                    queen.say(line);
                    System.out.println(queen.hear());
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从上面生成的keystore文件中导出证书430388229353192
     */
    @Test
    public void exportCert () {
        if (true) {
            
        }
    }



}
