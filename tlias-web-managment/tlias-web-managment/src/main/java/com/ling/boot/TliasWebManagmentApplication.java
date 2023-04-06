package com.ling.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class TliasWebManagmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasWebManagmentApplication.class, args);
    }

}
