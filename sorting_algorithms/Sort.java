/**
 * Sort
 */
public class Sort {
	public void reducer(String sort, int[] arr) {
		System.out.println("Before sorting: ");
		printArray(arr);
		if (sort.equalsIgnoreCase("insertion sort")) {
			System.out.println("Insertion sort: ");
			insertionSort(arr);
		} else if (sort.equalsIgnoreCase("selection sort")) {
			System.out.println("Selection sort: ");
			selectionSort(arr);
		} else if (sort.equalsIgnoreCase("bubble sort")) {
			System.out.println("Bubble sort: ");
			bubbleSort(arr);
		} else if (sort.equalsIgnoreCase("merge sort -recursion")) {
			System.out.println("Merge sort -recursive: ");
			mergeSortRecursion(arr);
		} else if (sort.equalsIgnoreCase("merge sort -iterative")) {
			System.out.println("Merge sort -iterative: ");
		}
	}

	public void insertionSort(int[] arr) {
		int i, j, key, temp;
		for (i = 1; i < arr.length; i++) {
			key = arr[i];
			j = i - 1;
			while (j >= 0 && arr[j] > key) {
				// Swap values
				temp = key;
				arr[j + 1] = arr[j];
				arr[j] = temp;
				// Move on
				j--;
				printArray(arr);
			}
		}
		System.out.println("After sorting: ");
		printArray(arr);
	};

	public void selectionSort(int[] arr) {
		int i, j, temp;
		int position = 0;
		int currentMinimum;
		for (i = 0; i < arr.length; i++) {
			currentMinimum = arr[i];
			for (j = i + 1; j < arr.length; j++) {
				if (arr[j] < currentMinimum) {
					currentMinimum = arr[j];
					position = j;
				}
			}
			// swap currentMinimum, and array[i] if a change has occurred
			if (currentMinimum != arr[i]) {
				temp = arr[i];
				arr[i] = currentMinimum;
				arr[position] = temp;
			}
			printArray(arr);
		}
		System.out.println("After sorting: ");
		printArray(arr);
	}

	public void bubbleSort(int[] arr) {
		int i, j;
		int numSwaps = -1;
		for (i = 0; i < arr.length; i++) {
			if (numSwaps == 0)
				break;
			numSwaps = 0;
			for (j = 0; j < arr.length - 1; j++) {
				// When arr[i+1] > arr[i], swap
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
					numSwaps++;
					printArray(arr);
				}

			}
			System.out.println("Swaps in turn " + (i + 1) + ": " + numSwaps);
			printArray(arr);
		}
		System.out.println("After sorting: ");
		printArray(arr);
	}

	public void mergeSortRecursion(int[] arr) {
		mergeSort(arr);
		System.out.println("After sorting: ");
		printArray(arr);
	}

	public int[] mergeSort(int[] arr) {
		// TODO
		// partition A into 2 halfs
		if (arr.length == 1) {
			return arr;
		}
		int mid = arr.length / 2;
		int rightSize = arr.length - mid;
		int[] left = new int[mid];
		int[] right = new int[rightSize];
		for (int i = 0; i < mid; i++) {
			left[i] = arr[i];
		}
		for (int i = mid; i < arr.length; i++) {
			right[i - mid] = arr[i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(left, right, arr);
		return arr;
	}

	// Merges together 2 arrays in sorted order
	public void merge(int[] left, int[] right, int[] merged) {
		int mid = (merged.length) / 2;
		int newArrayLength = left.length + right.length;
		// int[] merged = new int[newArrayLength];
		int leftCounter = 0;
		int rightCounter = 0;
		int mergedCounter = 0;
		while (leftCounter < left.length && rightCounter < right.length) {
			if (left[leftCounter] <= right[rightCounter]) {
				merged[mergedCounter] = left[leftCounter];
				leftCounter++;
			} else if (right[rightCounter] <= left[leftCounter]) {
				merged[mergedCounter] = right[rightCounter];
				rightCounter++;
			}
			mergedCounter++;
		}
		// Copy the rest over as one of the arrays will finish first
		// Only 1 of these will execute
		while (leftCounter < left.length) {
			merged[mergedCounter] = left[leftCounter];
			mergedCounter++;
			leftCounter++;
		}
		while (rightCounter < right.length) {
			merged[mergedCounter] = right[rightCounter];
			mergedCounter++;
			rightCounter++;
		}
	}

	public void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				System.out.println(arr[i] + "]");
			} else {
				System.out.print(arr[i] + ", ");
			}
		}
	}
}