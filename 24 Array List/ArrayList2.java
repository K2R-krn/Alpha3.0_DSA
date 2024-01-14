import java.util.*;

public class ArrayList2 {
    
    public static void main(String args[]){

    //*  C R E A T I O N    O F   A R R A Y   L I S T
        ArrayList<Integer> list = new ArrayList<>();   //Similar to OOPS creation of class      
                                                       //ClassName objectName = ClassName();
        
    //*  O P E R A T I O N S
        // ADDING NUMBER IN A L   takes  O(1)
        list.add(1);                                               
        list.add(8);                                               
        list.add(6);                                               
        list.add(2);   
        list.add(5);   
        list.add(4);                                               
        list.add(8);                                               
        list.add(3);   
        list.add(7); 
        System.out.println("LIST 1 = "+list);

        ArrayList<Integer> list1sorted = new ArrayList<>();   
        
        list1sorted.add(1);                                               
        list1sorted.add(2);                                               
        list1sorted.add(3);                                               
        list1sorted.add(4);   
        list1sorted.add(5);   
        list1sorted.add(6);      
        System.out.println("LIST 2 = "+list1sorted);



        //*  // ADDING AT AN INDEX      O(n)
        // list.add(1, 9);
        // System.out.println(list);
        
        //*  GET ELEMENT OPERATION    O(1)
        // int element= list.get(2);
        // System.out.println(element);

        //* REMOVE ELEMENT           O(n)
        // list.remove(2);
        // System.out.println(list);

        //* SET ELEMENT AT INDEX     O(n)
        // list.set(2, 10);
        // System.out.println(list);

        //* CONTAINS                 O(n)
        // System.out.println(list.contains(1));
        // System.out.println(list.contains(11));

    //*  S I Z E   O F   A R R A Y   L I S T
        // System.out.println(list.size());

    //* P R I N T I N G    A R R A Y   L I S T
        // for(int i = 0; i<list.size();i++){
        //     System.out.print(list.get(i));
        // }
        // System.out.println();

    //*  R E V E R S E   P R I N T    O(n)
        // for(int i = list.size()-1;i>=0;i--){
        //     System.out.print(list.get(i)+" ");
        // }
        // System.out.println();
    
    //*  M A X I M U M   I N    A R R A Y L I S T   O(n) 
    //     int max = Integer.MIN_VALUE;
    //     for(int i = 0; i<list.size();i++){
    //         // if(max<list.get(i)){
    //         //     max = list.get(i);
    //         // }
    //         max = Math.max(max, list.get(i));
    //     }
    // System.out.println(" Max element = " + max);

    //* S W A P    2    N O S 
        // int a = 10;
        // swap(list, 3, 0);

    //*  S O R T I N G  L I S T
        // Collections.sort(list);         //  A S C E N D I N G
        // System.out.println(list);  

        // Collections.sort(list, Collections.reverseOrder());  // D E S C E N D I N G
        // System.out.println(list);  


    //*  STORE WATER
    // System.out.println(storeWaterBruteForce(list));
    // System.out.println(storeWater2PTR(list));

    //*  P A I R   S U M 
        // System.out.println(pairSumBRUTE(list1sorted, 5));

        // System.out.println(pairSumPTR(list1sorted, 3));

    }

    //* S W A P    2    N O S
    public static void swap(ArrayList<Integer> list, int idx1,int idx2){
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);        System.out.println(list);
    }


    //* CONTAINER WITH MOST WATER ( B R U T E   F O R C E)    O (n^2)
    public static int storeWaterBruteForce(ArrayList<Integer> height){
        int maxWater = 0;
        // Brute Force
        for(int i=0; i<height.size(); i++){
            for(int j = i+1; j<height.size(); j++){
                int ht = Math.min(height.get(i), height.get(j));
                int width= j-i;
                int currWater = ht*width;
                maxWater = Math.max(maxWater, currWater);
            }
        }
        return maxWater;
    }

    //* CONTAINER WITH MOST WATER ( 2 P O I N T E R   A P P R O A C H)    O (n)  BETTER THAN BEFOEW
    public static int storeWater2PTR(ArrayList<Integer> height){
        int maxWater = 0;
        int lp = 0;
        int rp = height.size()-1;

        while(lp<rp){
            // calculate water area
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp-lp;
            int currWater = ht*width;
            maxWater = Math.max(maxWater, currWater);

            // Update ptr
            if(height.get(lp) < height.get(rp)){
                lp++; 
            }else {
                rp--;
            }
        }
        return maxWater;
    }

    //* P A I R S U M     (BRUTE FORCE   O(n^2)
    public static boolean pairSumBRUTE(ArrayList<Integer> list, int target){
        for(int i = 0; i<list.size();i++){
            for(int j = i+1; j<list.size(); j++){
                if(list.get(i)+list.get(j) == target){
                    return true;
                }
            }
        }
        return false;
    }

    //* P A I R S U M     (2 PTR APPROACH   O(n)
    public static boolean pairSumPTR(ArrayList<Integer> list, int target){
        int lp = 0;
        int rp = list.size()-1;

        while(lp<rp){
            // CASE 1
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }
            // CASE 2
            if(list.get(lp)+list.get(rp)<target){
                lp++;
            }else {
            // CASE 3
                rp--;
            }
        }
        return false;
    }

    

}
