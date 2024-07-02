import java.util.*;
public class M4axLengthChainOfPairs {
    
    //! SAME ACTIVITY SELECTION CODE
    public static void main(String args[]){  //*  TC =  (nlog n) 
        
        int pairs[][] = {{5,24}, {39,60},{5,28},{27,40},{50,90}};

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int ans = 1; // that is chain length
        int pairEnd = pairs[0][1]; // last ending of chain , last selected pair end  // int chainEnd

        for(int i =1 ;i<pairs.length;i++){
            if(pairs[i][0]>pairEnd){
                ans++;
                pairEnd = pairs[i][1];
            }
        }

        System.out.println("Max length of chain = "+ ans);

    }
}
 