
import java.util.Arrays;
public class Application {

	public static void printArray(int[] arr) {
		System.out.print("Array: [");
		for (int i = 0; i < arr.length; ++i) {
			if (i == arr.length - 1) {
				System.out.println(arr[i] + "]");
			} else {
				System.out.print(arr[i] + ", ");
			}
		}
	}
	
	public static void main(String[] args) {
		//Array from textbook, maximum subarray should be from index 7-10
		int[] arr = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		int[] results = new int[3];
		Algorithm algo = new Algorithm();
		results = algo.find_max_subarray(arr, 0, arr.length-1);
		printArray(results);
	}

	
}