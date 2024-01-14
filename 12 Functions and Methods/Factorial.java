import java.util.*;
public class Factorial {
    
    public static int Fact(int n){
        int f =1;
        for(int i = 1;i<=n;i++){
            f = f*i;
        }
        return f;
    }

    public static void Factor(int n){ // Better one with printing all the lines and operations
        int f = 1;
        int fac = 1;
        for(int i = 1; i<=n;i++){
            fac = fac*i;
            System.out.println(f+" * "+i+" = "+fac);
            f = fac;
        }
        System.out.println(fac);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number : ");
        int a = sc.nextInt();
        System.out.println(Fact(a));

        Factor(a);

    }
}
