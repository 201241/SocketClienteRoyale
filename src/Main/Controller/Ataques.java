package Main.Controller;

public class Ataques {

    public int posicionObjetivo;
    public int dañoTotal;
    public int ganador;

    public Ataques(int posicionEnemigo, int dañoTotal, int ganador){
        this.posicionObjetivo = posicionEnemigo;
        this.dañoTotal = dañoTotal;
        this.ganador = ganador;
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
