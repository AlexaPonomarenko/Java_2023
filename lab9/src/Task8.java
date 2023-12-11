public class Task8 {
    public static void main(String[] args) {
        printResult("The user with the nickname koala757677 this month wrote 3 times more comments than the user with the nickname croco181dile920 4 months ago");
        printResult("In the coding competition from 07.01.16 coderXplorer2000 submitted 5 times more solutions than coderElite007 did 3 months back.");
        printResult("The detective examined the crime scene and discovered a series of coded messages");
        printResult("Chance of bae278mov winning raised to 90%");
        printResult("");
    }
    public static void printResult(String str) {
        try {
            System.out.println(countNumbers(str));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private static int countNumbers(String str) {
        if(str == null || str.isEmpty()) throw new IllegalArgumentException("Invalid string");
        int numberCount = 0;
        for(String s : str.split("[^a-zA-Z\\d]")) {
            boolean isNumber = true;
            for(char ch : s.toCharArray()) {
                if(!Character.isDigit(ch)) {
                    isNumber = false;
                    break;
                }
            }
            if(isNumber) numberCount++;
        }
        return numberCount;
    }
}
