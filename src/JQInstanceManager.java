import javax.microedition.lcdui.*; // Para el Graphics

class JQInstanceManager {
	
	int STATE_MOVELEFT_CONSTANT=0;
	int STATE_MOVERIGHT_CONSTANT=1;
	
	
	
	
	int maxinstances = 100;
	JQInstance [] instances;
	int numinstances = 0;
	JQMIDlet midlet;

	boolean hole = false;	// Control de huecos
	int holeat = 0;
	
	JQInstanceManager(JQMIDlet m) {
		
		System.out.println("JQInstanceManager constructor");
		instances = new JQInstance[maxinstances];	
		midlet = m;
		
	}
	
	
	
	public void reset() {
		
		//System.out.println ("JQInstanceManager zero" );	
		instances = new JQInstance[maxinstances];	
		numinstances = 0;
		hole = false;
		holeat = 0;
		System.gc();
		
	}
	public int add(JQInstance i) {
		
		int index = numinstances;
		//if (hole) {
		//	index = holeat;
		//	hole = false;	
		//} 
		//System.out.println ("JQInstanceManager add at index=" + index);
		
		instances[index] = i;
		instances[index].actor.index = index;
		numinstances++;
		return index;
		
	}
	
	public void del(int index) {
		
		//System.out.println ("JQInstanceManager del index=" + index);
		instances[index] = null;
		//hole = true;
		//holeat = index;
		
		instances[index] = instances[numinstances];
		instances[numinstances] = null;
		numinstances--;
		
		
	}
	
	public void draw(Graphics g) {
		//System.out.println ("JQInstanceManager draw instances=" + numinstances);
		int i;
		for (i=0;i<numinstances;i++)
		{
			
				instances[i].draw(g);	
			
		}	
		
		
	}
	
	public int add(JQActor a, int t) {
		
	//	System.out.println ("JQInstanceManager add actor type: " + t);
		JQInstance i = new JQInstance(midlet);
		i.actor = a;
		i.type = t;
		return add(i);		
	}
	
	public void cycle(long elapsed) {
		//System.out.println ("JQInstanceManager cycle (ms)=" + elapsed);
		int i;
		for (i=0;i<numinstances;i++)
		{
				// Euler
				
				instances[i].cycle(elapsed);				
					
					
                              
				
				
			}
	}	
	public void marktodel(int i)
	{	
		instances[i].markedtodel = true;
		
	}	
			
			
	public void compact()
	{	
		int i;
		for (i=0;i<numinstances;i++)
		{
			if (instances[i].markedtodel)
				 { instances[i] = instances[numinstances-1];
				    numinstances--;	
				  }
			
			
			
		}
		
		
	}			
			
	
		
		
	
	
}