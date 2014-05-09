import java.util.Vector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.EventListenerList;

public class Counter extends Thread
{
	private Vector listeners = new Vector();
	private int count =0;
	
	public Counter (int c)
	{
		count = c;
	}
	
	public Counter()
	{
		this(0);
	}
	
	public void run()
	{
		while (true)
		{
			try
			{
				sleep( (int)Math.round(Math.random() * 3000));
			}
			catch (InterruptedException e) {}
			count++;
			notifyCounterChange(count);
		}
	}
	
	public void startCounting()
	{
		this.start();
	}
	
	protected void notifyCounterChange(int count)
	{
		Vector tmpList;
		CounterEvent ce = new CounterEvent(this, count);
		
		synchronized (this)
		{
			tmpList = (Vector)listeners.clone();
		}
		
		for(int i=0; i < tmpList.size(); i++)
		{
		   Object t=tmpList.elementAt(i);
		
			//( (CounterChangeListener) (tmpList.elementAt(i))).counterChange(ce);
			 (( CounterChangeListener)  t).counterChange(ce);
		}
	}	
		//public synchronized void addCounterChangeListener(CounterChangeListener ccl) throws TooManyListenersExceptions
		public synchronized void  addCounterChangeListener(CounterChangeListener ccl)
		{
			listeners.addElement(ccl);
		}
		
		public synchronized void removeCounterChangeListener(CounterChangeListener ccl) 
		{
			listeners.removeElement(ccl);
		}  
	
}
