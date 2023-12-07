import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        printSelectionSortResults(new short[]{});
        printSelectionSortResults(new short[]{2});
        printSelectionSortResults(new short[]{-128, 1728, 271, -491, 589, 124, -759, 1200, 68});
        printSelectionSortResults(new short[]{45, 78, 34, 45, 89, 99, 34, 89, 42, 74, 78});
        
        printInsertionSortResults(null);
        printInsertionSortResults(new short[]{-128, 1728, 271, -491, 589, 124, -759, 1200, 68});
        printInsertionSortResults(new short[]{45, 78, 34, 45, 89, 99, 34, 89, 42, 74, 78});
        printInsertionSortResults(new short[]{489, 456, 389, 341, 299, 109, 108, 97, 85, 74});
    }
    public static short[] ascSelectionSort(short[] array) {
        if(array == null || array.length == 0) throw new IllegalArgumentException("Array is null or empty");
        if(array.length == 1) return array;
        for(int i = 0; i< array.length-1; i++) {
            int indexOfMinNum = i;
            for(int j = i+1; j< array.length; j++) {
                if(array[j] < array[indexOfMinNum]) {
                    indexOfMinNum = j;
                }
            }
            if(indexOfMinNum!=i) {
                short temp = array[i];
                array[i] = array[indexOfMinNum];
                array[indexOfMinNum] = temp;
            }
        }
        return array;
    }
    public static short[] ascInsertionSort(short[] array) {
        if(array == null || array.length == 0) throw new IllegalArgumentException("Array is null or empty");
        if(array.length == 1) return array;
        for (int i = 1; i < array.length; i++) {
            short key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }

    private static void printSelectionSortResults(short[] array) {
        try {
            System.out.println("Вихідний масив     " + Arrays.toString(array));
            System.out.println("Сортування вибором " + Arrays.toString(ascSelectionSort(array)));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    private static void printInsertionSortResults(short[] array) {
        try {
            System.out.println("Вихідний масив       " + Arrays.toString(array));
            System.out.println("Сортування вставками " + Arrays.toString(ascInsertionSort(array)));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}