//import CounterChangeListener;

public class CounterTest implements CounterChangeListener
{
	public static void main(String args[])
	{
		CounterTest et = new CounterTest();
	}
	
	public  CounterTest()
	{
		Counter c = new Counter();
		c.addCounterChangeListener(this);
		
		Counter b = new Counter();
		b.addCounterChangeListener(this);
		c.startCounting();//b.startCounting();
	}
	
	public void counterChange(CounterEvent evt)
	{
		System.out.println("Counter valu has changed:"
				+ evt.getCount());
	}

	
	
}
