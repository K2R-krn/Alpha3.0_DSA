import java.util.*;
public class PowerOf2 {
    public static boolean PowOf2(int n){
        return (n & (n-1)) == 0 ;
    }

    public static void main(String args[]){
        System.out.println(PowOf2(16));
    }
}
