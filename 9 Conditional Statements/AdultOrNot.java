import java.util.*;
public class AdultOrNot {
    public static void main(String args[]) {
        int Age = 10;
        if (Age > 13 && Age < 18) {
            System.out.println("Teenager");
        }
        else {
            if (Age >= 18) {
                System.out.println("Adult");
            } else {
                System.out.println("K I D");
            }
        }
    }
}  