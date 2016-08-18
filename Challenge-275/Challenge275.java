import java.util.Scanner;
public class Challenge275 {
	//Easy challenge 
	public boolean correctSymbol(String element, String symbol){
		if(element.length() <= 1 || symbol.length() <= 1) return false;
        String elementLow = element.toLowerCase(), symbolLow = symbol.toLowerCase();
        //The symbol String will always be a length of 2.
        char firstLetter = symbolLow.charAt(0), secondLetter = symbolLow.charAt(1);
        boolean trueFirst = false, trueSecond = false;
    
        for(int pos = 0; pos < elementLow.length(); pos++){
            char currLetter = elementLow.charAt(pos);
            //Checking whether the first letter has been found yet.
            if(!trueFirst){
                if(firstLetter == currLetter){
                    trueFirst = true;
                }
            } else {
                if(secondLetter == currLetter){
                    trueSecond = true;
                }
            }
        }
    
        if(trueFirst && trueSecond){
            return true;
        } else {
            return false;
        }
    }
	
	public static void main(String[] args){
		Challenge275 challenge = new Challenge275();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter element name: ");
		String element = input.nextLine();
		System.out.print("Enter element symbol: ");
		String symbol = input.nextLine();
		
		if(challenge.correctSymbol(element, symbol)){
			System.out.println(symbol + " is a suitable element symbol for the element " + element + ".");
		} else {
			System.out.println(symbol + " is NOT a suitable element symbol for the element " + element + ".");
		}
		
		input.close();
	}
}
