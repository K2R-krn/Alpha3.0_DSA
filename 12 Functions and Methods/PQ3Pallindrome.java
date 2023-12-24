import java.util.*;
public class PQ3Pallindrome {
    public static boolean Pal(int n){
        int pal = n;
        int rev = 0;

        while(pal!=0){
            int rem = pal %10;
            rev = rev*10+rem;
            pal = pal/10;
        }
        if(n == rev){
            return true;
        }

        return false; 
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to check : ");
        int n = sc.nextInt();
        System.out.println(Pal(n));
    }
}