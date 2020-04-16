package Uhr;

//VIEW4

//Konsolenuhr
public class View implements IObserver {
	   protected UhrVerwalter myUhr = null;
	 
	   public void setzeSubjekt(UhrVerwalter s) {
	     if (this.myUhr != null)
	       this.myUhr.delete(this);
	 
	     this.myUhr = s;
	 
	     if (this.myUhr != null)
	       this.myUhr.register(this);
	   }
	 
	   public void update() {
	     System.out.println(this.myUhr.getDate());
	   } 
	
}