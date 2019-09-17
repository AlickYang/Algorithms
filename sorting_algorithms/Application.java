/**
 * Main application
 */
import java.util.List;
import java.util.ArrayList;

public class Application {
	public static void main(String[] args) {
		Sort sort = new Sort();		
		//10 numbers in an array
		int[] list = {23, 81, 48, 49, 6, 92, 119, 74, 73, 0};
		sort.reducer("merge sort -recursion", list);
	}
}