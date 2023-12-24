import java.util.*;
public class BinarySearch {
    public static int BinarySearch(int numbers [], int key){
        int start = 0, end=numbers.length - 1;

        while(start<=end){
            int mid = (start+end)/2;
            
            // C O M P A R I S I O N S
            if(numbers[mid]==key){
                return mid;
            }
            if(numbers[mid]<key){           // R I G H T
                start = mid+1;              
            } else{                         // L E F T 
                end = end-1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int numbers[] = {1,2,4,6,8,10,12,15,18,20,22,39,47,66,69,87,91,101,2222};
        int key = 20;

        System.out.println("index for key is "+BinarySearch(numbers, key));
    }
}
