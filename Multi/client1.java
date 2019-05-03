import java.io.*;
import java.net.*;


public class client1 implements Runnable
{

	String str=null;

	Socket s;
	BufferedReader br;
	BufferedReader br1;
	Thread t1=null;
	Thread t2=null;

	DataOutputStream out1;

	public client1()  throws Exception   // consturctor of class
	{


		System.out.println("Server running");
		s=new Socket("localhost",5000);
		System.out.println("Client connected to Server");
		br=new BufferedReader(new InputStreamReader(System.in));
		br1=new BufferedReader(new InputStreamReader(s.getInputStream()));
		out1=new DataOutputStream(s.getOutputStream());


	}


	public void run()
	{
		try
		{
			do
			{

				if(Thread.currentThread()==t1)   // to send mesaage to next client
				{
					System.out.println("Enter message to destination Client");
					str=br.readLine();
					out1.writeBytes(str+'\n');
				}
				else    // to display mesaage to next client
				{ 

					str=br1.readLine();
					System.out.println("Message from source Client:"+str);
				}
			}while(true);
		}

		catch(Exception e1)
		{
		System.out.println("Excpetion"+e1);
		}
	}




public static void main(String args[]) throws Exception
{

	client1 cli=new client1();
	cli.t1=new Thread(cli);
	cli.t2=new Thread(cli);
	cli.t1.start();
	cli.t2.start();

}


}


