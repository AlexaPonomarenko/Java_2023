public class Task5 {
    public static void main(String[] args) {
        printResult("101010011");
        printResult("1111111111111111");
        printResult("1010000101001010001");
        printResult("1011");
        printResult("b1n0rystr1ng");
        printResult("128256512");
    }
    public static void printResult(String str) {
        try {
            System.out.println(binaryStringToInt(str));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static int binaryStringToInt(String str) {
        if (str == null || str.isEmpty() || !isBinary(str)) throw new IllegalArgumentException("Invalid string");
        int number = 0;
        for (int i = 0; i < str.length(); i++) {
            number += Integer.parseInt(String.valueOf(str.charAt(i))) * (int) Math.pow(2, str.length() - i - 1);
        }
        return number;
    }
    private static boolean isBinary(String str) {
        for (char ch : str.toCharArray()) {
            if (Character.isAlphabetic(ch)) return false;
            if (Character.isDigit(ch)) {
                int value = Character.getNumericValue(ch);
                if (value != 0 && value != 1) return false;
            }
        }
        return true;
    }
}
