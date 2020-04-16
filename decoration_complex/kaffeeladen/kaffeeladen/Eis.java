package kaffeeladen;

public class Eis extends Decorator{
    
	IKaffee worein;
	double preis = 1.00;
	
	public Eis(){
	//public Eis(IKaffee meinKaffee){
	  //super(meinKaffee);
	  //worein = meinKaffee;
	  this.setItem("Eis");	
	}
	
	@Override
	public void add(IKaffee kaffeeElement){
    
        //super.operation();
        //System.out.println("Eis");
    }
	
	@Override
	public double getPreis() {
		return preis;
	}
	
	
}
