import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





public class GebuehrenVerwaltungKonsole  {

 
  private List<GebuehrKonsole> list = new ArrayList<GebuehrKonsole>();

  private float betrag = 0.0f;
  
  Scanner scan = new Scanner(System.in); 
  GebuehrKonsole gebuehr = null;
  
  private String menu = "";
  
  public GebuehrenVerwaltungKonsole() {
	  listOption(); 
	  
  }
   
public void zeige(){
	int index = list.size();
    if (index >= 0) {
        for (int i=0;i<index;i++){
          System.out.println(index+ " "+ list.get(i).toString());
          betrag += gebuehr.getBetrag();
      	 }
        }
}


public void listOption(){
	int eingabe = 0;
    while(!menu.equals("ende")){
   	 System.out.println("Moegliche Auswahl sind: ");
   	 System.out.println("(1) Neue Beschaedigung");
   	 System.out.println("(2) Neue Fernleihe");
   	 System.out.println("(3) Neues Saeumnis");
   	 System.out.println("(4) Neue Benachrichtigungsgebuehr");
   	 System.out.println("(5) Aendern");
   	 System.out.println("(6) zeigeElemente");
   	 System.out.println("(7) Loeschen");
   	 System.out.println("(8) Ende");
   	 System.out.println("\nGesamtbetrag: "+betrag);

   	 int tmp = 0;
   	 try {
   	  tmp =	scan.nextInt();
   	 } catch( Exception e){}
   	 
   	 switch (tmp){
   	  case 1: gebuehr = new GebuehrKonsole(1); list.add(gebuehr);
   	    break;
   	  case 2: gebuehr = new GebuehrKonsole(2); list.add(gebuehr);
 	        break;
   	  case 3: gebuehr = new GebuehrKonsole(3); list.add(gebuehr);
 	       break;
   	  case 4: gebuehr = new GebuehrKonsole(4); list.add(gebuehr);
 	       break;
   	  case 5: zeige();
             System.out.println("aendern: ");
             eingabe = scan.nextInt();
             
       	  list.set(eingabe, new GebuehrKonsole(list.get(eingabe).getArt()));
       	  break;
   	  case 6: zeige();
   	     break;
   	  case 7: zeige(); 
   	    System.out.println("loeschen: ");
            eingabe = scan.nextInt();
           list.remove(eingabe);
         break;
   	  case 8: menu = "ende"; return;
       }
    }  
   	 
}
  


  public static void main (String[] args) {
    new GebuehrenVerwaltungKonsole();
  }

}
