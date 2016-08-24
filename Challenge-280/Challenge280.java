
public class Challenge280 {
	//Easy challenge
	public String validCounting(int[] fingers){
		String invalid = "Invalid";
		int numberOfFingers = fingers.length;
		if(numberOfFingers != 10) return invalid;
		//These integers will keep track of counting on each hand.
		int tensValue = 0, onesValue = 0;
		//These statements determine whether a 1 to 0 occurs.
		boolean tensChange = false, onesChange = false;
		//Checking left thumb
		if(fingers[(numberOfFingers/2)-1] == 1) tensValue += 50;
		//Checking right thumb
		if(fingers[(numberOfFingers/2)] == 1) onesValue += 5;
		
		//Parsing through left hand fingers from pinky to index
		for(int leftFinger = 0; leftFinger < (numberOfFingers/2)-1; leftFinger++){
			if(tensChange){
				//zeros found after a one is invalid to the counting scheme.
				if(fingers[leftFinger] == 0) return invalid;
			}
			if(fingers[leftFinger] == 1){
				tensChange = true;
				tensValue += 10;
			}
		}
		//Parsing through right hand fingers from pinky to index
		for(int rightFinger = numberOfFingers-1; rightFinger >= (numberOfFingers/2)+1; rightFinger--){
			if(onesChange){
				//zeros found after a one is invalid to the counting scheme.
				if(fingers[rightFinger] == 0) return invalid;
			}
			if(fingers[rightFinger] == 1){
				onesChange = true;
				onesValue += 1;
			}
		}
		
		int sum = tensValue + onesValue;
		return String.valueOf(sum);
	}
	
	public static void main(String[] args){
		Challenge280 challenge = new Challenge280();
		//Inputing challenge test cases
		int[][] testCases = { {0,1,1,1,0,1,1,1,0,0},
		                      {1,0,1,0,0,1,0,0,0,0},
				              {0,0,1,1,1,0,1,1,1,0},
				              {0,0,0,0,1,1,0,0,0,0},
				              {1,1,1,1,1,1,0,0,0,1} };
		for(int num = 0; num < testCases.length; num++){
			System.out.println("The output of your entry is " + challenge.validCounting(testCases[num]));
		}
	}
}
