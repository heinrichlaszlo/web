package org.example.exception;


import org.example.model.Players;

public class UnknownPlayersException extends Exception {
    private Players players;

    public UnknownPlayersException(Players players){this.players=players;}

    public UnknownPlayersException(String message, Players players){
        super(message);
        this.players=players;
}

    public UnknownPlayersException(String message){super(message);}

}