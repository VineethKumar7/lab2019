import java.io.*;
import java.net.*;
import java.lang.Thread;

public class server1 implements Runnable 
{

	String str;
	ServerSocket ser;
	Socket s,s1;
	BufferedReader br;
	BufferedReader br1;
	Thread t1=null;
	Thread t2=null;
	PrintWriter pw,pw1;
	DataOutputStream out1,out2;

	public server1() throws Exception    // consturctor of class
	{


		ser=new ServerSocket(5000);
		System.out.println("Server running");
		s=ser.accept();                                        //socket to accept connection request from first client
		System.out.println("-----Client1 connected-------");
		s1=ser.accept();			//socket to accept connection request from second client
		System.out.println("-----Client2 connected-------");
		br=new BufferedReader(new InputStreamReader(s.getInputStream()));    //BufferedReader for first client
		br1=new BufferedReader(new InputStreamReader(s1.getInputStream()));    //BufferedReader for 

													//second client



		out1=new DataOutputStream(s.getOutputStream());  // to write by client1 
		out2=new DataOutputStream(s1.getOutputStream());   // to write by client2




	}


	public void run()     // throws Exception not possible for run method of thread son include try catch clause
	{ 
		try
		{
			do
			{

				if(Thread.currentThread()==t1) //for read input from first client
				{

				str=br.readLine();


				out2.writeBytes(str+'\n');   // write through client2 socket 
				 } 
				if(Thread.currentThread()==t2) //for read input from second client
				{

				  str=br1.readLine();   


				out1.writeBytes(str+'\n');		// write through client1 socket 
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

	server1 serv=new server1();
	serv.t1=new Thread(serv);
	serv.t2=new Thread(serv);
	serv.t1.start();
	serv.t2.start();


}


}
