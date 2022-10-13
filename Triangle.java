import java.util.*;

public class Triangle {
private ArrayList<Double> bottomRow = new ArrayList<>();
private ArrayList<ArrayList<Double>> fullTriangle = new ArrayList<>();

public Triangle(double[] bottomRow) {
	this.bottomRow = arrayConversion(bottomRow);
	this.fullTriangle = computeTriangle();
}

private ArrayList<ArrayList<Double>> computeTriangle() {
	ArrayList<ArrayList<Double>> fullTriangle = new ArrayList<>();
	int length = this.bottomRow.size();
	int row = 0;
	fullTriangle.add(0, bottomRow);
	while (length>1) {
		row++;
		fullTriangle.add(row, newRow(fullTriangle.get(row-1)));
		length = fullTriangle.get(row).size();
	}
	return fullTriangle;
}

public void displayTriangle() {
	for (int i=0; i<this.fullTriangle.size(); i++) {
		System.out.println("ROW " + i + ": " + fullTriangle.get(i));
	}
	boolean validTriangle = evaluateTriangle();
	if (validTriangle) {
		System.out.println("VALID TRIANGLE!");
	} else {
			System.out.println("INVALID TRIANGLE: ");
			if (!noDuplicates()) {
				System.out.println("Duplicate entries found.");
			}
			if (!allIntegers()) {
				System.out.println("Non integer entries found.");
			}
		}
}

public boolean evaluateTriangle() {
	return noDuplicates() && allIntegers();
}

private boolean noDuplicates() {
	for (int row1=0; row1<this.fullTriangle.size(); row1++) {
		for (int index1=0; index1<this.fullTriangle.get(row1).size(); index1++) {
			for (int row2=0; row2<this.fullTriangle.size(); row2++) {
				for (int index2=0; index2<this.fullTriangle.get(row2).size(); index2++) {
					if (row1!=row2 || index1!=index2) {
						if (this.fullTriangle.get(row1).get(index1).equals(this.fullTriangle.get(row2).get(index2))) {
							return false;
						}
					}
				}
			}
		}
	}
	return true;
}

private boolean allIntegers() {
	for (int row=0; row<this.fullTriangle.size(); row++) {
		for (int index=0; index<this.fullTriangle.get(row).size(); index++) {
			if (this.fullTriangle.get(row).get(index) % 1 != 0) {
				return false;
			}
		}
	}
	return true;
}

private ArrayList<Double> newRow(ArrayList<Double> previousRow) {
	ArrayList<Double> newRow = new ArrayList<>();
	for (int i=0; i<previousRow.size()-1; i++) {
		newRow.add((previousRow.get(i)+previousRow.get(i+1))/2);
	}
	return newRow;
}

private ArrayList<Double> arrayConversion(double[] array) {
	ArrayList<Double> arrayList = new ArrayList<>();
	for (int i=0; i<array.length; i++) {
		arrayList.add(array[i]);
	}
	return arrayList;
}

}
