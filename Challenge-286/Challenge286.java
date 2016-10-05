
public class Challenge286 {
	
	public void reverseFactorial(long num){
		int divisor = 1;
		long val = num;
		String errorMessage = val + "   NONE";
		if(num <= 0){
			System.out.println(errorMessage);
			return;
		}
		while(num > 1){
			if(num % divisor == 0){
				num /= divisor;
				divisor++;
			} else {
				System.out.println(errorMessage);
				return;
			}
		}
		//Divisor still increments right at the end.
		divisor--;
		System.out.println(val + " = " + divisor + "!");
	}

	public static void main(String[] args) {
		long[] inputs = {3628800, 479001600, 6, 18, 0, 1};
		
		Challenge286 challenge = new Challenge286();
		for(int pos = 0; pos < inputs.length; pos++){
			challenge.reverseFactorial(inputs[pos]);
		}

	}

}
