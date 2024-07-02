import java.util.*;
public class M3inAbsoluteDifferencePairs {
    
    public static void main(String args[]){     //*   O (n logn) 

        int A[] = {1,2,3};
        int B[] = {2,1,3};

        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;
        for(int i =0;i<A.length;i++){
            // we will always find absolute diff and add it up in min difference
            minDiff += Math.abs(A[i]-B[i]);
        }

        System.out.println("Min Abs diff = "+minDiff);
    }

}
