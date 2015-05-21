import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_ADDPeer;


public class Servidor {

	
		ServerSocket server;
		Socket socket;
		int Puerto=9000;
		DataOutputStream salida;
		BufferedReader entrada;

		
		
		
		public void inicio(){
			while(true){
			try {
				
				server =new ServerSocket(Puerto);
				socket=new Socket();
				System.out.println("Esperando Cliente");
				socket=server.accept();
				entrada=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String mensaje=entrada.readLine();
				System.out.println("Mensaje de entrada:"+mensaje);
				salida=new DataOutputStream(socket.getOutputStream());
				salida.writeUTF("Servidor:"+mensaje);
				System.out.println("Servidor: "+mensaje);
			socket.close();
			server.close();
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
			}
			
			
			
		}
	

}
