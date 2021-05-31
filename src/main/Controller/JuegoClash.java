package main.Controller;

        import javafx.application.Platform;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;
        import javafx.scene.image.ImageView;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.Pane;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Rectangle;

        import java.io.IOException;
        import java.io.ObjectOutputStream;
        import java.net.Socket;
        import java.util.Observable;
        import java.util.Observer;

public class JuegoClash implements Observer {


    @FXML
    private Label vidaEnemigo1;

    @FXML
    private Label vidaEnemigo2;

    @FXML
    private Label vidaEnemigo3;

    @FXML
    private Label vidaAliado1;

    @FXML
    private Label vidaAliado2;

    @FXML
    private Label vidaAliado3;

    @FXML
    private Label tiempo1;

    @FXML
    private Label tiempo2;

    @FXML
    private Label tiempo3;

    @FXML
    private Rectangle barraSeleccion1;

    @FXML
    private Rectangle barraSeleccion2;

    @FXML
    private Rectangle barraSeleccion3;

    //_________Nombre VS
    @FXML
    private Label nombreJugador1;
    String nombreJ1;

    @FXML
    private Label nombreJugador2;


    private boolean aliadoSeleccionado= false;
    private boolean enemigoSeleccionado= false;
    //private int daño=0;

    private int VidaEnemigo1;
    private int VidaEnemigo2;
    private int VidaEnemigo3;

    private int VidaAliado1;
    private int VidaAliado2;
    private int VidaAliado3;

    private Socket socket;
    private ObjectOutputStream ataqueEnviado = null;


    public JuegoClash() {
        VidaEnemigo1=100;
        VidaEnemigo2=100;
        VidaEnemigo3=100;

        VidaAliado1=100;
        VidaAliado2=100;
        VidaAliado3=100;
    }

    @FXML
    private Pane paneVistaInicio;

    @FXML
    private TextField nombreJugador;

    @FXML
    void iniciarJuego(MouseEvent event) {
        nombreJ1=nombreJugador.getText();
        nombreJugador1.setText(nombreJ1);
        paneVistaInicio.setVisible(false);
        Ataques ataqueEnviar = new Ataques( nombreJ1,0, 0,0);
        enviarDaño(ataqueEnviar);
    }

    @FXML
    void SalirDelJuego(MouseEvent event) {
        System.exit(0);
        System.out.println("Salir");
    }


    @FXML
    void reiniciarJuego(MouseEvent event) {
        VidaEnemigo1=100;
        VidaEnemigo2=100;
        VidaEnemigo3=100;

        VidaAliado1=100;
        VidaAliado2=100;
        VidaAliado3=100;

        vidaAliado1.setText("100");
        vidaAliado2.setText("100");
        vidaAliado3.setText("100");

        vidaEnemigo1.setText("100");
        vidaEnemigo2.setText("100");
        vidaEnemigo3.setText("100");

        paneGanaste.setVisible(false);
        panePerdiste.setVisible(false);
        paneVistaInicio.setVisible(true);

        System.out.println("reiniciar");
    }

