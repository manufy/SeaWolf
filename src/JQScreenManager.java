//import javax.microedition.midlet.*;
//import javax.microedition.lcdui.*;
//import java.io.*;


// Engine.

public class JQScreenManager extends Thread implements Runnable {
	
	// Objetos
	
        JQMIDlet  midlet;	// MIDlet padre
	JQScreen  activeScreen; // Pantalla activa
	JQSound	  soundmanager;
	
	// Cálculo de timers
	
	long started;
 	long processStarted;
 	long processTime;
 	long elapsed =0;
 	long gameelapsed = 0;
 	
 	int width;
 	int height;
 	
 	boolean forcerepaint;
 	
 	// Flags
 	
 	boolean stop; // Flag de parada
	int exit = 1;
	int framecounter = 0;
	
	
	// Constructor
	
	JQScreenManager (JQMIDlet m) {
		
		
		soundmanager = new JQSound();
		soundmanager.playFile("a.mid");
		midlet = m;
		processStarted = System.currentTimeMillis() ;
		elapsed = 0;	
		stop = false;
		forcerepaint = false;
		activeScreen = null;
	}
	
	
	// Thread principal - Bucle infinito - Game Loop
	
 	public void run(){
  	
  	while (stop==false){  		
  		
  		 // Cálculo de tiempos
  		 
  		 processTime = System.currentTimeMillis() - processStarted;
       		 processStarted = System.currentTimeMillis();
       		 elapsed+=processTime;
       		 gameelapsed+=processTime;
       		 framecounter+=processTime;
       		//System.out.println ("elapsed: " + gameelapsed);     // Debug
	
       
       		// Llamada al run de la pantalla activa
       		 
       		 if (activeScreen == null){}
       		  else
       		    {  		        
       		    	activeScreen.run();
       	  	    }
       		  if (framecounter > 33) // MAX_FPS
       		  { framecounter = 0;
       		
  		  }	
	}  // fin while
   	}  // fin run
   
   	// Enlazar una pantalla
   
  	public void attach( JQScreen s){
  	
  	if (activeScreen == null) 
  		{activeScreen = s;}
 	      else
  	       { 
  	       	 activeScreen.deactivate();
  	       	 activeScreen=s;}
  	activeScreen.activate(); 
     //   midlet.jmcanvas.repaint();
      
	}
	

   
   }