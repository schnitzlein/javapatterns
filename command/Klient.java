import java.awt.Color;

import javax.swing.JTextField;


/*Der Klient erzeugt einen konkreten Befehl und versieht ihn mit
  * einem Verweis auf den Empfänger und allen anderen nötigen Informationen.
  Er gibt dem Aufrufer eine Referenz auf den konkreten Befehl. */

public class Klient {
  private int id = 0;
	
  
  Empfaenger myEmpfaenger = new Empfaenger();
  KonkreterBefehl kcmd = new KonkreterBefehl(myEmpfaenger.getObject(),myEmpfaenger);
  
  
  //Konstruktor
  public Klient(int id){
	this.id = id;  
  }
  
  public void setzeEmpfaenger(Empfaenger e){
	  myEmpfaenger = e;
  }

  public Empfaenger getEmpfaenger(){
	  return myEmpfaenger;
  }
  
  //setzt einen neuen Befehl
  public void setCmd(KonkreterBefehl cmd){
	  kcmd = cmd;
  }
  
  public KonkreterBefehl getCmd(){
	  return kcmd;  
  }
   

}
