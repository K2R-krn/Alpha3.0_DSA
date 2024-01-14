import java.util.*;
public class changeArray {
    public static void changeArr(int arr[], int i, int val){
        // BC
        if(i==arr.length){
            printArray(arr);
            return;
        }
        // Kaam
        arr[i] = val;
        changeArr(arr, i+1, val+1); // Function call step
        arr[i]= arr[i]-2;           // Backtracking step
    }
    public static void printArray(int arr[]){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        } 
    }
    public static void main(String args[]){
        int arr[] = new int[4];
        changeArr(arr, 0, 1);
        System.out.println();
        printArray(arr);
    }
}
