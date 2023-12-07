import java.util.Arrays;

public class Task47 {
    public static void main(String[] args) {
        printResults(null);
        printResults(new int[] {2, 12, 78, 32, 67});
        printResults(new int[] {-90, 189, 1, 78, -48, 3, 5, 890, 132, -200, 96, 67, 29, 89, 12, 32, 99, 187, 51});
        printResults(new int[] {23849, 46781, -128704, 16728, 0, 2108, -38740, 13749, 97432, 27340, 73491, 2835, 2730});
    }
    public static int maxNumByIndex(int[] array) {
        if(array == null || array.length <= 6) throw new IllegalArgumentException("Array is null or underfilled");
        int max = Integer.MIN_VALUE;
        for (int i = 1; i<array.length; i++) {
            if(i%6==0 && array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    private static void printResults(int[] array) {
        try {
            System.out.println("Для масиву: " + Arrays.toString(array) + " максимальним елементом масиву з індексом, що кратний 6 є " + maxNumByIndex(array));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
