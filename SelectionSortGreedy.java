import java.util.Scanner;

public class SelectionSortGreedy {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Accept number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Accept array elements
        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Selection Sort (Greedy Approach)
        for (int i = 0; i < n - 1; i++) {

            int min = i;

            // Find minimum element
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // Swap elements
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        // Display sorted array
        System.out.println("Sorted array:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
