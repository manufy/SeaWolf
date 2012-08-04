import javax.microedition.lcdui.*;


public class JQActor {
	
	
	// Implementa un actor

	
	public static final int MAX_SPRITES_PER_ACTOR = 5;
	public static final int ACTOR_ANIMATION_ONESHOT =1;
	public static final int ACTOR_ANIMATION_LOOP    =2;
	public static final int ACTOR_ANIMATION_ENDLESS =3;

	
	

        JQSprite sprite;
        JQSprite sprites[] ;
        int      animationtypes[]; // Tipo de animacion para cada sprite
        int      numtiles[]; // Nº de tiles que componen cada sprite
        int      activetiles[];   // Que tile de cada sprite esta activo

        
        long     tiletransitiontimes[];
        long     animationtimer = 0;
        long     elapsed = 0;
      
        int      numsprites = 0;
        int      activesprite = 0;
  	int      index;
  	boolean  animationfinished = false;
  	
  	
	
	JQActor(String filename, int theight, int twidth, int tiles, int animationtype, long tiletransitiontime) { 
		
		// Tipo animacion= 0=one shot 1=loop 2=sinfin
		
  		System.out.println("JQActor constructor  " + filename);       
		sprites =             new JQSprite[MAX_SPRITES_PER_ACTOR];
		tiletransitiontimes = new long[MAX_SPRITES_PER_ACTOR];
		animationtypes =      new int[MAX_SPRITES_PER_ACTOR];
		numtiles =            new int[MAX_SPRITES_PER_ACTOR];
		activetiles =            new int[MAX_SPRITES_PER_ACTOR];
		animationtypes[numsprites] = animationtype;
		sprites[numsprites] = new JQSprite(filename,theight,twidth);
		numtiles[numsprites] = tiles;
		activetiles[numsprites] = 0;
		tiletransitiontimes[numsprites] = tiletransitiontime;
  		numsprites++;
  		animationtimer =  System.currentTimeMillis() ;
  		  	}
  	
  	
  	//public void add(String filename, int theight, int twidth, int tiles, long animationtime, long tiletransitiontime) {
  		
  	//	sprites[numsprites] = new JQSprite(filename,theight,twidth);			
  	//	numtiles[numsprites] = tiles;
	//	activetiles[numsprites] = 0;
  	//	numsprites++;
  		
  	//}
  	
  	public void draw(Graphics g,int x, int y)
  	{
  		
  		//System.out.println("JQActor draw " + activetiles[activesprite]);
  		if (!animationfinished)
  			sprites[activesprite].draw(g,x,y, activetiles[activesprite]);	
  		
  	}
  	
  	public void cycle(long msec) {
  		
  		long delta;
  		delta = System.currentTimeMillis() - animationtimer;
       		animationtimer = System.currentTimeMillis();
       		elapsed+=delta;
  		
  	
  		//delta = msec - animationtimer;
  		//System.out.println("Actor INDEX " + index  + " cycle ms=" + msec + " elapsed = " + elapsed + " > " + tiletransitiontimes[activesprite]);
  		if (tiletransitiontimes[activesprite] > 0) {
  			//System.out.println("if" + elapsed + " >  " + tiletransitiontimes[activesprite]);
  			if (elapsed > tiletransitiontimes[activesprite]) {
  					elapsed = 0;
  				//	System.out.println("Actor anitimer Reset");	
  					activetiles[activesprite]++; 	
  					if (activetiles[activesprite] == numtiles[activesprite])
  					        switch(animationtypes[activesprite]) {
  					        	case ACTOR_ANIMATION_ONESHOT:activetiles[activesprite] = 0;	
										     animationfinished = true;  					        				
										     //System.out.println("Actor Animation End");
  					        		
  					        	case ACTOR_ANIMATION_LOOP: activetiles[activesprite] = 0;	
			    					        	   //System.out.println("Actor Tile Reset");
  		
  					        }
  						
  			}
  			
  		}
  	
  		
  	}
	
	
	}

