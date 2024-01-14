
//^     M A X    S U B A R R A Y    S U M  

import java.util.*;
public class M1axSubarraySumBruteForce {
 
    public static void MaxSubarraySum(int numbers[]){
        int MaxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i=0;i<numbers.length;i++){
            for(int j=i;j<numbers.length;j++){
                currSum = 0;
                for(int k=i;k<=j;k++){  // Subarray Sum
                currSum += numbers[k];
                }
                System.out.println(currSum);
                if(MaxSum<currSum){
                    MaxSum=currSum;
                }
            }
        }
        System.out.println("Max sum : "+MaxSum);
    }
     public static void main(String args[]){
        int numbers[]= {2,4,6,8};
        MaxSubarraySum(numbers);
     }
                                                     //^    This is not preffered because it has time complexity of ( t^3 )  cuz 3 nested for loops.
    
}
