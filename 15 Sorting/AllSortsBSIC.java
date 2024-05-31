import java.util.*;                //todO     1.BUBBLE SORT   2.SELECTION SORT   3.INSERTION SORT   4.INBUILT SORT   5.COUNTING SORT
public class AllSortsBSIC {
    
    //^  B U B B L E    S O R T
    public static void BubbleSort(int num[]){
        for(int i =0; i<num.length; i++){
            for(int j = 0;j<num.length-1-i; j++){
                if(num[j]>num[j+1]){
                    //Swap
                    int temp = num[j];
                    num[j]= num[j+1];
                    num[j+1]= temp;
                }
            }
        }       
    }

     //* Optimized     B U B B L E    S O R T 
    public static void BubbleSortOptmzd(int num[]){
        for(int i =0; i<num.length; i++){
            boolean swapped = false;
            for(int j = 0;j<num.length-1-i; j++){
                if(num[j]>num[j+1]){
                    //Swap
                    int temp = num[j];
                    num[j]= num[j+1];
                    num[j+1]= temp;
                    swapped = true;
                }
            }
            if(swapped == false){
                break;
            }
        }    
    }

    //^  S E L E C T I O N   S O R T
    public static void SelectionSort(int num[]){
        for(int i = 0; i<num.length-1;i++){
            int minPos = i;
            for(int j = i+1; j<num.length; j++){
                if(num[minPos]>num[j]){
                    minPos = j;
                }
            }
            // swap
            int temp = num[minPos];
            num[minPos]= num[i];
            num[i]= temp;
        }
    }
   

    //^  I N S E R T I O N   S O R T
    public static void InsertionSort(int num[]){
        for(int i = 1; i<num.length;i++){
            int curr = num[i];
            int prev = i-1;
            // Finding Out the corerct pos to insert
            while(prev>=0 && num[prev]>curr){
                num[prev+1]=num[prev];
                prev--;
            }
            // Insertion
            num[prev+1] = curr;
        }
    }

    //^  C O U N T   S O R T
    public static void CountSort(int num[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<num.length;i++){
            largest = Math.max(largest,num[i]);
        }
        int count[] = new int [largest+1];
        for(int i = 0;i<num.length;i++){
            count[num[i]]++;
        }
        //sorting
        int j = 0;
        for(int i = 0;i<count.length;i++){
            while(count[i] > 0){
                num[j] = i;
                j++;
                count[i]--;
            }
        }
    }
    
    //^  P R I N T    A R R A Y
    public static void PA(int num[]){
        for (int i = 0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
    }
    public static void main(String args[]){
        int num[] = {2,6,4,5,1,3,8,10,7,9};

        // BubbleSort(num);
        // SelectionSort(num);
        // InsertionSort(num);
        //Arrays.sort(num);
        //Arrays.sort(num,0,7);
        //Arrays.sort(num, Collections.reverseOrder());      //*Only work with Object type Variable so we need to use*/ " Integer "  in place of " int "  
        //CountSort(num);
        BubbleSortOptmzd(num );
        PA(num);
    }
}
 