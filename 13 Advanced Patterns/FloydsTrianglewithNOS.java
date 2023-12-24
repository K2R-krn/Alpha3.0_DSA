import java.util.*;
public class FloydsTrianglewithNOS {

        public static void FloydsTrianglewithNOS(int a){
            int c=1;
            for(int i=1;i<=a;i++){
                for(int j=1;j<=i;j++){
                    System.out.print(c);
                    c++;
                }System.out.println();
            }
        }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of Rows : ");
        int n = sc.nextInt();
        FloydsTrianglewithNOS(n);
    }
}

