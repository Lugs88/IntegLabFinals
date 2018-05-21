

import java.lang.*;
import java.util.*;
import java.io.*;


public class Test
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		DB obj=new DB();

		String user = input.nextLine();
		String password = input.nextLine();


		if(obj.login(user,password))
		{
			System.out.println("Correct Password");
			//System.out.println(obj.login(user,password));
		}
		else
		{
			System.out.println("Wrong Password");
			//System.out.println(obj.login(user,password));
		}
	}
}