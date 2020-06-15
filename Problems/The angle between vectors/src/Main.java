import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scn = new Scanner(System.in);
        double vector11 = scn.nextDouble();
        double vector12 = scn.nextDouble();
        double vector21 = scn.nextDouble();
        double vector22 = scn.nextDouble();
        double length1 = Math.sqrt(vector11 * vector11 + vector12 * vector12);
        double length2 = Math.sqrt(vector21 * vector21 + vector22 * vector22);
        double product = vector11 * vector21 + vector12 * vector22;
        double cosinus = product / (length1 * length2);
        System.out.println(Math.toDegrees(Math.acos(cosinus)));
    }
}