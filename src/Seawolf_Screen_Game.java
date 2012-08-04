
import javax.microedition.lcdui.*;

public class Seawolf_Screen_Game extends JQScreen implements CommandListener {


	public static final int INSTANCE_ENEMY = 0;
	public static final int INSTANCE_DEEPCHARGE = 1;
	public static final int INSTANCE_PLAYER = 2;
	public static final int INSTANCE_EXPLOSION = 3;
	public static final int INSTANCE_SCENERY=4;
	
	public static final int ACTOR_ANIMATION_STATIC  = 0;
	public static final int ACTOR_ANIMATION_ONESHOT = 1;
	public static final int ACTOR_ANIMATION_LOOP    = 2;
	


	JQActor    submarino;
	JQActor    carga;
	JQSprite   sol;
	JQActor   nube;
	JQSprite   fondomar;
	JQSprite   radar;
	JQSprite   mar;
	JQSprite   cielo;
	JQSprite   redspike;
	JQSprite   torpedo;
	JQSprite   indicarga;
	JQActor    explosiontorpedo;
	JQActor    barco2;
	
	int barco_x;
	int barco_y;
	
	
	// Variables del Juego
	
	long recarga_elapsed = 0;
	long recarga_start   = 0;
	long gametime  = 0;
	long submarinetime=0;
	
	int numsubmarinos = 0;
	int maxcargas = 50;
	int cargaslanzadas = 0;
	int cargaslistas = 5;
	int maxcargaslistas = 5;
	int maxdelaycaidacarga = 25;
	int delaycaidacarga = 0;
	int ladodetiro = 0; // oscila entre 0 y 1, izquierda y derecha
	
	int handleplayer = 0; // Handle al instance del player	
	
        Seawolf_Screen_Game(JQMIDlet m) {
   	
   	        mar   = new JQSprite("/mar.png",0,0);
   		indicarga  = new JQSprite("/indicarga.png",0,0);
   		nube  = new JQActor("/nube.png",34,15,1,ACTOR_ANIMATION_STATIC,0);
   		radar = new JQSprite("/radar.png",0,0);
   		redspike = new JQSprite("/redspike.png",0,0);
   		submarino = new JQActor("/submarino.png",56,16,2,ACTOR_ANIMATION_STATIC,0);
   		fondomar = new JQSprite("/fondo.png",0,0);
   		torpedo   = new JQSprite("/torpedo.png",0,0);
   		explosiontorpedo = new JQActor("/exptorp.png",32,28,7,ACTOR_ANIMATION_ONESHOT,100);
   		carga = new JQActor("/carga.png",11,11,2,ACTOR_ANIMATION_LOOP,1000);
   			       	
	
   		barco2 = new JQActor("/barcos.png",50,16,2,ACTOR_ANIMATION_STATIC,0); // filename, tilesizex, tilesizey
   		submarino = new JQActor("/submarino.png",38,11,2,ACTOR_ANIMATION_STATIC,0);
   			       	
   		// AL FINAL: 
   		
		midlet = m;
		
	
		//barco2.load("/barcos.png");		
	}
	
	
   public void startgame()
   {

   
   		

   	handleplayer = createplayer(barco2);
   	
	 recarga_elapsed = 0;
	 recarga_start   = 0;
	 gametime  = 0;
	 submarinetime=0;
		 numsubmarinos = 0;
	 maxcargas = 50;
	 cargaslanzadas = 0;
	 cargaslistas = 5;
	 maxcargaslistas = 5;
	 maxdelaycaidacarga = 25;
	 delaycaidacarga = 0;
	 ladodetiro = 0; // oscila entre 0 y 1, izquierda y derecha
   	//createnube(nube);
	//createnube(nube);
   	}
   
	
	
