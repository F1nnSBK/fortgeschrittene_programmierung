import java.util.Random;

public class bubbleSort {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] toBeSorted = generateIntArray(1000);
        printArray(toBeSorted);
        int[] sorted = bubbleSort(toBeSorted);
        printArray(sorted);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        double durationInMillis = (double) totalTime / 1_000_000.0;
        System.out.println("Total time: " + durationInMillis + " ms");
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
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
