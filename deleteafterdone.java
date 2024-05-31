import java.util.Scanner;

public class deleteafterdone {

    public static void star(int n){
        for(int i = 0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static int binToDec(int n){
        int pow =0;
        int sum = 0;
        while(n>0){
            int lastNum = n%10;
            sum+=lastNum*(int)Math.pow(2, pow);
            n = n/10;
            pow++;
        }
        return sum;
        
    }

    public static int DecToBin(int n){
        int sum = 0;
        int pow = 0;
        while(n>0){
            int rem = n%2;
            
            sum+=rem*Math.pow(10, pow);
            pow++;
            n=n/2;
        }
        return sum;
    }










    public static int BinSearch(int num[], int key ){
        int n = num.length;

        int start = 0;
        int end = n-1;
        

        while(start<=end){
            int mid = (start+end)/2;

            if(num[mid]==key){
                return mid;
            }else if(num[mid]>key){
                end=mid-1;
            }else if(num[mid]<key){
                start = mid+1;
            }
        }
        return -1;   
    }




    public static void Subarray(int nums[]){
        int MaxS = Integer.MIN_VALUE;
        int n = nums.length;
        int prefArr[]= new int[n];

        prefArr[0] = nums[0];
        for(int i = 1;i<n;i++){
            prefArr[i]= nums[i]+prefArr[i-1];
        }
        for(int i = 0; i<nums.length;i++){
            for(int j =i;j<nums.length;j++){
                int CurrS = i==0? prefArr[j] : prefArr[j]-prefArr[i-1];
                
                System.out.print(CurrS);
                if(MaxS<CurrS){
                    MaxS=CurrS;
                }
            }
        }
        System.out.println("Max Subarray sum : "+MaxS);

    }
    


    public static void kadane(int arr[]){
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        int mss = 0;
        
        if(ms<0){
            for(int i = 0;i<arr.length;i++){
                mss = Math.min(mss, arr[i]);
            }
            System.out.println("Max sub sum = "+mss);
        } else {
            for(int i = 0;i<arr.length;i++){
                cs+=arr[i];
                if(cs<0){
                    cs = 0;
                }
                ms = Math.max(ms, cs);
                System.out.println("Max subarray sum : "+ms);
            }
        }
        
    }




    public static void TrappingRainwater(int ht[]){
        int n = ht.length;


        int leftmax [] = new int[n];
        leftmax[0]=ht[0];
        for(int i = 1;i<n;i++){
            leftmax[i] = Math.max(ht[i], leftmax[i-1]);
        }

        int rightmax[] = new int[n];
        rightmax[n-1]=ht[n-1];
        for(int i = n-2;i>=0;i--){
            rightmax[i]=Math.max(ht[i], rightmax[i+1]);
        }

        int trappedwater = 0;
        for(int i = 0;i<n;i++){
            int waterlevel = Math.min(rightmax[i], leftmax[i]);
            trappedwater += waterlevel - ht[i];
        }
        System.out.println(trappedwater);
    }



    public static int BestTimeforStock(int prices[]){
        int bp = Integer.MAX_VALUE;
        int maxp = 0;

        for(int i = 0;i<prices.length;i++){
            if(bp<prices[i]){
                int profit = prices[i]-bp;
                maxp = Math.max(maxp, profit);
            }else{
                bp = prices[i];
            }
        }
        return maxp;
    }





    // ^      S O R T I N G

    // *    B U B B L E S O R T 
    public static void BubSort(int arr[]){
        int n = arr.length;
        for(int i = 0;i<=n-2;i++){
            boolean swap = false;
            for(int j = 0;j<=n-2-i;j++){
                if(arr[j]>arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap = true;
                }

            }
            if(swap==false){
                break;
            }
        }
    }

    public static void PrtArr(int arr[]){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }


    public static void SelSort(int arr[]){
        int n = arr.length;
    
        for(int i = 0;i<n-1;i++){
            int minPos = i;
            for(int j =i;j<n;j++){
                if(arr[minPos]>arr[j]){
                    minPos=j;
                }
            }
            //swap
            int temp = arr[minPos];
            arr[minPos]=arr[i];
            arr[i]=temp;
        }
    }


    public static void InsSort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int curr = arr[i];
            int prev = i-1;

            //finding correct position to insert
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            // insertion
            arr[prev+1] =curr;
        }
    }

    public static void CntSrt(int arr[]){

        // finding largest number in the arr
        int largest = Integer.MIN_VALUE;
        for(int i= 0;i<arr.length;i++){
            largest = Math.max(largest, arr[i]);
        }
 
        //creating and adding in count array
        int count[]= new int[largest+1];
        for(int i = 0;i<arr.length;i++){
            count[arr[i]]++;
        }

        //sorting
        int j = 0; // to start from 0 in original array
        for(int i = 0;i<count.length;i++){
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }

    }
    // public static void main(String args[]){
        
        // int num[] = {2,4,6,8,10,12,14};
        // int key = 10;
        // System.out.println("At index : "+BinSearch(num, key));

        // int arr[] = {4,2,0,6,3,2,5};

        // TrappingRainwater(arr);

        // System.out.println(BestTimeforStock(arr));


        // int arrs[] = {1,2,3,4,5};
        // int arr[] = {5,4,3,2,1};
        // BubSort(arrs);
        // InsSort(arr);
        
        // CntSrt(arr);
        // PrtArr(arr);

    // }




    //^     2 D   A R R A Y S

    

    public static void main(String args[]){




    }
} 