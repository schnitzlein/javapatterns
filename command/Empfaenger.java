import javax.swing.JTextField; 

public class Empfaenger {
    Object myObj = null;
    JTextField tf = null;

	public Empfaenger(){
		if (myObj == null){
		  myObj = new Object();
		}
		if (tf == null){
			tf = new JTextField();
		}
	}//Konstruktor
	
	/*public Empfaenger(Object obj){
		if (myObj == null){
		  myObj = new Object();
		}
		if (obj.getClass().isInstance(JTextField)){
			tf = obj;
		}
	}//Konstruktor2*/
	
	
	public void setzeEmpfaenger(Object obj){
		myObj = obj;
	}
	
	//gibt das OBjekt zurueck mit dem gearbeitet werden soll
	public Object getObject(){
		return myObj;
	}
	
	
	public JTextField getTf() {
		return tf;
	}

	public void setEmpfaenger(JTextField tf) {
		this.tf = tf;
	}

}
