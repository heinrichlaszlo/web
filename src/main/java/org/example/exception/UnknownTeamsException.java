package org.example.exception;

import lombok.Data;
import org.example.model.Teams;

@Data
public class UnknownTeamsException extends Exception {
    private Teams teams;

    public UnknownTeamsException(Teams teams){this.teams=teams;}

    public UnknownTeamsException(String message, Teams teams){
        super(message);
        this.teams=teams;


    }

    public UnknownTeamsException(String message){
        super(message);
    }
}
