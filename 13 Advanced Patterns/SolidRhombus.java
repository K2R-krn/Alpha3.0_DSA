import java.util.*;
public class SolidRhombus {
    public static void SolRhombus(int n){
        for(int i = 1; i<=n; i++){
            for(int j=1; j<=(n-i);j++){      //Spaces
                System.out.print(" ");
            }for(int j=1;j<=n;j++){          //Stars
                System.out.print("*");
            }System.out.println();
        }
    }
    public static void main(String args[]){
        SolRhombus(5);
    }
}
