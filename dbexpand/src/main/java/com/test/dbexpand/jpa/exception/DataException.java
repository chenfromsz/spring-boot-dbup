package com.test.dbexpand.jpa.exception;

public class DataException extends RuntimeException{

    public int code;

    public final static int noPermission = -100;
    public final static int noID = -1;

    public DataException(int code) {
        this.code = code;
    }

    public DataException(int code , String message) {
        super(message);
        this.code = code;
    }

    public DataException(int code , String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public DataException(int code , Throwable cause) {
        super(cause);
        this.code = code;
    }
}
