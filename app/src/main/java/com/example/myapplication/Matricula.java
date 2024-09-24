package com.example.myapplication;

public class Matricula {
    private int anyo;
    private int estacion;
    private String matricula;

    // Constructor
    public Matricula(int anyo, int estacion, String matricula) {
        this.anyo = anyo;
        this.estacion = estacion;
        this.matricula = matricula;
    }

    // Getters
    public int getAnyo() {
        return anyo;
    }

    public int getEstacion() {
        return estacion;
    }

    public String getMatricula() {
        return matricula;
    }

    // Setters
    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public void setEstacion(int estacion) {
        this.estacion = estacion;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}

