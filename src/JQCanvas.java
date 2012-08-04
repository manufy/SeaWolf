import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.util.*;

public class JQCanvas extends Canvas  implements CommandListener {
	
  
	
   Command leftcommand;
   Command rightcommand;
   JQMIDlet midlet;
   JQScreenManager  Screenmanager;
   JQInput   input;
   int height;
   int width;
   
  	
   JQCanvas(JQMIDlet e, JQScreenManager sm) {
   	height      = getHeight();
        width       = getWidth();
        Screenmanager = sm;
	midlet = e;
	//System.out.println ("TYa:"+ input.upKey);
	
	input = new JQInput(e);	
	input.upKey = 1; //( UP );		
	input.downKey = 6;
	input.leftKey = 2;
	input.rightKey = 5;
	input.fireKey = 8;
}


  
   protected void paint( Graphics g ){
     	//g.setColor( 255, 255, 255 );
  	//g.fillRect( 0, 0, width, height );
  	//g.setColor( 0, 0, 0 );
  
  	
	
      	Screenmanager.activeScreen.paint(g);
  	
      
      	
  }
  
  
  public void commandAction (
		Command c, Displayable s) {
		Screenmanager.activeScreen.commandAction(c,s);
		}
	
	
	protected void keyPressed(int keyCode) {
  		 input.Press(getGameAction(keyCode));
        }
        
       protected void keyRepeated(int keyCode) {
	if (hasRepeatEvents())
  	 {
  	    keyPressed(keyCode);
  	 }
        }  	
	protected void keyReleased(int keyCode) {
         input.Release(getGameAction(keyCode));
        }
}

	
	
	
 
  
 