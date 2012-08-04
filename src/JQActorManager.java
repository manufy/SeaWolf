import javax.microedition.lcdui.*;

public class  JQActorManager {
	
	int MaxActors = 100; // Nº maximo de actores, incluyendo balas y explosiones
	JQActor [] actors;   // Array de actores
	int [] holes;    // Gestion de huecos
	int numelem;
	int numholes;
	
	JQActorManager()
	{
		System.out.println ("JQActorManager cnstructor");		
		numelem = 0;
		numholes = 0;
		holes  = new int[MaxActors];
		actors = new JQActor[MaxActors]; 	
	}	
	
	
	public void add(JQActor a)
	{
	System.out.println ("JQActorManager add");			
	if (numholes == 0)   {
		a.index = numelem;
		actors[numelem] = a; }
	    else {
	        a.index = holes[numholes];
	        actors[holes[numholes]] = a;
	        numholes--; }
	numelem++;	
		
	}
	

	
	
	
}
