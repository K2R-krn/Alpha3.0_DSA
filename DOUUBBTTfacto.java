import java.util.*;
public class DOUUBBTTfacto {
    public static int factorial(int n){
        if (n == 0){
            return 1;
            }
            int smallOutput = factorial(n - 1);
            int output = n * smallOutput;
            return output;
        }
    public static void main(String args[]){
        System.out.println(factorial(5));
    }
}