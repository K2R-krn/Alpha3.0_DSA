import java.util.*;
public class b_heaps {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        
        //^ 1  Adding in a heap
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
                
                x = par;
                par = (x-1)/2;
            }  
        }

        //^ 2 Peek in heap
        public int peek(){
            return arr.get(0);
        }

        //^ 3 Delete in a heap
        public int remove(){
            int data = arr.get(0);

            // Step 1 - Swap with last index
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // Step 2 - delete last element
            arr.remove(arr.size()-1);

            // Step 3 - Heapify   i.e. fix heap now
            heapify(0);
            return data;
        }

        //* H E A P I F Y
        private  void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i; // we assume out root in minimum index

            if(left<arr.size() && arr.get(minIdx) > arr.get(left)){ // sometimes i can be leaf node so no left and right child // so if leaf node left and right doesnt exist so check left<arr.size()
                minIdx = left;
            }
            if(right<arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx = right;
            }
            if(minIdx != i){ // if nothing bigdaa   if root correcet root is moinimum  else fix it
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }

        }
        public boolean isEmpty(){
            return arr.size() == 0;
        }

        //chodiya      - Rajan Kumar Jha  // Maksood    / So. Amit 
        
    }


    //*  HEAPSORT     -    O ( nlogn )    [ as heapify log n and heap sort runs for n times so nlogn ]__  || SC - O(1) || TC - O(nlogn) ||
    public static void heapSort(int arr[]){
        // Step 1 - Build MaxHeap
        int n = arr.length;
        for(int i = n/2; i>=0; i--){
            heapifyy(arr, i, n);
        }
        // Step 2 - Push largest element at end
        for(int i = n-1;i>0;i--){
            // Swap   / swapped first with last index
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapifyy(arr, 0, i);
        }
    
    }
    public static void heapifyy(int arr[], int i, int size){
        int left = 2*i+1;
        int right = 2*i+2;
        
        int maxIdx = i;

        if(left < size && arr[left] > arr[maxIdx]){
            maxIdx = left;
        }
        if(right < size && arr[right ] > arr[maxIdx]){
            maxIdx = right;
        }

        if(maxIdx != i){
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapifyy(arr, maxIdx, size);
        }
    }
    
    public static void main(String args[]){
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        while(!h.isEmpty()){
            System.out.print(h.peek()+"  ");
            h.remove();
        }
        System.out.println();


        // * Heapsort
        int arr[] = {1,2,4,5,3};
        heapSort(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        
    }
}
