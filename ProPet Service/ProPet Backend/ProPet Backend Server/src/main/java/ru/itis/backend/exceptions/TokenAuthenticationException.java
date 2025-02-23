package ru.itis.backend.exceptions;

public abstract class TokenAuthenticationException extends RuntimeException{

    public TokenAuthenticationException() {
        super();
    }

    public TokenAuthenticationException(String message) {
        super(message);
    }

    public TokenAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenAuthenticationException(Throwable cause) {
        super(cause);
    }
}
