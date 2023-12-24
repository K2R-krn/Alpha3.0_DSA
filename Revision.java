import java.util.*;

public class Revision {
    //public static void main(String args[]){

        //Scanner sc = new Scanner(System.in);

                    //AVERAGE OF 3 NOS
        // Scanner sc = new Scanner(System.in);
        
        // System.out.print("Enter First Number : ");
        // int a = sc.nextInt();
        
        // System.out.print("Enter Second Number : ");
        // int b = sc.nextInt();
        
        // System.out.print("Enter Third Number : ");
        // int c = sc.nextInt();
        
        // int av = (a+b+c)/3;
        // System.out.print("Average of 3 nos : "+av);
        

                                                    //GREATEST OF 3 NOS
                                            // Scanner sc = new Scanner(System.in);
                                            // System.out.print("Enter First Number : ");
                                            // int A = sc.nextInt();
                                            // System.out.print("Enter Second Number : ");
                                            // int B = sc.nextInt();
                                            // System.out.print("Enter Third Number : ");
                                            // int C = sc.nextInt();

                                            // if((A>=B) && (A>=C)){
                                            //     System.out.println("A is Largest");
                                            // }
                                            // else if(B>=C){
                                            //     System.out.println("B is Largest");
                                            // }
                                            // else{
                                            //     System.out.println("C is Largest");
                                            // }



        //   CALCULATOR
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter a number : ");
        // int inp1 = sc.nextInt();
        // System.out.print("Enter another number : ");
        // int inp2 = sc.nextInt();
        // System.out.print("Enter a character : ");
        // char op = sc.next().charAt(0);                                                                                                                                                                              
        // switch(op){
        //     case'A' : System.out.println("Sum of 2 nos is : "+(inp1+inp2));
        //                 break;
        //     case'S' : System.out.println("Difference of 2 nos is : "+(inp1-inp2));
        //                 break;
        //     case'M' : System.out.println("Product of 2 nos is : "+(inp1*inp2));
        //                 break;
        //     case'D' : System.out.println("Division of 2 nos is : "+(inp1/inp2));
        //                 break;
        //     default : System.out.println("Enter a valid operation character.");
        // }
 
                                                        ////Positive or negetive
                                                        //Scanner sc = new Scanner(System.in);
                                                        //System.out.println("Enter a number : ");
                                                        //char a = sc.next().charAt(0);
                                                        //if(a =='-'){
                                                        //    System.out.println("Number is Negetive.");
                                                        //}
                                                        //else{System.out.println("Number is Positive");}   
        

// ***********************************************************************************************************************************************//
        
        //LOOPS

            // SUM OF FIRST N NATURAL NUMBERS

    //     System.out.print("Enter a number n : ");
    //     int n = sc.nextInt();
    //     int sum = 0;
    //    while(n>=0){
    //     sum=sum+n;
    //     n--;
    //    }
    //    System.out.println("Sum is : "+sum);


                                                         //     //REVERSE of a number
                                                         // System.out.println("Enter a numebr : ");
                                                         // int n = sc.nextInt();
                                                         // int b = 0;
                                                         // while(n > 0){
                                                         //     int c = (n%10);
                                                         //     b = (b*10)+c;
                                                         //     n = n/10;
                                                         // }
                                                         // System.out.println(b);


        // DISPLAY ALL NUMBERS EXCEPT MULTIPLES OF 10                                                   
        // do{
        //     int a = sc.nextInt();
        //     if(a%10 == 0){
        //         continue;
        //     }
        //     System.out.println(a);
        // }while(true);
        

                                                // // Prime or not
                                                // System.out.print("Enter a number : ");
                                                // int n = sc.nextInt();
                                                
                                                //     if(n==2 || n==1){
                                                //         System.out.println("Number is Prime.");
                                                //     }
                                                //     else{
                                                //         boolean isPrime= true;
                                                //         for(int i=2; i<=Math.sqrt(n);i++){                   
                                                //             if(n%i==0){
                                                //                 isPrime=false;
                                                //             }  
                                                //         }
                                                //         if(isPrime==false){
                                                //             System.out.println("Number is NOT Prime");
                                                //         }
                                                //         else{
                                                //         System.out.println("Number is PRIME.");
                                                //         }
                                                //     }
                                                    
