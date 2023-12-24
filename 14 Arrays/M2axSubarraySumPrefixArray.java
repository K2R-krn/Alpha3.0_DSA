import java.util.*;
public class M2axSubarraySumPrefixArray{

    public static void M2axSubarraySum(int numbers[]){
        int MaxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int prefix[] = new int[numbers.length];
        
        //Calculate Prefix Array
        prefix[0] = numbers[0];
        for(int i = 1;i<prefix.length;i++){
            prefix[i]= prefix[i-1]+numbers[i];
        }
        for(int i=0;i<numbers.length;i++){
            for(int j=i;j<numbers.length;j++){
                currSum = 0;
                
                currSum = i ==0 ? prefix[j] : prefix[j] - prefix[i-1];

                if(MaxSum<currSum){
                    MaxSum=currSum;
                }
            }
        }
        System.out.println("Max sum : "+MaxSum);
    }
    public static void main(String args[]){
       int numbers[]= {2,4,6,8};
       M2axSubarraySum(numbers);
    }
}
