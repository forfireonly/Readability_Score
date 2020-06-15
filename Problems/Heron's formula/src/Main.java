import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scn = new Scanner(System.in);
        double firstSide = scn.nextInt();
        double secondSide = scn.nextInt();
        double thirdSide = scn.nextInt();
        double halfPerimeter = (firstSide + secondSide + thirdSide) / 2;
        double area = Math.sqrt(halfPerimeter * (halfPerimeter - firstSide) * (halfPerimeter - secondSide) *
                (halfPerimeter - thirdSide));
        System.out.println(area);
    }
}