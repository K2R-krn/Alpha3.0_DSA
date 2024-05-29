public class M3axSubarraySumKadaneSaLgo {                       //^ Max  Subarray   ( KADANEs ALGO )
    public static void M3axSubarraySum(int numbers[]){      //^  WITH NEGETIVE ARRAY  VERIFIED
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for(int i = 0; i<numbers.length;i++){
            cs+=numbers[i];

            ms = Math.max(cs, ms);

            if(cs<0){
                cs = 0;
            }
        }
        System.out.println("Out max subarray sum is : "+ ms);
    }

    //^     VERIFIED FOR NEGETIVE COMPLETELY NEGETIVE ARRAY
    // public static void kadane(int arr[]){
    //     int cs = 0;
    //     int ms = Integer.MIN_VALUE;
    //     int mss = 0;
        
    //     if(ms<0){
    //         for(int i = 0;i<arr.length;i++){
    //             mss = Math.min(mss, arr[i]);
    //         }
    //         System.out.println("Max sub sum = "+mss);
    //     } else {
    //         for(int i = 0;i<arr.length;i++){
    //             cs+=arr[i];
    //             if(cs<0){
    //                 cs = 0;
    //             }
    //             ms = Math.max(ms, cs);
    //             System.out.println("Max subarray sum : "+ms);
    //         }
    //     }
        
    // }
    public static void main(String args[]){
        int numbers[] = {-2,-3,4,-1,-2,1,5,-3};
        M3axSubarraySum(numbers);
    }                                                     //^ Fastest and easiest of all and TC least  O(n)   only one loop but main thing is LOGIC.
}