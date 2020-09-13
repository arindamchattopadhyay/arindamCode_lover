/**
 * 
 * @author Arindam
 * @category Multithreading
 * @version 12.0.1
 *
 */
class NewThread implements Runnable{
	Thread t;
	String name;
	NewThread(String threadname){
		name=threadname;
		t=new Thread(this,name);
		System.out.println("Thread "+t);
		t.start();
	}
	public void run()
	{
		try {
			for(int i=5;i>0;i--)
			{
				
				System.out.println(name+" "+i);
				Thread.sleep(1000);
			}
		}
			catch(Exception e)
			{
				System.out.println("Interrupted exception "+e.getMessage());
			}
		System.out.println("Child thread exiting....");
	}
}
public class ThreadExample {
public static void main(String args[])
{
	NewThread ob1=new NewThread("One");
	NewThread ob2=new NewThread("Two");
	NewThread ob3=new NewThread("Three");
	System.out.print("Waiting for the child threads to exit.....");
	try {
		ob1.t.join();
		ob2.t.join();
		ob3.t.join();
	}
	catch(InterruptedException e)
	{
		System.out.println(e.getMessage());
		
	}
	System.out.println("Status of thread "+ob1.t.getName()+" :-- "+ob1.t.isAlive());
	System.out.println("Status of thread "+ob1.t.getName()+" :-- "+ob2.t.isAlive());
	System.out.println("Status of thread "+ob1.t.getName()+" :-- "+ob2.t.isAlive());
	System.out.println("Main thread Exiting... ");
	System.out.println("###Ends....###");
	
}
}
