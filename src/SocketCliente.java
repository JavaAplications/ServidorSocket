import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextArea;

import BBDD.Conexion;



public class SocketCliente extends Thread{
	
	Socket sock;

     private DataOutputStream dos;
    private DataInputStream dis;
    

    String NombreCliente;
    BufferedReader entrada ;

    PrintWriter salida;
	public SocketCliente (Socket sock){
		
		this.sock=sock;
		
		
	}
	
  
     
   

public void desconnectar() {
    try {
    	sock.close();
    } catch (IOException ex) {
       
    }
}

public void run() {
	  try {
            NombreCliente=sock.getInetAddress().getHostName();
       	 entrada = new BufferedReader(new InputStreamReader(sock.getInputStream()));
     	String datos = entrada.readLine();
		System.out.println(" Cliente "+NombreCliente+" dice:"+datos);
         	 salida= new PrintWriter(new OutputStreamWriter(sock.getOutputStream()),true);
         salida.write("El servidor dice: "+datos);
         	 
       } catch (IOException ex) {
           
       }
	
	
}
}
