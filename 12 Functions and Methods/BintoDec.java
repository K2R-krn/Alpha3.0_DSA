import java.util.*;
public class BintoDec {
    
    public static void binToDec(int binNum){
        int pow =0;
        int decNum =0;
        int bn = binNum;

        while(bn>0){
            int lastDigit = bn%10;
            decNum = decNum + (lastDigit*(int)Math.pow(2, pow));

            pow++;
            bn = bn/10; 
        }
        System.out.println("Decimal of " + binNum + " = "+ decNum);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter binary number : ");
        int a = sc.nextInt();
        binToDec(a);
    }
}
