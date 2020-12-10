package org.example;


import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * RUN Config Enviroment Variables
 * - db_host localhost /127.0.0.1
 *
 */
@Slf4j
@SpringBootApplication
public class App {

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

}
















