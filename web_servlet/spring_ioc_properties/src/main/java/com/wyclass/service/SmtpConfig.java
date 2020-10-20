package com.wyclass.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.print.DocFlavor;

@Component
public class SmtpConfig {

    @Value("${smtp.host:localhost}")
    private String host;

    @Value("${smtp.port:25}")
    private int port;

    public String getHost()
    {
        return  host;
    }

    public int getPort(){
        return port;
    }



}
