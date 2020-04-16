import javax.swing.JTextField;

import java.awt.Color;
import java.lang.reflect.Method;

public class KonkreterBefehl implements Befehl{
	//TODO lesen wegen zustand
    // Arraylist bzw. stapel
	//private int zustand = 0;
	
	Empfaenger e = null;
	JTextField tf  = null;
	Color c = null;
	Method method = null;
	
	 String cmdName = "";
	
	public KonkreterBefehl(Object obj, Empfaenger e){
		
		cmdName = obj.getClass().getName();
		
		this.e = e;
				
	}
	
	/* Method m wird setBackground uebergeben, Color
	 * public KonkreterBefehl(Method m){
		tf = e.getTf();
		method = m;
	}*/

    //sehr spezifisch, TODO: unspezifischer mit Objects und so siehe Example1-4
	//in Annahme Empfaenger sei gesetzt worden...
	@Override
	public void commandAction() throws Exception{
	  method = e.getObject().getClass().getMethod( "setBackground", Color.class );
	  method.invoke( e.getObject(), c );
	  
	  //System.out.println(e.getTf().getBackground().toString());
	}
	
	public String cmdName(){
		return method.getName();
	}
	
	//setzt die Farbe, wird in commandAction verwendet
	public void setColor(Color neu){
		c = neu;
	}	
	
	//gibt die Farbe des Befehls zurueck
	public Color getColor(){
		return c;
	}
}
