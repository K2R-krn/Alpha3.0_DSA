import java.util.*;
public class InvRotatedHalfPyramid {
    public static void InvRotHalPyr(int n){
        for(int i = 1; i<=n;i++){
            for(int j = 1;j<=n-i;j++){          // SPACES
                System.out.print(" ");
            }
            for(int j = 1;j<=i;j++){            // STARS
                System.out.print("*");
            }System.out.println();
        }   
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of Rows : ");
        int n = sc.nextInt();

        InvRotHalPyr(n);
    }
}