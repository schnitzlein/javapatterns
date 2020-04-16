package bankingsystem;

import java.util.List;

public class DefaultKonto extends Konto {

	public DefaultKonto(String nutzer, double kapital, double dispo){
		super(nutzer, kapital, dispo);
	}
	
	@Override
	public boolean einzahlen(String einzahlerName, double betrag) {
		Buchung tmp = null;
		try {
		  kontostand += betrag;
		  tmp = new Buchung(betrag, "von "+einzahlerName);	
		  buchungen.add(tmp);
		} catch (Exception e){
			System.out.println("konnte keine neuen Buchung hinzufuegen");
		}
		 if ( buchungen.contains((Buchung)tmp) ) return true;
		 else return false;
	}

	@Override
	public boolean auszahlen(String empfaengerName, double betrag) {
		if ((gibKontostand() - betrag + gibVerfuegungsrahmen()) > 0) {
		Buchung tmp = null;
		try {
		  kontostand -= betrag;
		  tmp = new Buchung(betrag, "an "+empfaengerName);	
		  buchungen.add(tmp);
		} catch (Exception e){
			System.out.println("konnte keine neuen Buchung hinzufuegen");
		}
		 if ( buchungen.contains((Buchung)tmp) ) return true;
		 else return false;
		} else return false; 
	}

	@Override
	public double gibKontostand() {
		
		return this.kontostand;
	}

	@Override
	public double gibVerfuegungsrahmen() {
		return this.dispo;
	}

	@Override
	public void sperreKonto() {
		this.gesperrt = true;
	}

	@Override
	public void entsperreKonto() {
		this.gesperrt = false;
		
	}

	@Override
	public boolean loescheKonto() {
		if (gesperrt == true){
		
		/*try {
			Konto vergleichen = (Konto) this.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			this.finalize();
			return true;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}//if
		return false;
	}

	@Override
	public List<Buchung> gibBuchungen() {
		if (this.buchungen.isEmpty()) return null;
		else return buchungen;
		
	}
	
	


}
