package deko;



public class DecoratorAfter {


	
	
interface I { 
	void doIt();
	void LevelUp();
	int checkLevel();
}

//hier alle variablen spiechern und vergleichen
static class SpielFigur implements I { 
	int level = 0;
	int MAX_Level = 3;
	
	public void doIt() { System.out.print( "SpielFigur " ); }

	public void LevelUp() {
		if (level < MAX_Level) level++;	
	}

	public int checkLevel() {
		return level;
	} 
	
	


}

//hier weiterleitung der ...
static abstract class D implements I {
   private I core;
   public D( I inner ) { core = inner; }
   public void doIt()  { core.doIt();  }
   public void LevelUp(){ core.LevelUp(); }
   public int checkLevel(){ return core.checkLevel(); }
}

static class X extends D {
   public X( I inner ) { super( inner ); }
   public void doIt()  {
      super.doIt();
      doX();
   }
   private void doX() { System.out.print( 'X' ); }

   /*@Override
   public void LevelUp() {
	 super.LevelUp();
   }

   @Override
   public int checkLevel() {
	return super.checkLevel();
   }*/
}

static class Y extends D {
   public Y( I inner ) { super( inner ); }
   public void doIt()  {
      super.doIt();
      doY();
   }
   private void doY() { System.out.print( 'Y' ); }
}

static class Z extends D {
   public Z( I inner ) { super( inner ); }
   public void doIt()  {
      super.doIt();
      doZ();
   }
   private void doZ() { System.out.print( 'Z' ); }
}

static class B extends D {
	   public B( I inner ) { super( inner ); }
	   public void doIt()  {
	      super.doIt();
	      doB();
	   }
	   private void doB() { System.out.print( 'B' ); }
}


}

