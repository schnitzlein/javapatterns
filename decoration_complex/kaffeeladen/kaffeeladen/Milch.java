package kaffeeladen;

public class Milch extends Decorator{
	
	IKaffee worein;
	double preis = 0.40;
	
	//public Milch(IKaffee meinKaffee) {
	public Milch() {
		//super(meinKaffee);
		//worein = meinKaffee;
		this.setItem("Milch");	
	}
	
	@Override
	public void add(IKaffee kaffeeElemente){
		//super.operation();
		//System.out.println("Milch");
	}
	
	
	@Override
	public double getPreis() {
		return preis;
	}
}
