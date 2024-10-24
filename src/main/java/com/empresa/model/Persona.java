package com.empresa.model;


public class Persona {
    public String nombre;
    public String dni; 
    public char sexo;

    public Persona(String dni, String nombre, char sexo) {
        this.dni = dni;
        this.nombre = nombre;
        this.sexo = sexo;
    }

    public Persona(String nombre, char sexo) {
        this.nombre = nombre;
        this.sexo = sexo;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String imprime() {
        return nombre + " " + dni;
    }
}
