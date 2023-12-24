import java.util.*;

public class ntimesprintusingWhile {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Statement : ");
        String pri = sc.nextLine();

        System.out.print("Number of times you want to print statement : ");
        int n = sc.nextInt();

        // //USING    W H I L E   L O O P
        // int cnt = 1;
        // while (cnt <= n) {
        //     System.out.println(pri);
        //     cnt++;
        // }

        //USING      F O R     L O O P
        for(int cnt=1; cnt<=n; cnt++){
            System.out.println(pri);
        }

    }
}
