import java.util.*;

public class OddorEven {
    public static void OddEven(int n){
        int bitMask = 1;
        if((n & bitMask)==0){
            // even number
            System.out.println("Even Number");
        }
        else {
            System.out.println("Odd number");
        }
    }
    public static void main(String args[]){
        OddEven(99999992);
    }    
}
