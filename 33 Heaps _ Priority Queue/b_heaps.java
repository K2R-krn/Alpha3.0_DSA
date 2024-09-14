import java.util.*;
public class b_heaps {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        
        // 1  Adding in a heap
        public void add(int data){
            // add at last index
            arr.add(data);

            int x = arr.size()-1; // Last index of arrayList
            int par = (x-1)/2;   // parent index

            while(arr.get(x) < arr.get(par)){ // This will run for log(n) times as it is a tree   // As worst case me log n parents hote hai so TC - O ( logn )
                // Swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
            }  
        }

        // 2 Peek in heap
        public int peek(){
            return arr.get(0);
        }

    }    
}
