import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
//import java.util.*;

public class JQMIDlet extends MIDlet implements CommandListener {
	
	JQScreen              mainscreen;
	JQScreen 	      menuscreen;
	JQScreen	      hiscorescreen;
	JQScreen	      aboutscreen;
	JQScreen	      helpscreen;
	JQScreen	      settingsscreen;
	JQScreenManager       screenmanager;
	//JQBulletManager	      bulletmanager;
	JQInstanceManager     instancemanager;
	JQCanvas       	      jmcanvas;
	JQRandom              randomgenerator;
	//JQHighScores highscores;
	
	public JQActorManager actormanager;
	public JQScreen intro;
	//public ScreenMenu  screenmenu;
	//public ScreenStartLevel screenstartlevel;
	//public ScreenEndLevel   screenendlevel;
	//public ScreenHiScore screenhiscore;
	//public ScreenGame  screengame;
	public JQResourceStrings resourcestrings;
	public JQHighScores     highscores;
	public JQSync		sync;
	 //El Display
	public Display display;
	boolean 	   playing; // si false, modo demo timeout en menu y game 30 segundos
	
	
	JQMIDlet() {
		System.out.println ("Constructor JQMIDlet");
		screenmanager = new JQScreenManager(this);
		actormanager = new JQActorManager();
		//bulletmanager = new JQBulletManager();
		instancemanager = new JQInstanceManager(this);
		randomgenerator = new JQRandom();
	    	jmcanvas = new JQCanvas(this, screenmanager); 
	    	jmcanvas.setCommandListener(jmcanvas);
		display = Display.getDisplay(this);    
	    	
		//jmtimer  	= new JQTimer(this);
		//jmtimer.start();
		//System.out.println("fdgcf·");
		
	}
	public void startApp() {
	
		}
	public void start() {}
	public void startApp2() {
		System.out.println ("startApp2 JQMIDlet");
		resourcestrings = new JQResourceStrings();
		highscores      = new JQHighScores();
		sync 		= new JQSync();
		
		playing = false;
			
		
		}
	public void pauseApp() { } 

	public void destroyApp (boolean unconditional) {
	
	}
	
	public void exit(){
		screenmanager.stop = true;
    		destroyApp( true );
    		notifyDestroyed();
	}
	
	public void commandAction(Command c, Displayable d) {}

	
   }