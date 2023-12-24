import java.util.*;

//*  Q1.  Print nos in decreasing order.
//*  Q2.  Print nos in increasing order.
//*  Q3.  Find factorial of n.
//*  Q4.  Print Sum of n natural number.
//*  Q5.  Print Nth Fibonacci Number.
//*  Q6.  If a given array is sorted or not.
//*  Q7.  Program to find and return first occurance of element of array.
//*  Q8.  "  "  "  "  "   "   "   "   LAST "       "    "      "     "   ".
//*  Q9.  CAlculate x^n .
//*  Q10. CAlculate x^n .OPTIMIZED
//*  Q11. Tiling Problem  AMAZON  
//*  Q12. Remove DUPLICATES in a String.   GOOGLE + MICROSOFT  
//*  Q13. Friends Pairing problem.   GOLDEN SACHS  


public class Recursion {

    //*  Q1
    public static void nosDec(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.print(n+" ");
        nosDec(n-1);
    }

    //*  Q2 
    public static void nosInc(int n){
        if(n==1){
            System.out.print(n+ " ");
            return ;
        }
        nosInc(n-1);
        System.out.print(n+" ");
    }

    //*  Q3 
    public static int Facto(int n){
        if(n==0){
            return 1;
        }
        int fac1 = Facto(n-1);
        int fac = n * fac1 ;
        return fac;
    }

    //*  Q4 
    public static int SumOfN(int n){
        if(n==1){
            return 1;
        }
        int sum1 = SumOfN(n-1);
        int sum = n + sum1;
        return sum;
    }

    //*  Q5 
    public static int fibbonaciNth(int n){
        if(n ==0 || n ==1){
            return n;
        }

        int fnm1= fibbonaciNth(n-1);
        int fnm2 = fibbonaciNth(n-2);
        // int fnm = fnm1 + fnm2;
        // return fnm;
         return fnm1 + fnm2;
    }

    //*  Q6 
    public static boolean isSorted(int arr[], int i){
        if(i == arr.length-1 ){
            return true;
        }
        if( arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }

    //*  Q7 
    public static int firstOccurance(int arr[], int key, int i){
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        return firstOccurance(arr, key, i+1);
    }

    //*  Q8 
    public static int lastOccurance(int arr[], int key, int i){
        if(i==arr.length){
            return -1;
        }
        int isFound = lastOccurance(arr, key, i+1);
        if(isFound == -1 && arr[i]==key){
            return i;
        }
        return isFound;
    }

    //*  Q9 
    public static int xpowern(int x, int n){
        if(n == 0){
            return 1;
        }
        // int xnm1 = xpowern(x, n-1);
        // int sol = x*xnm1;
        // return sol;
        //*  O R 

        return x * xpowern(x, n-1);
    }
    //* Q10 
    public static int xPownOptimzed(int x, int n){
        if(n == 0){
            return 1;
        }
        int halfPow = xPownOptimzed(x, n/2);
        int halfPowSq = halfPow * halfPow;

        //n is odd
        if(n%2 != 0){
            halfPowSq =x*halfPowSq;
        }
        return halfPowSq;
        }

        //*  Q11
        public static int tilingProblem(int n){ // 2 * n (floor sizr)
            //base case
            if(n==0 || n==1){
                return 1;
            }
            //kaam
                //vertical choise
                int fnm1 = tilingProblem(n-1);
                //horizontal choice
                int fnm2 = tilingProblem(n-2);
                         int totalWays = fnm1 + fnm2;
            return totalWays;
        }

        // //*  Q12
        // public static String removeDuplicates(String str){
        //     public static void removedDuplicate(String str, )
        // }

        //*  Q13 
        public static int friendsPairing(int n){
            //BC
            if(n==1 || n==2){
                return n;
            }
            // //choice
            //     //single
            //     int fnm1 = friendsPairing(n-1);

            //     //pair
            //     int fnm2 = friendsPairing(n-2);
            //     int pairWays = (n-1) * fnm2;
            // int totWays = fnm1 + pairWays;
            // return totWays;
              //&  O R

            return friendsPairing(n-1) + (n-1)* friendsPairing(n-2);       
        }

        //*  Q14 
        public static void printBinaryStrings(int n, int lastPlace, String str){
            //BC
            if(n==0){
                System.out.println(str);
                return;
            }
            //kaam
            // if(lastPlace == 0){
            //     //sit 0 on chair n
            //     printBinaryStrings(n-1, 0, str.append("0"));
            //     printBinaryStrings(n-1, 1, str.append("1"));
            // }else{
            //     printBinaryStrings(n-1, 0, str.append("0"));

            // }         //& BETTER
            //kaam
            printBinaryStrings(n-1, 0, str+"0");
            if(lastPlace == 0){
                printBinaryStrings(n-1, 1, str+"1");
            }
        }
    public static void main(String args[]){
        int n = 5;  
        int arr[] = {2,5,7,9,20,34,20};

        //  Q1  nosDec(n);
        //  Q2  nosInc(n);
        //  Q3  System.out.println(Facto(n));
        //  Q4  System.out.println(SumOfN(n));
        //  Q5  System.out.println(fibbonaciNth(23));
        //  Q6  System.out.println(isSorted(arr, 0));
        //  Q7  System.out.println(firstOccurance(arr, 20, 0));
        //  Q8  System.out.println(lastOccurance(arr, 20, 0));
        //  Q9  System.out.println(xpowern(2, 10)); 
        // Q10  System.out.println(xPownOptimzed(2, 10)); 
        // Q11  System.out.println(tilingProblem(4));
        // Q12  System.out.println(removeDuplicates(str));
        // Q13  System.out.println(friendsPairing(5));
        // Q14  printBinaryStrings(3, 0, new String(""));
    }
}