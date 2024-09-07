import java.util.*;

public class dpdp {

    //* 1.    Fibonacci
    //* 1 a.     Count Ways - Stairs - Memoization - O(n)
    //* 1 b.     Count Ways - Stairs - Tabulation - O(n)
  
    //* 2.    0-1 Knapsack   recursion      - O(2^n)   
    //* 2 a.     0-1 Knapsack Memoization   - O( i * W )
    //* 2 b.     0-1 Knapsack Tabulation    - O( i * W )
    //* 3.     Target Sum  Tabulation       - O( i * W )
    //* 4.     Unbounded Knapsack           - O( n  * W ) 
    //* 5.      Coin Change                 - O( n * sum )      // WAYS OF GIVING BACK CHANGE  // LC - CoinChange 2
    //* 6.      Rod Cutting                 - O( n * len )
    //* 7.    Longest Common Subsequence    
    //* 7 a.    Recurssion LCS              - O( 2 ^ n or m)  (whichever is smaller either n or m)
    //* 7 b.    MEMOIZATION LCS             - O( n * m ) 
    //* 7 c.    TABULATION LCS              - O( n * m ) 
    //* 8     Longest Common SubString      - O( n * m ) 
    //* 9     Longest Increasing SubString  - O( n * m ) 
    //* 10    Edit Distance                 - O( n * m ) 
    //* 11    String Conversion             - O( n * m ) ( Number of deletions and insertions )
    //* 12    WildCard Matching             - O( n * m )
    //* 13    Catlan s Number               - O( n * m )



    // *    FIBONACCI
    public static int fib(int n, int[] f){
        if(n==0 || n==1){
            return n;
        }
        if(f[n]!=0){
            return f[n];  
        }
        f[n] = fib(n-1, f) + fib(n-2, f);
        return f[n];
    }

    //* 1 a. Count Ways - Stairs - Memoization - O(n)
    public static int countWaysStairsMemo(int n, int[] ways){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }

