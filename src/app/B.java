package app;
import java.util.*;
public class B {

	public static void main(String[] args)
	{
		int i=0, b;
		Scanner keyboard = new Scanner(System.in);
		i = keyboard.nextInt();
		b = foo(i);
		System.out.println(b);
	}
	
	public static int foo(int i)
	{
		if(i==0) return 1;
		else
			return 0;
	}
}
