
public class dpdp {

    //* 1.  Fibonacci
    //* 1 a.  Count Ways - Stairs - Memoization - O(n)
    //* 1 b.  Count Ways - Stairs - Tabulation - O(n)

    //* 2.  0-1 Knapsack   recursion    - O(2^n)   
    //* 2 a.  0-1 Knapsack Memoization  - O( i * W )



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
        for(int i = 0;i<dp.length;i++){
            dp[i][0] = 0;
        }
        for(int j = 0;j<dp[0].length;j++){
            dp[0][j] = 0;
        }

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


    public static void main(String args[]){
        // int n = 5; 
        // int f[] = new int[n+1];
        // System.out.println(fib(n, f));

        // int n = 5;
        // int ways[] = new int[n+1];
        // System.out.println(countWaysStairsMemo(n, ways));
        // System.out.println(countWaysStairsTAB(n));
    
        int wt[] = {2,5,1,3,4};
        int val[] = {15, 14, 10, 45,30};
        int W = 7;
        // System.out.println(knapSack01(wt, val, 5, W));
    
        int dp[][] = new int[val.length+1][W+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        // System.out.println(knapSack01MEMO(wt, val, 5, W, dp));
        // System.out.println(knapSack01TABU(wt, val, W));

        

    }
}
  