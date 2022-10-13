import java.util.*;

public class Driver {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		ArrayList<Triangle> triangleList = new ArrayList<>();
		boolean forever = true;
		//Triangle t = new Triangle(splitDouble(stdIn.nextLine().split(" ")));
		int i=0;
		while (forever) {
		System.out.print("Input bottom row, with a space between each number: ");
		triangleList.add(new Triangle(splitDouble(stdIn.nextLine().split(" "))));
		triangleList.get(i).displayTriangle();
		i++;
		System.out.println();
		}
		stdIn.close();
		
	}

	
	public static double[] splitDouble(String[] numberString) {
		double[] numbers = new double[numberString.length];
		for (int i=0; i<numberString.length; i++) {
			numbers[i] = Double.valueOf(numberString[i]);
		}
		return numbers;
	}
}
