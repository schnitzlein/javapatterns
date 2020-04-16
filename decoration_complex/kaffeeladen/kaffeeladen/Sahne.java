package kaffeeladen;

public class Sahne extends Decorator{

	IKaffee worein;
	double preis = 0.50;
	
	public Sahne() {
	//public Sahne(IKaffee meinKaffee) {
		//super(meinKaffee);
		//worein = meinKaffee;
		this.setItem("Sahne");	
	}
	
	@Override
	public void add(IKaffee kaffeeElemente){
		//super.operation();
		//System.out.println("Sahne");
	}
	
	@Override
	public double getPreis() {
		return preis;
	}

}
