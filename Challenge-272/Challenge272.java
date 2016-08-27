import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Challenge272 {
	
	//Easy challenge
	
	private HashMap<Character, Integer> lettersInBag = new HashMap<>();
	//This is map is static, because using multiple copies is unnecessary
	private static HashMap<Character, Integer> valueOfLetters = new HashMap<>();
	
	public void removeTiles(String tiles){
		if(tiles == null) return;
		//This new String ensures that the input is considers only upper-case characters and underscores.
		String correctTiles = tiles.toUpperCase();
		correctTiles = correctTiles.replaceAll("[^A-Z\\_]", "");
		char[] charTiles = correctTiles.toCharArray();
		int length = charTiles.length;
		//Parsing through each character letter
		for(int pos = 0; pos < length; pos++){
			char tile = charTiles[pos];
			int letterCount = lettersInBag.get(tile);
			//If there are no more of a requested letter in the bag, this "invalid" statement runs.
			if(letterCount == 0){
				System.out.println("Invalid input. More " + tile + "'s have been taken from the bag than possible.");
			} else {
				//Letter is removed from the bag, and map is updated.
				letterCount--;
				lettersInBag.put(tile, letterCount);
			}
		}
	}
	
	private void displayLetters(){
		//Allowing primitive types
		TreeMap<Integer, TreeSet<Character>> outputMap = new TreeMap<>(new MyComparator());
		TreeSet<Character> currentSet;
		//Entering letters and counts into a TreeMap.
		for(Map.Entry<Character, Integer> entry : lettersInBag.entrySet()){
			char letter = entry.getKey();
			int letterCount = entry.getValue();
			//When a count value is not in the map...
			if(!outputMap.containsKey(letterCount)){
				currentSet = new TreeSet<>();
			} else {
				currentSet = outputMap.get(letterCount);
			}
			//Duplicate keys are not re-entered in sets.
			currentSet.add(letter);
			outputMap.put(letterCount, currentSet);
		}
		printTreeMap(outputMap);
	}
	
	private void printTreeMap(TreeMap<Integer, TreeSet<Character>> treeMap){
		StringBuilder builder = new StringBuilder();
		for(Map.Entry<Integer, TreeSet<Character>> entry : treeMap.entrySet()){
			int letterCount = entry.getKey();
			TreeSet<Character> letterSet = entry.getValue();
			
			builder.append(letterCount).append(": ").append(letterSet).append("\n");
		}
		System.out.println(builder.toString());
	}
	
	public static void main(String[] args){
		String[] tilesToBeRemoved = { "PQAREIOURSTHGWIOAE_", "LQTOONOEFFJZT", "AXHDRUIOR_XHJZUQEE" };
		//Simulating three games where tiles are removed from the bag.
		Challenge272 gameOne = new Challenge272();
		Challenge272 gameTwo = new Challenge272();
		Challenge272 gameThree = new Challenge272();
		gameOne.removeTiles(tilesToBeRemoved[0]);
		gameOne.displayLetters();
		gameTwo.removeTiles(tilesToBeRemoved[1]);
		gameTwo.displayLetters();
		gameThree.removeTiles(tilesToBeRemoved[2]);
		gameThree.displayLetters();
	}
	
	//Compares items in descending order
	private class MyComparator implements Comparator<Integer> {
		public int compare(Integer val1, Integer val2){
			return val2.intValue() - val1.intValue();
		}
	}
	
	//The challenge prompts for each call to removeTiles() to be a different instance of the bag and not shared.
	public Challenge272(){
		lettersInBag.put('A', 9);
		lettersInBag.put('B', 2);
		lettersInBag.put('C', 2);
		lettersInBag.put('D', 4);
		lettersInBag.put('E', 12);
		lettersInBag.put('F', 2);
		lettersInBag.put('G', 3);
		lettersInBag.put('H', 2);
		lettersInBag.put('I', 9);
		lettersInBag.put('J', 1);
		lettersInBag.put('K', 1);
		lettersInBag.put('L', 4);
		lettersInBag.put('M', 2);
		lettersInBag.put('N', 6);
		lettersInBag.put('O', 8);
		lettersInBag.put('P', 2);
		lettersInBag.put('Q', 1);
		lettersInBag.put('R', 6);
		lettersInBag.put('S', 4);
		lettersInBag.put('T', 6);
		lettersInBag.put('U', 4);
		lettersInBag.put('V', 2);
		lettersInBag.put('W', 2);
		lettersInBag.put('X', 1);
		lettersInBag.put('Y', 2);
		lettersInBag.put('Z', 1);
		lettersInBag.put('_', 2);
	}
	
	static {
		valueOfLetters.put('A', 1);
		valueOfLetters.put('B', 3);
		valueOfLetters.put('C', 3);
		valueOfLetters.put('D', 2);
		valueOfLetters.put('E', 1);
		valueOfLetters.put('F', 4);
		valueOfLetters.put('G', 2);
		valueOfLetters.put('H', 4);
		valueOfLetters.put('I', 1);
		valueOfLetters.put('J', 8);
		valueOfLetters.put('K', 5);
		valueOfLetters.put('L', 1);
		valueOfLetters.put('M', 3);
		valueOfLetters.put('N', 1);
		valueOfLetters.put('O', 1);
		valueOfLetters.put('P', 3);
		valueOfLetters.put('Q', 10);
		valueOfLetters.put('R', 1);
		valueOfLetters.put('S', 1);
		valueOfLetters.put('T', 1);
		valueOfLetters.put('U', 1);
		valueOfLetters.put('V', 4);
		valueOfLetters.put('W', 4);
		valueOfLetters.put('X', 8);
		valueOfLetters.put('Y', 4);
		valueOfLetters.put('Z', 10);
		valueOfLetters.put('_', 0);
	}
}