    public void initialize(){
        String ipServer="192.168.0.14";
        int portServer=3001;
        try {
            socket = new Socket(ipServer,portServer);
            //log.setText( "Conectado");
            ataqueEnviado = new ObjectOutputStream(socket.getOutputStream());
            ataqueEnviado.flush();

            ThreadCliente cliente = new ThreadCliente(socket);
            cliente.addObserver(this);
            new Thread(cliente).start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void botonJugar(ActionEvent e) {
        /*String ipServer="192.168.0.14";
        int portServer=3001;
        try {
            socket = new Socket(ipServer,portServer);
            //log.setText( "Conectado");
            bufferDeSalida = new DataOutputStream(socket.getOutputStream());
            bufferDeSalida.flush();

            ThreadCliente cliente = new ThreadCliente(socket);
            cliente.addObserver(this);
            new Thread(cliente).start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
    }

    @FXML
    void seleccionadoAliado1(MouseEvent event) {
        barraSeleccion1.setFill(Color.rgb(162,74,203));
        barraSeleccion2.setFill(Color.rgb(225,225,225));
        barraSeleccion3.setFill(Color.rgb(225,225,225));
        System.out.println("Aliado 1");
        aliadoSeleccionado=true;
        daño=10;
    }


    @FXML
    void seleccionadoAliado2(MouseEvent event) {
        barraSeleccion1.setFill(Color.rgb(225,225,225));
        barraSeleccion2.setFill(Color.rgb(162,74,203));
        barraSeleccion3.setFill(Color.rgb(225,225,225));
        System.out.println("Aliado 2");
        aliadoSeleccionado=true;
        daño=30;
    }

    @FXML
    void seleccionadoAliado3(MouseEvent event) {
        barraSeleccion1.setFill(Color.rgb(225,225,225));
        barraSeleccion2.setFill(Color.rgb(225,225,225));
        barraSeleccion3.setFill(Color.rgb(162,74,203));
        System.out.println("Aliado 3");
        aliadoSeleccionado=true;
        daño=15;
    }

    @FXML
    void seleccionadoEnemigo1(MouseEvent event) {
        System.out.println("Enemigo 1");
        enemigoSeleccionado=true;
        if(aliadoSeleccionado==true && enemigoSeleccionado==true){
            enviarDatoAtaque(daño,0,0,1);
        }

    }

    @FXML
    void seleccionadoEnemigo2(MouseEvent event) {
        System.out.println("Enemigo 2");
        enemigoSeleccionado=true;
        if(aliadoSeleccionado==true && enemigoSeleccionado==true){
            enviarDatoAtaque(0,daño,0,2);
        }
    }

    @FXML
    void seleccionadoEnemigo3(MouseEvent event) {
        System.out.println("Enemigo 3");
        enemigoSeleccionado=true;
        if(aliadoSeleccionado==true && enemigoSeleccionado==true){
            enviarDatoAtaque(0,0,daño,3);
        }
    }

    @FXML
    private Pane paneGanaste;

    private int dañoTotal;
    public void enviarDatoAtaque(int ataque1, int ataque2, int ataque3, int posicionEnemigo){
        System.out.println("atacado 1");
        aliadoSeleccionado=false;
        enemigoSeleccionado=false;
        dañoTotal=ataque1+ataque2+ataque3;
        System.out.println("atacado: "+ posicionEnemigo+" -> daño: "+ (dañoTotal));

        barraSeleccion1.setFill(Color.rgb(225,225,225));
        barraSeleccion2.setFill(Color.rgb(225,225,225));
        barraSeleccion3.setFill(Color.rgb(225,225,225));
        dañoEnemigoLocal(posicionEnemigo,dañoTotal);

        if(VidaEnemigo1<=0 && VidaEnemigo2<=0 && VidaEnemigo3<=0){
            Ataques ataqueEnviar = new Ataques(nombreJ1,0, 0,1);
            enviarDaño(ataqueEnviar);
            paneGanaste.setVisible(true);
        }
        Ataques ataqueEnviar = new Ataques(nombreJ1,posicionEnemigo, dañoTotal,0);
        enviarDaño(ataqueEnviar);

    }
    public void enviarDaño(Ataques ataqueEnviar){
        System.out.println( "Ataque enviado > "+ataqueEnviar.getDañoTotal());
        System.out.println("objetivo atacado > "+ataqueEnviar.getPosicionObjetivo());

        try {
            ataqueEnviado.writeObject(ataqueEnviar);
            System.out.println("Si enviado");

        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
            System.out.println("Error es: "+ioException);
            System.out.println("No enviado");
        }
    }

    public void dañoEnemigoLocal(int enemigo, int daño){
        String vidaAcual;

        if(enemigo==1){
            vidaAcual = String.valueOf(VidaEnemigo1-daño);
            VidaEnemigo1-=daño;
            vidaEnemigo1.setText(vidaAcual);
            if(VidaEnemigo1<=0){
                vidaEnemigo1.setText("Eliminado");
            }
        }
        if(enemigo==2){
            vidaAcual = String.valueOf(VidaEnemigo2-daño);
            VidaEnemigo2-=daño;
            vidaEnemigo2.setText(vidaAcual);
            if(VidaEnemigo2<=0){
                vidaEnemigo2.setText("Eliminado");
            }
        }
        if(enemigo==3){
            vidaAcual = String.valueOf(VidaEnemigo3-daño);
            VidaEnemigo3-=daño;
            vidaEnemigo3.setText(vidaAcual);
            if(VidaEnemigo3<=0){
                vidaEnemigo3.setText("Eliminado peo");
            }
        }

    }

    Ataques ataqueResivido;
    int daño=0;
    int posicion=0;

    @FXML
    private Pane panePerdiste;


    @Override
    public void update(Observable o, Object arg) {
        //if(o instanceof )
        System.out.println("Update cliente");
            ataqueResivido = (Ataques)arg;
            int gana = ataqueResivido.getGanador();
            daño=ataqueResivido.getDañoTotal();
            posicion=ataqueResivido.getPosicionObjetivo();
            System.out.println("Posicion Aliado> "+posicion+" -daño:"+daño);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                nombreJugador2.setText(ataqueResivido.getNombre());
                if(gana==1){
                    System.out.println("Gana jugador server");
                    panePerdiste.setVisible(true);
                }else{
                    if(posicion==1){
                        VidaAliado1-=daño;
                        vidaAliado1.setText(String.valueOf(VidaAliado1));
                        if(VidaAliado1<=0){
                            vidaAliado1.setText("Eliminado");
                        }
                    }if(posicion==2){
                        VidaAliado2-=daño;
                        vidaAliado2.setText(String.valueOf(VidaAliado2));
                        if(VidaAliado2<=0){
                            vidaAliado2.setText("Eliminado");
                        }
                    }
                    if(posicion==3){
                        VidaAliado3-=daño;
                        vidaAliado3.setText(String.valueOf(VidaAliado3));
                        if(VidaAliado3<=0){
                            vidaAliado3.setText("Eliminado");
                        }
                    }
                }


            }
        });


    }
}


