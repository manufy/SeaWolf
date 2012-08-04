import javax.microedition.lcdui.*; // Para el Graphics


class JQInstance {
	
	JQActor actor; 			// Actor relacionado
	int x = 0;
	int y = 0;   // Posicion en pantalla
	
	long gx = 0;
	long gy = 0; // Posicion global
	
	// Fisica
	
	int vx = 0; // Velocidades
	int vy = 0;
	
	int ax = 0;
	int ay = 0; // Aceleraciones
	
	int rx = 0; // Ruido
	int ry = 0; 
	
	int minx;
	int maxx;
	int miny;
	int maxy;
	
	
	long movetimer = 0;
	long speed = 0;
	 
	boolean checklimits = false;
	
	
	boolean markedtodel = false;
	
	int type = 0;	// Tipo de instancia, enemigo, bala, etc.
	
 
 	long elapsed = 0;
 	
 	// Estado de la instancia
 	
 	boolean enabled = false; // true=proceso cycle()
	int state = 0;		 // Estado actual
	
	JQMIDlet midlet;		 // Padre
	int actualsprite = 0;
	boolean loop = false;
	int steps = 0;
		
	JQInstance(JQMIDlet m) {		 // Constructor
		midlet = m;
		
	}
	
	public void draw(Graphics g) {	// Dibuja la instancia dependiendo del estado
		
		//System.out.println ("JQInstance draw");
		actor.draw(g,x,y);
		if (actor.animationfinished)
				markedtodel = true;
	}
	
	
	public void cycle(long msec) {	// Ciclo
		
		// Timers
		
		
       	 	elapsed+=msec;
       	 	movetimer+=msec;
       	 	
       	 	// Estados
       	 	
       	 	actor.cycle(msec);
       	 	
       	 
       	 	// Euler
       	 	
       	 	if (movetimer>speed)
			{ x+=vx;
 			  y+=vy;
 			  movetimer =0; }
		
	   	// Perturbaciones					
					
		if (rx>0) 	
	   	{
			x = x + (midlet.randomgenerator.getRandom(rx));	
	   	}	 
		if (ry>0) 	
	   	{
			y = y + (midlet.randomgenerator.getRandom(ry));	
	   	}	 
	   	
	   	// Limites
	   
	   	if (checklimits) {
	   		
	   			if ((x<minx) || (x>maxx)) {
	   					
	   				markedtodel = true;
	   				//System.out.println("delx");
	   				
	   			
	   		}	
	   		
	   			if ((y<miny) || (y>maxy)) {
	   					
	   				markedtodel = true;
	   			//System.out.println("dely");
	   			
	   		}	
	   		
	   		
	   	}
		
	
}



	void setlimits(int newminx, int newmaxx, int newminy, int newmaxy)
	{	minx  = newminx;
		maxx  = newmaxx;
		miny  = newminy;
		maxy  = newmaxy;
		
		
		}
		
		
	public void reset() {
		
	x = 0;
	y = 0;   // Posicion en pantalla
	
	gx = 0;
	gy = 0; // Posicion global DEPRECATED
	
	// Fisica
	
	vx = 0; // Velocidades
	vy = 0;
	
	ax = 0;
	ay = 0; // Aceleraciones
	
	rx = 0; // Ruido
	ry = 0; 
	
	minx = 0;
	maxx = 0;
	miny = 0;
	maxy = 0;
	
	
	movetimer = 0;
	speed = 0;
	 
	checklimits = false;
	
	
	markedtodel = false;
	
	type = 0;	// Tipo de instancia, enemigo, bala, etc.
	
 
 	elapsed = 0;
 	
 	// Estado de la instancia
 	
 	enabled = false; // true=proceso cycle()
	state = 0;		 // Estado actual
	actualsprite = 0;
	loop = false;
	steps = 0;	
		
		
	}
	
	
	
	
	
}