import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;


public class QueueDemo 
{
	public void showOperations()
	{
		PriorityQueue<Integer> piq = new PriorityQueue<Integer>();
		PriorityBlockingQueue<Integer> pbqi = new PriorityBlockingQueue<Integer>();
		ArrayDeque<Integer> adqi = new ArrayDeque<Integer>();
		
		//offer/add
		for (int i = 0; i < 10; i++)
		{
			piq.offer(i);
			pbqi.offer(i * 2);
			adqi.add(i * 4);
		}
		
		//peek/poll
		while (piq.peek() != null)
		{
			System.out.println("Next item from PIQ: " + piq.poll());
		}
		while (pbqi.peek() != null)
		{
			System.out.println("Next item from PBQI: " + pbqi.poll());
		}
		
		//element/remove
		//while (adqi.element() != null)  --> won't work because it throws an exception
		try
		{
			while (adqi.element() != null)
			{
				System.out.println("Next item from adqi: " + adqi.remove());
			}
		}
		catch(Exception ex)
		{
			System.out.println("Exception was thrown:");
			ex.printStackTrace();
		}
		System.out.println("Done");
	}
}
