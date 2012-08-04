import javax.microedition.lcdui.*;
import java.util.*;

class JQRandom {
	
	private Random generador = new Random(System.currentTimeMillis());
	
	
	
	JQRandom() {
		System.out.println ("JQRandom constructor");
		
	}
	
	
	public int getRandom(int bound) {
		
		
		return generador.nextInt() % bound;	
		
	}
	
	public int getABSRandom(int bound) {
		
		return Math.abs(generador.nextInt() % bound);	
		
	}		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}