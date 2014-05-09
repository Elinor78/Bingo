import java.util.EventObject;


public class CounterEvent extends EventObject
{
	private int count;
	CounterEvent(Object source, int c)
	{
		super(source);
		count = c;
	}
	
	public int getCount()
	{
		return count;
	}
	
}
