
class JQExplosion {
	
	public static final int constReset = -1000;
	public static final int constExploding = -1001;
	public static final int constIdle = -1002;
	public static final int constInitialState = 0;
	// estad
	JQSprite explosion;
	
	int vx; 
	int vy;
	int initx;
	int inity;
	int x;
	int y; 
	
	int initialstate = 0;
	
	// MAIN STATES INICIALIZAR EN CLASE DERIVADA, ASI COMO MAXSTATES
	
	public int[] mainstates; //     = {initialstate,1,constReset};
	int maxstates = 0;
	
	
	int stateindex = 0;
	int state = initialstate;
	
	
	JQExplosion()
	{ vx = 0;
	  vy = 0;
	  initx = 0;
	  inity = 0;
	  x = 0;
	  y = 0;
		
	}
	JQExplosion(String filename,int  newinitx,int  newinity,int  newvx,int  newvy)
	{
		explosion.load(filename);	
		x = newinitx;
		y = newinity;
		vx = newvx;
		vy = newvy;	
	}
	
	
	public void cycle()
	{
		int i;
		switch(state) 
		{
			 
			
		}	
		
		
	}
}