package com.empresa.model;

public class DatosNoCorrectosException extends Exception {
    public DatosNoCorrectosException(String mensaje) {
        super(mensaje);
    }
}
