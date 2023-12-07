import java.util.Arrays;

public class Task63 {
    public static void main(String[] args) {
        printResults(null);
        printResults(new int[] {});
        printResults(new int[] {1, 3, -6, 0, 10, -11});
        printResults(new int[] {-90, 189, -1, 78, -48, 3, 55});
    }

    public static int[] transformArray(int[] array) {
        if(array == null || array.length == 0) throw new IllegalArgumentException("Array is null or empty");
        int[] newArray = new int[array.length];
        for (int i = 0; i<array.length; i++) {
            if(array[i] < 0) newArray[i] = array[i] + maxNumOf(array);
            if(array[i] == 0) newArray[i] = 1;
            if(array[i]>0) newArray[i] = array[i]*2;
        }
        return newArray;
    }
    private static int maxNumOf(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i: array) {
            if(i>max) max = i;
        }
        return max;
    }
    private static void printResults(int[] array) {
        try {
            System.out.println("Вихідний масив     " + Arrays.toString(array) + "\nПеретворений масив " + Arrays.toString(transformArray(array)));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
