import java.util.*;
public class P4SumofDigitsinInt {
    public static int sumInt(int n){
        int num = n;
        int sum =0;
        while(num!=0 /*n>0*/ ){
            int a = num%10;
            sum = sum+a;
            num = num/10;
        }
        return sum;
    
    }   
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        System.out.println(sumInt(n));
    }
}
