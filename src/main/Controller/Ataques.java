package main.Controller;

import java.io.Serializable;

public class Ataques implements Serializable {
    static final long serialVersionUID=123456789l;
    public int posicionObjetivo;
    public int dañoTotal;
    public int ganador;
    public String nombre;

    public Ataques( String nombre,int posicionEnemigo, int dañoTotal, int ganador){
        this.nombre = nombre;
        this.posicionObjetivo = posicionEnemigo;
        this.dañoTotal = dañoTotal;
        this.ganador = ganador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosicionObjetivo() {
        return posicionObjetivo;
    }

    public void setPosicionObjetivo(int posicionObjetivo) {
        this.posicionObjetivo = posicionObjetivo;
    }

    public int getDañoTotal() {
        return dañoTotal;
    }

    public void setDañoTotal(int dañoTotal) {
        this.dañoTotal = dañoTotal;
    }

    public int getGanador() {
        return ganador;
    }

    public void setGanador(int ganador) {
        this.ganador = ganador;
    }
}
