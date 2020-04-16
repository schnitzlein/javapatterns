package Uhr;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.GridLayout;

//VIEW3

public class RestUhrTag extends JFrame implements IObserver {
	   protected UhrVerwalter myUhr = null;
	 
	   public void setzeSubjekt(UhrVerwalter s) {
	     if (this.myUhr != null)
	       this.myUhr.delete(this);
	 
	     this.myUhr = s;
	 
	     if (this.myUhr != null)
	       this.myUhr.register(this);
	   }
	 
	   
	   
	   // fuer Uhr Program und GUI
	   private JLabel label = new JLabel("");
	   String time = "";
	   String fullDay = "24:00:00";
	   private Font font = new Font("Verdana", Font.PLAIN, 20);
	   Date d1=null,d2=null;
	   
	   SimpleDateFormat sdfmt = new SimpleDateFormat();
	   
	   //Konstruktor of JFrame
	   public RestUhrTag(String uhrFormat){
		   setTitle("Restzeit des Tages Uhr");
		    
		    sdfmt.applyPattern(uhrFormat);
		    
		    this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		    this.setLayout( new GridLayout(2,2) );
		    this.setSize(200,120);
		    label.setFont(font);
		    
		    this.add(label);
		    this.setVisible(true);
	  }
	   
	   public void update() {
	     //System.out.println("Rest Uhr haelt die Klappe.");
		   String time = sdfmt.format(myUhr.getDate());
	       try {
	             d1 = sdfmt.parse(fullDay);
	             d2 = sdfmt.parse(time);
	       } catch (ParseException e) {
	          
	           e.printStackTrace();
	       }
	           
	       long diff = d1.getTime() - d2.getTime();
	       long diffSeconds = diff / 1000 % 60;         
	       long diffMinutes = diff / (60 * 1000) % 60;         
	       long diffHours = diff / (60 * 60 * 1000);
	       
	       String second = "";
	           String minute = "";
	           String hour = "";
	       
	       if (diffSeconds < 10) {
	         second = "0" + (new Long(diffSeconds)).toString();
	       }
	       else {
	             second = (new Long(diffSeconds)).toString();
	       }
	           
	       if (diffMinutes < 10) {
	             minute = "0" + (new Long(diffMinutes)).toString();
	       }
	       else {
	         minute = (new Long(diffMinutes)).toString();
	       }
	       
	       if (diffHours < 10) {
	         hour = "0" + (new Long(diffHours)).toString();
	       }
	       else {
	         hour = (new Long(diffHours)).toString();
	       }
	       
	       String time2 = (hour + ":" + minute + ":" + second);
	       
	       //System.out.println(time2);
	       label.setText(time2);
	       //time = sdfmt.format(myUhr.getDate());
	     }
}//RestUhr
