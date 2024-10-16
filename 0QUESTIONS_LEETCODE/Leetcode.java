import java.util.*;
public class Leetcode {
    //^ Q1 Position of an Element in an Infinite Sorted array
    //^ Q2   852. Peak Index in a Mountain Array
    //^ Q3   56. Merge Intervals

    
    //^ Q1 Position of an Element in an Infinite Sorted array
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

    //^ Q2   852. Peak Index in a Mountain Array
        public int peakIndexInMountainArray(int[] arr) {
            int start = 0;
            int end = arr.length-1;
            while(start<end){
                int mid = start + (end-start)/2;
                if(arr[mid]> arr[mid+1]){
                    // You are in decreasing part of array // May be answer but look left
                    end = mid; // This may be answer that s why end = mid and not mid-1
                }else {
                    // You are in ascending part of array
                    start = mid+1; // we know mid+1 element is greater than mid elemeent 
                }
            }
            // In the end start == end and pointing to largest number beccause of the 2 checks above
            // start and end are always trying to find max element in above 2 checks 
            // hence when they are pointing to one element thaey are at max peak
    
            // MORE ELABORATION
            // at every point of start and end, they have the best possible till that time and if we    are saying that only one item is remaining hence because of above line that is the best psosible answer
            return start;
        }

        //^ Q3   56. Merge Intervals
        public static int[][] mergeIntervals(int[][] intervals){
            // 1. Sort the array
            Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
            // 2. Create Merged List which has merged intervals // Final full answer
            List<int        []> merged = new ArrayList<>();
            // 3. Create prev arr which stores one previous array of List
            int[] prev = intervals[0];
            
            for(int i = 1;i<intervals.length;i++){
                // Interval to track current array
                int interval[] = intervals[i];
                // Compare if first element of interval is less than or equal to 2nd element of prev arr 
                if(interval[0]<=prev[1]){
                    // If so update second element of prev to Max of ( prev[1] or interval[1] )
                    prev[1] = Math.max(prev[1], interval[1]);
                }else{ // Add prev to merged and change prev to current(interval)
                    merged.add(prev);
                    prev = interval;
                }
            }
            // Finally add last prev also to merged and
            // Return an 2Darray which we get by converting merged toArray  
            merged.add(prev);
            return merged.toArray(new int[merged.size()][]);
        }
    
    public static void main(String args[]){
        // Q1
        // int arr[] = new int[]{3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        // int ans = 10;
        // System.out.println(ans(arr, ans));

        // Q2 MOuntain Array


        //Q3  56. Merge Intervals
        int arr[][] = {{1,3}, {2,6}, {8,10},{15,18},{17,25}};
        
        int[][] arr1 = mergeIntervals(arr);
        for(int i = 0;i<arr1.length;i++){
            for(int j = 0;j<arr1[0].length;j++){
                System.out.print(arr1[i][j]+" ");
            }
            System.out.println();
        }

    }
}
