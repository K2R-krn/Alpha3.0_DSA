import java.util.*;
public class OddorEven{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number : ");
        int F = sc.nextInt();

        if(F%2==0){
            System.out.print(F +" : Number is Even ");
        }
        else{
            System.out.print(F +" : Number is Odd");
        
        }
    }

}
