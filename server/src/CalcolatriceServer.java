package src;

import java.io.*;
import java.net.*;
import java.util.*;

public class CalcolatriceServer 
{

	Socket client_socket=null;
	ServerSocket server_socket=null;
    int client_number1=0;
    String client_symbol="";
    int client_number2=0;
    String server_answer=null;
    BufferedReader client_input;
    DataOutputStream client_output;
    
    public Socket waitForClient ()
    {
        try 
        {
            System.out.println("Inizio esecuzione server.");
            server_socket=new ServerSocket(8888);
            System.out.println("Attesa di connessione da parte del client.");
            client_socket=server_socket.accept();
            System.out.println("Connessione del client ricevuta.");
            client_input=new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
            client_output=new DataOutputStream(client_socket.getOutputStream());
        }
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'esecuzione del server.");
            System.exit(1);
        }
        return(client_socket);
    }
    
    public void calculate ()
    {
    		try 
            {
                System.out.println("Attesa del primo numero in input dal client.");
                client_number1=Integer.valueOf(client_input.readLine());
                System.out.println("Primo numero ricevuto.");
                client_output.writeBytes("OK"+'\n');
                System.out.println("Attesa del simbolo dell'operazione in input dal client.");
                client_symbol=client_input.readLine();
                System.out.println("Simbolo ricevuto.");
                client_output.writeBytes("OK"+'\n');
                System.out.println("Attesa del secondo numero in input dal client.");
                client_number2=Integer.valueOf(client_input.readLine());
                System.out.println("Secondo numero ricevuto.");
                client_output.writeBytes("OK"+'\n');
                switch (client_symbol)
                {
                case "+":
                	client_output.writeBytes(String.valueOf(client_number1+client_number2)+'\n');
                case "-":
                	client_output.writeBytes(String.valueOf(client_number1-client_number2)+'\n');
                case "*":
                	client_output.writeBytes(String.valueOf(client_number1*client_number2)+'\n');
                case "/":
                	client_output.writeBytes(String.valueOf(client_number1/client_number2)+'\n');
                case "": 
                	throw new Exception("Simbolo non valido.");
                }
                System.out.println("Operazione completata.");
                client_socket.close();
            }
            catch (Exception e) 
            {
                System.out.println("...");
            }
    }
}
