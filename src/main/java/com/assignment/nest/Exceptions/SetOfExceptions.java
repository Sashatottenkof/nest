package com.assignment.nest.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;


public class SetOfExceptions {

    public SetOfExceptions() {

    }
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public static class NotFoundException extends RuntimeException {


        private static final long serialVersionUID = 5507194073455226160L;

        public NotFoundException(String message) {
            super(message);
        }

    }


    @ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
    public static class NotAcceptable extends RuntimeException {


        private static final long serialVersionUID = -4130900763526212720L;

        public NotAcceptable(String message) {
            super(message);

        }

    }
}
