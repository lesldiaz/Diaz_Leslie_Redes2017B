/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1redes;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JOptionPane;

public class ClientUDP {
    private static int SERVER_PORT = 9091;
     public static void main(String[] args) throws IOException {
     String serverAddress = JOptionPane.showInputDialog("Enter IP Address of a machine that is \n" + 
             "runing the date service in port " + SERVER_PORT + ":");
    
     DatagramSocket clientSocket = new DatagramSocket(); //socket que crea una coneccion UDP - objeto Java
     byte bufferSend[]= serverAddress.getBytes(); //direccion de servidor transformada a bytes (IP) de string a bytes
     DatagramPacket sendPacket= new DatagramPacket(bufferSend,bufferSend.length, 
             InetAddress.getByName(serverAddress),SERVER_PORT);
       // InetAddress.getByName(serverAddress) : Manda la direccion IP de forma InetAddress
     clientSocket.send(sendPacket); //envio el paquete
     
     //Receive packet
    Byte bufferReceive[]= new Byte[128];
    DatagramPacket receivePacket= new DatagramPacket(bufferSend, bufferSend.length);
    clientSocket.receive(receivePacket);
     //Transforma bytes a String
     InputStream myInputStream= new ByteArrayInputStream(receivePacket.getData());
     BufferedReader input = new BufferedReader(new InputStreamReader(myInputStream));
     String answer = input.readLine();
     
     //despliega mensaje
     JOptionPane.showMessageDialog(null, answer);
     clientSocket.close();
     System.exit(0);
     }
    
}

