package org.example;

import antlr.ASdebug.IASDebugStream;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.*;
import org.example.dao.entity.PlayersEntity;
import org.example.dao.entity.TeamsEntity;
import org.example.exception.UnknownPlayersException;

import org.example.model.Players;
import org.example.model.Teams;
import org.example.service.PlayersService;
import org.example.service.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.security.Timestamp;
import java.sql.SQLOutput;
import java.util.Date;

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
















