package com.liumapp.certificate.generator.worker;

import com.liumapp.DNSQueen.queen.Queen;
import com.liumapp.pattern.keystore.KeyStorePattern;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by liumapp on 11/23/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class KeyStoreGeneratorTest {

    @Test
    public void generateKeyStore () {
        Queen queen = new Queen();
        try {
            queen.connect();
            KeyStorePattern keyStorePattern = new KeyStorePattern();
            if (keyStorePattern.chk()) {
                String line = keyStorePattern.getEncoding();
                queen.say(line);
                System.out.println(queen.hear());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
