import java.util.EventListener;
//package addCounterChangeListener;

public interface CounterChangeListener extends EventListener
{
	public void counterChange(CounterEvent e);
}
