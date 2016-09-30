package com.lucasmro.graphs.exception;

public class NoSuchRouteException extends RuntimeException {
    private static final long serialVersionUID = 7666027126417044365L;

    public NoSuchRouteException() {
        super("NO SUCH ROUTE");
    }

    public NoSuchRouteException(String s) {
        super(s);
    }
}
