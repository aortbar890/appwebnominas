package com.empresa.model;


public class Empleado extends Persona {

    private int categoria;

    public int anyos;

    public Empleado(String dni, String nombre, char sexo) {
        super(dni, nombre, sexo);
        categoria = 1;
        anyos = 0;
    }

    public Empleado(int anyos, int categoria, String dni, String nombre, char sexo) throws DatosNoCorrectosException {
        super(dni, nombre, sexo);
        if (categoria < 1 || categoria > 10 || anyos < 0) {
            throw new DatosNoCorrectosException(nombre);
        }
        this.anyos = anyos;
        this.categoria = categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getCategoria() {
        return categoria;
    }
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public char getSexo() {
        return sexo;
    }
    public int getAnyos() {
        return anyos;
    }

    public String imprime() {
        return super.imprime() + " " + categoria + " " + anyos;
    }
}
