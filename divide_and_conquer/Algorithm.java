import java.util.Arrays;
public class Algorithm {
	public int[] find_max_subarray(int[] arr, int low, int high) {
		int[] result = new int[3];
		int mid = -1;
		if (low == high) {
			// System.out.println("Low: " + low + " and High: " + high + " sum: " + arr[low]);
			result[0] = low;
			result[1] = high;
			result[2] = arr[low];
			return result;
		} else {
			mid = (low + high)/2;
			// System.out.println("Mid is: " + mid);
		}
		//Recursive cases
		int[] left_results = new int[3];
		int[] right_results = new int[3];
		int[] crossing_results = new int[3];

		left_results = find_max_subarray(arr, low, mid);
		right_results = find_max_subarray(arr, mid+1, high);
		crossing_results = find_max_crossing_subarray(arr, low, mid, high);

		//Destructure
		int left_sum = left_results[2];
		int right_sum = right_results[2];
		int crossing_sum = crossing_results[2];

		if (left_sum >= right_sum && left_sum >= crossing_sum) {
			return left_results; 
		} else if (right_sum >= left_sum && right_sum >= crossing_sum) {
			return right_results;
		}
		//Else case
		return crossing_results;
	}
	/**
	 * 
	 * @param arr = Array to be searched
	 * @param low = low index of the array
	 * @param mid = middle index of the array
	 * @param high = last index of the array
	 * @return an array containing the results [0] = max_left, [1] = max_right, [2] = sum of left and right
	 */
	public int[] find_max_crossing_subarray(int[] arr, int low, int mid, int high) {
		int left_sum = Integer.MIN_VALUE;
		int right_sum = Integer.MIN_VALUE;
		int max_left = 0;
		int max_right = 0;
		int sum = 0;
		//Left array scan
		//Must go from mid down, as starting from mid makes it contiguous
		for (int i = mid; i >= low; i--) {
			sum = sum + arr[i];
			if (sum > left_sum) {
				left_sum = sum;
				max_left = i;
			}
		}
		//Right array scan
		sum = 0;
		for (int i = mid+1; i <= high; i++) {
			sum = sum + arr[i];
			if (sum > right_sum) {
				right_sum = sum;
				max_right = i;
			}
		}
		int[] results = {-1, -1, -1};
		results[0] = max_left;
		results[1] = max_right;
		results[2] = (left_sum + right_sum);
		return results;
	}
}