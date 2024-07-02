import java.util.*;
public class I5ndianCoin {
    
    public static void main(String args[]){
        Integer coins[] = {1,2,5,10,20,50,100,500,1000,2000};

        Arrays.sort(coins, Comparator.reverseOrder()); // for comparator to work Above coins should be Integer type 

        int countofCoins = 0;
        int amount = 590;
        
        ArrayList<Integer> ans = new ArrayList<>();// array list to store which all denominations used and how much
        
        for(int i = 0;i<coins.length;i++){
            if(coins[i]<=amount){
                while(coins[i]<=amount){
                    countofCoins++;
                    amount-=coins[i];
                    ans.add(coins[i]);
                }
            }
        }

        // To print which all notes or denominations used we print content of ans Arraylist
        System.out.println("Total min  coins used = "+countofCoins);
        for(int i = 0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
        System.out.println();
    }
}
