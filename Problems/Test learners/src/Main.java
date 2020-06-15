import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scn = new Scanner(System.in);
        int input = scn.nextInt();
        System.out.print(input == 1 ? "Yes!" : input < 5 ? "No!" : "Unknown number");
    }
}