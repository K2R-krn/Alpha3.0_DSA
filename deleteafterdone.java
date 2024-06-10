import java.lang.ProcessBuilder.Redirect;
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




    public static void Subarray(int nums[]){
        int MaxS = Integer.MIN_VALUE;
        int n = nums.length;
        int prefArr[]= new int[n];

        prefArr[0] = nums[0];
        for(int i = 1;i<n;i++){
            prefArr[i]= nums[i]+prefArr[i-1];
        }
        for(int i = 0; i<nums.length;i++){
            for(int j =i;j<nums.length;j++){
                int CurrS = i==0? prefArr[j] : prefArr[j]-prefArr[i-1];
                
                System.out.print(CurrS);
                if(MaxS<CurrS){
                    MaxS=CurrS;
                }
            }
        }
        System.out.println("Max Subarray sum : "+MaxS);

    }
    


    public static void kadane(int arr[]){
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        int mss = 0;
        
        if(ms<0){
            for(int i = 0;i<arr.length;i++){
                mss = Math.min(mss, arr[i]);
            }
            System.out.println("Max sub sum = "+mss);
        } else {
            for(int i = 0;i<arr.length;i++){
                cs+=arr[i];
                if(cs<0){
                    cs = 0;
                }
                ms = Math.max(ms, cs);
                System.out.println("Max subarray sum : "+ms);
            }
        }
        
    }




    public static void TrappingRainwater(int ht[]){
        int n = ht.length;


        int leftmax [] = new int[n];
        leftmax[0]=ht[0];
        for(int i = 1;i<n;i++){
            leftmax[i] = Math.max(ht[i], leftmax[i-1]);
        }

        int rightmax[] = new int[n];
        rightmax[n-1]=ht[n-1];
        for(int i = n-2;i>=0;i--){
            rightmax[i]=Math.max(ht[i], rightmax[i+1]);
        }

        int trappedwater = 0;
        for(int i = 0;i<n;i++){
            int waterlevel = Math.min(rightmax[i], leftmax[i]);
            trappedwater += waterlevel - ht[i];
        }
        System.out.println(trappedwater);
    }



    public static int BestTimeforStock(int prices[]){
        int bp = Integer.MAX_VALUE;
        int maxp = 0;

        for(int i = 0;i<prices.length;i++){
            if(bp<prices[i]){
                int profit = prices[i]-bp;
                maxp = Math.max(maxp, profit);
            }else{
                bp = prices[i];
            }
        }
        return maxp;
    }





    // ^      S O R T I N G

    // *    B U B B L E S O R T 
    public static void BubSort(int arr[]){
        int n = arr.length;
        for(int i = 0;i<=n-2;i++){
            boolean swap = false;
            for(int j = 0;j<=n-2-i;j++){
                if(arr[j]>arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap = true;
                }

            }
            if(swap==false){
                break;
            }
        }
    }

    public static void PrtArr(int arr[]){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }


    public static void SelSort(int arr[]){
        int n = arr.length;
    
        for(int i = 0;i<n-1;i++){
            int minPos = i;
            for(int j =i;j<n;j++){
                if(arr[minPos]>arr[j]){
                    minPos=j;
                }
            }
            //swap
            int temp = arr[minPos];
            arr[minPos]=arr[i];
            arr[i]=temp;
        }
    }


    public static void InsSort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int curr = arr[i];
            int prev = i-1;

            //finding correct position to insert
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            // insertion
            arr[prev+1] =curr;
        }
    }

    public static void CntSrt(int arr[]){

        // finding largest number in the arr
        int largest = Integer.MIN_VALUE;
        for(int i= 0;i<arr.length;i++){
            largest = Math.max(largest, arr[i]);
        }
 
        //creating and adding in count array
        int count[]= new int[largest+1];
        for(int i = 0;i<arr.length;i++){
            count[arr[i]]++;
        }

        //sorting
        int j = 0; // to start from 0 in original array
        for(int i = 0;i<count.length;i++){
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }

    }
    // public static void main(String args[]){
        
        // int num[] = {2,4,6,8,10,12,14};
        // int key = 10;
        // System.out.println("At index : "+BinSearch(num, key));

        // int arr[] = {4,2,0,6,3,2,5};

        // TrappingRainwater(arr);

        // System.out.println(BestTimeforStock(arr));


        // int arrs[] = {1,2,3,4,5};
        // int arr[] = {5,4,3,2,1};
        // BubSort(arrs);
        // InsSort(arr);
        
        // CntSrt(arr);
        // PrtArr(arr);

    // }




    //^     2 D   A R R A Y S

    
    public static void SpiralMatrix(int arr[][]){

        int n = arr.length;
        int m = arr[0].length;
        int sr=0 , er=n-1, sc=0, ec = m-1;
        
        while(sr<=er && sc<=ec){
            // TOP
            for(int j = sc;j<=ec;j++){
                System.out.print(arr[sr][j]+"  ");
            }

            //RIGHT
            for(int i = sr+1;i<=er;i++){
                System.out.print(arr[i][ec]+"  ");
            }

            //BOTTOM
            for(int j = ec-1;j>=sc;j--){
                System.out.print(arr[er][j]+"  ");
            }

            //LEFT
            for(int i =er-1;i>sr;i--){
                System.out.print(arr[i][sc]+"  ");
            }
            sr++;
            ec--;
            sc++;
            er--;
        }
        
    }
 
    public static void Prt2DArr(int arr[][]){
        for(int i = 0;i<arr.length;i++){
            for(int j= 0;j<arr[0].length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }


    public static int DiagnolSum(int arr[][]){

        int ts = 0;
        
        for(int i = 0;i<arr.length;i++){
            //sum of Primary Diagnol
            ts+=arr[i][i];
            //sum of Secondary Diagnol
            if(i!=arr.length-1-i){
                ts+=arr[i][arr.length-1-i];
            }
        }
        return ts;

    }



    public static boolean SearchinSortedMatrix(int arr[][], int key){
        int row=0, col = arr[0].length-1;

        while(row<arr.length && col>=0){
            if(arr[row][col]==key){
                System.out.println("Key found at : "+row+" , "+col); 
                return true;
            }
            else if(arr[row][col]>key){
                col--;
            }
            else{
                row++;
            }
        }
        System.out.println("Key not found ! ");
        return false;

    }
    // public static void main(String args[]){
        // int matrix[][] = new int[4][4];
        // Scanner sc = new Scanner(System.in );
        // int n = 4, m=4;
        // for(int i = 0;i<n;i++){
        //     for(int j= 0;j<m;j++){
        //         matrix[i][j] = sc.nextInt();
        //     }
        // }
    //     int matr[][] = {{1,2,3,4},
    //                     {5,6,7,8},
    //                     {9,10,11,12}
    //                     ,{13,14,15,16}};
    
    //     // SpiralMatrix(matr);
    //     // System.out.println(DiagnolSum(matr));
    //     SearchinSortedMatrix(matr, 10);
    // }



    //^   S T R I N G S

    public static boolean Pallindrome(String str){
        for(int i = 0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    public static void shortestPath(String str){

        int x = 0, y=0;
        for(int i = 0;i<str.length();i++){
            char dir = str.charAt(i);
            if(dir== 'N'){
                y++;
            }else if(dir=='S'){
                y--;
            }else if(dir=='W'){
                x--;
            }else if(dir=='E'){
                x++;
            }else{
                System.out.println("INVALID INPUT");
            }
        }
        int x2 = x*x;
        int y2 = y*y;
        float Shorp = (float)Math.sqrt(x2+y2);
        // float ShorP = (float)Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
        System.out.println("Shortest path = "+Shorp);
    }


    public static String toUpper(String str){

        StringBuilder sb = new StringBuilder(str.length());

     // Appends first word as no space before it so we do it manually and after this all the words will have space before them so loop forward
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i = 1;i<str.length();i++){
            if(str.charAt(i)==' ' && i<str.length()-1){ // If empty spaces and more characters forward then 
                sb.append(str.charAt(i));              // Copy empty space and 
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));// Copy other letters after converting them to uppercase
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();

    }

    
    public static String compress(String str){

        StringBuilder sb = new StringBuilder(str.length());

        for(int i = 0;i<str.length();i++){
            int count = 1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1) ){
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count>1){
                sb.append(count);
            }
        }
        return sb.toString();
    }

    // public static void main(String args[]){
        // String str = "racecar";
        // System.out.println(Pallindrome(str));

        // String dir = "WNEENESENNN";
        // shortestPath(dir);
    
        // String fruits[] = {"apple", "mango", "banana","pineapple"};
        // String largestStr = fruits[0];
        // for(int i=1;i<fruits.length;i++){
        //     if(fruits[i].compareTo(largestStr)>0){
        //         largestStr = fruits[i];
        //     }
        // }
        // System.out.println(largestStr);

        // String str = " hello WORLSD";
        // System.out.println(toUpper(str));

    //     String str = "aaabbcccdde";
    //     System.out.println(compress(str));
    // }



            //^     B I T  -   M A N I P U L A T I O N 
            
    public static void EvenorNo(int n){
        int bitMask = 1;
        if( (n & bitMask) ==0){
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }

    }

    public static int GetIthBit(int n, int i){
        int bitmask = 1<<i;
        if((n&bitmask)==0){
            return 0;
        }else{
            return 1;
        }
    }

    // EvenorNo(12);







    //   ^      O O P


    public static void rotateArr(int arr[], int n){
        int ck = 0;
        // int i = 0;
        while(ck<n){
            // if(i<=arr.length){
                int temp = arr[0];
                for(int j =0;j<arr.length-1;j++){
    
                    // int temp = arr[j-1];
                    arr[j] = arr[j+1];
                }
                arr[arr.length-1] = temp;
            // }
            ck++;
            // i++;
        }
        
    }
    public static void rotate(int[] nums) {
        // int ck = 0;
        // while(ck<k){
                int temp = nums[nums.length-1];
                for(int j =nums.length-1;j>0;j--){
                    nums[j] = nums[j-1];
                }
                nums[0] = temp;
            
            // ck++;
            
        // }
    }
    // public static void main(String args[]){
        // Pen p1 = new Pen();
        // p1.setColor("Red");
        // p1.setTip(5);
        // System.out.println(p1.color);

        // Pen p5 = new Pen();
        // p5.OwnweID="k2r";
        // p5.setName("String"); 
        // System.out.println(p5.getID());
        
        // Fish shark = new Fish();
        // shark.breathe();
        
        // int arr[] = {1,2,3,4,5};
        // // rotateArr(arr,3);
        // rotate(arr);
        // for(int i = 0;i<arr.length;i++){
        //     System.out.print(arr[i]+ " ");
        // }

//     }

// } 

class Animal{
    String color;
    void breathe(){
        System.out.println("Breathes");
    }
}
class Fish extends Animal{
    int fins;
    void swim(){
        System.out.println("Swims");
    }
}



class Pen{
    String color;
    int TipSize;
    private String OwnerName;
    public String OwnweID;

    public void setName(String name){
        OwnerName = name;
    }
    void setColor(String col){
        color = col;
    }
    void setTip(int tip){
        TipSize = tip;
    }
    String getID(){
        return OwnweID;
    }
}




public static void prtNosinDecOrder(int n){
    if(n==1){
        System.out.print(n);
        return;
    }
    System.out.print(n+" ");
    prtNosinDecOrder(n-1);


}

public static void prtNosinAESCOrder(int n){
    if(n==1){
        System.out.print(n+" ");
        return;
    }
    prtNosinAESCOrder(n-1);
    System.out.print(n+" ");
}

public static int Facto(int n){
    if(n==0){
        return 1;
    }
    // int factn-1 = Facto(n-1);
    int factn= n*Facto(n-1);
    return factn;
}

public static int SumNnos(int n){
    
    if(n==1){
        return 1;
    }
    int sum = n + SumNnos(n-1);
    return sum;

}

public static int Fibo(int n){
    if(n==0 || n==1){
        return n;
    }
    int fib = Fibo(n-1)+Fibo(n-2);
    return fib;

}

public static boolean sortedorno(int arr[], int i){
    if(i==arr.length-1){
        return true;
    }
    if(arr[i]>=arr[i+1]){
        return false;
    }

    return sortedorno(arr, i+1);
}
public static int FirstOccurance(int arr[], int i, int key){
    if(i==arr.length-1){
        return -1;
    }
    if(key==arr[i]){
        return i;
    }

    return FirstOccurance(arr, i+1, key);
}
public static int LastOccurance(int arr[], int i, int key){
    // if(n<0){
    //     return -1;
    // }
    // if(key==arr[n]){
    //     return n;
    // }
    // return LastOccurance(arr, n-1, key);

    if(i==arr.length){
        return -1;
    }
    int isFound = LastOccurance(arr, i+1, key);
    if(isFound == -1 && arr[i]==key){
        return i;
    }
    return isFound;
}

public static int powxn(int x, int n){
    if(n==1){
        return x;
    }
    int sol =x * powxn(x, n-1);
    return sol;
}
public static int powxnOPTIMZD(int x, int n){
    if(n==0){
        return 1;
    }
    int halfPow = powxnOPTIMZD(x, n/2);
    int halfPowSq = halfPow*halfPow;
    if(n%2!=0){
        halfPowSq = x*halfPowSq;
    }
    return halfPowSq;
}


public static int TilingProblem(int n){
    if(n==1 || n==0){
        return 1;
    }
    int fnm1 = TilingProblem(n-1);
    int fnm2 = TilingProblem(n-2);
    return fnm1+fnm2;
}


public static void removeSTRduplicate(String str, StringBuilder sb, int idx, boolean map[]){
    if(idx == str.length()){
        System.out.println(sb);
        return;
    }
    //kaam
    char curr = str.charAt(idx);
    if(map[curr-'a'] == true){
        //duplicate
        removeSTRduplicate(str, sb, idx+1, map);
    }else{
        map[curr-'a']=true;
        removeSTRduplicate(str, sb.append(curr), idx+1, map);
    }
}

public static int friendsPair(int n){
    if(n==1 || n==2){
        return n;
    }
    // //kaaamm
    // int fnm1 = friendsPair(n-1);
    // int fnm2 = (n-1)*friendsPair(n-2);
    // return fnm1+fnm2;
    //^ FULL CODE IN ONE LINE - 
    return friendsPair(n-1)+((n-1)*friendsPair(n-2));
}
// public static void main(String args[]){
    // prtNosinDecOrder(5);
    // prtNosinAESCOrder(5);
    // System.out.println(Facto(5));
    // System.out.println(SumNnos(5));
    // System.out.println(Fibo(25));
    // int arr[] = {1,2,3,4,5,9,2,9,1,6,9,2,3,5};
    // System.out.println(sortedorno(arr, 0));
    // System.out.print(FirstOccurance(arr, 0, 9));
    // System.out.print(LastOccurance(arr, 0, 9));    
    // System.out.println(powxn(2, 7));
    // System.out.println(powxnOPTIMZD(2, 7));
    // System.out.println(TilingProblem(4 ));
    // removeSTRduplicate("aapnnaaccollegggeeee", new StringBuilder(""), 0, new boolean[26]);
    //  System.out.println(friendsPair(10));


    // }






    //    ^     D I V I D E   A N D   C O N Q U E R !!


    // *    M E R G E    S O R T
    public static void MergeSoort(int arr[], int si, int ei){
        if(si>=ei){
            return ;
        }

        //kaam
        int mid = si+(ei-si)/2;
        MergeSoort(arr, si, mid);
        MergeSoort(arr, mid+1,ei);
        merge(arr,si,mid,ei);
    
    
    
    }
    public static void merge(int arr[], int si,int mid, int ei){
        int temp[] = new int[ei-si+1];
        int i =si; // iterator fo left part
        int j = mid+1; // iterator for right part
        int k = 0;  //iterator for temp arr

        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            
            }else{
                temp[k]=arr[j];
                j++;
                
            }
            k++;
        }
                        
        while(i<=mid){   //left part
            temp[k] = arr[i];
            k++;
            i++;
        }
        while(j<=ei){    // right part
            temp[k++] = arr[j++];
        }

        //copy temp to original arr
        for(k=0, i=si ;k<temp.length;k++,i++){
            arr[i] = temp[k];
        }


    }

    // public static void MerggeSort(int arr[],int si, int ei){

    //     if(si>=ei){
    //         return;
    //     }
    //     int mid = si+(ei-si)/2;
    //     MerggeSort(arr, si, mid);
    //     MerggeSort(arr, mid+1, ei);

    //     mergee(arr, si, mid,ei);
    // }
    // public static void mergee(int arr[],int si,int mid,int ei){
    //     int i = si;
    //     int j = mid+1;
    //     int k = 0;
    //     int temp[] = new int[ei-si+1];

    //     while(i<=mid && j<=ei){
    //         if(arr[i]<arr[j]){
    //             temp[k++]=arr[i++];
    //         }else{
    //             temp[k++]=arr[j++];
    //         }
    //     }
    //     while(i<=mid){
    //         temp[k++]=arr[i++];
    //     }
    //     while (j<=ei) {
    //         temp[k++]=arr[j++];
    //     }

    //     //copy to main arr
    //     for(k=0,i=si; k<temp.length; k++,i++){
    //         arr[i] = temp[k];
    //     }
    // }


    // *    Q U I C K    S O R T

    public static void QuickSortt(int arr[], int si, int ei){
        if(si>=ei){
            return;
        }
    
        //1st step - FIND PIVOT
        // that is last element
        int pidx =partion(arr, si, ei);
        
        QuickSortt(arr, si, pidx-1);
        QuickSortt(arr, pidx+1, ei);
    }

    public static int partion(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si-1; //iterator to make placce for elemrents smallen than pivbot

        // Elements smaller than pivot are placed on one side
        for(int j = si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j]=arr[i];
                arr[i]= temp;
            }
        }
        // Now putting pivot in right place.
        i++;
        //swap
        int temp = pivot;
        arr[ei]=arr[i];
        arr[i]= temp;
        return i;

    }

    public static void QuickSorttt(int arr[], int si, int ei){
        if(si>=ei){
            return;
        }

        //pivot
        int pidx = partionn(arr, si, ei);
        QuickSorttt(arr, si, pidx-1);
        QuickSorttt(arr, pidx+1, ei);
    }



    public static void main(String args[]){
        int arr[] = {6,3,9,5,2,8};
        // MerggeSort(arr, 0, arr.length-1);
        QuickSortt(arr, 0, arr.length-1);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }
}