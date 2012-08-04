import javax.microedition.lcdui.*;
import java.io.*;
import javax.microedition.media.*;

public class JQSound   {



	public void playFile( String filename ) {
	  try
	  {
	    InputStream is = getClass().getResourceAsStream(filename);
	    Player m_player = Manager.createPlayer(is, "audio/midi");
	    m_player.prefetch();
	    m_player.start();
	  }
	  catch (Exception ex)
	  {
	    System.out.println(ex.toString());
	  }
	}







}
