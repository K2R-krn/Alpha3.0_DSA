import java.util.*;
public class ALL12FuncMethods {

// ***********************************************************************************************************************************************//

    // Multiply 2 nos.
    public static int multiply(int a , int b){
        int product = a*b;
        return product;
    }

// ***********************************************************************************************************************************************//

        //FACTORIAL
        public static int Factorial(int n){
            int f =1;
            for(int i = 1;i<=n;i++){
                f = f*i;
            }
            return f;
        }

// ***********************************************************************************************************************************************//

        //BINOMIAL COEFFICIENT                       BC = n! / r!*(n-r)!
        public static int binCoeff(int n, int r){
            int nfact = Factorial(n);
            int rfact = Factorial(r);
            int nmrfact = Factorial(n-r);
            int binCoeff = nfact / (rfact * nmrfact);
            return binCoeff;
        }
// ***********************************************************************************************************************************************//

        // P R I M E
        public static boolean isPrime(int n){
            if(n==2){
                return true;
            }   //  O P T I M I S E D                   
            for(int i = 2; i<=Math.sqrt(n);i++){
                if(n%i==0){
                    return false;
                }
            }return true;
        }
// ***********************************************************************************************************************************************//

        // PRIMES IN RANGE
        public static void PrimesinRange(int n){
            for(int i = 2; i<=n;i++){
                if(isPrime(i)){//True
                    System.out.print(i+"  ");
                }
            } System.out.println();
        }

// ***********************************************************************************************************************************************//

        // Average of 3
        public static double Avof3(double a, double b, double c){
            double av = (a+b+c)/3;
            return av;
        }
            
// ***********************************************************************************************************************************************//

        // Sum of digits of Integer

        public static int sumInt(int n){
            int num = n;
            int sum =0;
            while(num!=0 /*n>0*/ ){
                int a = num%10;
                sum = sum+a;
                num = num/10;
            }return sum;
        } 

// ***********************************************************************************************************************************************//

        // Pallindrome

        public static boolean Pallindrome(int n){
            int pal = n;
            int rev = 0;
            while(pal!=0){
                int rem = pal %10;
                rev = rev*10+rem;
                pal = pal/10;
            }if(n == rev){
                return true;
            }return false; 
        }
// ***********************************************************************************************************************************************//

        // Binary to Decimal
        public static void BinaryToDecimal(int binNum){
            int pow =0;
            int decNum =0;
            int bn = binNum;
            while(bn>0){
                int lastDigit = bn%10;
                decNum = decNum + (lastDigit*(int)Math.pow(2, pow));
    
                pow++;
                bn = bn/10; 
            }System.out.println("Decimal of " + binNum + " = "+ decNum);
        }
// ***********************************************************************************************************************************************//

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
// ***********************************************************************************************************************************************//
    public static void main(String args []){
        // System.out.println(multiply(a,b));
        // System.out.println(Factorial(a));
        // System.out.println(binCoeff(a,b));
        // System.out.println(isPrime(a));
        // PrimesinRange(a);
        // Avof3(a, b, c);
        // sumInt(a);
        // System.out.print(Pallindrome(a));
        // BinaryToDecimal(a);
        // DecToBinary(a);
    }
}