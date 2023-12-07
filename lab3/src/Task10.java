public class Task10 {
    public static double calculateFunc(int t, int n)  {
        if(n<=0) throw new IllegalArgumentException("n is not valid");
        int i = 1;
        double sum = 0;
        while(i<=n) {
            if (t<0) sum+=t*t*i;
            if(t>=0)  sum += Math.sqrt(t * i);
            i++;
        }
        return sum;
    }
    private static void printResults(int t, int n) {
        try {
            System.out.printf("For t = %d, n = %d, x(t,n) = %.3f\n", t, n, calculateFunc(t, n));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        printResults(0, 18);
        printResults(-16, 9);
        printResults(8, -1);
        printResults(-1, 0);
        printResults(23, 34);
    }
}
