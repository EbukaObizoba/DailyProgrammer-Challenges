import java.util.Scanner;

public class Challenge277 {
	//Easy challenge
	public static void main(String[] args){
		Challenge277 challenge = new Challenge277();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter numerator: ");
		int numerator = input.nextInt();
		System.out.print("Enter denominator: ");
		int denominator = input.nextInt();
		int[] nums = challenge.simpleFraction(numerator, denominator);
		
		System.out.println("Original fraction is " + numerator + " / " + denominator);
		System.out.println("Reduced fraction is " + nums[0] + " / " + nums[1]);
		input.close();
	}
	public int[] simpleFraction(int num, int denom){
	      int[] array;
	      if(denom == 0) return null;
	      if(num == 0){
	          return new int[]{0, 1};
	      }
	      //Number divisible by num and denom
	      int div = 0;
	      if(num == denom){
	          return new int[]{1, 1};
	      }
	      if(num < 0 && denom < 0){
	    	  num += 2*num;
	    	  denom += 2*denom;
	      }
	      array = new int[2];
	      if(num%denom == 0){
	          div = denom;
	          return findFrac(num, denom, div, array);
	      } else if(denom%num == 0){
	          div = num;
	          return findFrac(num, denom, div, array);
	      }
	  
	      div = divisibleBy(num, denom);
	      return findFrac(num, denom, div, array);
	  }
	  
	  public int divisibleBy(int val1, int val2){
	      //Finds the greatest common multiple by using modulus until there is a remainder of zero.
	      return (val2 == 0) ? val1 : divisibleBy(val2, val1%val2);
	  }
	  
	  public int[] findFrac(int num, int denom, int div, int[] array){
	      num /= div;
	      denom /= div;
	      array[0] = num; array[1] = denom;
	      return array;
	  }
}
