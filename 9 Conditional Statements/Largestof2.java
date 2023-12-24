import java.util.*;
public class Largestof2{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number : ");
        int F = sc.nextInt();

        System.out.print("Enter second number : ");
        int S = sc.nextInt();

        if(F>S){
            System.out.print("Largest number from 2 is : "+F);
        }
        else{
            System.out.print("Largest number from 2 is : "+S);
        }
        
    }
}