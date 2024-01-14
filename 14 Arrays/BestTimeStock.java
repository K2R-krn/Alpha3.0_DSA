import java.util.*;
public class BestTimeStock {
    public static int BuyAndSellStock(int prices[]){
        int BP = Integer.MAX_VALUE;
        int maxP = 0;

        for(int i = 0; i<prices.length;i++){
            if(BP<prices[i]){//profit
            int profit = prices[i]-BP; // Today s Profit
            maxP = Math.max(maxP, profit);
            }
            else{
                BP = prices[i];
            
        } return maxP;
    }
    public static void main(String args[]){
        int prices[] = {7,1,5,3,6,4};
        System.out.println(BuyAndSellStock(prices));
    }
}
}
