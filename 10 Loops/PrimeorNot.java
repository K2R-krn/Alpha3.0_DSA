import java.util.*;
public class PrimeorNot {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number to check : ");
        int n = sc.nextInt();

        if (n==2){
            System.out.println("Your number : "+n+" is Prime");
        }
        else{
            
        boolean isPrime = true;
        for(int i=2; i<=Math.sqrt(n); i++){    //instead of n-1 we can use Math.sqrt(n) which will reduce the numbers to checked to half and code will be more optimised!!
            if(n%i==0){ //n is a multiple of i (i not equal to 1 or number n)
                isPrime = false;
            }
        }

        if(isPrime==true){
            System.out.println("Your number : "+n+" is Prime");
        }
        else{
            System.out.println("Your number : "+n+" is NOT Prime");
        }

        }
    }
}
