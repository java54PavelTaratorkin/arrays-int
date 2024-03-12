package telran.util;

import java.util.Arrays;

public class ArraysInt {
	public static int[] addNumber(int[] array, int number) {
		//TODO
		//apply method copyOf of class Arrays
		int[] newArray = Arrays.copyOf(array, array.length + 1);
		newArray[newArray.length - 1] = number;
		
		return newArray;
	}
	
	public static int[] insertNumber(int[] array, int index, int number) {
		//TODO
		//apply method arraycopy of class System
		int[] newArray = new int[array.length + 1];
		if (index == array.length) {
			System.arraycopy(array, 0, newArray, 0, array.length);
			System.arraycopy(new int[] {number}, 0, newArray, array.length, 1);
		} else if (index == 0) {
			System.arraycopy(array, 0, newArray, 1, array.length);
			System.arraycopy(new int[] {number}, 0, newArray, 0, 1);
		} else if (index > 0 && index < array.length) {
			System.arraycopy(array, 0, newArray, 0, index);
			System.arraycopy(new int[] {number}, 0, newArray, index, 1);
			System.arraycopy(array, index, newArray, index + 1, array.length - index);
		}

		return newArray;
	}
	
	public static int[] removeNumber(int[] array, int index) {
		//TODO
		//apply method arraycopy of class System
		int[] newArray = new int[array.length - 1];
		if (index == array.length - 1) {
			System.arraycopy(array, 0, newArray, 0, array.length - 1);
		} else if (index == 0) {
			System.arraycopy(array, 1, newArray, 0, array.length - 1);
		} else if (index > 0 && index < array.length - 1) {
			System.arraycopy(array, 0, newArray, 0, index);
			System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
		}

		return newArray;
	}
	
	public static int[] insertSorted(int[] sortedArray, int number) {
		//TODO
		//insert number into sorted array with keeping the sorted order
		//apply method binarySearch of the class Arrays
			
		int index = Arrays.binarySearch(sortedArray, number) >= 0 ? 
				Arrays.binarySearch(sortedArray, number): 
					-Arrays.binarySearch(sortedArray, number) - 1;
					
		return ArraysInt.insertNumber(sortedArray, index, number);
	}
}
