import java.util.*;
public class PQ4FloydsTriangle {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of lines : ");
        int n = sc.nextInt();
        int ch = 1 ;              //Same as Character pattern. But there char ch ='A' //

        //Outer Loop
        for(int line = 1;line<=n;line++){
            //Inner Loop
            for(int chars=1; chars<=line; chars++){
                System.out.print(ch);
                ch++;
            }
        System.out.println();
        }
        
    }
}
