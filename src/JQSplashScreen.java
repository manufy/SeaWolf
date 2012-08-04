import javax.microedition.lcdui.*;


public class JQSplashScreen extends JQScreen implements CommandListener {


	JQSprite   fondo;
	int timer;
	
        JQSplashScreen(JQMIDlet m, String pantallafondo, int timeout) {
   	
   		fondo = new JQSprite(pantallafondo,0,0);
		midlet = m;
		timer = timeout;
			
	}
   public void paint( Graphics g ){

       fondo.paintfull(g,0,0);
     
  }
  
  
  // Si se salta la presentacion, pasa al siguiente estado
   public void commandAction (
		Command c, Displayable s) {
		
		if (c == midlet.jmcanvas.leftcommand) {
			//midlet.screenmanager.attach(midlet.screenmenu);
			midlet.exit();
		}
		
		
		
		}
	
	public void activate() {
		midlet.jmcanvas.leftcommand = new Command(midlet.resourcestrings.getString(midlet.resourcestrings.ID_GAME_SKIP), Command.SCREEN, 1);
   		midlet.jmcanvas.addCommand(midlet.jmcanvas.leftcommand);
   				
	}
 	public void deactivate() {
		midlet.jmcanvas.removeCommand(midlet.jmcanvas.leftcommand);
	}
	public void run()
	{ 
	// System.out.println(midlet.screenmanager.elapsed);
	
	 if (midlet.screenmanager.elapsed > timer)
	{  
		midlet.start();
		//midlet.exit();
	//deactivate();

//	   midlet.screenmanager.attach(midlet.screenmenu);
		//commandAction(midlet.jmcanvas.leftcommand,this);
	}
	//	{midlet.screenmanager.attach(midlet.screenmenu);}
	}
	
  
  }