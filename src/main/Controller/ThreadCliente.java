package main.Controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadCliente extends Observable implements Runnable {

    private Socket socket;
    //private ObjectInputStream bufferDeEntrada = null; //DataInputStream

    public ThreadCliente(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Inicar buffer");
            //ObjectInputStream bufferDeEntrada = new ObjectInputStream(socket.getInputStream());
            Ataques AtaqueRecibido;
            //String st ="";
            do {
                System.out.println("Recibir Thread Cliente");
                try {
                    ObjectInputStream bufferDeEntrada = new ObjectInputStream(socket.getInputStream());
                    Thread.sleep(ThreadLocalRandom.current().nextLong(1000L)+100);
                    AtaqueRecibido=(Ataques)bufferDeEntrada.readObject();
                    this.setChanged();
                    this.notifyObservers(AtaqueRecibido);
                    System.out.println("Enviar a update");
                } catch (Exception e) {
                    e.printStackTrace();
                    //socket.close();
                    System.exit(0);
                }

            }while(!socket.isClosed());
            //bufferDeEntrada.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }

    }
}
