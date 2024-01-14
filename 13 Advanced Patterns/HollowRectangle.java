import java.util.*;
public class HollowRectangle {
    public static void hollow_Rectangle(int tr , int tc){
        for(int i = 1; i<=tr;i++){                      // Outer loop
            for(int j = 1;j<=tc;j++){                   //Inner loop
                if(i==1||i==tr||j==1||j==tc){           // cell - (i,j)
                    System.out.print("*");              // Boundry cells
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
        System.out.print("Enter no. of Coloumns : ");
        int j = sc.nextInt();

        hollow_Rectangle(i, j);
    }
}
