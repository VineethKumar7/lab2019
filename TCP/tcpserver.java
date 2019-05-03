import java.io.*;
import java.net.*;
class tcpserver{
	public static void main(String[] args) throws Exception 
	{
		System.out.println("TCP server");
		System.out.println("Server waiting for connetion request");
		ServerSocket ss =new ServerSocket(7000);
		Socket objectname = ss.accept();
		System.out.println("Server accepted the connection request");
		BufferedReader br= new BufferedReader(new InputStreamReader(objectname.getInputStream()));
		BufferedReader br2 =new BufferedReader(new InputStreamReader(System.in));
		String obj = new String();
		DataOutputStream obj2= new DataOutputStream(objectname.getOutputStream());

		do{
			obj=br.readLine();
			System.out.println("Message from client : "+ obj);
			System.out.println("Enter the messagge for client");
			obj = br2.readLine();
			obj2.writeBytes(obj + "\n");
		}while(!obj.equals("quit"));
		
	}
}
