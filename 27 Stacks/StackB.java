import java.util.*;
public class StackB {
    static class Stack0{
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size() == 0; // return true if list size is 0
        }

        // PUSH FN 
        public static void push(int data){
            list.add(data); // this basically adds data at the end of list that is top of stack

        }

        // POP FN
        public static int pop(){  // use int data type as it returns data before deleting in regular functionz
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);  // this in itself is O(1) operration
            return top;
        }

        // PEEK OP
        public static int peek(){
            return list.get(list.size()-1);
        }
    }
    public static void main(String args[]){
        //Stack s = new Stack();

        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peek()); // prints elemeny one by one 
            s.pop();                        //   deletes element after printitng
        }
    }
}
