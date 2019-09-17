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
			j = i-1;
			while (j >= 0 && arr[j] > key) {
				//Swap values
				temp = key;
				arr[j+1] = arr[j];
				arr[j] = temp;
				//Move on
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
			//swap currentMinimum, and array[i] if a change has occurred
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
			if (numSwaps == 0) break;
			numSwaps = 0;
			for (j = 0; j < arr.length-1; j++) {
				//When arr[i+1] > arr[i], swap
				if (arr[j] > arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					numSwaps++;
					printArray(arr);	
				}
				
			}
			System.out.println("Swaps in turn " + (i+1) + ": " + numSwaps);
			printArray(arr);
		}
		System.out.println("After sorting: ");
		printArray(arr);
	}

	public void mergeSortRecursion(int[] arr) {
		//TODO
	}

	public void mergeSort(int[] arr, int[] temp, int start, int end) {
		//TODO
	}

	public int[] merge(int[] arr, int[] mergeArray, int start, int end) {
		//TODO
		return arr;
	}

	public void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length-1) {
				System.out.println(arr[i] + "]");
			} else {
				System.out.print(arr[i] + ", ");
			}
		}
	}
}