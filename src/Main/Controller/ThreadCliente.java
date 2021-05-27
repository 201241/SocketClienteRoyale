package Main.Controller;

import java.io.DataInputStream;
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

            Ataques AtaqueRecibido=null;
            do {
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextLong(1000L)+100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    AtaqueRecibido = (Ataques) bufferDeEntrada.readObject();
                    //String[] array = st.split(":");

                    this.setChanged();
                    this.notifyObservers(AtaqueRecibido);
                } catch (IOException e) {
                    //e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }while (AtaqueRecibido.getGanador()!=2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