        // SUM OF EVEN AND ODD INTEGERS
        // int res;
        // int Esum = 0;
        // int Osum = 0;
        // do{
        // System.out.print("Enter a number : ");
        // int a = sc.nextInt();
        // if(a%2==0){
        //     Esum+=a;
        // }else{
        //     Osum+=a;
        // }
        // System.out.println("Enter 1 to continue or 2 to stop.");
        // res = sc.nextInt();
        // }
        // while(res == 1);
        // System.out.println("Sum of Even nos : "+Esum);
        // System.out.println("Sum of Odd nos : "+Osum);


                                            // // Multiplication table
                                            // System.out.print("Enter a number whose multiplication table is needed: ");
                                            // int a = sc.nextInt();
                                            // System.out.print("Enter a number TILL WHERE multiplication table is needed: ");
                                            // int n = sc.nextInt();   

                                            // for(int i = 1;i<=n;i++){
                                            //     int m = a*i;
                                            //     System.out.println(a+" x "+i+" = "+m+" ");
                                            // }

// ***********************************************************************************************************************************************//

        //NESTED LOOPS

        //  STAR PATTERN
        // System.out.print("Enter number of lines : ");
        // int a = sc.nextInt();
        // for(int i = 1; i <= a;i++){
        //     for(int j=1; j<=i;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println("");
        // }

                                                        // Inverted Star pattern
                                                        // System.out.print("Enter number of lines : ");
                                                        // int a = sc.nextInt();
                                                        // for(int i = a;i>=1;i--){
                                                        //     for(int j =i;j>=1;j--){
                                                        //         System.out.print("*");
                                                        //     }
                                                        //     System.out.println("");
                                                        // }
        
        //HALF PYRAMID
        // int a = 4;
        // for (int i=1;i<=a;i++){
        //     for(int j=1;j<=i;j++){
        //             System.out.print(j);
        //         }     
        //     System.out.println("");
        // }

                                                                  // Character Pyramid Incremeting
                                                                //   char ch = '/';
                                                                //   int n = 5;
                                                                //   for(int i = 1;i<=n;i++){
                                                                //     for(int j = 1;j<=i;j++){
                                                                //         System.out.print(ch);
                                                                //         ch++;
                                                                //     }
                                                                //     System.out.println("");
                                                                //   }  

// ***********************************************************************************************************************************************//

        // FUNCTIONS AND METHODS

        //FACTORIAL
        public static int Factorial(int a){
            int prod = 1;
            for(int i=1;i<=a;i++){
                prod = prod*i;
            }return prod ;
        }
        
                                                        // Prime Number
                                                        public static boolean Prime(int a){
                                                            if(a==2){
                                                                return true;
                                                            }
                                                            for(int i=2;i<=Math.sqrt(a);i++){
                                                                if(a%i==0){
                                                                    return false;
                                                                }
                                                            }
                                                            return true;
                                                        }

       
        // Primes in Range.
        public static void PrimesInRange(int a){
            for(int i=2;i<=a;i++){
                if(Prime(i)==true){
                    System.out.print(i+" ");
                }
            }
        }

        // Sum of Digits in an integer.
        public static int Sum(int a){
            int sum = 0;
            do{
                int p = a%10;
                sum+=p;
                a = a/10;
            }
            while(a>0);
            return sum;
        }

                                                        //Pallindrome
                                                        public static void Pallindrome(int a){
                                                            int p = a;
                                                            int s = 0;
                                                            while(p>0){
                                                                int q = p%10;
                                                                s = s*10+ q;
                                                                p=p/10;
                                                            }
                                                            if(a==s){
                                                                System.out.println("Numebr is pallindrome.");
                                                            }    
                                                        }

