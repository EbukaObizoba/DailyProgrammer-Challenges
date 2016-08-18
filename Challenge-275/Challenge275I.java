import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;

public class Challenge275I {
	// Intermediate Challenge
	public static void main(String[] args) {
		File textFile = new File("Splurthian Elements.txt");
		Challenge275I challenge = new Challenge275I();
		challenge.preferredSymbol(textFile);
	}

	public void preferredSymbol(File textFile) {
		// Using a HashMap to map the preferred symbol to it's element.
		HashMap<String, String> elementSyms = new HashMap<String, String>();
		// ArrayList to store each element in given file.
		ArrayList<String> allLines = new ArrayList<String>();
		// Dumps each element into ArrayList
		readLines(textFile, allLines);

		for (String line : allLines) {
			String symbol = findSymbol(line, elementSyms);
			// This will indicate which element does not have a symbol it can
			// use.
			if (symbol == null) {
				System.out.println(line + " is the first element without an assigned symbol.");
				break;
			}
		}
	}

	public String findSymbol(String line, HashMap<String, String> map) {
		for (int outer = 0; outer < line.length() - 1; outer++) {
			for (int inner = outer + 1; inner < line.length(); inner++) {
				// Possible symbol for element
				String tempSym = charsToString(line.charAt(outer), line.charAt(inner));
				// Checking for available symbol
				if (!(map.containsKey(tempSym))) {
					map.put(tempSym, line);
					return tempSym;
				}
			}
		}
		// Preferred element symbol is not available.
		return null;
	}

	public String charsToString(char first, char second) {
		// First letter of a 2 character element symbol is always capitalized.
		return "" + (String.valueOf(first)).toUpperCase() + (String.valueOf(second)).toLowerCase();
	}

	public void readLines(File file, ArrayList<String> lineList){
	      try {
	    	  BufferedReader buffer = new BufferedReader(new FileReader(file));
	          String text = buffer.readLine();
	          while(text != null){
	        	  lineList.add(text);
	              text = buffer.readLine();
	          }
	          buffer.close();
	      } catch(IOException e) {
	          e.printStackTrace();
	      }
	}
}
