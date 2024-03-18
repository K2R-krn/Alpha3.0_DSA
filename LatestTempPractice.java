import java.util.*; 
public class LatestTempPractice {
    public static void PerimeterRect(int a, int b){
        System.out.println("Perimeter of rectangle is : " +(a*b));
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side a of rectangle: ");
        int a = sc.nextInt();
        System.out.print("Enter side b of rectangle: ");
        int b = sc.nextInt();
        System.out.println();

        PerimeterRect(a, b);
        // System.out.println("Perimeter of rectangle is : "+(a*b));
    }
}