   public void paint( Graphics g ){
    

 	 
	
  	mar.paintfill(g); 
  	fondomar.paintfull(g,0,108);
  	fondomar.paintfull(g,65,108);
  	
//  	nube.paintfull(g,barco_x/2,0);
   
  	radar.paintfull(g,45,0);
//  	redspike.paintfull(g,20+(barco_x/4),5);
  
 //     barco.paint(g,barco_x,barco_y,0);
  //  barco.paintfull(g,barco_x,barco_y);
  //	g.setColor(255,255,255);
   	
  //    g.drawString ("intro", 
  //         barco_x, barco_y, Graphics.TOP|Graphics.LEFT);
           
           
//   submarino.paintfull(g,submarino.x,submarino.y);           
//   torpedo.paintfull(g,torpedo.x,torpedo.y);
//barco2.draw(g);


	midlet.instancemanager.draw(g);
//	midlet.actormanager.draw(g);
//	midlet.bulletmanager.draw(g);
	g.setClip(0,0,100,100);
	//g.drawString("Ready: " + cargaslistas,0,0, Graphics.TOP|Graphics.LEFT);
   	g.drawString("" + (maxcargas-cargaslanzadas),95,0, Graphics.TOP|Graphics.LEFT);
   	g.drawString("T:" + (gametime/1000),0,10, Graphics.TOP|Graphics.LEFT);
   	int i;
   	int cx = 0;
   	for (i=0;i<cargaslistas;i++)
   	{
   		indicarga.paintfull(g,cx,0);	
   		cx+=5;
   	}
   	drawradar(g);
  }
  
  
  // Si se salta la presentacion, pasa al siguiente estado
   public void commandAction (
		Command c, Displayable s) {
		
		if (c == midlet.jmcanvas.leftcommand) {
			midlet.screenmanager.attach(midlet.menuscreen);
			//midlet.exit();
		}
		
		
		
		}
	
	public void activate() {
		midlet.jmcanvas.leftcommand = new Command(midlet.resourcestrings.getString(midlet.resourcestrings.ID_GAME_MENU), Command.SCREEN, 1);
   		midlet.jmcanvas.addCommand(midlet.jmcanvas.leftcommand);
   		midlet.instancemanager.reset();
   		startgame();
   		
   		
   				
	}
 	public void deactivate() {
		midlet.jmcanvas.removeCommand(midlet.jmcanvas.leftcommand);
	}
	
	
	
	
	public void run()
	{ 
		
	
	 gametime+=midlet.screenmanager.elapsed;
	 if (cargaslistas < 5) { recarga_elapsed+=midlet.screenmanager.elapsed;	
         	//System.out.println(recarga_elapsed);
         if (recarga_elapsed>5000) 
         	 { recarga_elapsed = 0;
         	   if (cargaslistas < maxcargaslistas)
         	   	cargaslistas++;
         	}
	}
	 
	 
	 if (gametime>100)
	 {
	 			midlet.screenmanager.attach(midlet.hiscorescreen);
	 	
	}
	 
	 	
	 if ((midlet.screenmanager.elapsed) >10)
         { if (midlet.jmcanvas.input.keys[midlet.jmcanvas.input.leftKey] == true)
         	 { midlet.instancemanager.instances[handleplayer].x-=1; 
         	   
         	};
           if (midlet.jmcanvas.input.keys[midlet.jmcanvas.input.rightKey] == true)
         	 { midlet.instancemanager.instances[handleplayer].x+=1; 
         	};
         	
	   if (midlet.jmcanvas.input.keys[midlet.jmcanvas.input.fireKey] == true && cargaslistas>0)
         	{ recarga_elapsed = 0;
         	  createdeepcharge();
         	  midlet.jmcanvas.input.keys[midlet.jmcanvas.input.fireKey] = false;
         	};   
        
         	
       		instancecycle(midlet.screenmanager.elapsed);
         	
         	midlet.screenmanager.elapsed = 0;
         }
         
         
         
	
     
      	IA();
	long timeOfLastMovement = System.currentTimeMillis();
   	while (System.currentTimeMillis()-timeOfLastMovement <    1) { 
                	//TIME_BETWEEN_MOVEMENTS) {
          yield();
       	 
       	}
       	 midlet.jmcanvas.repaint(); 
	}
	
