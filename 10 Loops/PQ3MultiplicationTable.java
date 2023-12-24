//Write a program to print the multiplication table of a number N, entered by the user

import java.util.*;
public class PQ3MultiplicationTable {
        public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        for(int i=1; i<=10; i++){
            System.out.println(n+" * "+i+" = "+n*i);
        }

        /* REVISION TIME TABLE*/     //😁   BETTER  😁
        // Multiplication table
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter a number whose multiplication table is needed: ");
        // int a = sc.nextInt();
        // System.out.print("Enter a number TILL WHERE multiplication table is needed: ");
        // int n = sc.nextInt();   

        // for(int i = 1;i<=n;i++){
        //     int m = a*i;
        // System.out.println(a+" x "+i+" = "+m+" ");
        // }

    }
}



