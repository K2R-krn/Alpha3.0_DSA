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





    public static int BuyAndSellStock(int prices[]){
        int bp = Integer.MAX_VALUE;
        int maxProft = 0;
        int selPrice = 0;
        int buyPrice = Integer.MAX_VALUE;
        for(int i = 0;i<prices.length;i++){    

            if(bp<prices[i]){
                int profit = prices[i]-bp;
                maxProft = Math.max(maxProft, profit);
            }else{
                bp = prices[i];
            }
            // bp= Math.min(prices[i], bp);
            // int sp = prices[i];

            // int profit = sp-bp;
            // System.out.println("Profit for Day "+i+" is : "+ profit);
            
            // if(profit>maxProft){
            //     maxProft=profit;
            //     selPrice = prices[i];
            // }

            // if(buyPrice>bp){
            //     buyPrice=bp;
            // }

            }
        // System.out.println("Max profit till date is : "+ maxProft);
        // System.out.println("Buy price for maxProfit is : "+buyPrice);
        // System.out.println("Sell price for maxProfit is : "+selPrice);
        return maxProft;
    }

    public static boolean CheckDuplicate(int nums[]){

        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++ ){
                if(nums[i]==nums[j]){
                    return false;
                }
            }
        }
        return true;
    }


    public static int ReturnIndex(int nums[], int target){
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }


    public static void Stockbest( int prices[]){
        int bp = Integer.MAX_VALUE;
        int maxProf = 0;
        for(int i = 0;i<prices.length;i++){
            bp = Math.min(prices[i], bp);
            if(bp<prices[i]){
                int profit = prices[i]-bp;
                if(profit>maxProf){
                    maxProf = profit;
                }
            }
        }
        System.out.println(maxProf);
    }



    public static void TR(int height[]){

        int n = height.length;

        // For leftMax
        int lfm[] = new int[n];
        lfm[0] = height[0];
        for(int i = 1;i<n;i++){
            lfm[i] = Math.max(lfm[i-1], height[i]);
        }

        // For RightMax
        int rtm []= new int[n];
        rtm[n-1]= height[n-1];
        for(int i = n-2;i>=0;i--){
            rtm[i]=Math.max(rtm[i+1], height[i]);
        }

        // LOOP

        int TrappedWater = 0;

        for(int i = 0;i<n;i++){
            int waterLevel = Math.min(lfm[i], rtm[i]) ;
            TrappedWater += waterLevel-height[i];
        }

        System.out.println(TrappedWater);
    }

            // ^   A R R A Y S
    // public static void main(String[] args){
        // int arrSimple[]= {1,2,3,4,5,6,1};
        // int arrSimple[]= {-2,-3,4,-1,-2,1,5,-3};
        // int arr[]={1,2,4,33,2,44,-199,5,666,3,44,2222,33,44444,55555,199999,100000000};
        // LargestNSmallest(arr);
        // int SortedArr[]= {0,4,77,123,1543,11234,1123123};
        // System.out.println(BinarySearch(SortedArr, 11234));
        // RevArray(arr);
        // PairsinArray(arrSimple);
        // maxSubarraySum(arrSimple);
        // Kadanes(arrSimple);
        
        // int height[] = {4,2,0,6,3,2,5};
        // System.out.println(TrappedRainwater(height));

        // int prices[]= {7,1,5,3,6,4};
        // System.out.println(BuyAndSellStock(prices));

        // int nums[]= {1,4,2,55,222, 22,11};
        // System.out.println(CheckDuplicate(nums));

        // int nums2[] = {2,5,9,23,29,56,89,99,258,580,899,9000};

        // System.out.println(ReturnIndex(nums2, 999999));

        // Stockbest(prices);

        // TR(height);
        // System.out.println(TrappedRainwater(height));
    // }





    // ^   S O R T I N G




    public static void BubbleSort(int arr[]){
        for(int turns = 0; turns<arr.length-1;turns++){
            for(int j = 0; j<arr.length-1-turns;j++){
                if(arr[j]>arr[j+1]){
                    int temp =  arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j]=temp;
                    
                }
            }
        }
    }
    public static void printArray(int arr[]){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }


public static void selectionSort(int arr[]){
    for(int i = 0;i<arr.length-1;i++){
        int minPos = i;
        for(int j = i+1;j<arr.length-1;j++){
            if(arr[minPos]>arr[j]){
                minPos = j;
            }
        }
        //swap
        int temp = arr[minPos];
        arr[minPos] = arr[i];
        arr[i] = temp;
    }
}

    public static void main(String args[]){
        int arr[] = { 8,3 ,5,33,43,2,11,9};
        selectionSort(arr);
        printArray(arr);
    }
}