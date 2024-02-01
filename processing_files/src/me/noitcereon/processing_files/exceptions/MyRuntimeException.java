package me.noitcereon.processing_files.exceptions;

public class MyRuntimeException extends RuntimeException{
    public MyRuntimeException() {
        super();
    }

    public MyRuntimeException(String message) {
        super(message);
    }

    public MyRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
