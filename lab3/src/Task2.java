public class Task2 {
    public static double sumOfNumberSeries(int t, int s, int k) {
        if(k<2 || k>25) throw new IllegalArgumentException("k is not valid");
        if(t>0) throw  new IllegalArgumentException("t is not valid");
        if(s<0) throw  new IllegalArgumentException("s is not valid");
        double sum = 0;
        for(int i = 1; i<=k; i++) {
            sum+=Math.log(-t*i)*Math.cos(Math.sqrt(s*(1/Math.pow(i, 2))));
        }
        return sum;
    }
    private static void printResults(int t, int s, int k) {
        try {
            System.out.printf("For t = %d, s = %d, k = %d, sum is %.3f\n",t, s, k, sumOfNumberSeries(t, s, k));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void main(String[] args) {
        printResults(-1, 1, 1);
        printResults(-3, 5, 20);
        printResults(10, 8, 13);
        printResults(-34, 21, 9);
        printResults(-18,-6 , 25);
    }
}