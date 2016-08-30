
public class Challenge281 {
	
	private void findBase(String value){
		//value should only be in  numbers or letters a-f. This will stop any character errors.
		value = value.replaceAll("[^a-f0-9]", "");
		int length = value.length();
		//Invalid input
		if(length == 0) return;
		char largestValue = 0;
		for(int pos = 0; pos < length; pos++){
			char digit = value.charAt(pos);
			if(digit > largestValue) largestValue = digit;
		}
		int base = auxBase(largestValue);
		printAllBases(value, base);
		
	}
	
	private void printAllBases(String val, int base){
		for(int pos = base; pos <= 16; pos++){
			int decimalValue = baseToDecimal(val, pos);
			System.out.printf("Base %d => %d\n", pos, decimalValue);
		}
	}
	
	private int baseToDecimal(String value, int base){
		int length = value.length();
		int sum = 0;
		int constant = 0;
		for(int pos = length-1; pos >= 0; pos--){
			int exponent = length-pos-1;
			char val = value.charAt(pos);
			constant = charToInt(val);
			sum += (constant) * ((int) Math.pow(base, exponent));
		}
		return sum;
	}
	
	private int charToInt(char c){
		String entries = "0123456789abcdef";
		int val = entries.indexOf(c);
		return val;
	}
	
	private int auxBase(char val){
		int base = charToInt(val);
		//The lowest base is 2.
		if(base == 0){
			return 2;
		}
		/*1 is added to base, because the lowest base is the value one greater than the 
		 * largest digit in the number.*/
		return base + 1;
	}
	
	public static void main(String[] args){
		Challenge281 challenge = new Challenge281();
		String[] testCases = {"1","21","ab3", "ff"};
		for(int pos = 0; pos < testCases.length; pos++){
			challenge.findBase(testCases[pos]);
			System.out.println();
		}
	}
}
