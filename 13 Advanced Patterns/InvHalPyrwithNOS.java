import java.util.*;
public class InvHalPyrwithNOS {
    
    public static void InvHalPyrNo(int n){
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n-i+1;j++){
                System.out.print(j);
            }System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of Rows : ");
        int n = sc.nextInt();

        InvHalPyrNo(n);
    }
}
