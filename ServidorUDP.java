package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class ServidorUDP {
   public static void main(String[] args){
       System.out.println("Servidor UDP Iniciado");
       try {
           DatagramSocket socketUDP = new DatagramSocket(8888);
           byte [] buffer = new byte[1024];
           while (true) {               
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
                socketUDP.receive(peticion);
                String cadena = new String(peticion.getData());
                String y = conv(cadena, peticion.getLength());
                int cont = 0;
                String s = "";
                for (int i = 0; i < peticion.getLength(); i++) {
                    s = s + y.substring(i, i+1);
                    if (y.substring(i, i+1).equals(" ")) {
                        cont++;
                    }
                }
                cont++;
                String numCad = cont + " Palabras";
                byte [] respuesta = new byte[1024];
                respuesta = numCad.getBytes();
                DatagramPacket mensaje = new DatagramPacket(respuesta, respuesta.length, peticion.getAddress(), peticion.getPort());
                socketUDP.send(mensaje);
                String sms =new String(peticion.getData());
                String x = conv(sms, peticion.getLength());
                System.out.println(peticion.getLength());
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