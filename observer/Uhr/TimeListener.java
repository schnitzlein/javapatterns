package Uhr;

import java.util.EventListener;


public interface TimeListener extends EventListener{

	public void timePerformed(TimeEvent e);
}
