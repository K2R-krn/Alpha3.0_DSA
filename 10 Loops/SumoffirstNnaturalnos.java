import java.util.*;
public class SumoffirstNnaturalnos {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number till which u want to add : ");
        int n =sc.nextInt();

        int sum=0;

        // //Using    W H I L E    L O O P
        // int i = 1;
        // while(i<=n){
        //     sum+=i;
        //     i++;
        // }


        //Using         F O R       L O O P
        for(int i=1; i<=n; i++){
            sum+=i;
        };
        System.out.println("Sum is : "+sum);
    }
}
