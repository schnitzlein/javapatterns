package Uhr;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
 
public class UhrVerwalter implements Runnable {
 
  private List<IObserver> clock_listener = new ArrayList<IObserver>();
 
  private Date next = null;
  //private Date now = new Date();
  private Thread thread;
  
   
  public UhrVerwalter(){
	  start();
  }
  
  private void newsForOberserver() {
    for (IObserver b : clock_listener)
      b.update();
  }
 
  public void delete(IObserver b) {
    clock_listener.remove(b);
  }
 
  public Date getDate() {
    return next;
  }
 
  public void register(IObserver b) {
    clock_listener.add(b);
  }
 
  public void updateDate(Date neu) {
    next = neu;
    newsForOberserver();
  }

  
  
  public void start() {
    if (thread == null) {
      thread = new Thread(this);
      thread.start();
    }
  }
  
  //informiert die listener ueber ein neues Datum
  public void tickTack(){
	  updateDate(new Date());
  }
  
 
  
  public void run() {
    
    while (true) {
    
      tickTack();
      
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (Exception e){;
      }
    }
  }
  
}//UhrVerwalter