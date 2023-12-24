import java.util.*;

public class HollowRhombus {
    public static void HolRho(int n){
        for(int i=1; i<=n; i++){
            for(int j=1;j<=(n-i);j++){                   //Spaces
                System.out.print(" ");
            }
            for(int j=1; j<=n; j++){                    //Hollow Rectangle
                if(i==1|| i==n|| j==1 || j== n ){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter no. of Rows : ");
        int i = sc.nextInt();
        HolRho(i);
    }
}
