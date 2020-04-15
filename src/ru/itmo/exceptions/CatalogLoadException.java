package ru.itmo.exceptions;

public class CatalogLoadException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public CatalogLoadException() {
        super();
    }

    public CatalogLoadException(String errorMessage) {
        super(errorMessage);
    }

    public CatalogLoadException(Throwable err) {
        super(err);
    }

}