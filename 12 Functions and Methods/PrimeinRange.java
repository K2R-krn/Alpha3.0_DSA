import java.util.*;
public class PrimeinRange {
    
    public static boolean isPrime(int n){
        if(n==2){
            return true;
        }
                //  O P T I M I S E D
        for(int i = 2; i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void primesinRange(int n){
        for(int i = 2; i<=n;i++){
            if(isPrime(i)){//True
                System.out.print(i+", ");
            }
        } System.out.println();
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter range till : ");
        int a = sc.nextInt();
        primesinRange(a);//2 to 20
    }
}
