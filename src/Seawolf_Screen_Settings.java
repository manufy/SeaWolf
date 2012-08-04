
import javax.microedition.lcdui.*;


public class Seawolf_Screen_Settings extends JQScreen implements CommandListener {



        Seawolf_Screen_Settings(JQMIDlet m) {
   	

		//barco2.load("/barcos.png");		
	}
	
	public void paint( Graphics g ){
    

 	g.fillRect(0,0,midlet.jmcanvas.height,midlet.jmcanvas.height); 
	g.setClip(0,0,midlet.jmcanvas.height,midlet.jmcanvas.height);
  	g.drawString("Settings",0,0, Graphics.TOP|Graphics.LEFT);
   	
  	
  	
	}
	
	
	public void commandAction (
		Command c, Displayable s) {
		
		if (c == midlet.jmcanvas.leftcommand) {
			midlet.screenmanager.attach(midlet.menuscreen);
			
		}	
		}
	
	public void activate() {
		midlet.instancemanager.reset();
   		
		midlet.jmcanvas.leftcommand = new Command(midlet.resourcestrings.getString(midlet.resourcestrings.ID_GAME_MENU), Command.SCREEN, 1);
   		midlet.jmcanvas.addCommand(midlet.jmcanvas.leftcommand);  		   					
	}
 	public void deactivate() {
		midlet.jmcanvas.removeCommand(midlet.jmcanvas.leftcommand);
	}
	
	public void run()
	{	
		midlet.jmcanvas.repaint(); 
		}
}