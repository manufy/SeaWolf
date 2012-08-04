
import javax.microedition.lcdui.*;


public class Seawolf_Screen_Menu extends JQScreen implements CommandListener {


	public static final int INSTANCE_MENU = 0;
		
	public static final int ACTOR_ANIMATION_STATIC  = 0;
	public static final int ACTOR_ANIMATION_ONESHOT = 1;
	public static final int ACTOR_ANIMATION_LOOP    = 2;
	

	
	int indexplay;
	int indexhelp;
	int indexabout;
	int indexhiscores;
	int indexinternet;
	int indexsettings;
	
	int activemenu;
	
	JQActor play;
	JQActor about;
	JQActor help;
	JQActor hiscores;
	JQActor internet;
	JQActor settings;

        Seawolf_Screen_Menu(JQMIDlet m) {
        	
        	midlet = m;
   	        play     = new JQActor("/txtplay.png",23,28,2,ACTOR_ANIMATION_LOOP,500); // filename, tilesizex, tilesizey
          	about    = new JQActor("/txtabout.png",33,28,2,ACTOR_ANIMATION_LOOP,100); // filename, tilesizex, tilesizey
          	help     = new JQActor("/txthelp.png",25,28,2,ACTOR_ANIMATION_LOOP,200); // filename, tilesizex, tilesizey
          	hiscores = new JQActor("/txthiscores.png",50,28,2,ACTOR_ANIMATION_LOOP,300); // filename, tilesizex, tilesizey
          	internet = new JQActor("/txtinternet.png",41,28,2,ACTOR_ANIMATION_LOOP,400); // filename, tilesizex, tilesizey
          	settings = new JQActor("/txtinternet.png",41,28,2,ACTOR_ANIMATION_LOOP,400); // filename, tilesizex, tilesizey
   		
	}
	
	public void paint( Graphics g ){
    g.setColor(0,0,0);
	g.setClip(0,0,midlet.jmcanvas.height,midlet.jmcanvas.height);
 	g.fillRect(0,0,midlet.jmcanvas.height,midlet.jmcanvas.height); 
  	//play.paintfill(g); 
  
  	midlet.instancemanager.draw(g);
  	
	}
	
	
	public void commandAction (
		Command c, Displayable s) {
		
		if (c == midlet.jmcanvas.leftcommand) {
			//midlet.screenmanager.attach(midlet.screenMenu);
			midlet.exit();
		}	
		}
	
	public void activate() {
		midlet.jmcanvas.leftcommand = new Command(midlet.resourcestrings.getString(midlet.resourcestrings.ID_GAME_EXIT), Command.SCREEN, 1);
   		midlet.jmcanvas.addCommand(midlet.jmcanvas.leftcommand);
   		midlet.instancemanager.reset();
   		activemenu = 0;
   		indexplay = midlet.instancemanager.add(play ,INSTANCE_MENU);
  		midlet.instancemanager.instances[indexplay].reset();
  		midlet.instancemanager.instances[indexplay].x = 20;
  		midlet.instancemanager.instances[indexplay].y = 32;
  		
  		indexhelp = midlet.instancemanager.add(help ,INSTANCE_MENU);

  		midlet.instancemanager.instances[indexhelp].x = 20;
  		midlet.instancemanager.instances[indexhelp].y = 44;
  		
  		indexhiscores = midlet.instancemanager.add(hiscores ,INSTANCE_MENU);
  		
  		midlet.instancemanager.instances[indexhiscores].x = 20;
  		midlet.instancemanager.instances[indexhiscores].y = 56;
  		
  		indexabout = midlet.instancemanager.add(about ,INSTANCE_MENU);
  		
  		midlet.instancemanager.instances[indexabout].x = 20;
  		midlet.instancemanager.instances[indexabout].y = 68;
  	
  		indexinternet = midlet.instancemanager.add(internet ,INSTANCE_MENU);
  		
  		midlet.instancemanager.instances[indexinternet].x = 20;
  		midlet.instancemanager.instances[indexinternet].y = 80;
   		
   		setmenu();
   				
	}
 	public void deactivate() {
		midlet.jmcanvas.removeCommand(midlet.jmcanvas.leftcommand);
	}
	
	public void run()
	{		
		
		midlet.instancemanager.instances[indexplay].actor.tiletransitiontimes[0] = 0;
		 midlet.instancemanager.cycle(midlet.screenmanager.elapsed);
	//	 System.out.println("elapsed=" + midlet.screenmanager.elapsed);
	   if (midlet.jmcanvas.input.keys[midlet.jmcanvas.input.fireKey] == true )
         	{
         	   
         	   midlet.jmcanvas.input.keys[midlet.jmcanvas.input.fireKey] = false;
         	   //midlet.exit();
         	   //midlet.mainscreen.startgame();
         	   midlet.screenmanager.attach(midlet.mainscreen);
         	   
         	}; 
	
		midlet.jmcanvas.repaint(); 
		}
		
	public void setmenu() {
		
		midlet.instancemanager.instances[indexplay].actor.tiletransitiontimes[0] = 500;
		midlet.instancemanager.instances[indexhelp].actor.tiletransitiontimes[0] = 000;
		midlet.instancemanager.instances[indexabout].actor.tiletransitiontimes[0] = 0;
		midlet.instancemanager.instances[indexhiscores].actor.tiletransitiontimes[0] = 0;
		midlet.instancemanager.instances[indexsettings].actor.tiletransitiontimes[0] = 0;
		midlet.instancemanager.instances[indexinternet].actor.tiletransitiontimes[0] = 0;
			
		switch (activemenu) {
			
			case 0: midlet.instancemanager.instances[indexplay].actor.tiletransitiontimes[0] = 500;
				break;
			case 1: midlet.instancemanager.instances[indexhelp].actor.tiletransitiontimes[0] = 500;
				break;
			case 2: midlet.instancemanager.instances[indexhiscores].actor.tiletransitiontimes[0] = 500;
				break;
			case 3: midlet.instancemanager.instances[indexabout].actor.tiletransitiontimes[0] = 500;
				break;
			case 4: midlet.instancemanager.instances[indexinternet].actor.tiletransitiontimes[0] = 500;
				break;
			case 5: midlet.instancemanager.instances[indexsettings].actor.tiletransitiontimes[0] = 500;
				break;
			
			
		}
		
		
		
		}
}