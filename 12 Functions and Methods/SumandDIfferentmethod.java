import java.util.*;

public class SumandDIfferentmethod {

            // B A S I C 1st .
    // public static void calcSum(){
    // Scanner sc = new Scanner(System.in);
    // System.out.print("Enter a number :");
    // int a = sc.nextInt();
    // System.out.print("Enter second number :");
    // int b = sc.nextInt();
    // int sum = a+b;
    // System.out.println("Sum is : " + sum);
    // }
    // public static void main(String args[]){
    // calcSum();
    // }



            // W I T H P A R A M E T E R
    // public static void calcSum(int num1, int num2) {
    //     int sum = num1 + num2;
    //     System.out.println("Sum is : " + sum);
    // }

    // public static void main(String args[]) {
    //     Scanner sc = new Scanner(System.in);
    //     System.out.print("Enter a number :");
    //     int a = sc.nextInt();
    //     System.out.print("Enter second number :");
    //     int b = sc.nextInt();
    //     calcSum(a,b);
    // }



        //With return type int and Sum print statement in main.

    public static int calcSum(int num1, int num2) {
        int sum = num1 + num2;
        return sum;
        
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number :");
        int a = sc.nextInt();
        System.out.print("Enter second number :");
        int b = sc.nextInt();
        int sum = calcSum(a,b);
        System.out.println("Sum is : " + sum);
    }

}
