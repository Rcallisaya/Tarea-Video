package UDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class ClienteUDP {
   public static void main(String[] args){
     
       System.out.println("Cliente UDP Iniciado");
       try {
           DatagramSocket socketUDP = new DatagramSocket();   
           int puerto = 8888;
           InetAddress host = InetAddress.getByName("localhost");
           BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
           String cad; 
           while (true) {               
           cad = sc.readLine();
               if (cad.equalsIgnoreCase("0")) break;   
           byte [] men = cad.getBytes();
           DatagramPacket peticion = new DatagramPacket(men, cad.length(), host, puerto);
           socketUDP.send(peticion);
           byte [] buffer = new byte[10000];
           DatagramPacket mensaje = new DatagramPacket(buffer, buffer.length);
           socketUDP.receive(mensaje); 
           String sms =new String(mensaje.getData());
           String x = conv(sms, mensaje.getLength());
           System.out.println("La cadena contiene : "+x);
           }      
       } catch (Exception e) {
           System.out.println(e);
       }         
   }
   
   public static String conv(String x, int ta) {
       String res = "";
       for (int i = 0; i < ta; i++) {
           res += x.charAt(i);
       }
       return res;
   }
   
}