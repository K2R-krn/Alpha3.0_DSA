import java.util.*;
public class InvertedStarPattern {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of lines : ");
        int n = sc.nextInt();

        for(int lines = 1; lines<=n; lines++){
            for(int star = 1; star<=n-lines+1; star++){
                System.out.print("*");
            }
        System.out.println();
        }   
                // int rows = 5;        
                // for (int i = rows; i >= 1; i--) {
                //     for (int j = 1; j <= i; j++) {
                //         System.out.print("* ");
                //     }
                //     System.out.println();
                // }
            }
        }

