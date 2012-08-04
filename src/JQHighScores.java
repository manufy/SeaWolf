
import javax.microedition.rms.*;
import java.io.*;

public class JQHighScores {


	private static final String[] defaultscores_names =  {  "Uno","Dos","Tres" };
	private static final int[]    defaultscores_points = {     100,  200,   300  };

	public static final int NUM_SCORES = 3;


	RecordStore recordstore;
	public static final String FileName = "vvhudfv";
	
	byte[] databuffer = new byte[200]; // buffer
	ByteArrayInputStream inputstream   = new ByteArrayInputStream(databuffer);
	ByteArrayOutputStream outputstream = new ByteArrayOutputStream(200);
	
	
	StringBuffer[] arrayscoresname   = new StringBuffer[10]; // 3 letras
	int         []   arrayscoresdata = new int[10];
	 
	 
	 
	 JQHighScores() {
	try {
		System.out.println("JQHighScores constructor");
		
		recordstore = RecordStore.openRecordStore(FileName, true);
		if (recordstore.getNumRecords()== 0)
		{	//	System.out.println("OpenScores es 0");
			CreateDefaultScores();
			
			
		}
		}  
	catch(Exception e) {
		System.out.println("Fallo al abrir: " + FileName);
	//	recordstore = new RecordStore();
		//CreateDefaultScores();	
		//LoadScore();
		} 
	
	LoadScore();
	}
	 

 public void OpenScores() {
 
 
	try {
		recordstore = RecordStore.openRecordStore(FileName, true);
		System.out.println("OpenScores");		
		}  
	catch(Exception e) {
		System.out.println("Fallo al abrir: " + FileName);
		} 
 }
 
 public void CloseScores() {
 	try {
	recordstore.closeRecordStore();
	System.out.println("CloseScores");
	}
	catch(Exception e) {
		System.out.println("Fallo al cerrar: " + FileName);
	}
  
}


	public void SaveScore(String name, int score) {
		
		try{
			String newrecordstring = name + "o=" + score;
			newrecordstring+= "cdfc";
			byte[] record = newrecordstring.getBytes();
			// Add to record store.
			recordstore.addRecord(record, 0, record.length);
		} catch(Exception e) {
			System.out.println("Failed to add stock to RMS: " + e.toString());

		}
		
		
	}
 	public void LoadScore() {
 		System.out.println("LoadScores");
		OpenScores();
		try{
    			  int datalength;

   			   for (int i = 1; i <= recordstore.getNumRecords(); i++){

    				     recordstore.getRecord(i, databuffer, 0);
   				     datalength = recordstore.getRecord(i, databuffer, 0);

    				    String str = new String(databuffer, 0, datalength);
      				    System.out.println("Record numero " + i + ": " + str);     

    			  }//for
    			  System.out.println("HiScores file version: " + recordstore.getVersion());
    			  System.out.println("HiScores last modified: " + recordstore.getLastModified());
    			  
    			  
         
 		   } catch (Exception e) {
     			 System.err.println(e.toString());
   		 }
		
		
		
	CloseScores();
		
	}
 
	public void CreateDefaultScores() {
	
	OpenScores();
	System.out.println("CreateDefaultScores");
	for(int i=0;i<NUM_SCORES;i++)
	{
		SaveScore(defaultscores_names[i],defaultscores_points[i]);
		System.out.println("Generado " + i + ": " + defaultscores_names[i]);  
		
	}
	CloseScores();
	
}

}