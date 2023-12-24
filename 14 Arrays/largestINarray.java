import java.util.*;
public class largestINarray {
    public static int getLargest(int numbers[]){
        int largest = Integer.MIN_VALUE;    // - Infinity
        int smallest = Integer.MAX_VALUE;

        for(int i=0; i<numbers.length;i++){
            if(largest < numbers[i]){
                largest = numbers[i];
            }
            if(smallest>numbers[i]){
                smallest = numbers[i];
            }
        } 
        System.out.println("Smallest number is : "+smallest);
        return largest;
        
        

    }
    public static void main(String args[]){
        int numbers[] ={1,5,88,74,52,14,6,7,9};
        System.out.println("Largest number in array is : "+ getLargest(numbers));
    }
}
