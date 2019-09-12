package cn;
import java.io.*;
import java.net.*;
import java.util.*;

public class servertcp 
{

	public static class ClientHandler extends Thread
	{
		private Socket socket;
		ClientHandler(Socket socket)
		{
			System.out.println("Client Connection");
			this.socket=socket;
		}
		public void run()
		{
			try
			{
				BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter writer=new PrintWriter(socket.getOutputStream(),true);
				String file=reader.readLine().trim();
				System.out.println("Requested file is"+file+"\n");
				FileReader fp2=new FileReader(file);
				BufferedReader rr=new BufferedReader(fp2);
				String k=null;
				while((k=rr.readLine())!=null)
				{
					writer.println(k);
				}
				writer.close();
				rr.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					socket.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}	
	}
	public static void main(String[] args)
	{
		final int port=9912;
		try
		{
			ServerSocket ss=new ServerSocket(port);
			System.out.println("Listening.............");
			while(true)
			{
				Socket socket=ss.accept();
				new ClientHandler(socket).start();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
