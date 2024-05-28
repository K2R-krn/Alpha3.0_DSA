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


    public static void main(String args[]){
        
        int num[] = {2,4,6,8,10,12,14};
        int key = 10;
        System.out.println("At index : "+BinSearch(num, key));


        }
}

