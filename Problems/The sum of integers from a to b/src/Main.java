import java.util.Scanner;

class Main {
    public static int sumFromTo(int a, int b) {
        int sum = a;
        if (b == a) {
            return sum;

        } else {
            sum = b + sumFromTo(a, b - 1);
            return sum;
        }
    }
    public static void main(String[] args) {
        // put your code here
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        System.out.print(sumFromTo(a, b));

    }
}