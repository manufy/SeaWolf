//import javax.microedition.midlet.*;
//import javax.microedition.lcdui.*;
///

// Gestion de teclado

public class JQInput  {

	 public boolean[] keys ={false,false,false,false,false,false,false,false,false,false,false,false,
				 false,false,false,false,false,false,false,false,false,false,false,false,
				 false,false,false,false,false,false,false,false,false,false,false,false,
				 false,false,false,false,false,false,false,false,false,false,false,false,
				 false,false,false,false,false,false,false,false,false,false,false,false,
				 false,false,false,false,false,false,false,false,false,false,false,false,
				 false,false,false,false,false,false,false,false,false,false,false,false,
				 false,false,false,false,false,false,false,false,false,false,false,false,
				 false,false,false,false,false,false,false,false,false,false,false,false,
				 false,false,false,false,false,false,false,false,false,false,false,false };

int    upKey;
int    downKey;
int    leftKey;
int    rightKey;
int    fireKey;

	JQMIDlet m;


  	JQInput(JQMIDlet midlet) { 
  		m = midlet;
  					
  	}
  	
  	
  	public void Press(int KeyIndex) {
  		
  		keys[KeyIndex] = true; 
  		m.screenmanager.forcerepaint = true;
  		}
  		
  	public void Release (int KeyIndex) {
  	
  		keys[KeyIndex] = false;
  		m.screenmanager.forcerepaint = true;
  	
  	}
  	
  	public void reset() {
  	
  		int i;
  		for (i=0;i<10;i++) // ojo al 10
  		    keys[i] = false;
  
  		
  	}	
  	

}