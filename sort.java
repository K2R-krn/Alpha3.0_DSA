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
        if(n==1 || n==0){
            return n;
        }
        int ans = fibo(n-1)+fibo(n-2);
        return ans;
    }


    public static boolean sortedArr(int arr[], int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return sortedArr(arr, i+1);
    }
    public static int lastOccurance(int arr[], int key,int i){
        // int i=0;
        if(i==arr.length-1){
            return -1;
        }
        int isFound = lastOccurance(arr, key, i+1);
        if(isFound==-1 && arr[i]==key){
            return i;
            
        }
        return isFound;
    }

    public static int xpown(int x, int n){
        if(n==0){
            return 1;
        }
        int halfp = xpown(x, n/2);
        int halfPowSq = halfp*halfp;
        if(n%2!=0){
            halfPowSq = halfPowSq*x;
        }
        return halfPowSq;
    }


    public static void spiralMatrix(int arr[][]){
        int sR = 0;
        int sC = 0;
        int eR = arr.length-1;
        int eC = arr[0].length-1;

        while(sC<=eC && sR<=eR){
            // Top print
            for(int i=sC;i<=eC;i++){
                System.out.print(arr[sR][i]+" ");
            }
            //Right
            for(int i=sR+1;i<=eR;i++){
                System.out.print(arr[i][eC]+" ");
            }
            //Bottom
            for(int i=eC-1;i>=sC;i--){
                if(sR==eR){
                    break;
                }
                System.out.print(arr[eR][i]+" ");
            }
            //Left
            for(int i=eR-1;i>sR;i--){
                if(sC==eC ){
                    break;
                }
                System.out.print(arr[i][sC]+" ");
            }
            sR++;
            sC++;
            eR--;
            eC--;
        }



        
    }
    public static int diagSum(int arr[][]){
        int n = arr.length;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i][i];
            sum+=arr[i][n-i-1];
        }
        if(arr.length%2==0){
            return sum;
        }else{
            return (sum - arr[arr.length/2][arr.length/2]);
        }
        // return sum;
        
    }


    public static void stairCaseSearch(int arr[][], int key){
        int i=0, j=arr[0].length-1;
        while(i<arr.length && j>=0){
            if(arr[i][j]==key){
                System.out.println("Key found at : "+i+" , "+j);
                break;
            }else if(key<arr[i][j]){
                j--;
            }else{
                i++;
            }
        }
        System.out.println("Key not found.");
    }

    //  Merge OverLapping Interval
    public static int[][] mergeIinterval(int arr[][]){
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>(); 
        int prev[] = arr[0];

        for(int i=1;i<arr.length;i++){
            int[] interval = arr[i];
            if(interval[0]<=prev[1]){
                prev[1] = Math.max(prev[1], interval[1]);
            }else{
                merged.add(prev);
                prev = interval;
            }
        }
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }

    public static void combine2arrsort(int nums1[], int n, int nums2[], int m){
        int ans[] = new int[m+n];
        int i=0;
        int j=0;
        int k=0;
        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                ans[k]=nums1[i];
                i++;
                
            }else{
                ans[k]=nums2[j];
                j++;
            }
            k++;
        }
        while(i<n){
            ans[k]=nums1[i];
            i++;
            k++;
        }
        while(j<m){
            ans[k]=nums2[j];
            k++;
            j++;
        }
        printArray(ans);
        return;
    }

    public static int sqqopt(int x,int n){
        if(n==0){
            return 1;
        }

        int halfp = sqqopt(x, n/2);
        int halfPow = halfp*halfp;

        if(n%2!=0){
            halfPow=halfPow*x;
        }
        
        return halfPow;
    }


    public static int totalWaysTILING(int n){
        if(n==0||n==1){
            return 1;
        }
        int fnm1 = totalWaysTILING(n-1);
        int fnm2 = totalWaysTILING(n-2);
        return fnm1+fnm2;
    }

    public static void removeDup(String str, int idx, StringBuilder ans, boolean map[]){

        if(idx==str.length()){
            System.out.print(ans);
            return;
        }

        char currChar = str.charAt(idx);
        if(map[currChar-'a']==true){
            // means its duplicate
            removeDup(str, idx+1, ans, map);
        }else{
            map[currChar-'a']=true;
            removeDup(str, idx+1, ans.append(currChar), map);
        }
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
        //  System.out.print(fibo(3));
        // int arr[] = {1,2,3,8,2,4,5,8,6};
        // System.out.println(sortedArr(arr, 0));
        // System.out.println(lastOccurance(arr, 8, 0));
        // System.out.println(xpown(2, 4));

        // int arr[][] = {{1,2,3,0,1},{4,5,6,0,1},{7,8,9,0,1},{10,11,12,0,1},{13,14,15,16,1}};
        // spiralMatrix(arr);
        // System.out.println(diagSum(arr));
        // stairCaseSearch(arr, 1);
        // System.out.println(arr[0]);

        // int nums1[] = {1,3,5,7,9};
        // int nums2[] = {0,2,4,6,8};
        // combine2arrsort(nums1, 5, nums2, 5); 
        
        // System.out.println(sqqopt(2, 5));

        // System.out.println(totalWaysTILING(4));

        String str = "kkaaransssinnhnhh";
        removeDup(str, 0, new StringBuilder(""), new boolean[26]);
    }
}
