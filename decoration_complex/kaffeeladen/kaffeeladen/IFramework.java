package kaffeeladen;

import java.util.List;



public interface IFramework {
	  
	public Product getProduct();

	public void makeProduct(IKaffee k);
		
	public double Rechnung(List<IKaffee> liste);
}