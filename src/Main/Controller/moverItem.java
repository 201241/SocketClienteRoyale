package Main.Controller;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.TimerTask;

public class moverItem extends TimerTask {

    private boolean juego = true;

    private double centerX= 350;
    private double centerY=150;
    private double radius=10;
    private int direccionX=3;
    private int direccionY=2;


    private double x=25;
    private double y=150;
    private double width=20;
    private double height=20;

    private Circle bola;
    private Pane PaneCampo;


    public moverItem(Circle bola, Pane PaneCampo){
        this.bola = bola;
        this.PaneCampo = PaneCampo;
    }
    public void repintar(){
        bola.setLayoutX(this.centerX);
        bola.setLayoutY(this.centerY);

    }

    @Override
    public void run() {
        PaneCampo.getChildren().add(bola);
        
        System.out.println("aa");
        if(juego){
            centerX+=direccionX;
            centerY+=direccionY;
            if(centerX>700-20){
                direccionX = -direccionX;
            }
            if(centerX<0){
                direccionX = -direccionX;
            }
            if(centerY<0){
                direccionY = -direccionY;
            }
            if(centerY>300-20){
                direccionY = -direccionY;
            }
        }
    }
}
