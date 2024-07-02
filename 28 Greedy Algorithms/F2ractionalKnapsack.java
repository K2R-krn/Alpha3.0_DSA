import java.util.*;
public class F2ractionalKnapsack {
    
    public static void main(String args[]){
        int val[]={60,100,120};
        int weight[]={10,20,30};
        int W = 50;  // Total weight of knapsack that we can take

        // To sort ratios we create a 2D array
        double ratio[][] = new double[val.length][2];
        //0th col -> storing index
        //1st col -> we storing items ratio
        for(int i = 0;i<val.length;i++){
            ratio[i][0] = i;                          // 0th col = stored index
            ratio[i][1] = val[i]/(double)weight[i];   // 1st Col = storing ratios
        }

        // Sorting in Ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1])); // sorted for first col ie ratio   who s ratio least comes first

        // for descending order we can run loop ULTA reverse

        int capacity = W;
        int finalVal = 0;

        for(int i = ratio.length-1;i>=0;i--){
            
            int idx = (int)ratio[i][0]; // this will give highest ratio s index

            if(capacity>=weight[idx]){ // include full item
                finalVal += val[idx];
                capacity-=weight[idx];
            }else{                     // include fractional item
                finalVal+=(ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println("Final value : "+finalVal); 
    }
}