	public void yield() {}
	
  
  

  
  	public int createplayer(JQActor a)
  	{
  		
  		// Crea un jugador
  		
  		int index;
  		index = midlet.instancemanager.add(a,INSTANCE_PLAYER);	
  		midlet.instancemanager.instances[index].y = 25;
  		return index;
  		
  		
  		
  	}
  
  
  	public void createenemy(JQActor a) {
  		
  		// Crea un enemigo, submarino en este juego	
  		
  		int index;
  		index = midlet.instancemanager.add(a,INSTANCE_ENEMY);	
  		//if (midlet.randomgenerator.getABSRandom(2) > 0) 
  		{
  			// Derecha a izquierda	
  			int sentido = midlet.randomgenerator.getABSRandom(2);
  			System.out.println (sentido);
  			midlet.instancemanager.instances[index].x  = -100 +  midlet.randomgenerator.getABSRandom(200);;	
  			midlet.instancemanager.instances[index].y  = 25 + midlet.randomgenerator.getABSRandom(80);		
  			midlet.instancemanager.instances[index].vx = -(1 + midlet.randomgenerator.getABSRandom(2));
  			if (sentido==1)
  				midlet.instancemanager.instances[index].vx=-midlet.instancemanager.instances[index].vx;
  			midlet.instancemanager.instances[index].vy = 0;
  			
  			midlet.instancemanager.instances[index].checklimits = true;
  			midlet.instancemanager.instances[index].setlimits(-100,160,0,120);
         	 	midlet.instancemanager.instances[index].speed = 100 +  midlet.randomgenerator.getABSRandom(400); 
         	 		
  			
  			
  		}
  		numsubmarinos++;
  	
  		
  		
  	}
  	
  	public void createnube(JQActor a) {
  		
  		// Crea un enemigo, submarino en este juego	
  		
  		int index;
  		index = midlet.instancemanager.add(a,INSTANCE_SCENERY);	
  		//if (midlet.randomgenerator.getABSRandom(2) > 0) 
  		{
  			// Derecha a izquierda	
  		//	int sentido = midlet.randomgenerator.getABSRandom();
  			midlet.instancemanager.instances[index].x  = 50; //midlet.randomgenerator.getABSRandom(100);	
  			midlet.instancemanager.instances[index].y  =  50; // midlet.randomgenerator.getABSRandom(25);		
  			midlet.instancemanager.instances[index].vx = -(1 + midlet.randomgenerator.getABSRandom(2));
  			//if (sentido==1)
  			//	midlet.instancemanager.instances[index].vx=-midlet.instancemanager.instances[index].vx;
  			midlet.instancemanager.instances[index].vy = 0;
  			midlet.instancemanager.instances[index].checklimits = false;
  			midlet.instancemanager.instances[index].setlimits(-50,140,-30,25);
         	 	midlet.instancemanager.instances[index].speed =  100 +  midlet.randomgenerator.getABSRandom(900);	
         	 		
  			
  			
  		}
  		
  	
  		
  		
  	}
  	
  
  	public void createexplosion(JQActor a,int x, int y) {
  		
  		// Crea un enemigo, submarino en este juego	
  		
  		int index;
  		index = midlet.instancemanager.add(a,INSTANCE_EXPLOSION);
  		midlet.instancemanager.instances[index].checklimits = false;
  		
  		System.out.println("EXPLOSION");
  		midlet.instancemanager.instances[index].markedtodel = false;
  		midlet.instancemanager.instances[index].actor.animationfinished = false;
  		midlet.instancemanager.instances[index].x = x;
  		midlet.instancemanager.instances[index].y = y;
  		midlet.instancemanager.instances[index].vx = 0;
  		midlet.instancemanager.instances[index].vy = 0;
  		
  	}
  
  
  
