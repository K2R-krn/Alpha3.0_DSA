
// // 1. Average of 3 nos. A,B,C .

// import java.util.*;
// public class PRACTICE1 {
//     public static void main(String args[]) {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter the First number: ");
//         double num1 = sc.nextDouble();

//         System.out.println("Enter the Second number: ");
//         double num2 = sc.nextDouble();

//         System.out.println("Enter the Third number: ");
//         double num3 = sc.nextDouble();

//         double av = (num1+num2+num3)/3;
//         System.out.println("The average of 3 nos is: "+ av);
//         }
// }


// // 2. Input the Side of a square and give output.

// import java.util.*;
// public class PRACTICE1 {
//     public static void main(String arg[]){
        
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter a Side of square : ");
//         double side = sc.nextDouble();
//         double area = side*side;
//         System.out.println("Area of Square is : "+area);



//     }
// }

// 3. Cost of 3 items and make a bill

import java.util.*;
public class practice1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter price of Pen: ");
        Float penp = sc.nextFloat();

        System.out.print("Enter price of Pencil: ");
        Float pencilp = sc.nextFloat();

        System.out.print("Enter price of Notebook: ");
        Float notebook = sc.nextFloat();

        float bil = (penp+pencilp+notebook) ;
        float $ = (18*bil)/100;
        float bill = bil+$;
        System.out.println("Your BILL is : "+ bill+"/-   Including $"+$+" tax" );
    }
}
