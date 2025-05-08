package christopher.flores.tranferencia;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final int PORT = Servidor.PORT;
    private static final String HOST = Servidor.HOST;
    private String DIR_ARRIBADA = System.getProperty("java.io.tmpdir");
    private ObjectOutputStream objectOutputStream;    
    private ObjectInputStream objectInputStream;
    private Socket socketCliente;

    public void connectar() throws IOException{
        socketCliente = new Socket(HOST , PORT);
        objectOutputStream = new ObjectOutputStream(socketCliente.getOutputStream());
        objectInputStream = new ObjectInputStream(socketCliente.getInputStream());
    }

    public void rebreFitxers() {
        Scanner sc = new Scanner(System.in);
        
    }

    public void tancarConnexio() throws IOException{
        if (socketCliente != null) socketCliente.close();
        if (objectOutputStream != null) objectOutputStream.close();
        if (objectInputStream != null) objectInputStream.close();
    }

    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.connectar();
            client.rebreFitxers();
            client.tancarConnexio();
        } catch (IOException e) {
        
        }
    }
}
