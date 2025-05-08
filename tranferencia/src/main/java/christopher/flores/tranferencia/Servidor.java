package christopher.flores.tranferencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    static final int PORT = 9999;
    static final String HOST = "127.0.0.1";
    private ServerSocket serverSocket;
    private Socket socketClient;
    private ObjectInputStream entrada;

    public Socket connectar() throws IOException {
        serverSocket = new ServerSocket(PORT);
        return serverSocket.accept();
    }

    public void tancarConnexio(Socket socket) throws IOException{
        socket.close();
    }

    public void enviarFitxers() throws IOException, ClassNotFoundException{
        File file = null;
        String msgrebut = "";
        // Rebre missatges del servidor i mostrar-los per pantalla
        while ((msgrebut = (String) entrada.readObject()) != null) {
            file = new File(msgrebut);
        }
    }    
 
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        try {
            servidor.socketClient = servidor.connectar();
            servidor.entrada = new ObjectInputStream(servidor.socketClient.getInputStream());
            servidor.enviarFitxers();
            servidor.tancarConnexio(servidor.socketClient);
        } catch (IOException | ClassNotFoundException e) {
            
        }
    }
}