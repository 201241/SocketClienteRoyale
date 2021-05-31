/*
package main.Controller;
import main.Modelo.paqueteEnvioMsj;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Controller implements Runnable{


    @FXML
    private TextField textoMSJ;

    @FXML
    private TextArea chatArea;

    @FXML
    private TextField nickName;

    @FXML
    private TextField ipContacto;

    @FXML
    private void initialize(){
        Thread mihilo = new Thread(this);
        mihilo.start();
    }


    @FXML
    private void enviarTxt(ActionEvent e){
        System.out.print("Funcia");
        try {
            Socket miSocket = new Socket("192.168.0.14", 3001);

            paqueteEnvioMsj datos = new paqueteEnvioMsj();
            datos.setIp(ipContacto.getText());
            datos.setNick(nickName.getText());
            datos.setMensaje(textoMSJ.getText());

            ObjectOutputStream paqueteMsj = new ObjectOutputStream(miSocket.getOutputStream());
            paqueteMsj.writeObject(datos);
            miSocket.close();

            */
/*DataOutputStream flujoSalida = new DataOutputStream(miSocket.getOutputStream()); //flujo de datos se enviar en la conexion indicada
            flujoSalida.writeUTF(texto.getText()); // escribe en el flujo
            flujoSalida.close();*//*


        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }


    @Override
    public void run() {

        try {
            ServerSocket servidorCliente = new ServerSocket(3002);
            Socket cliente;
            paqueteEnvioMsj paqueteRecibido;
            while (true){
                cliente=servidorCliente.accept();
                ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
                 paqueteRecibido = (paqueteEnvioMsj)flujoEntrada.readObject();
                 chatArea.appendText("\n"+paqueteRecibido.getNick()+" :: "+paqueteRecibido.getMensaje());
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

*/
