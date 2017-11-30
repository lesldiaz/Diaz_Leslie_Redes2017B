
package lab1redes;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerUDP {
private static int PORT = 9091;
    public static void main(String[] args) throws IOException {
        DatagramSocket serverSocket = new DatagramSocket(PORT);
        System.err.println("Server listening on port " + PORT + " using UDP conecction \n"); 
        long initialTime = System.currentTimeMillis();
        System.out.println("Tiempo Inicial: " + initialTime + "\n"); //para medir cuanto tiempo se demora el algoritmo
        
        try
        {
            while (true){
                //receive packet
                byte bufferReceive[]=new byte[128];
                DatagramPacket receivePacket = new DatagramPacket(bufferReceive, bufferReceive.length);
                serverSocket.receive(receivePacket);
                //info cliente port
                InetAddress clientAdress = receivePacket.getAddress(); //obtengo la direccion del cliente
                int clientPort = receivePacket.getPort();
                System.out.println("Client port : "+ clientPort + "\n");
                //termina info cliente port
                
                //send packet
                
                String msg = "Message from Server";
                byte bufferSend[]=msg.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(bufferSend, bufferSend.length,clientAdress,clientPort ); //paquete que voy a enviar
                serverSocket.send(sendPacket);
                
            }
        }
    finally {
        serverSocket.close();
    }
   }
}
