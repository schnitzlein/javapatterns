
import java.util.Scanner;




public class GebuehrKonsole {
 
  private int art = 0;
  private String titel = "";

  
  private float betrag = 0.0f;
  private int seitenZahl = 0; 
  private int wochenZahl = 0;
  
  private String benachrichtigungsAuswahl = "eMail"; 
 
  private String gebuehrArt = "";
  
  Scanner scan = new Scanner(System.in); 
  
  public GebuehrKonsole(int art) {

    this.art = art;
    
    switch (art) {
      case 1: gebuehrArt = "Betrag";
              break;
      case 2: gebuehrArt = "Seitenzahl";
              break;
      case 3: gebuehrArt = "Wochenzahl";
              break;
      case 4: gebuehrArt = "Benachrichtigungsart"; 
      break;
    } 
    logik();
    
  }//GebuehrKonsole


  public void abfrage(){
	  System.out.println("Moegliche Benachrichtigungen sind: eMail, Brief, Telefon"); //feld ausgeben + schleife bei falsch in funktion stopfen
	    
	    if(gebuehrArt.equals("Benachrichtigungsart")){
	       switch (scan.next()){
	       case "eMail": benachrichtigungsAuswahl = "eMail";
	    	   break;
	       
	       case "Brief": benachrichtigungsAuswahl = "Brief";
		     break;
	       
	       case "Telefon": benachrichtigungsAuswahl = "Telefon";
	         break;
	       
	       }
	    }
  }
  
  public void logik() {
   
      System.out.println("Bitte geben Sie den Titel ein: ");
      titel = scan.next();
      
      System.out.println("Bitte geben Sie die: "+gebuehrArt+ "an");
    
        switch (art) {
          case 1: betrag = scan.nextFloat();
                  break;
          case 2: seitenZahl = scan.nextInt();
                  break;
          case 3: wochenZahl = scan.nextInt();
                  break;
          case 4: abfrage();
                  break;
        }  
  }


  public String getTitel() {
    return titel;
  }
  

  public float getBetrag() {
    switch (art) {
      case 1: return betrag;
      case 2: if (seitenZahl > 20) {
                return 1.5f + 0.15f * seitenZahl;
              } else {
                return 1.5f;
              }
      case 3: if (wochenZahl == 1) {
                return 1.0f;
              } 
              if (wochenZahl == 2) {
                return 2.0f;
              }
              if (wochenZahl <= 5) {
                return 2.0f + 2.5f * wochenZahl;
              }
              return 15.0f;
      case 4: 
    	  if (benachrichtigungsAuswahl.equals("eMail")){
    	    return 0.5f;
          }
    	  if (benachrichtigungsAuswahl.equals("Brief")){
      	    return 1.0f;
          }
    	  if (benachrichtigungsAuswahl.equals("Telefon")){
        	    return 2.0f;
          }
    }
    return 0.0f;
  }
  

  public String toString() {
    switch (art) {
      case 1: return "Beschaedigung: " + titel;
      case 2: return "Fernleihe: " + titel + ", " + seitenZahl + " Seiten";
      case 3: return "Saeumnis: " + titel + ", " + wochenZahl + " Wochen";
      case 4: return "Benachrichtigung: " + titel + ", per " + this.benachrichtigungsAuswahl;
    }
    return "";
  }
  public int getArt() {
		return art;
	}
}
