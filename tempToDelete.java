
import java.util.*;
public class tempToDelete{
    // public static void Areaofcircle(int n){
    //     System.out.println("Area of circle : "+(3.14*(Math.pow(n, 2))));
    // }
    
    public static boolean PrimeOrNot(int n){
        for(int i = 2; i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
        
    }

    public static void PrimeinRangee(int a,int b){
        for(int i = a; i<=b;i++){
            if(PrimeOrNot(i)){
                System.out.println(i);
            }
        }
    }

    public static void main(String args[]){
        PrimeinRangee(3, 13);
    }
}