package bankingsystem;


import java.util.LinkedList;
import java.util.List;

public abstract class Konto {
  
  protected /*@spec_public@*/ double kontostand;
  protected /*@spec_public@*/ double dispo;
  protected /*@spec_public@*/ String kontoinhaber;
  protected /*@spec_public@*/ boolean gesperrt;
  protected /*@spec_public@*/ boolean aktiv;
  protected /*@spec_public@*/ List<Buchung> buchungen;
  
  
  
  //*@ public invariant kontostand >= dispo
  
  /*@ 
  @ ensures Double.isNaN(startkapital) == false && startkapital >= 0 &&  
  @       dispo >= 0 && Double.isNaN(dispo) == false && kontoinhaber != null
  @ && this.kontoinhaber.equals(kontoinhaber) && buchungen != null && kontostand >= 0;
  @*/
  public Konto(String kontoinhaber, double startkapital, double dispo){
    this.kontostand = startkapital;
    this.kontoinhaber = kontoinhaber;
    this.dispo = dispo;
    this.aktiv = true;
    this.gesperrt = false; //hinzugefuegt
    this.buchungen = new LinkedList<Buchung>();
  }
  
  /*@ requires 0 < betrag && gesperrt == false && aktiv == true &&
  @   einzahlerName != null;
  @ assignable kontostand;
  @ ensures kontostand == \old(kontostand) + betrag &&
  @   buchungen.size() == \old(buchungen.size()) +1 &&
  @   \result == true;
  @*/
  public abstract boolean einzahlen(String einzahlerName, double betrag);
  
  /*@ requires 0 < betrag && gesperrt == false && aktiv == true &&
  @   empfaengerName != null && kontostand >= dispo == true;
  @ assignable kontostand;
  @ assignable buchungen;
  @ assignable dispo;
  @ ensures kontostand == \old(kontostand) - betrag &&
  @   kontoinhaber.equals(kontoinhaber) &&
  @   buchungen.size() == \old(buchungen.size()) +1;
  @*/
  public abstract boolean auszahlen(String empfaengerName, double betrag);
  
  
  //*@ ensures \result = \old(kontostand);
  public abstract /*@ pure @*/ double gibKontostand();
  
  /*@ requires aktiv==true && gesperrt == false;
  @*/
  public abstract double gibVerfuegungsrahmen();
  
  
  /*@ requires kontostand == 0;
  ensures gesperrt == true;
  @*/
  public abstract void sperreKonto();
  
  
  /*@ requires gesperrt==false;
  @ ensures gesperrt==true;
  @*/
  public abstract void entsperreKonto();
  
  /*@ requires kontostand==0;
  @ ensures aktiv==false;
  @*/
  public abstract boolean loescheKonto();
  
  /*@ requires aktiv == true && buchungen != null && buchungen.size() > 0;
    @   ensures buchungen != null;
    @*/
  public abstract List<Buchung> gibBuchungen();
  
}//Konto


