package Main.Controller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.Timer;
import java.util.TimerTask;

public class Juego {

    @FXML
    private Pane PaneCampo;
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
    public Juego(){

 /*       PaneCampo.getChildren().add(bola);
        PaneCampo.getChildren().add(rect);*/

    }

    Circle bola = new Circle( centerX,  centerY,  radius);
    Rectangle rect = new Rectangle( x,  y,  width,  height);

    public void initialize(){
        moverItem mov = new moverItem(bola,PaneCampo);
        Timer task = new Timer();
        task.scheduleAtFixedRate(mov,0,200);
    }

    public void pintar(){
        //mover();
        //PaneCampo.getChildren().add(bola);
        //PaneCampo.getChildren().add(rect);
    }

    public void mover(){

    }


}

