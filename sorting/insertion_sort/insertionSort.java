import java.util.Random;

public class insertionSort {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] toBeSorted = generateIntArray(10);
        printArray(toBeSorted);
        int[] sorted = insertionSort(toBeSorted);
        printArray(sorted);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        double durationInMillis = (double) totalTime / 1_000_000.0;
        System.out.println("Total time: " + durationInMillis + " ms");
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int previous = i - 1;
            while (previous >= 0 && arr[previous] > arr[previous + 1]) {
                int temp = arr[previous];
                arr[previous] = arr[previous + 1];
                arr[previous + 1] = temp;
                previous--;
            }
        }
        return arr;
    }

    public static int[] generateIntArray(int n) {
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

}
