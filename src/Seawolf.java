
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
//import java.util.*;

// MIDLet básico, responde a acciones de teclado
public class Seawolf extends JQMIDlet implements CommandListener{
	
	// Pantallas canvas
	
	// 1 - Intro
	// 2 - Menu
	// 3 - Game
	// 4 - HiScore
	// 5 - Acerca de 
	
	
	//Seawolf_Screen_Game pantalla;
	//Seawolf_Screen_Menu subkillermenu;

	// Comenzar MIDlet, inicialización de JQEngine
	
	public void startApp() {
		System.out.println ("startApp Seawolf");     // Debug
		display.setCurrent(jmcanvas);			 // Enlazamos el Canvas al MIDlet
		startApp2(); 					 // inicializa el Midlet de base, JQMIDlet
		
	   	intro = new JQSplashScreen(this,"/intro.png",3);   // Splash Screen
	    	screenmanager.attach(intro);			 // enlazamos la splash al canvas
	 	screenmanager.start();	    			 // empieza la fiesta
	 
	}

	// Comienza juego o menu, despues de presentar splashscreen

	public void start() {	
		mainscreen     = new Seawolf_Screen_Game(this);            // Crea pantalla principal
		menuscreen     = new Seawolf_Screen_Menu(this);       // Crea los menus
		aboutscreen     = new Seawolf_Screen_About(this);       // Crea los menus
		helpscreen     = new Seawolf_Screen_Help(this);       // Crea los menus
		settingsscreen = new Seawolf_Screen_Settings(this);       // Crea los menus
		hiscorescreen = new Seawolf_Screen_HiScores(this);       // Crea los menus
	  	screenmanager.attach(menuscreen);			 // Enlaza al canvas
	  	
		//subkillermenu.startmenu();				 // Inicializa juego
	}

	// Pausa
	
	public void pauseApp() { 
		System.out.println ("pauseApp Seawolf");
		}

	// Destruir
	
	public void destroyApp (boolean unconditional) {
		
		System.out.println ("destroyApp Seawolf");
	//screenmanager.stop = true;
	//System.out.println ("destroyApp");
	}

public void commandAction (
		Command c, Displayable s) {
	
	}



}