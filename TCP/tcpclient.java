import java.io.*;
import java.net.*;
class tcpclient{
	public static void main(String[] args) throws Exception 
	{
		System.out.println("Client sending connection request to server");
		Socket ss= new Socket("localhost",7000);
		System.out.println("Connection Established :)");
		System.out.println("Enter the messagge for server");
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br2= new BufferedReader(new InputStreamReader(ss.getInputStream()));
		String obj = new String();
		DataOutputStream obj2= new DataOutputStream(ss.getOutputStream());
		do{
			obj = br.readLine();
			obj2.writeBytes(obj + "\n");
			obj=br2.readLine();
			System.out.println("Message from Server : "+ obj);

		}while(!obj.equals("quit"));
	
	}
}
