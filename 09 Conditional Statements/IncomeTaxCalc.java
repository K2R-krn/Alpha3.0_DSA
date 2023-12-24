import java.util.*;
public class IncomeTaxCalc {

    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("I N C O M E   T A X   C A L C U L A T O R");
        System.out.print("Enter your Income : ");
        Float ic = sc.nextFloat();
        Float tax;
        if(ic<500000){
            System.out.println("U are Tax Free !!  :)");
        }
        else if(ic >=500000 && ic<1000000){
            tax = (float) (ic * 0.2);
            System.out.println("Tax on your income is :"+tax);
        }
        else{
            tax = (float) (ic*0.3);
            System.out.println("Tax on your income is :"+tax);

        }

    }
}
