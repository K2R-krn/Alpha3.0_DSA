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

    public static void printBin(int n, String str,int lastP){
        if(n==0){
            System.out.println(str);
            return;
        }
        printBin(n-1, str+"0", 0);
        if(lastP==0){
            printBin(n-1, str+"1", 1);
        }
    }

    public static int friendsPair(int n){
        if(n==1 || n==2){
            return n;
        }
        return friendsPair(n-1)+friendsPair(n-2)*(n-2);
    }

    //*  Return places of occurances of a number in an array using Recurssion 
    public static void allOccurances(int arr[], int key,int idx){
        if(idx==arr.length){
            return;
        }
        if(arr[idx]==key){
            System.out.print(idx+" ");
        }
        allOccurances(arr, key, idx+1);
    }

    //*  Returns words name for numbers   eg. 2002 = two zero zero two  ;  Given a condition that last digit wont be zero
    public static String digits[] = {"zero","one", "two","three","four", "five","six","seven", "eight", "nine"};
    public static void printDigits(int numbers){
        if(numbers==0){
            return;
        }
        int lastDigit = numbers%10;
        printDigits(numbers/10);
        System.out.print(digits[lastDigit]+" ");
    }

    //* Write a recursive funtion to calculate length of string
    public static int lenofString(String str){
        if(str.length()==0){
            return 0;
        }

        return lenofString(str.substring(1)+1);
    }


    //*  Merge Sort
    public static void mS(int arr[], int si, int ei){
        if(si>=ei){
            return;
        }
        int mid = si+(ei-si)/2;
        mS(arr, si, mid);
        mS(arr, mid+1, ei);
        mergg(arr,si,mid,ei);
    }
    public static void mergg(int arr[], int si,int mid,int ei){
        int temp[] = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        for(k=0,i=si;k<temp.length;i++,k++){
            arr[i]=temp[k];
        }
    }


    //*   QUICK  SORT   */
    public static void qs(int[] arr, int si, int ei){
        if(si>=ei){
            return;
        }
        int pivotidx = partition(arr, si, ei);
        qs(arr, si, pivotidx-1);
        qs(arr, pivotidx+1, ei);
    }
    public static int partition(int[] arr, int si, int ei){
        int pivot = arr[ei];
        int i = si-1;
        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    //*   Search In SORTED Rotated Array
    public static int searchOnsortedRotated(int arr[], int si, int ei, int target){
        if(si>ei){
            return -1;
        }
        int mid = si+(ei-si)/2;
        if(arr[mid]==target){
            return mid;
        }

        // Now if mid is on L1
        if(arr[si]<=arr[mid]){
            // 2 cases
            if(arr[si]<=target && target<=arr[mid]){
                return searchOnsortedRotated(arr, si, mid-1, target);
            }else{
                return searchOnsortedRotated(arr, mid+1, ei, target);
            }
        }else{
            if(arr[mid]<=target && target<=arr[ei]){
                return searchOnsortedRotated(arr, mid+1, ei, target);
            }else{
                searchOnsortedRotated(arr, si, mid-1, target);
            }
        }
        return -1;
    }


    //* B A C K T R A C K I N G

    public static void changArr(int arr[], int i, int val){
        if(i==arr.length){    
            printArray(arr);
            return;
        }

        arr[i] = val;
        changArr(arr, i+1, val+1);
    
        arr[i] = arr[i]-2;
    
    }

    //*   Subsets */
    public static void findSubset(String str, int i, String ans){
        //bc
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }
        //rec
        findSubset(str, i+1, ans+str.charAt(i));
        findSubset(str, i+1, ans);
    } 

    public static void perMutations(String str, String ans){
        //bc
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        //rec
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            // "abcde"     =>   "ab" + "de" = "abde"  c removed,,  uske pehle ka taken and uske baad ka taken and combined
            String newStr = str.substring(0,i) + str.substring(i+1);
            perMutations(newStr, ans+curr);
        }
    }
    
    public static void multiples(int a, int k){
        if(k==0){
            return;
        }
        multiples(a, k-1);
        System.out.print(a*k+" ");
    }
    public static int ansans(int n){
        //bc
        if(n==0) return 0;
        //
        if(n%2==0){
            return ansans(n-1)-n;
        }else{
            return ansans(n-1)+n;
        }
    }

    public static int maxAarray(int arr[] , int idx){
        if(idx==arr.length-1){
            return arr[idx];
        }
        return Math.max(maxAarray(arr, idx+1), arr[idx]);
    }
    public static int sumofArray(int arr[], int i){
        if(i==arr.length){
            return 0;
        }
        return arr[i]+sumofArray(arr, i+1);
    }
    public static ArrayList<Integer> exist(int arr[], int i, int target,ArrayList<Integer> ans ){
        if(i==arr.length){
            return ans;
        }
        if(arr[i]==target){
            ans.add(i);
        }
        exist(arr, i+1, target,ans);
        // else{  
        //     if(exist(arr, i+1, target)==true){
        //         return true;
        //     }else{
        //         return false;
        //     }
        // }
        return ans;
    }

    // *  Remove A from a string
    // * M1
    static String removeA(String str, int i){
        if(i==str.length()){
            return "";  
        }
        String ans = removeA(str, i+1);
        char currChar = str.charAt(i);
        if(currChar!='a'){
            return currChar+ans;
        }else{
            return ans;
        }
    }
    // * m2
    static String removeA2(String str){
        if(str.length()==0){
            return "";  
        }
        String ans = removeA2(str.substring(1));
        char currChar = str.charAt(0);
        if(currChar!='a'){
            return currChar+ans;
        }else{
            return ans;
        }    
    }

    // *   REVERSE STRING 
    public static String reverseStr(String str, int i){
        if(i==str.length()){
            return "";
        }
        String smans = reverseStr(str, i+1);
        return smans+str.charAt(i);
    }
    // * Pallindrome String
    public static boolean pallindrome(String str, int i, int j){
        if(i>=j){
            return true;
        }
        return (str.charAt(i) == str.charAt(j) && pallindrome(str, i+1, j-1));
    }

    // *  Subsequences
    static void subSeq(String str, int i, String ans){
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            } else{
                System.out.println(ans);
            }
            return;
        }
        subSeq(str, i+1, ans+str.charAt(i));
        subSeq(str, i+1, ans);
    }

    // *  Sum of all subsets
    public static void sumofSubsets(int arr[], int n, int i, int currSubsetSum){

        if(i>arr.length-1){
            System.out.println(currSubsetSum);
            return;
        }

        // curr idx + sum
        sumofSubsets(arr, n, i+1, currSubsetSum+arr[i]);
        // curr sum
        sumofSubsets(arr, n, i+1, currSubsetSum);

    }




    public static int findFibo(int n){
        
        //  M  E  M  O  I  Z  A  T  I  O  N

        // if(n==0||n==1){
        //     return n;
        // }
        // if(arr[n]!=0){
        //     return arr[n];
        // }
        // arr[n] = findFibo(n-2, arr)+findFibo(n-1,arr); 
        // return arr[n];

        //  T  A  B  U  L  A  T  I  O  N
        
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];

    }


    public static int knaps01(int[] wt, int[] val, int W, int i,int dp[][]){
        if(W<=0 || i==0) return 0;
        if(dp[i][W]!=-1) return dp[i][W];
        if(wt[i-1] <= W){
            // Now 2 options we can include or not include
            int a = knaps01(wt, val, W-wt[i-1], i-1,dp)+val[i-1];
            int b = knaps01(wt, val, W, i-1,dp);
            dp[i][W] = Math.max(a, b);
            
        }
        else{
            dp[i][W] = knaps01(wt, val, W, i-1,dp);
            
        }
        return dp[i][W];
    }
    public static int knapTab(int[] wt, int[] val, int W){
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v = val[i-1];
                int w = wt[i-1];
                if(w<=j){
                    int excludeProfit = v+dp[i-1][j-w];
                    int includeProf = dp[i-1][w];
                    dp[i][j] = Math.max(excludeProfit, includeProf);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }



    public static int knapsack01T(int wt[], int val[], int W){

        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        // Initialize it and give it a meaning
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;            
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = 0;
        }

        // Start filling it bottum up  // Small problem first and then going to biffer problem
        for(int i=1 ; i<dp.length;i++){
            for(int j=1 ; j<dp[0].length;j++){
                int v = val[i-1];
                int w = wt[i-1];
                if(w<=j){
                    int incP = v+dp[i-1][j-w];
                    int excP = dp[i-1][j];
                    dp[i][j] = Math.max(incP, excP);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }


    public static boolean targetSum(int arr[], int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        for(int i = 0;i<n+1;i++){
            dp[i][0] = true;
        }

        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<sum+1;j++){
                int v = arr[i-1];               
                // Check valid condition first
                if(arr[i-1]<=j && dp[i-1][j-v]==true){
                    dp[i][j] = true;
                }else if(dp[i-1][j]==true){
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][sum];
    }


    public static int lcsTabu(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static int lcSubstr(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1]  ;

        int ans = 0;

        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    ans = Math.max(ans, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(dp[n][m]);
        return ans;
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

        // String str = "kkaaransssinnhnhh";
        // removeDup(str, 0, new StringBuilder(""), new boolean[26]);
        
        // printBin(3, new String(""), 0);
        // System.out.println(friendsPair(4));
        // int arr[] = {1,4,2,3,1,3,2,4,2,3,3,3,45,4,2,3,4,5};
        // allOccurances(arr, 3, 0);
        // printDigits(2002);

        // int arr[] = {1,4,8,2,7,5,6,3,9};
        // mS(arr, 0, 8);
        // qs(arr, 0, 8);
        // printArray(arr);

        // int arr[] = {4,5,6,7,0,1,2,3};
        // System.out.println(searchOnsortedRotated(arr, 0, 7, 2));


        // int arr[] = new int[5];
        // changArr(arr,0,1);
        // printArray(arr);

        // findSubset("ab", 0, "");

        // perMutations("abc", "");
        // multiples(5, 4);
        // System.out.println(ansans(5));
        // int arr[] = {1,4,84,6,9,77, 84,3,5,84};
        // System.out.println(maxAarray(arr, 0));
        // System.out.println(sumofArray(arr, 0));
        // System.out.println(exist(arr, 0, 84));
        
        // ArrayList<Integer> ans = new ArrayList<>();
        // exist(arr, 0, 84,ans);
        // for(int i=0;i<ans.size();i++){
        //     System.out.print(ans.get(i)+" ");
        // }

        // String str = new String("Karansinh Rathod");
        // System.out.println(removeA2(str));
        // System.out.println(reverseStr(str,0));

        // String str = new String("LEVEL");
        // System.out.println(pallindrome(str, 0, str.length()-1));

        // String str = new String("abc");
        // String ans = new String("");
        // subSeq(str, 0, ans);

        // int arr[] = {2,4,5};
        // sumofSubsets(arr, 3, 0, 0);

        // int[] arr = new int[100];
        // System.out.println(findFibo(9));

        int wt[] = {2,5,1,3,4};
        int val[] = {15,14,10,45,30};
        int W = 7;
        // int[][] dp = new int[val.length + 1][W + 1]; // Correct size of dp table
        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }
        // System.out.println(knaps01(wt,val ,W,wt.length, dp));
        // System.out.println(knapTab(wt,val ,W));

        // System.out.println(knapsack01T(wt, val, W));
        
        int arr[] = {4,2,7,3};
        int n = 10;
        // System.out.println(targetSum(arr, n));
        
        String str1 = "abcde";
        String str2 = "abce";
        // System.out.println(lcsTabu(str1,str2));
        System.out.println(lcSubstr(str1,str2));
    }
}
