package main.Controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadCliente extends Observable implements Runnable {

    private Socket socket;
    private ObjectInputStream bufferDeEntrada = null; //DataInputStream

    public ThreadCliente(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            bufferDeEntrada = new ObjectInputStream(socket.getInputStream());

            Ataques AtaqueRecibido;
            do {
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextLong(100L)+100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    AtaqueRecibido = (Ataques) bufferDeEntrada.readObject();
                    this.setChanged();
                    this.notifyObservers(AtaqueRecibido);
                } catch (IOException e) {
                    //e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
