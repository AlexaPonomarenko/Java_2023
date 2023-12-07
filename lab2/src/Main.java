import java.lang.Math;

public class Main {
    public static double task1(double a, double b, double c, double d) {
        return Math.pow((4*Math.cosh(Math.sqrt(Math.abs(a/b)))+3*Math.acos(d)), c);
    }
    public static double task2(double a, double b, double c, double d) {
        return 2 * Math.sqrt(Math.tan(Math.abs(a+c))) + (Math.log(b))/Math.pow(c, d);
    }
    public static double task3(double a, double b, double c, double d) {
        return Math.sin(Math.pow(a, -b)) + 3*Math.abs(Math.acos(-Math.sqrt(c/d)));
    }

    public static void main(String[] args) {
        System.out.println("Result of task #1 = " + task1(-3.45, 2.34, 1.45, 0.83));
        System.out.println("Result of task #2 = " + task2(-1.49, 23.4, 1.23, 2.254));
        System.out.println("Result of task #3 = " + task3(0.478, -1.26, 2.68, 18.24));

    }
}