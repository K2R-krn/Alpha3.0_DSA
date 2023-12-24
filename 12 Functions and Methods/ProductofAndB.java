import java.util.*;
public class ProductofAndB {
   
    public static int multiply(int a , int b){
        int product = a*b;
        return product;
    }
    public static void main(String args []){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number : ");
        int a = sc.nextInt();

        System.out.print("Enter second number : ");
        int b = sc.nextInt();
        
        int prod = multiply(a,b);
        System.out.println("Multiplication of a*b = "+prod);
    
    }
}
