package ru.itmo.exceptions;

public class ItemAlreadyExistsException extends Exception {

    private static final long serialVersionUID = 1L;

    public ItemAlreadyExistsException() {
        super();
    }

    public ItemAlreadyExistsException(Throwable err) {
        super(err);
    }

    public ItemAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}