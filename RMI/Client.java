import java.io.*;

import java.net.*;

import java.rmi.*;

public class Client

{

public static void main(String args[])

{

try

 {

String URL="rmi://localhost/Server";

multiply m=(multiply)Naming.lookup(URL);

System.out.println("number of items purchased:"+args[1]);

int a=Integer.parseInt(args[1]);

System.out.println("Unit price"+args[2]);

int b=Integer.parseInt(args[2]);

System.out.println("The total is"+m.multiply(a,b));

 }

catch(Exception e)

 {

 System.out.println("Exception"+e);

 }

}}