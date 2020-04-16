package singleton;

public class Singleton {
  private static Singleton theInstance = null; 

  //Konstruktor, darf nur von Client einmalig aufgerufen werden
  private Singleton() {
	  //erstelle hier eine neue Singleton Klasse, fuer spezifische Aufgaben
	  System.out.println("blah blah singleton");
  } 
	 
  public static Singleton getInstance() { 
	 if (theInstance == null){
	   theInstance = new Singleton(); 
	 }
	    
	 return theInstance; 
  } 
}
