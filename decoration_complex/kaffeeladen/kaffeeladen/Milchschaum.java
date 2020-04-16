package kaffeeladen;

public class Milchschaum extends Decorator {
	IKaffee worein;
	double preis = 0.20;
	
	//public Milchschaum(IKaffee meinKaffee) {
	public Milchschaum() {
		//super(meinKaffee);
		//worein = meinKaffee;
		this.setItem("Milchschaum");	
	}
	
	@Override
	public void add(IKaffee kaffeeElemente){
		//super.operation();
		//System.out.println("Milchschaum");
	}
	
	@Override
	public double getPreis() {
		return preis;
	}
}