        //Binary to Decimals
        public static void BinToDecimal(int a){
            int dec = 0;
            int p = 0;
            while(a>0){
                int l = a%10;
                dec= dec +(l * (int)Math.pow(2, p));
                p++;
                a= a/10;
            }
            System.out.println("Decimal of binary number "+a+" is :"+dec);
            }
        
        // Decimal to Binary
            public static void DecToBinary(int a){
                int pow = 0;
                int BinNum = 0;
                while(a>0){
                    int rem = a%2;
                    BinNum = BinNum+(rem*(int)Math.pow(10, pow));
                    a=a/2;
                    pow++;
                }System.out.println(BinNum);
            }

        //public static void main(String args[]){
            // int a =Factorial(5);
            // System.out.println(a);
            // System.out.println(Prime(a));
            // PrimesInRange(a);
            // System.out.print(Sum(a));
            // Pallindrome(a);
            //BinToDecimal(a);
            //DecToBinary(a);
        //}
        
// ***********************************************************************************************************************************************//

        // ^  A D V A N C E D    P A T T E R N S   

        //^  Hollow Rectangle
        public static void HollowRect(int totRows,int totCols){
            for(int i=1;i<=totRows;i++){
                for(int j=1;j<=totCols;j++){
                    if(i==1 ||i==totRows || j==1|| j==totCols ){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }System.out.println("");
            }
        }

                                                            //^  Inverted and Rotated Half Pyramid
                                                            public static void InvertedNDRotatedHalfPyramid(int a){
                                                                for(int i=1;i<=a;i++){
                                                                    for(int j=1;j<=a-i;j++){     // For SPACES
                                                                        System.out.print(" ");
                                                                    }for(int j =1;j<=i;j++){     // For STARS
                                                                        System.out.print("*");
                                                                    }System.out.println();
                                                                }
                                                            }
        
            // ^ Inverted Half Pyramid with Numbers
            public static void InvHalfPyramidNOS(int a){
                for(int i=1;i<=a;i++){
                    int c = 1;
                    for(int j=1;j<=a-i+1;j++){
                        System.out.print(c);
                        c++;
                    }System.out.println();
                }
            }
            

                                                                    //^  Floyd's Triangle
                                                                    public static void FloydsTriangle(int a){
                                                                        int c=1;
                                                                        for(int i=1;i<=a;i++){
                                                                            for(int j=1;j<=i;j++){
                                                                                System.out.print(c);
                                                                                c++;
                                                                            }System.out.println();
                                                                        }
                                                                    }


            //^  0-1 Triangle
            public static void Triangle01(int a){
                for(int i=1;i<=a;i++){
                    for(int j=1;j<=i;j++){
                        if((i+j)%2==0){
                            System.out.print("1");
                        }
                        else{
                            System.out.print("0");
                        }
                    }System.out.println();
                }
            }


                                                        //^  Butterfly Pattern
                                                        public static void ButterflY(int a){
                                                            for(int i=1;i<=a;i++){
                                                                for(int j=1;j<=i;j++){             //STARS
                                                                    System.out.print("*");
                                                                }
                                                                for(int j=1;j<=2*(a-i);j++){       //SPACES
                                                                    System.out.print(" ");
                                                                }
                                                                for(int j=1;j<=i;j++){             //STARS
                                                                    System.out.print("*");
                                                                }System.out.println();
                                                            }
                                                            for(int i=a;i>=1;i--){
                                                                for(int j=1;j<=i;j++){             //STARS
                                                                    System.out.print("*");
                                                                }
                                                                for(int j=1;j<=2*(a-i);j++){       //SPACES
                                                                    System.out.print(" ");
                                                                }
                                                                for(int j=1;j<=i;j++){             //STARS
                                                                    System.out.print("*");
                                                                }System.out.println();
                                                            }
                                                        }

            // ^ S O L I D    R H O M B U S
            public static void RhombusSolid(int a){
                for(int i=1;i<=a;i++){
                    for(int j=(a-i);j>=1;j--){
                        System.out.print(" ");
                    }
                    for(int j=1;j<=a;j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
            }


                                                            // ^ H O L L O W   R H O M B U S 
                                                            public static void RhombusHollow(int a){
                                                                for(int i=1;i<=a;i++){
                                                                    for(int j=(a-i);j>=1;j--){
                                                                        System.out.print(" ");
                                                                    }
                                                                    for(int j=1;j<=a;j++){
                                                                        if(i==1||j==1||i==a||j==a){
                                                                            System.out.print("*");
                                                                        }
                                                                        else{
                                                                            System.out.print(" ");
                                                                        }
                                                                    }System.out.println();
                                                                }
                                                            } 
                
        // ^  Diamond Pattern
        public static void Diamond(int a){
            // F I R S T     H A L F
            for(int i=1;i<=a;i++){
                for(int j=1;j<=a-i;j++){
                    System.out.print(" ");
                }
                for(int j=1;j<=(2*i)-1;j++){
                    System.out.print("*");
                }System.out.println();
            }
            // S E C O N D   H A L F
            for(int i=a;i>=1;i--){
                for(int j=1;j<=a-i;j++){
                    System.out.print(" ");
                }
                for(int j=1;j<=(2*i)-1;j++){
                    System.out.print("*");
                }System.out.println();
            }
        }                          
        
        
        //public static void main(String args[]){
            //HollowRect(5,8);
            //InvertedNDRotatedHalfPyramid(a);
            //InvHalfPyramidNOS(a);
            //FloydsTriangle(a);
            //Triangle01(a);
            //ButterflY(a);
            //RhombusSolid(a);
            // RhombusHollow();
            //Diamond(4);
       //}
    
// ************************************************************************************************************************************************



        // ^ A R R A Y S

                    //^~  Create Arrays 
// /*datatype*/    int ArrayName[] = new int[10]; /*datatype*/
//                 int ArrayName1[] = {1,2,3};
//                 String fruits[] = {"Apple", "Mango", "Orange"};


                    // Scanner sc = new Scanner(System.in);
                    // int marks[] = new int[10];
                    // marks[0] = sc.nextInt();  //Phy Marks
                    // marks[1] = sc.nextInt();  //Chem Marks 
                    // marks[2] = sc.nextInt();  //Maths Marks
                    // System.out.println("Phy = "+marks[0]+" ; Chem = "+marks[1]+" ; Math = "+marks[02]);

                    // ^ U P D A T E
                    // marks[2]+=1;
                    // System.out.println("Updated Math = "+marks[2] );
                
                    // int marks[] = new int[10];
                    // System.out.println("Length of array : "+ marks.length);


            // ============================================
            // // Update Array Marks Function  
            public static void Update(int marks[]){             // WE CAN SEE ARRAYS ARE PASSED BY REFERENCE CUZ MAIN ARRAY ALSO CHANGE IF ANY CHANGE MADE IN FUNCTION
                for(int i =0;i<marks.length; i++){
                    marks[i] = marks[i]+1;
                }
            }
            // public static void main(String args[]){
            //     int marks[] = {97,93,92};
            //     Update(marks);
    
                 //print marks                       
            //     for(int i = 0;i<marks.length;i++){
            //         System.out.println(marks[i]);
            //     }
            // }
            // ============================================
// ===================================================================

                // ^   L I N E A R    S E A R C H    IN  A R R A Y

            public static int LinSearchArrays(int numbers[], int key){
                for(int i=0;i<numbers.length;i++){
                    if(numbers[i]==key){
                        return i;
                    }
                }
                return -1;
            }
            // public static void main(String args[]){
            //     int numbers[] = {2,4,6,8,10,12,14,16};
            //     int key = 1;
            //     int index = LinSearchArrays(numbers, key);
            //     if(index == -1){
            //         System.out.println("N O T   F O U N D");
            //     }
            //     else{
            //         System.out.println("Key is at index : "+ index);
            //     }
                
            // }
// ===============================================================================


                                                        // ^ L A R G E S T   A N D   S M A L L E S T    N U M B E R    I N    A R R A Y

                                                    public static void getLargestNDsMallestinArray(int numbers[]){
                                                        int largest = Integer.MIN_VALUE;    //TODO      Signifies -Infinity in Java
                                                        int smallest = Integer.MAX_VALUE;   //TODO      Signifies + Infinity
                                                        for(int i = 0;i<numbers.length;i++){
                                                            if(numbers[i]>largest){
                                                                largest = numbers[i];
                                                            }
                                                            if(numbers[i]<smallest){
                                                                smallest = numbers[i];
                                                            }
                                                        }
                                                        System.out.println("Smallest number is : "+smallest);
                                                        System.out.println("Largest number is : "+largest);
                                                    }
                                                    // public static void main(String args[]){
                                                    //     int numbers[] = {0,2,4,100,8,10,12,14,16};
                                                    
                                                    //     getLargestNDsMallestinArray(numbers);
                                                    // }
// ===============================================================================


                    //^ B I N A R Y   S E A R C H

                    public static int BinarySearchArry(int numbers[], int key){
                        int start = 0, end = numbers.length-1;
                        while(start<=end){
                            int mid =(start+end)/2;

                            // Comparisions
                            if(numbers[mid]==key ){
                                return mid;
                            }
                            if(numbers[mid]<key){
                                start = mid+1;
                            }
                            else{ //left
                                end = mid-1;
                            }
                        }return -1;
                    }
                // public static void main(String args[]){
                //     int numbers[] = {0,2,4,100,8,10,12,14,16};
                //     int key = 8;

                //     System.out.println("Index for key is : "+BinarySearchArry(numbers, key));
                // }
// ===============================================================================

                                                                //^ R E V E R S E    A N    A R R A Y

                                                            public static void ReverseArray(int numbers[]){
                                                                int first = 0, last = numbers.length-1;
                                                                while(first<last){
                                                                    int temp = numbers[last];
                                                                    numbers[last] = numbers[first];
                                                                    numbers[first] = temp;
                                                                    first++;
                                                                    last--;
                                                                }
                                                                
                                                            }
                                                            // public static void main(String args[]){
                                                            //     int numbers[] = {1,2,3,4,5,6,7,8,9,10};
                                                            //     ReverseArray(numbers);
                                                            //     for(int i = 0; i<numbers.length;i++){
                                                            //         System.out.print(numbers[i]+" ");
                                                            //     }
                                                            // }
                //^ P A I R S    I N    A R R A Y
                public static void PairsInArray(int numbers[]){
                    int tp = 0;
                    for(int i = 0;i<numbers.length;i++){
                        int current = numbers[i];
                        for(int j=i+1;j<numbers.length;j++){
                            System.out.print("( "+current+" , "+numbers[j]+" )");
                            tp++;
                        }
                        System.out.println();
                    }
                    System.out.println("Total pairs are : "+ tp);
                }
                // public static void main(String args[]){
                //     int numbers[] = {2,4,6,8,10};
                //     PairsInArray(numbers);

                // }


             //^ P R I N T    S U B A R R A Y   

            public static void Subarrays(int numbers[]){
                int ts = 0;
                for(int i=0; i<numbers.length;i++){
                    int start = i;
                    for(int j=i;j<numbers.length;j++){
                        int end = j;
                        for(int k = start;k<=end;k++){
                            System.out.print(numbers[k]+" ");
                        }
                        ts++;
                        System.out.println();
                    }System.out.println();
                }
                System.out.println("Total subarrays = : "+ts);
            }            
            // //^     M A X    S U B A R R A Y    S U M  
            public static void MaxSubarraySum(int numbers[]){
                int MaxSum = Integer.MIN_VALUE;
                int currSum = 0;
                for(int i=0;i<numbers.length;i++){
                    for(int j=i;j<numbers.length;j++){
                        currSum = 0;
                        for(int k=i;k<=j;k++){
                        currSum += numbers[k];
                        }
                        System.out.println(currSum);
                        if(MaxSum<currSum){
                            MaxSum=currSum;
                        }
                    }
                }
                System.out.println("Max sum : "+MaxSum);

            }
             public static void main(String args[]){
                int numbers[]= {2,4,6,8};
                MaxSubarraySum(numbers);
             }

}   








    
    


