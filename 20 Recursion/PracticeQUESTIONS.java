import java.util.ArrayList;

public class PracticeQUESTIONS {
    //*  Multiples of a number 
        public static void multiples(int a, int k){
        if(k==0){
            return;
        }
        multiples(a, k-1);
        System.out.print(a*k+" ");
    }

    //*  Alternate add ans dubtract 
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

    //*  maximum from an array
    public static int maxAarray(int arr[] , int idx){
        if(idx==arr.length-1){
            return arr[idx];
        }
        return Math.max(maxAarray(arr, idx+1), arr[idx]);
    }

    //* Sum of an array
    public static int sumofArray(int arr[], int i){
        if(i==arr.length){
            return 0;
        }
        return arr[i]+sumofArray(arr, i+1);
    }

    //* If an element exists or not
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
    
    public static void main(String args[]){

    }
}
