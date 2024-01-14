import java.util.*;
public class ReverseAnArray {
    public static void RevArray(int numbers[]){
        int first =0, last = numbers.length-1;

        while(first<last){
            // S W A P
            int temp = numbers[last];
            numbers[last] = numbers[first];
            numbers[first]= temp;

            first++;
            last--;

        }
    }
    public static void main(String args[]){
        int numbers[]={2,4,6,8,10,12,14,16,18,20,22,24,30,100};
        RevArray(numbers);
        // P R I N T     A R R A Y
        for (int i = 0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
    }
}
