//import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
//import java.util.*;
import java.io.*;


public class JQSprite {

	
	Image tiles; // siempre 1 por x
	int tile_width = 0; // ancho de los tiles
	int tile_height = 0;	
	long timer = 0; // msec
	
	JQSprite(String filename, int twidth, int theight) {
	
		System.out.println("JQSprite.constructor " + filename);   	       	
		tile_width = twidth;
		tile_height = theight;
	 	try {
    	 	tiles =  Image.createImage(filename);
	   		}
 		  catch (IOException e) {
   	
   		System.out.println("JQSprite: No existe imagen " + filename);
  			}	
	}

// Cargar sprite

public void load(String filename)
{
	System.out.println("JQSprite.load  " + filename);   	       
	try {
    	tiles =  Image.createImage(filename);
    	         System.out.println("loaded JQSprite  " + filename);
   	       
            }
 	  catch (IOException e) {
   	         System.out.println("JQSprite: No existe imagen " + filename);
   	        }
}




public void paint( Graphics g, int posx, int posy, int ntile ){
	


//	g.setClip(posx,posy,posx + tile_width,posy + tile_height);
	//g.setClip(posx,0,32,16);
	
	g.drawImage(tiles,posx,-tile_height * ntile,Graphics.TOP | Graphics.LEFT);
	
}
	

public void paintfull( Graphics g, int posx, int posy ){

g.drawImage(tiles,posx,posy,Graphics.TOP | Graphics.LEFT);

}

public void paintfill( Graphics g ){
	
	for (int i =0; i < 126; i+=16) {
		g.drawImage(tiles,i,0,Graphics.TOP | Graphics.LEFT);			
	}
	
	}
	

	
	
public void draw(Graphics g, int posx, int posy, int ntile )
{

		
		g.setClip(posx,posy,tile_width,tile_height);
		g.drawImage(tiles,posx,posy+(-tile_height*ntile),Graphics.TOP | Graphics.LEFT);
	//      else
	//	{ g.setClip(posx,posy,100,100); // chapuza
	//	  g.drawImage(tiles,posx,posy,Graphics.TOP | Graphics.LEFT);      
	//	}
	
}	










	
}

