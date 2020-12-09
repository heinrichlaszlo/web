package org.example.exception;


import org.example.model.Matches;

public class UnknownMatchesException extends Exception{
        private Matches match;

        public UnknownMatchesException(Matches match){this.match=match;}

        public UnknownMatchesException(String message, Matches match){
            super(message);
            this.match=match;
        }

        public UnknownMatchesException(String message){super(message);}
    }

