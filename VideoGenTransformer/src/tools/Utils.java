package tools;

import java.io.BufferedReader;
import java.io.IOException;

public class Utils{
		
	
	
	public static int nbLignes(String string) {
		if(string.equals("")) {
			return 0;
		}else if(string.indexOf('\n') == -1) {
			return 1;			
		}else {
			int pos = string.indexOf('\n') + 1;
			return 1 + nbLignes(string.substring(pos));
		}
	}
	
	public static String formatHHmmss(int seconds) {
		// Calculate the seconds to displayed
		int displayedSeconds = seconds % 60;
		seconds -= displayedSeconds;
		// Calculate the minutes to displayed
		int minutes = seconds /60;
		int displayedMinutes = minutes % 60;
		minutes -= displayedMinutes;
		// Calculate the hours to displayed
		int displayedHours = minutes / 60;
		return String.format("%02d:%02d:%02d", displayedHours, displayedMinutes, displayedSeconds);
	}
	
	public static String readBufferReader(BufferedReader reader) {
		StringBuilder builder = new StringBuilder();
		String aux = "";

		try {
			while ((aux = reader.readLine()) != null) {
			    builder.append(aux + '\n');
			}
		} catch (IOException e) {
			return builder.toString();
		}

		String text = builder.toString();
		return text;
		
	}
}
