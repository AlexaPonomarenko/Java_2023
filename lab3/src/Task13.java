public class Task13 {
    public static double calculateInfiniteSum(double eps) {
        if(eps<0) throw new IllegalArgumentException("eps is not valid");
        int i = 1;
        double sum = 0, currentStep;
        while(true) {
            currentStep = Math.pow(-1, i)/factorial(i);
            if(Math.abs(currentStep) < eps) break;

            sum+=currentStep;
            i++;
        }
        return sum;
    }
    private static int factorial(int n) {
        int factor = 1;
        for(int i = 1; i<=n; i++) {
            factor*=i;
        }
        return factor;
    }
    private static void printResults(double eps) {
        try {
            System.out.printf("For epsilon %f sum is %.3f\n", eps, calculateInfiniteSum(eps));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        printResults(0.00001);
        printResults(-2.679);
        printResults(1);
        printResults(0.09);
    }
}
