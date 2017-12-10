package lab2redes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ClientTCP {
    private static int SERVER_PORT = 9090;
    public static void main(String[] args) throws IOException {
        String serverAddress = JOptionPane.showInputDialog("Enter IP Adress of a machine that is runing the date service on port\n"+ SERVER_PORT );
        //Establece la conexion con el servidor mediante un Socket
        Socket clientSocket = new Socket(serverAddress, SERVER_PORT);
        //Obtiene el mensaje enviado por el servidor a traves del socket
        InputStreamReader inputStream = new InputStreamReader(clientSocket.getInputStream());
        //Lee los datos del mensaje && Transforma String
        BufferedReader input = new BufferedReader(inputStream);
        String answer= input.readLine();
        //Imprime los datos del mensaje
        JOptionPane.showMessageDialog(null, answer);
        System.exit(0);
    }
    
}
