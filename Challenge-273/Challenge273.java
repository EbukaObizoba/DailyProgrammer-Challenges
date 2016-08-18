import java.util.Scanner;

public class Challenge273 {
	//Easy challenge
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		String prevState = findState(line, 2);
		String finalState = findState(line, 1);
		double value = 0.0;

		value = decipherLine(line);
		System.out.println(conversion(value, prevState, finalState));
		input.close();
	}

	public static String conversion(double value, String unit1, String unit2) {
		double pi = Math.PI;
		double val = 0.0;

		if (unit1.equals("d")) {
			val = (value) * (pi / 180);
		} else {
			val = (value) * (180 / pi);
		}

		return "" + val + unit2;
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
