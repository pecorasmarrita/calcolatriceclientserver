package src;

public class ClientApplication 
{

	public static void main (String[] args) 
	{
        CalcolatriceClient client=new CalcolatriceClient();
        client.connection();
        client.send();
    }
	
}
