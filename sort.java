import java.util.*;
public class sort {
    
    public static void bubbleSort(int arr[]){
        for(int j=0;j<arr.length;j++){
            int swapped = 0;
            for(int i=0;i<arr.length-1-j;i++){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped = 1;
                }
            }
            if(swapped == 1){
                
            }
        }
    }

    public static void selectionSort(int arr[]){
        for(int i = 0;i<arr.length;i++){
            int minPos = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minPos]>arr[j]){
                    minPos = j;
                }
            }
            // SWAP CODE
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
    }
    
    public static void merge(int arr[], int si, int mid , int ei){
        int temp[] = new int[ei-si+1];
        int i = si;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=ei){
            temp[k++] = arr[j++];
        }
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i] = temp[k];
        }
    }
    public static void mergeSort(int arr[], int si, int ei){
        if(si>=ei){
            return;
        }
        int mid = si+(ei-si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1,ei);
        merge(arr, si, mid, ei);
    }



    public static void printArray(int arr[]){
        for(int i:arr){
            System.out.print(i+" ");
        } 
    }




    public static int prefix(int arr[]){
        int prefArr[] = new int[arr.length];
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        prefArr[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefArr[i]=prefArr[i-1]+arr[i];
        }
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                currSum = 0;
                currSum = i ==0? prefArr[j] : prefArr[j]-prefArr[i-1];

                maxSum= Math.max(maxSum, currSum);
            }
        }
        return maxSum;

    }

    public static void KadanesAlgo(int arr[]){
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for(int i=0;i<arr.length;i++){
            cs+=arr[i];
            ms = Math.max(cs, ms);
            if(cs<0){
                cs = 0;
            }
        }
        System.out.println(ms);
    }





    public static boolean isPallindrome(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    public String reverseWords(String s) {
        String words[] = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();

        for(int i=words.length-1;i>=0;i--){
            ans.append(words[i]);
            if(i!=0){
                ans.append(" ");
            }
        }
        return ans.toString();
    }






    // R E C U R S I O N
    public static void printInc(int n){
        if(n == 1){
            System.out.print(1+" ");
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");
        
    }
    public static int facto(int n){
        if(n==0){
            return 1;
        }
        int fnm1 = facto(n-1);
        int fac = n*fnm1;
        return fac;
    }
    public static int sumofNnos(int n){
        if(n==1){
            return 1;

        }
        int sum1 = sumofNnos(n-1);
        int sum = sum1+n;
        return sum;
    }
    public static int fibo(int n){
        if(n==0||n==1){
            return n;
        }
        int fibo1 = fibo(n-1);
        int fibo2 = fibo(n-2);
        int fibo = fibo1+fibo2;
        return fibo;
    }


    public static void main(String args[]){
        // int arr[] = {2,4,6,-2,33,-25};
        // int arr[] = {6,3,9,5,2,8};
        // bubbleSort(arr);
        // selectionSort(arr);
        
        // mergeSort(arr, 0, arr.length-1);                                     
        // printArray(arr);
        // System.out.println(prefix(arr));
        // KadanesAlgo(arr);
        

        //  STRINGS   -  I M M U T A B L E


        // char arr[] = {'a', 'b', 'c'};
        // String str1;
        // Scanner sc = new Scanner(System.in);
        // str1 = sc.nextLine();
        // System.out.println(str1);
        // String str1 = "krirk";
        // System.out.println(isPallindrome(str1));
        // reverseWords(s);
        
        // printInc(10);
        // System.out.print(facto(10));
         System.out.print(fibo(8));
    
    }
}
