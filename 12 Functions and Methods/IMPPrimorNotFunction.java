import java.util.*;
public class IMPPrimorNotFunction {
    //Only for n>=2
    public static boolean isPrime(int n){
        //corner case
        //2
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
        
                //   R E G U L A R
        //                                             //boolean isPrime=true;
        // for(int i =2;i<=n-1;i++){
        //     if(n%i==0){  //Completely dividing
        //         return false;                       // isPrime = false;
        //                                             // break;
        //     }
        // }
        //         return true;                        //return isPrime;
         
    }

                    // M A I N
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);  
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        System.out.println(isPrime(n));
    }
}
