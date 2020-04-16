package kaffeeladen;

public class Zucker extends Decorator {
	IKaffee worein;
	double preis = 0.10;
	
	//public Zucker(IKaffee meinKaffee) {
	public Zucker() {
		//super(meinKaffee);
		//worein = meinKaffee;
		this.setItem("Zucker");	
	}
	
	@Override
	public void add(IKaffee kaffeeElemente){
		//super.operation();
		//System.out.println("Zucker");
	}
	
	
	@Override
	public double getPreis() {
		return preis;
	}

}