        if(ways[n]!=0){
            return ways[n];
        }
        int ans = countWaysStairsMemo(n-1, ways) + countWaysStairsMemo(n-2,ways);
        ways[n] = ans;
        return ans;
        
    }

    //* 1 b. Count Ways - Stairs - Tabulation - O(n)
    public static int countWaysStairsTAB(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int i=1;i<=n;i++){
            if(i == 1){
                dp[i] = dp[i-1]+0;
            }else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }

    //* 2 a.  0-1 Knapsack Recursion O(2^n)
    public static int knapSack01(int[] wt, int[] val, int i, int W){
        if(W<=0 || i==0) return 0;

        if(wt[i-1]<=W){
            // include
            int ans1 = val[i-1]+knapSack01(wt, val, i-1, W-wt[i-1]);

            //exclude
            int ans2 = knapSack01(wt, val, i-1, W);
            
            return Math.max(ans1, ans2);
        }
        else{
            return knapSack01(wt, val, i-1, W);
        }
    }

        
    //* 2 a.  0-1 Knapsack Memoization O ( i * W )
    public static int knapSack01MEMO(int[] wt, int[] val, int i, int W, int[][] dp){
        if(W<=0 || i==0) return 0;

        if(dp[i][W]!=-1){
            return dp[i][W];
        }

        if(wt[i-1]<=W){
            // include
            int ans1 = val[i-1]+knapSack01MEMO(wt, val, i-1, W-wt[i-1],dp);

            //exclude
            int ans2 = knapSack01MEMO(wt, val, i-1, W,dp);
            
            dp[i][W] =  Math.max(ans1, ans2);
            return dp[i][W];
        }
        else{
            dp[i][W] = knapSack01MEMO(wt, val, i-1, W,dp);
            return dp[i][W];    
        }
    }

    //* 2 b.  0-1 Knapsack Tabulation O ( i * W )
    public static int knapSack01TABU(int[] wt, int[] val, int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i = 0,j = 0;i<dp.length && j<dp[0].length;i++,j++){
            dp[i][0] = 0;
            dp[0][j] = 0;
        }
        // for(int j = 0;j<dp[0].length;j++){
        //     dp[0][j] = 0;
        // }

        for(int i=1;i<n+1;i++){  // Represent how many items allowed
            for(int j =1;j<W+1;j++){ // Represent How many kg s allowed

                int v = val[i-1];
                int w = wt[i-1];
                
                if(w<=j){ // valid case
                   // Include profit 
                   int includeProfit = v+dp[i-1][j-w];
                   //exclude case
                   int excProfit = dp[i-1][w];
                   dp[i][j] = Math.max(includeProfit, excProfit); 
                }
                else{  // invalid case
                    int excludeP = dp[i-1][j];
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];

    }

    //* 3  .  Target Sum  Tabulation O ( i * W )
    public static boolean targetSum(int arr[], int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i = 0;i<n+1;i++){ // i is items and j is target sum
            dp[i][0] = true;   // A sum of 0 is always possible (by taking an empty subset).
        }

        // tabulation code 
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int v = arr[i-1];
                // include
                if(v<=j && dp[i-1][j-v] == true){ // v<=j checks can we add it in target sum in subset and 
                    dp[i][j] = true;
                }
                //exclude
                else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][sum];
    }

    //* 4.    Unbounded Knapsack           - O( n * W ) 
    public static int unboundedKnapsack(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<W+1;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(wt[i-1]<=j){ // Valid
                    // Include
                    dp[i][j] = Math.max(val[i-1]+dp[i][j-wt[i-1]], dp[i-1][j]); // UNBOUNDED KNAPSACK
                    // dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]); // FOR 0-1 KNAPSACH
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }


    //* 5.    Coin Change           - O( n * sum)    // WAYS OF GIVING BACK CHANGE  // LC - CoinChange 2
    public static int coinChange(int[] coins, int    sum){
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];

        for(int i=0;i<n+1;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(coins[i-1]<= j){
                    dp[i][j] = dp[i][j-coins[i-1]]+dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    // Using 1D DP array
    public static int coinChange1(int[] coins, int sum) {
        int dp[] = new int[sum + 1];
        dp[0] = 1; // Base case: there's one way to make sum 0 (by choosing no coins)
    
        // Iterate over each coin
        for (int coin : coins) {
            // Update the dp array for each amount j from coin to sum
            for (int j = coin; j <= sum; j++) {
                dp[j] += dp[j - coin]; // Include the current coin
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=coins[i];j<=amt;j++){
        //         dp[j]+=dp[j-coins[i]]; // Include current coin
        //     }
        // }
    
        return dp[sum];
    }
    
    
    

    //* 6.    Rod Cutting           - O( n * totalRod) 
    public static int rodCutting(int[] length, int[] prices, int totRod){
        int n = prices.length;
        int[][] dp = new int[n+1][totRod+1];
        
        // As automatic initialize with 0 for first row and column in java we dont do it again
        // so directly main loop is run 

        for(int i=1;i<n+1;i++){
            for(int j=1;j<totRod+1;j++){
                if(length[i-1]<= j){
                    dp[i][j] = Math.max(prices[i-1]+dp[i][j-length[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][totRod];
    
    }

    //* 7.    Longest Common Subsequence
    //* 7 a.    LCS  RECURSSION                 - O( 2 ^ n or m)  (whichever is smaller either n or m)
    public static int lcs(String str1, int n, String str2, int m){
        // BC
        if(n==0||m==0){
            return 0;
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)){ // SAME case
            return lcs(str1, n-1, str2, m-1)+1;
        }else{// diff
            int ans1 = lcs(str1, n-1, str2, m); 
            int ans2 = lcs(str1, n, str2, m-1);
            return Math.max(ans1, ans2); 
        }
    }

    //* 7 b.   LCS Rec.MEMOIZATION        - O( n * m )
    public static int lcs2memo(String str1, int n, String str2, int m, int dp[][]){
        //BC
        if(n==0 || m==0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        else if(str1.charAt(n-1)==str2.charAt(m-1)){
            return dp[n][m] = lcs2memo(str1, n-1, str2, m-1, dp)+1;
        }else{
            int ans1 = lcs2memo(str1, n-1, str2, m, dp);
            int ans2 = lcs2memo(str1, n, str2, m-1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }
    //* 7 c.   LCS TABULATION           - O ( n*m )  
    public static int lcs3tabu(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        
        int dp[][] = new int[n+1][m+1];
        
        // Initiazlize   - Not compulsory as in java DEFAULT IS 0
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j =1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
        
    }


    //* 8     Longest Common SubString      - O( n * m ) 
    public static int lcSubstring(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];
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
        return ans;
    }

    //* 9     Longest Increasing SubString  - O( n * m ) 
    public static int longestIncSubS_LIS(int arr1[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i =0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        int arr2[] = new int[set.size()]; // store sorted unioque elements
        int i=0;
        for(int num : set){
            arr2[i] = num;
            i++;
        }
        Arrays.sort(arr2); // sorted in ascending
        return lcsArr(arr1, arr2);
    }
    public static int lcsArr(int arr1[], int arr2[]){
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n+1][m+1];

        // Bottom UP
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    int ans1 = dp[i-1][j];
                    int  ans2 = dp[i][j-1];

                    dp[i][j]= Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    //* 10    Edit Distance                 - O( n * m ) 
    public static int EditDistance(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        
        // initialize
        for(int i = 0;i<n+1;i++){
            for(int j = 0;j<m+1;j++){
                if(i==0){
                    dp[i][j] = j;
                }else if(j==0){
                    dp[i][j] = i;
                }
            }
        }

        // Logic Filling the table BOTTOM UP 
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int add = dp[i][j-1]+1;
                    int delete = dp[i-1][j]+1;
                    int replace = dp[i-1][j-1]+1;
                    dp[i][j] = Math.min(add, Math.min(replace, delete));
                }   
            }
        }
        return dp[n][m];
    }

    //* 11    String Conversion             - O( n * m ) ( Number of deletions and insertions )
    public static void strConversion(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        
        int lcs = lcs3tabu(str1, str2);
        int delOp = n-lcs;
        int insOp = m-lcs;
        System.out.println(delOp);
        System.out.println(insOp);

    }

    //* 12    WildCard Matching            - O( n * m )
    public static boolean wildCard(String s, String p){

        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n+1][m+1];
        dp[0][0] = true;

        // Initialize
        for(int i = 1;i<n+1;i++){
            dp[i][0] = false;
        }
        for(int j=1;j<m+1;j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j] = dp[0][j-1];
            }
        }

        // BOTTOM UP FILLING NOW
        for(int i = 1 ;i<n+1;i++){
            for(int j = 1;j<m+1;j++){
                // C1  if ith char = jth char  and jth char = ?
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    //* 13    Catlan s Number            - O( n * m )

    // Tabu
    public static int catlanTabu(int n){
        
        int dp[] = new int[n+1];
        dp[0] =1;
        dp[1] =1;

        for(int i = 2;i<=n;i++){
            for(int j = 0;j<i;j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    
    // Memoization
    public static int catlanMemo(int n, int dp[] ){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int ans = 0; // is basically catlan of n
        for(int i = 0;i<=n-1;i++){
            ans+=catlanMemo(i,dp)*catlanMemo(n-i-1,dp);
        }
        return dp[n] = ans;
    }
    
    // BRUTE FORCE   really high tc stack overflow
    public static int catlan(int n ){
        if(n==0 || n==1){
            return 1;
        }
        int ans = 0; // is basically catlan of n
        for(int i = 0;i<=n-1;i++){
            ans+=catlan(i)*catlan(n-i-1);
        }
        return ans;
    }

    public static void main(String args[]){
        // int n = 5; 
        // int f[] = new int[n+1];
        // System.out.println(fib(n, f));

        // int n = 5;
        // int ways[] = new int[n+1];
        // System.out.println(countWaysStairsMemo(n, ways));
        // System.out.println(countWaysStairsTAB(n));
    
        // int wt[] = {2,5,1,3,4};
        // int val[] = {15, 14, 10, 45,30};
        // int W = 7;
        // System.out.println(knapSack01(wt, val, 5, W));
    
        // int dp[][] = new int[val.length+1][W+1];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // System.out.println(knapSack01MEMO(wt, val, 5, W, dp));
        // System.out.println(knapSack01TABU(wt, val, W));
        // int[] val = {15,14,10,45,30};
        // int[] wt = {2,5,1,3,4};
        // int W = 7;
        // int dp[][] = new int[val.length+1][W+1];
        // System.out.println(knapsacko1(val, wt, 5, 7, dp));
        // System.out.println(knapSack01(wt, val, 5, 7, dp));

        // int[] array = {4,2,7,1,3};
        // int ts = 10;
        // System.out.println(targetSum(array, ts));
    
        // int[] val = {15,14,10,45,30};
        // int[] wt = {2,5,1,3,4};
        // int W = 7;
        // System.out.println(unboundedKnapsack(val, wt, W));
    
        // int[] coins = {2,5,3,6};
        // int sum = 10;
        // System.out.println(coinChange(coins, sum));
        // System.out.println(coinChange1(coins, sum));
        
        //^ 6
        // int[] length = {1,2,3,4,5,6,7,8};
        // int[] prices = {1,5,8,9,10,17,17,20};
        // int rodLen = 8;
        // System.out.println(rodCutting(length, prices, rodLen));

        //^ 7
        // String str1 = "abcdge", str2 = "abedg";
        // int n=str1.length(), m=str2.length();
        // System.out.println(lcs(str1, n, str2, m));

        // int dp[][] = new int[n+1][m+1];
        // for(int i=0;i<n+1;i++){
        //     for(int j=0;j<m+1;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // System.out.println(lcs2memo(str1, n, str2, m, dp));
        // System.out.println(lcs3tabu(str1, str2));

        //^ 8
        // String str1 = "ABCDE", str2 = "ABGCE";
        // System.out.println(lcSubstring(str1, str2));
    
        //^ 9
        // int arr[] = {50, 3, 10, 7, 40, 80};
        // System.out.println(longestIncSubS_LIS(arr));

        //^ 10
        // String str1 = "intention";
        // String str2 = "execution";
        // System.out.println(EditDistance(str1, str2));

        //^ 11
        // String str1 = "abcdef";
        // String str2 = "aceg";
        // strConversion(str1, str2);
    
        //^ 12
        // String str1 = "baaabab";
        // String str2 = "*****ba*****ab";
        // System.out.println(wildCard(str1, str2));

        //^ 13
        int dp[] = new int[6];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        System.out.println(catlan(5));  
        System.out.println(catlanMemo(5, dp));  
        System.out.println(catlanTabu(5));  
    
    }
}
  