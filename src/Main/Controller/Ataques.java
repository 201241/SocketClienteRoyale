package Main.Controller;

public class Ataques {


    public int posicionObjetivo;
    public int dañoTotal;

    public Ataques(int posicionEnemigo, int dañoTotal){
        this.posicionObjetivo = posicionEnemigo;
        this.dañoTotal = dañoTotal;
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
}
