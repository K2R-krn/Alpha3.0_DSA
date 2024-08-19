
public class dpdp {

    //* 1.  Fibonacci
    //* 1 a.  Count Ways - Stairs - Memoization - O(n)
    //* 1 b.  Count Ways - Stairs - Tabulation - O(n)

    //* 2.  0-1 Knapsack 


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

    public static void main(String args[]){
        // int n = 5; 
        // int f[] = new int[n+1];
        // System.out.println(fib(n, f));

        int n = 5;
        int ways[] = new int[n+1];
        System.out.println(countWaysStairsMemo(n, ways));
        System.out.println(countWaysStairsTAB(n));
    }
}
  