package obsPattern;

import java.util.ArrayList;
import java.util.List;

import kaffeeladen.Product;

public class ConcreteObserver implements IObserver{

	 List<Product> produktListe = new ArrayList<Product>();
	
	 double summe = 0.0;
	 
	public double getSumme() {
		return summe;
	}

	public void setSumme(double summe) {
		this.summe = summe;
	}

	
	/*aktualisiert der aktuellen Preis der zu kaufenden Produkte
	* fuer die Rechnung.
	*/
	@Override
	public void update() {
		int i = 0;
		for (Product p : produktListe){ 
				//summe += p.getProdukt().getkListe().get(i).getPreis();
				double wert = p.getProdukt().getkListe().get(i).getPreis();
				String name = p.getProdukt().getkListe().get(i).getName();
				System.out.println("Preis: "+wert+ " fuer "+name);
				//System.out.println("Summe "+summe);
				i++;
			
		}

	}

	public List<Product> getProduktListe() {
		return produktListe;
	}

	public void setProduktListe(List<Product> produktListe) {
		this.produktListe = produktListe;
	}

	
	
}
