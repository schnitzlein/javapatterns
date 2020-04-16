package kaffeeladen;

import java.util.ArrayList;
import java.util.List;

//Controller

public class Application implements IFramework{

	Product myProduct = new Product(new Kaffee());  //failsafe
	
	List<Product> list1 = new ArrayList<Product>();
	

	
	
	public Application(){
		
		list1.add(myProduct); //Kaffee pur
	}
	
	
	//Cappuccino ( Kaffee + Sahne + Schokostreusel)
	public Product makeCappucino(){
		
		Kaffee k = new Kaffee();
		k.add(new Milch());
		k.add(new Sahne());
		k.add(new Schokostreusel());
		k.setName("Cappucino");
		makeProduct(k);
		
		return myProduct;
	}
	
	// Latte Macchiato (Kaffee + Milch + Milchschaum)
	public Product makeLatteMacciato(){
			
			Kaffee k = new Kaffee();
			k.add(new Milch());
			k.add(new Milchschaum());
			k.setName("Latte Macchiato");
			makeProduct(k);
			
			return myProduct;
	}
	
	// doppelter Espresso mit Zucker
	public Product makeDoppelterEspresso(){
				
				Espresso k = new Espresso();
				k.add(new Zucker());
				k.setName("Espresso");
				makeProduct(k);
				
				return myProduct;
	}
	
	//make neues Product isn: Kaffee, Mocca, DeCaf, Espresso
	@Override
	public void makeProduct(IKaffee k) {
		myProduct = new Product(k);
		
	}


	public List<Product> getList1() {
		return list1;
	}

	public void setList1(List<Product> list1) {
		this.list1 = list1;
	}

	@Override
	public Product getProduct() {
		return myProduct;
	}

	//aufaddieren der Decorator elemente Preise
	@Override
	public double Rechnung(List<IKaffee> liste) {
		if(liste.isEmpty() == true) return myProduct.getProdukt().getPreis();
		else {
			double summe = myProduct.getProdukt().getPreis();
			for ( IKaffee k : liste ){
				summe += k.getPreis();
			}
		  return summe;
		}
	}

}