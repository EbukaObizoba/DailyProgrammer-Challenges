import java.util.Scanner;

public class Challenge270 {
	
	public static void main(String[] args){
		Challenge270 challenge = new Challenge270();
		Scanner input = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.print("Enter 0 to run challenge with test cases, enter 1 to run challenge with a custom case: ");
			choice = input.nextInt();
		} while(!(choice == 0 || choice == 1));
		if(choice == 0){
			challenge.runTestCases();
		} else {
			challenge.runCustomCase();
		}
		input.close();
	}
	
	private char[][] scanInput(){
		Scanner input = new Scanner(System.in);
		System.out.print("How many lines is the text input? ");
		int numberOfLines = input.nextInt();
		input.nextLine();
		System.out.println("Enter lines now, and press enter to go to the next line.");
		//The length of each entered String is unknown, which makes a ragged 2D array necessary.
		char[][] inputString = new char[numberOfLines][];
		for(int num = 0; num < numberOfLines; num++){
			String line = "";
			line = input.nextLine();
			//Compressing each String entered into a one dimensional array and storing the array in a 2D array.
			char[] array = line.toCharArray();
			inputString[num] = array;
		}
		input.close();
		return inputString;
	}
	
	private char[][] transposeArray(char[][] array){
		int rows = array.length;
		//All columns of the 2D matrix must be the same length.
		int cols = array[0].length;
		//A transposed matrix switches row and column lengths.
		char[][] transposed = new char[cols][rows];
		for(int pos1 = 0; pos1 < rows; pos1++){
			for(int pos2 = 0; pos2 < cols; pos2++){
				transposed[pos2][pos1] = array[pos1][pos2];
			}
		}
		
		return transposed;
	}
	
	private char[][] equalLengthRows(char[][] array){
		//Finds the longest one dimensional array of a two dimensional array.
		int longestLength = longest1DArray(array);
		int arrayLength = array.length;
		char[][] paddedArray = new char[arrayLength][longestLength];
		for(int pos1 = 0; pos1 < arrayLength; pos1++){
			for(int pos2 = 0; pos2 < longestLength; pos2++){
				/*The length of some 1-D arrays may be shorter their padded versions.
				This if-else regulates that.*/
				if(pos2 < array[pos1].length){
					paddedArray[pos1][pos2] = array[pos1][pos2];
				} else {
					paddedArray[pos1][pos2] = ' ';
				}
			}
		}
		return paddedArray;
	}
	
	private int longest1DArray(char[][] array) {
		// All 1-D arrays must be padded with spaces to equal the length of the longest 1-D array.
		int length = array.length;
		int longestLength = 0;
		for (int pos = 0; pos < length; pos++) {
			int tempLength = array[pos].length;
			// This will produce the longest length
			if (tempLength > longestLength) {
				longestLength = tempLength;
			}
		}
		return longestLength;
	}
	
	private static void printArray(char[][] array){
		//This method prints the entire message of Strings as char arrays.
		int length = array.length;
		for(int pos1 = 0; pos1 < length; pos1++){
			for(int pos2 = 0; pos2 < array[pos1].length; pos2++){
				System.out.print(array[pos1][pos2]);
			}
			System.out.println();
		}
	}
	
	private char[][][] testCases(){
		char[][][] testCases = {
			        //Case 1
				{ {'S', 'o','m','e'},
			          {'t', 'e', 'x', 't', '.'} 
				},
				//Case 2
				{ {'p','a','c', 'k','a','g','e',' ', 'm', 'a','i','n'},
				  {' '},
				  {'i', 'm','p','o','r','t',' ','"','f','m','t','"'},
				  {' '},
				  {'f','u','n','c',' ','m','a','i','n','(',')',' ','}'},
				  {' ',' ',' ',' ','q','u','e','u','e',' ',':','=',' ','m','a','k','e','(','c','h','a','n',' ',
					  's','t','r','i','n','g',',',' ','2',')'},
				  {' ',' ',' ',' ','q','u','e','u','e',' ','<','-',' ','"','o','n','e','"'},
				  {' ',' ',' ',' ','q','u','e','u','e',' ','<','-',' ','"','t','w','o','0','"'},
				  {' ',' ',' ',' ','c','l','o','s','e','(','q','u','e','u','e',')'},
				  {' ',' ',' ',' ','f','o','r',' ','e','l','e','m',' ',':','=',' ','r','a','n','g','e',' ',
					  'q','u','e','u','e',' ','{'},
				  {' ',' ',' ',' ',' ',' ',' ',' ','f','m','t','.','P','r','i','n','t','l','n','(','e','l','e','m',')'},
				  {' ',' ',' ',' ','}'},
				  {'}'}
				}
		};
		return testCases;
	}
	
	private void runTestCases(){
		char[][][] testCases = testCases();
		char[][] case1 = testCases[0];
		char[][] case2 = testCases[1];
		//Processing first case...
		System.out.println("Original input for case1:");
		printArray(case1); 
		char[][] transposedArray = transposeArray(equalLengthRows(case1));
		System.out.println("Transposed input for case1:");
		printArray(transposedArray);
		System.out.println();
		//Processing second case...
		System.out.println("Original input for case2:");
		printArray(case2); 
		transposedArray = transposeArray(equalLengthRows(case2));
		System.out.println("Transposed input for case2:");
		printArray(transposedArray);
	}
	
	private void runCustomCase(){
		char[][] inputString = scanInput();
		System.out.println("Original input:");
		printArray(inputString); 
		char[][] transposedArray = transposeArray(equalLengthRows(inputString));
		System.out.println("Transposed input:");
		printArray(transposedArray);
	}
}
