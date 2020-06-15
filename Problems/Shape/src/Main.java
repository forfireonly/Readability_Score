import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        String[] shapes = {"square", "circle", "triangle", "rhombus"};
        Scanner scn = new Scanner(System.in);
        String firstPart = "You have chosen a ";
        int input = scn.nextInt();
        switch (input) {
            case 1 :
                System.out.print(firstPart + shapes[0]);
                break;
            case 2:
                 System.out.print(firstPart + shapes[1]);
                 break;
            case 3:
                System.out.print(firstPart + shapes[2]);
                break;
            case 4:
                System.out.print(firstPart + shapes[3]);
                break;
            default:
                System.out.print("There is no such shape!");

        }
    }
}