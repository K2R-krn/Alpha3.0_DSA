import java.util.*;
public class PQ1AvOf3nos {
    public static double Avof3(double a, double b, double c){
        double av = (a+b+c)/3;
        return av;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter num 1 : ");
        double x = sc.nextDouble();

        System.out.print("Enter num 2 : ");
        double y = sc.nextDouble();

        System.out.print("Enter num 3 : ");
        double z = sc.nextDouble();

        System.out.println("Average of 3 numbers is : "+Avof3(x, y, z));

    }
}