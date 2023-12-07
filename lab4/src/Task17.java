import java.util.Arrays;

public class Task17 {
    public static void main(String[] args) {
        printResults(null);
        printResults(new int[] {});
        printResults(new int[] {2});
        printResults(new int[] {1, 3});
        printResults(new int[] {-90, 189, 1, 78, -48, 3, 55});
        printResults(new int[] {-89926, -67, -90, -468, -3378, -2, -8});
    }

    public static int maxEvenNumOf(int[] array) {
        if(array == null || array.length == 0) throw new IllegalArgumentException("Array is null or empty");
        int max = Integer.MIN_VALUE;
        for (int i: array) {
            if(i%2==0 && i>max) {
                max = i;
            }
        }
        return max;
    }
    private static void printResults(int[] array) {
        try {
            int maxNum = maxEvenNumOf(array);
            System.out.println("Для масиву: " + Arrays.toString(array)
                    + (maxNum == Integer.MIN_VALUE ? " немає парного значення" : " максимальним парним елементом масиву є " + maxNum));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}