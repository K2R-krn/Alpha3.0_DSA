import java.util.*;
@SuppressWarnings("unused")
public class DOUUBBTTfacto{

    public static void LargestNSmallest(int arr[]){
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for(int i =0;i<arr.length;i++){
            if(arr[i]>largest){
                largest = arr[i];
            }
        }
        System.out.println("Largest number in array is : "+largest );
        
        for(int i =0;i<arr.length;i++){
            if(arr[i]<smallest){
                smallest = arr[i];
            }
        }
        System.out.println("Smallest number in array is : "+smallest );

    }
    
    public static void main(String[] args){
        int arr[]={1,2,4,33,2,44,-199,5,666,3,44,2222,33,44444,55555,199999,100000000};
        // LargestNSmallest(arr);
        int SortedArr[]= {0,4,77,123,1543,11234,1123123};

    
    
    
    }
}