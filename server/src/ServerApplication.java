package src;

public class ServerApplication 
{

	public static void main (String[] args)
	{
        CalcolatriceServer server=new CalcolatriceServer();
        server.waitForClient();
        server.calculate();
    }
	
}
