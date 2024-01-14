import java.util.*;
public class DiamondPattern {
    public static void Diamond(int n){
        // 1st half
        for(int i =1;i<=n;i++){

            //for Spaces
            for(int j=1; j<=(n-i); j++){
                System.out.print(" ");
            }

            // Stars
            for(int j = 1; j<=(2*i)-1; j++){
                System.out.print("*");
                
            }
            System.out.println();
        }// 2nd half
        for(int i =n;i>=1;i--){

            //for Spaces
            for(int j=1; j<=(n-i); j++){
                System.out.print(" ");
            }

            // Stars
            for(int j = 1; j<=(2*i)-1; j++){
                System.out.print("*");
                
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter no. of Rows : ");
        int i = sc.nextInt();

        Diamond(i);
    }
}
