import java.util.*;

public class Leapyear {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a year : ");
        int year = sc.nextInt();

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 4 == 0) {
                    System.out.println(year + " : Is a leap year");
                } else {
                    System.out.println(year + " : Not a leap year");
                }
            } else {
                System.out.println(year + " : Is a leap year");
            }
        } else {
            System.out.println(year + " : Not a leap year");
        }

    }
}
