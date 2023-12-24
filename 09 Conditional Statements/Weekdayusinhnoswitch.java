import java.util.*;
public class Weekdayusinhnoswitch {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number between 1 and 7 :");
        int week = sc.nextInt();

        switch(week){
            case 1:
            System.out.println("Monday");
            break;
            case 2:
            System.out.println("Tuesday");
            break;
            case 3:
            System.out.println("Wednesday");
            break;
            case 4:
            System.out.println("Thursday");
            break;
            case 5:
            System.out.println("Friday");
            break;
            case 6:
            System.out.println("Saturday");
            break;
            case 7:
            System.out.println("Sunday");
            break;
            default:
            System.out.println("Enter a valid input betweeen 1-7.");
        }
    }
}
