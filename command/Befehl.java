
import java.awt.Color;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public interface Befehl {
  Method method = null;
	
  String cmdName = "";
  Field field = null;
  
  Object param = null;
  
  /*public Befehl(Object obj, Empfaenger e){
	cmdName = obj.getClass().getName();
	
	
	try { //in Annahme Empfaenger sei gesetzt worden...
		method = e.getObject().getClass().getMethod(cmdName, Color.class);
	} catch (NoSuchMethodException | SecurityException e1) {
		e1.printStackTrace();
	}			 
    
  }*/
  
  //sehr speziell
  public void commandAction() throws Exception;
	  
  

  //fuer setBackground(Color neu)
  //public void commandAction(Color neu);
 
  
}
