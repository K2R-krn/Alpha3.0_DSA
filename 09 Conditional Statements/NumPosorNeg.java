import java.util.*;

import javax.print.attribute.standard.OrientationRequested;
public class NumPosorNeg {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number :");
        int a = sc.nextInt();

        if(a<0){
            System.out.println("Number is Negative");
        }
        else{
            System.out.println("Number is Positive");
        }
        // // Positive or negetive
        //     Scanner sc = new Scanner(System.in);
        //     System.out.println("Enter a numeber : ");
        //     char a = sc.next().charAt(0);
            
        //     if(a =='-'){
        //         System.out.println("Number is Negetive.");
        //     }
        //     else{System.out.println("Number is Positive");}
    }
}
