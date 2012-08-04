
import javax.microedition.lcdui.*;
import javax.microedition.io.*;
import java.io.*;


public class Seawolf_Screen_HiScores extends JQScreen implements CommandListener {



        Seawolf_Screen_HiScores(JQMIDlet m) {
   	
		midlet = m;
		//barco2.load("/barcos.png");		
	}
	
	public void paint( Graphics g ){
    
	g.setColor(0,0,0);
 	g.fillRect(0,0,midlet.jmcanvas.height,midlet.jmcanvas.height); 
	g.setClip(0,0,midlet.jmcanvas.height,midlet.jmcanvas.height);
	g.setColor(255,255,255);
  	g.drawString("HiScores",0,0, Graphics.TOP|Graphics.LEFT);
   	
  	
  	
	}
	
	
	public void commandAction (
		Command c, Displayable s) {
		
		if (c == midlet.jmcanvas.leftcommand) {
			midlet.screenmanager.attach(midlet.menuscreen);
			
		}	
		}
	
	public void activate() {
		midlet.jmcanvas.leftcommand = new Command(midlet.resourcestrings.getString(midlet.resourcestrings.ID_GAME_MENU), Command.SCREEN, 1);
   		midlet.jmcanvas.addCommand(midlet.jmcanvas.leftcommand);  
   		try {	   HttpGet("http://172.16.0.2/midp/t");
   			   HttpPut("http://172.16.0.2/midp/getscore");  }
   		
   		  catch (IOException e) {
   				System.out.println("get fallo");
 		
 			}
   				   					
	}
 	public void deactivate() {
		midlet.jmcanvas.removeCommand(midlet.jmcanvas.leftcommand);
	}
	
	public void run()
	{	
		midlet.jmcanvas.repaint(); 
		}
		
		
		
		
		
		
		
   void getscores(String url) throws IOException {
         HttpConnection c = null;
         InputStream is = null;
         System.out.println("getscores in " + url);
         try {
             c = (HttpConnection)Connector.open(url);
 		System.out.println("getscores open");
             // Getting the InputStream will open the connection
             // and read the HTTP headers. They are stored until
             // requested.
             is = c.openInputStream();
 	System.out.println("getscores open is");
             // Get the ContentType
             String type = c.getType();
 
             // Get the length and process the data
             int len = (int)c.getLength();
             if (len > 0) {
                 byte[] data = new byte[len];
                 System.out.println("lee");
                 int actual = is.read(data);
                 //
             } else {
                 int ch;
                 
                 while ((ch = is.read()) != -1) {
                     System.out.println(ch);
                 }
             }
         } finally {
             if (is != null) {
                 System.out.println("is != null");
                 is.close(); }
             if (c != null) {
             	System.out.println("c != null");
                 c.close(); }
         }
           //*System.out.println("FIN" + data[0]);
     }


 public String HttpGet( String url ) throws IOException {

        HttpConnection        hcon = null;

        DataInputStream       dis = null;

        StringBuffer          message;


	message = new StringBuffer();
        try {

 hcon = ( HttpConnection ) Connector.open( url );


		 dis = new DataInputStream( hcon.openInputStream() );
		 
		 int ch;

        while ( ( ch = dis.read() ) != -1 ) {

        message = message.append( ( char ) ch );

}

  } finally {

        if ( hcon != null ) hcon.close();

        if ( dis != null ) dis.close();

        }//end try/finally
	System.out.println(message.toString());
        return message.toString();

    }//end sendGetRequest( String )
    
    
    
    
    
    
    
    
    
    
    
    
    public void HttpPut( String url ) throws IOException {

    HttpConnection c = null;
        InputStream is = null;
        OutputStream os = null;
        
         try {
            c = (HttpConnection)Connector.open(url);

            // Set the request method and headers
            c.setRequestMethod(HttpConnection.POST);
            c.setRequestProperty("If-Modified-Since",
                "29 Oct 1999 19:43:31 GMT");
            c.setRequestProperty("User-Agent",
                "Profile/MIDP-1.0 Configuration/CLDC-1.0");
            c.setRequestProperty("Content-Language", "en-US");

            // Getting the output stream may flush the headers
            os = c.openOutputStream();
            os.write("LIST games\n".getBytes());
            os.flush();                // Optional, openInputStream will flush
           
        } finally {
            if (is != null)
                is.close();
            if (os != null)
                os.close();
            if (c != null)
                c.close();
        }
}
    
		
}