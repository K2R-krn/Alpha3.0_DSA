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


    public static int BinarySearch(int arr[], int key){
        int start = 0;
        int end = arr.length-1;
        
        do{
            int mid = (start+end)/2;
            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid]>key){
                end = mid-1;
            }
            else if(arr[mid]<key){
                start = mid+1;
            }
        } while(start<=end);

        return -1;
    }
    

    public static void RevArray(int arr[]){
        int start = 0;
        int end = arr.length-1;

        while(start<end ){
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start]=temp;

            start++;
            end--;
        }
        for(int i  =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void PairsinArray(int arr[]){
        for(int i = 0;i<arr.length;i++){
            int now = arr[i];
            for(int j = i+1;j<arr.length;j++){
                System.out.print("( "+now+" , "+arr[j]+" )");
            }
            System.out.println();
        }
    }

    public static void maxSubarraySum(int arr[]){
        int currsum=0;
        int maxSum = Integer.MIN_VALUE;

        int prefix[]= new int[arr.length];

        //calculate prefix array
        prefix[0]=arr[0];
        for(int i = 1;i<prefix.length;i++){
            prefix[i]=prefix[i]+prefix[i-1];
        }

        for(int i =0;i<arr.length;i++){
            int start = i;
            for(int j=i;j<arr.length;j++){
                int end = j;
                currsum=0;
                currsum = start ==0 ? prefix[end] : prefix[end]-prefix[start-1];

                // for(int k=start;k<=end;k++){
                //     // System.out.print(arr[k]+ " ");
                //     currsum+=arr[k];
                // }
                if(currsum>maxSum){
                    maxSum=currsum;
                }
                // System.out.println(currsum);
            }
        }
        System.out.println(maxSum);
    }

    public static void Kadanes(int arr[]){

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0;i<arr.length;i++){
            currSum=currSum+arr[i];

            if(currSum<0){
                currSum = 0;
            }
            maxSum= Math.max(currSum,maxSum);
        }
        System.out.println("Our maximum sum is : "+maxSum);
    }



    public static int TrappedRainwater(int height[]){

        int n = height.length;

        //calc keft max - array
        int leftMax[]= new int[n];

        leftMax[0]=height[0];
        
        for(int i = 1; i<n;i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }


        //calc right max boundary - array
        int rightMax[]= new int[n];

        rightMax[n-1]= height[n-1];

        for(int i=n-2;i>=0;i--){
            rightMax[i]= Math.max(height[i], rightMax[i+1]);
        }


        //loop
        int trappedWater = 0;
        for(int i =0; i<n;i++){

            //waterlevel = min(leftMax , RightMax)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            
            //tarpper water = waterLevel - height[i]
            trappedWater +=waterLevel-height[i];
        }
        return trappedWater;
    }


    public static void main(String[] args){
        // int arrSimple[]= {1,2,3,4,5,6,1};
        int arrSimple[]= {-2,-3,4,-1,-2,1,5,-3};
        int arr[]={1,2,4,33,2,44,-199,5,666,3,44,2222,33,44444,55555,199999,100000000};
        // LargestNSmallest(arr);
        int SortedArr[]= {0,4,77,123,1543,11234,1123123};
        // System.out.println(BinarySearch(SortedArr, 11234));
        // RevArray(arr);
        // PairsinArray(arrSimple);
        // maxSubarraySum(arrSimple);
        // Kadanes(arrSimple);
        
        int height[] = {4,2,0,6,3,2,5};
        System.out.println(TrappedRainwater(height));
        
    }
}