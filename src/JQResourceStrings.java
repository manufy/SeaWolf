//import java.lang.*;

public class JQResourceStrings {

	public static  final int  ID_GAME_SKIP  = 0; // Identifiersfor text strings
	public static  final int  ID_GAME_EXIT = 1;
	public static  final int  ID_GAME_PLAY = 2;
	public static  final int  ID_GAME_MENU = 3;
	
	public static  final String[] supportedLocales= {"es", "en", "fi-F", "de"};
	private static final String[][] strings= {
		{"Saltar","Salir","Jugar","Menu"},
		{"Skip", "Exit","Play","Menu"},
		{"Uusi peli", "Poistu","Ndede","Menu"}, 
		{"Neues Spiel", "Beenden","Haspen","Menu"}
		
		};
	
	
	public String getString(int key) {
	
		String locale = System.getProperty("microedition.locale");
		if (locale == null) 
			locale = new String(""); 	// Use empty instead of null}
		int localeIndex = -1; 			// Find the index of locale ID
		for (int i = 0; i <supportedLocales.length; i++) {
			if (locale.equals(supportedLocales[i]))
			  	{localeIndex= i;
			 	 break;
			 	}
			}
		if (localeIndex== -1)  // Not found
			return strings[0][key]; // Defaults to first language, English in this case
		
		return strings[localeIndex][key];
	}	
} 