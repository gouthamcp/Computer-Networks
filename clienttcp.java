package cn;
import java.io.*;
import java.net.*;
import java.util.*;
public class clienttcp
{
	public static void main(String[] args)
	{
		Socket socket=null;
		try
		{
			socket= new Socket (InetAddress.getLocalHost(),9912);
			BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer=new PrintWriter(socket.getOutputStream(),true);
			System.out.println("Enter file name");
			Scanner t=new Scanner(System.in);
			String file=t.nextLine();
			writer.println(file);
			System.out.println("Reading Client................");
			String h=null;
			while((h=reader.readLine())!=null)
					{
						System.out.println(h);
					}
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
