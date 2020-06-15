import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scn = new Scanner(System.in);
        double a = scn.nextDouble();
        double b = scn.nextDouble();
        double c = scn.nextDouble();
        double x1 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        double x2 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        System.out.println(x1 > x2 ? x2 + " " + x1 : x1 + " " + x2);
    }
}