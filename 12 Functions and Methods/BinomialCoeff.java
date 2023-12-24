import java.util.*;
public class BinomialCoeff {
    //FACTORIAL
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

    //BINOMIAL COEFFICIENT                       BC = n! / r!*(n-r)!
    public static int binCoeff(int n, int r){
        int nfact = Fact(n);
        int rfact = Fact(r);
        int nmrfact = Fact(n-r);

        int binCoeff = nfact / (rfact * nmrfact);
        return binCoeff;
    }
    //MAIN
    public static void main(String args []){
        System.out.println(binCoeff(5, 2));
    }
}