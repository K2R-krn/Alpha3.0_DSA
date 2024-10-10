import java.util.*;
public class Leetcode {
    
    // Q Position of an Element in an Infinite Sorted array
    // public static int infiniteArray(int arr[], int target){
    //     int start = 0;
    //     int end = 1; 
    // }
    public static int ans(int arr[], int target){
        // First find the range
        // Then start with a box of size 2
        int start = 0;
        int end = 1;

        // condition for target to lie in range
        // Keep doubling till target is bigger than end // we dont need to check if its bigger than start // we just need to check if its bigger than end if its not bigger than end in the same chunk it will lie 
        while(target>arr[end]){
            int newStart = end+1;
            // double the box value
            // end will be previous end + size of box *2
            end = end+(end -start +1)*2;
            start = newStart; // As we are using original start in above line we cannot use it , we had to make a newStart variable
        }
        return binarySearch(arr, target, start, end);
    }
    public static int binarySearch(int arr[], int target, int start, int end){
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target<arr[mid]){
                end = mid-1;
            }
            else if(target > arr[mid]){
                start = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        // Q1
        int arr[] = new int[]{3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int ans = 10;
        System.out.println(ans(arr, ans));

    }
}
