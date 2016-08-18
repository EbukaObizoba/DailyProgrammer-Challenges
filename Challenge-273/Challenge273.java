import java.text.DecimalFormat;
import java.util.Scanner;

public class Challenge273 {
	//Easy challenge
	public static void main(String[] args) {
		System.out.print("Enter value to convert in appropriate format: ");
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		String prevState = findState(line, 2);
		String finalState = findState(line, 1);
		double value = 0.0;

		value = decipherLine(line);
		System.out.println("Converted value: " + conversion(value, prevState, finalState));
		input.close();
	}

	public static String conversion(double value, String prevState, String finalState) {
		double pi = Math.PI;
		double val = 0.0;

		if (prevState.equals("d")) {
			val = (value) * (pi / 180);
		} else {
			val = (value) * (180 / pi);
		}
		DecimalFormat format = new DecimalFormat("#.###");
		return format.format(val) + finalState;
	}

	public static String findState(String line, int position) {
		int length = line.length();
		return String.valueOf(line.charAt(length - position));
	}

	public static double decipherLine(String line) {
		int length = line.length();
		String val = line.substring(0, length - 2);
		return Double.parseDouble(val);
	}
}
