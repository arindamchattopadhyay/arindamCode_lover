import java.util.*;
public class Queue_Example{
	static Stack<Integer> ob1=new Stack<Integer>();
	static Stack<Integer> ob2=new Stack<Integer>();
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
			int c;
		do{
			System.out.println("\n1.>Enter the elements\n2.>Pop out the elements\n3.Exit");
			c=sc.nextInt();
			switch(c)
			{
				case 1:
					insert(sc.nextInt());
					break;
				case 2:
					delete();
					break;
				case 3:
					System.exit(0);
					break;
				default:
					System.out.println("Wrong Choice\n");
					break;

			}
		}
		while(c!=3);


	}
	static void insert(int x)
	{
		
		while(!ob1.isEmpty())
		{
			ob2.push(ob1.pop());
			//ob1.pop();
		}
		ob1.push(x);
		while(!ob2.isEmpty())
		{
			ob1.push(ob2.pop());
			//ob2.pop();
		}
		
		System.out.println("Queue present:-- "+ob1);
	}
	static void delete()
	{
		if(ob1.size()==0)
		{
			System.out.println("Stack underflow");return;
		}
		int x=ob1.pop();
		//ob1.pop();
		    System.out.println("Queue present:-- "+ob1);
	    System.out.println("Element removed  :-- "+x);
	}
	

}
