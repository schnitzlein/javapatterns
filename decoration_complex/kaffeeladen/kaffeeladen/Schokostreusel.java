package kaffeeladen;

public class Schokostreusel extends Decorator{
	
	IKaffee worein;
	double preis = 0.20;
	
	//public Schokostreusel(IKaffee meinKaffee) {
	public Schokostreusel() {
		//super(meinKaffee);
		//worein = meinKaffee;
		this.setItem("Schokostreusel");	
	}
	
	@Override
	public void add(IKaffee kaffeeElemente){
		//super.operation();
		//System.out.println("Schokostreusel");
	}
	
	
	@Override
	public double getPreis() {
		return preis;
	}

}
