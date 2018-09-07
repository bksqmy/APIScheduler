package com.sl.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 *  APIScheduler
 *  @author gaoxueyong
 */
@SpringBootApplication
@ComponentScan
@EnableScheduling
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class);

    }
}