  	public void createdeepcharge() {
  		
  		// Crea una carga de profundidad
  		
  		
  		
  		int index;
  		index = midlet.instancemanager.add(carga,INSTANCE_DEEPCHARGE);	
  		midlet.instancemanager.instances[index].markedtodel = false;
  		midlet.instancemanager.instances[index].actor.animationfinished = false;
  		int initx;
  		if (cargaslistas > 0)
         	 	{	
         	 		if (ladodetiro==0)
         	 			{
         	 				ladodetiro=1;
         	 				initx = 0;
  					}
         	 		      else
         	 		       {
         	 		       		ladodetiro=0;
         					initx = 50;
         	 			}
         			midlet.instancemanager.instances[index].x = midlet.instancemanager.instances[handleplayer].x + initx;
  				midlet.instancemanager.instances[index].y = midlet.instancemanager.instances[handleplayer].y;
  				midlet.instancemanager.instances[index].vx = 0;
  				midlet.instancemanager.instances[index].vy = 1;
  				midlet.instancemanager.instances[index].rx = 1;
  				midlet.instancemanager.instances[index].ry = 1;  		 		
  				midlet.instancemanager.instances[index].speed = 100; 
         	 		
         	 		midlet.instancemanager.instances[index].checklimits = true;
         	 		midlet.instancemanager.instances[index].minx = -50;
         	 		midlet.instancemanager.instances[index].maxx = 160;
         	 		midlet.instancemanager.instances[index].miny = 0;
         	 		midlet.instancemanager.instances[index].maxy = 30 + midlet.randomgenerator.getABSRandom(90);
         	   		cargaslanzadas++;
         	   		cargaslistas--;
         	   		
         	   	}
         	  
  		
  		
 	  		
  	}
  	
  	
  	public void instancecycle(long msec) {
  		
  		int i;
  		for (i=0;i<midlet.instancemanager.numinstances;i++)
  		{
  			switch (midlet.instancemanager.instances[i].type)
  			{
  				case INSTANCE_ENEMY:  midlet.instancemanager.instances[i].cycle(msec);
  				
  						       
  						     
  				//case INSTANCE_PLAYER: midlet.instancemanager.instances[i].cycle(msec);
  				case INSTANCE_DEEPCHARGE: midlet.instancemanager.instances[i].cycle(msec);
  							  
  						          
  			
  				case INSTANCE_EXPLOSION:  midlet.instancemanager.instances[i].cycle(msec);
  								//createexplosion(explosiontorpedo);
  							
  				case INSTANCE_SCENERY: midlet.instancemanager.instances[i].cycle(msec);
  				
  				
  			}
  		}	
  		
  		
  		// Procesa
  		for (i=0;i<midlet.instancemanager.numinstances;i++)
  		{
  			if ( midlet.instancemanager.instances[i].markedtodel)  // LLEGO AL LIMITE, EXPLOSION
  					{
  						//System.out.println("T:" + midlet.instancemanager.instances[i].type);
  						switch(midlet.instancemanager.instances[i].type) {
  							
  						case INSTANCE_DEEPCHARGE: {
  							//System.out.println("BORRACHARGE");
  							createexplosion(explosiontorpedo, midlet.instancemanager.instances[i].x, midlet.instancemanager.instances[i].y);
  							break;}
  							
  						case INSTANCE_ENEMY: {numsubmarinos--;
  							//System.out.println("BORRAENEMY");
  							break;
  							}
  							
  							
  							
  							
  						}
  						
  					}
  		}
  		midlet.instancemanager.compact();
 		System.gc();
  	}
  	
  	
  	
  	
  	public void IA() {
  		//System.out.println(numsubmarinos);
  				if (numsubmarinos < 2) {
  					//System.out.println(numsubmarinos);
  					createenemy(submarino);		
  		 }
  			
  		
  		
  		
  	}
  	
  	public void drawradar(Graphics g)
  	{
  		 for (int i=0;i<midlet.instancemanager.numinstances;i++)
  		 {
  		 	if (midlet.instancemanager.instances[i].type == INSTANCE_ENEMY) {
  		 		
  		 			
  		 		redspike.paintfull(g,60+(midlet.instancemanager.instances[i].x/8),3+(midlet.instancemanager.instances[i].y/8));
  		 		
  		 	}
  		 	
  		}
  		 	
  		
  	}
  
  }