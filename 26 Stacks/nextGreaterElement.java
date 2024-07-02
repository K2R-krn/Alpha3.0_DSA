import java.util.*;

//TODO  1.  NEXT GREATER LEFT      for(int i = 0; i<=arr.length-1; i++){
//TODO  2.  NEXT GREATER RIGHT     for(int i = arr.length-1; i>=0; i--){
//TODO  3.  NEXT SMALLER LEFT      while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
//TODO  4.  NEXT SMALLER RIGHT     while(!s.isEmpty() && arr[s.peek()] >= arr[i]){   && for(int i = 0; i<=arr.length-1; i++){

public class nextGreaterElement {
    public static void main(String args[]){
        int arr[] = {2,5,1,8,3,6,0,9};
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];

      //for(int i = 0; i<=arr.length-1; i++){ //*  FOR NEXT GREATER LEFT SIDE
        for(int i = arr.length-1; i>=0; i--){
            // 1   WHILE                      // index store krte hasi stack me and not numebr
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            // 2   If else check
            if(s.isEmpty()){
                nextGreater[i] =-1;
            }else{
                nextGreater[i] = arr[s.peek()];
            }
            // 3   Push last one
            s.push(i);
        }

        for(int i = 0; i<nextGreater.length; i++){
            System.out.print(nextGreater[i]+" ");
        }
        System.out.println();
    }
}
