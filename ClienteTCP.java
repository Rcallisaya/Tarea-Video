package TCP;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ClienteTCP {
	public static void main(String[] args) throws IOException{

		Socket socketCliente =null;
		Scanner reader = new Scanner(System.in);
		BufferedReader entrada =null;
		PrintWriter salida =null;
		System.out.println("Cliente iniciado");
		try {
			socketCliente = new Socket("localhost",8888);
			entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
			salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())),true);
		} catch (Exception e) {
			System.out.println(e);
		}
		BufferedReader sc= new BufferedReader(new InputStreamReader(System.in)); 
		try {
			System.out.println("Menu");
			System.out.println("Opcion 1");
			System.out.println("opcion 2");
			System.out.println("Opcion 3");
			System.out.println("Opcion 4 salir");
			while (true) {
				int ca=0; String cadena="";
				int die=0;
				while(die==0) {
					System.out.println("Seleccione opcion");
					ca=reader.nextInt();
					switch(ca) {
					case 1:
						cadena="piedra";
						salida.println(cadena);
						break;
					case 2:
						cadena="papel";
						salida.println(cadena);	
						break;
					case 3:
						cadena="tijera";
						salida.println(cadena);			
						break;
					case 4:
						cadena="";
						salida.println(cadena);	
						die=1;
						break;
					default:
						cadena="";
						salida.println(cadena);
						System.out.println("Seleccione una opcion");
						break;
					}	
					cadena=entrada.readLine();
					System.out.println("Usted eligio "+cadena);
				}
				System.out.println("exit?");
				String cad=sc.readLine();
				if (cad.equals("exit"))break ;

			}
		} catch (Exception e) {

		}
		salida.close();
		entrada.close();
		sc.close();
		socketCliente.close();
	}
}