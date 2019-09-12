package cn;
import java.util.*;
import java.net.*;
public class server
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("----SENDER----");
		DatagramSocket ds=new DatagramSocket();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Message");
		while(true)
		{
			String msg=s.nextLine();
			InetAddress ip= InetAddress.getByName("127.0.0.1");
			DatagramPacket dp=new DatagramPacket(msg.getBytes(),msg.length(),ip,3000);
			ds.send(dp);
		}
	}
}
