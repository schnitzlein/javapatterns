package bankingsystem;

public class Buchung {
  protected double betrag;
  protected String infoText;
  
  /*@ requires betrag >= 0 && infoText != null;
    @ ensures true;
    @*/
  public Buchung(double betrag, String infoText){
    this.betrag = betrag;
    this.infoText = infoText;
  }
  public String gibInfoText(){
    return this.infoText;
  }
}