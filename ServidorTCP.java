package TCP;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

	public static void main(String[] args) throws Exception{
		ServerSocket socketServidor = null;
		Socket socketCliente=null;
		BufferedReader entrada = null;
		PrintWriter salida= null;
		System.out.println("Servidor iniciado");
		try {
			socketServidor = new ServerSocket(8888);	
		} catch (Exception e) {
		}
		try {
			while (true) {
				socketCliente =socketServidor.accept();			
				entrada= new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
				salida= new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())),true);

				while (true) {
					int q=1;
					while(q==1) {
						String cadena=entrada.readLine();
						salida.println(cadena);
						if (cadena.equals("")) {
							q=0;
						}
					}
					String ca2=entrada.readLine();
					salida.println(ca2);
					String cad=entrada.readLine();
					if (cad.equals("exit")) break;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		salida.close();
		entrada.close();
		socketServidor.close();
		socketCliente.close();
	}
}
