import java.util.*;
public class Triangle01 {
    
    public static void trianle01(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i;j++){
                if((i+j)%2==0){
                    System.out.print("1");
                }
                else{
                    System.out.print("0");
                }
            }System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of Rows : ");
        int n = sc.nextInt();

        trianle01(n);
    }
}
