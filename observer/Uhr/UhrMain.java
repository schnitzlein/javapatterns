package Uhr;

import java.util.Date;

public class UhrMain {
	   public static void main(String[] args) {
	     
		 //fügt views in die Observable Liste ein
		 UhrVerwalter s = new UhrVerwalter();
		 Date begin = new Date();
	     
		 
	     //Die VIEWS
	     DigitalUhrEU view1 = new DigitalUhrEU("HH:mm:ss");
	     RestUhrTag view2 = new RestUhrTag("HH:mm:ss");
	     DigitalUhrUS view3 = new DigitalUhrUS("hh:mm:ss aa");
	     //View view4 = new View();
	     
	     view1.setzeSubjekt(s);
	     view2.setzeSubjekt(s);
	     view3.setzeSubjekt(s);
	     //view4.setzeSubjekt(s);
	     
	 
	     //s.setzeZustand("intervall1");
	     //s.setzeZustand("intervall2");
	     //s.setzeZustand(begin);
	   }
	
}//UhrMain