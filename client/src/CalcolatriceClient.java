package src;

import java.io.*;
import java.net.*;
import java.util.*;

public class CalcolatriceClient 
{

	String ip_server="127.0.0.1";
    int porta_server=8888;
    Socket socket;
    BufferedReader keyboard_input;
    String message;
    String answer;
    DataOutputStream sever_input;
    BufferedReader server_output;
    
    public Socket connection ()
    {
        System.out.println("Inizio dell'esecuzione del client.");
        try
        {
            keyboard_input=new BufferedReader(new InputStreamReader(System.in));
            socket=new Socket(ip_server,porta_server);
            sever_input=new DataOutputStream(socket.getOutputStream());
            server_output=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Connessione al server riuscita.");
        }
        catch(UnknownHostException e)
        {
        	System.out.println(e.getMessage());
            System.err.println("Host sconosciuto.");
        }
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            System.out.println("Connessione non riuscita.");
            System.exit(1);
        }
        return(socket);
    }
    
    public void send ()
    {
    	for (;;)
    	{
    		try 
    		{
                System.out.println("Inserire primo numero");
                message=keyboard_input.readLine();
                System.out.println("Invio dati al server.");
                sever_input.writeBytes(message+'\n');
                answer=server_output.readLine();
                System.out.println("Inserire operazione desiderata");
                message=keyboard_input.readLine();
                System.out.println("Invio dati al server.");
                sever_input.writeBytes(message+'\n');
                answer=server_output.readLine();
                System.out.println("Inserire secondo numero");
                message=keyboard_input.readLine();
                System.out.println("Invio dati al server.");
                sever_input.writeBytes(message+'\n');
                answer=server_output.readLine();
                answer=server_output.readLine();
                System.out.println("Risposta da parte del server: "+answer);
                System.out.println("Chiusura connessione.");
                socket.close();
            }
            catch (Exception e) 
    		{
                System.out.println(e.getMessage());
                System.out.println("Errore durante l'invio al server.");
                System.exit(1);
            }
    	}
    }
}
