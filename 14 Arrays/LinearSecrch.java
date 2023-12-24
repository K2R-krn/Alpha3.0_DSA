import java.util.*;
public class LinearSecrch {
    public static int LinearSearch(int numbers[] , int key){
        for(int i = 0; i<numbers.length;i++){
            if(numbers[i]==key){
                return i;
            }

        }
        return -1;
    }
    public static void main(String args[]){
        int numbers[] = {1,5,7,9,66,5,41,25,852};
        int key =5;

        int index = LinearSearch(numbers, key);
        if(index == -1){
            System.out.println("Not Found");
        }
        else{
            System.out.println("Key is at index :"+index);
        }
    }
}
