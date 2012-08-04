import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.rms.*;
import java.io.*;
import java.util.*;

public class JQSync {
	
	RecordStore recordstore;
	public static final String FileName = "vvhudfv";
	
	byte[] databuffer = new byte[200]; // buffer
	ByteArrayInputStream inputstream   = new ByteArrayInputStream(databuffer);
	ByteArrayOutputStream outputstream = new ByteArrayOutputStream(200);
	
	// Informacion de sincronizacion
	
	StringBuffer regdata;
	
	
	JQSync() {
	
	 Calendar cal;
	  cal = Calendar.getInstance();
        Date date =  cal.getTime();
      
	
	//Date hoy;
	System.out.println("JQSync constructor");	
	regdata = new StringBuffer();
	regdata.append(date.toString());
	//regdata.append(Date());
		
        System.out.println(date.toString()); 
	System.out.println( "time: " + cal.get(cal.HOUR_OF_DAY) + ":" + cal.get(cal.MINUTE) );
	System.out.println( "date: " + cal.get(cal.DAY_OF_MONTH ) + "/" + cal.get(cal.MONTH)+ "/" + cal.get(cal.YEAR) );
	}
	
	
	}
	