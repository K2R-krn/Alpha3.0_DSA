import java.util.*;
public class DecToBin {

    public static void DecToBin(int n){
        int pow = 0;
        int binNum = 0;
        int myNum = n;
        while(n>0){
            
            int rem = n%2;
            binNum = binNum + (rem * (int)Math.pow(10,pow) );
 
            pow++;
            n = n/2;

        } System.out.println("Binary form of "+ myNum + " = "+binNum);
    }
    public static void main(String args []){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter binary number : ");
        int a = sc.nextInt();
        DecToBin(a);
    }
}
