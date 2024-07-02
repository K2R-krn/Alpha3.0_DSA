import java.util.*;

public class StackRevsn {
    static class StackAL{
        static ArrayList <Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size()==0;
        }
        //PUSH FN
        public static void push(int data){
            list.add(data);
        }
        //POP FN
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        //PEEK FN
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
        
    
    }


    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class StackLL{
        static Node head = null;
        public static boolean isEmpty(){
            return head == null;
        }
        //PUSH
        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next =head;
            head = newNode;
        }
        //POP
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head= head.next;
            return top;
        }
        //peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }
    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.print(s.pop()+"  ");
        }
        System.out.println();
        return;
    }

    public static void pushBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushBottom(s, data);
        s.push(top);
    }

    public static String reverseStr(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder sb = new StringBuilder("");
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        return sb.toString();
    }

    public static void revStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        revStack(s);
        pushBottom(s, top);
    }

    public static void stockSpan(int stocks[], int span[]){
        Stack<Integer> s = new Stack<>();
        
        // Span of 0 will always be one'
        span[0] = 1;
        s.push(0);

        // loop below will calculate span for every dayt
        for(int i = 1;i<stocks.length;i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice>stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            }else{
                int prevHigh = s.peek();
                span[i] = i-prevHigh;
            }
            s.push(i);
        }
    }





    //*   D U P L I C A T E   P A R E N T H E S I S
    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);

            //closing case
            if(ch==')'){
                int count = 0;
                while(/*!s.isEmpty() &&*/ s.peek()!='('){  // !s.isEmpty()  can be omitted as it will be a valid parenthesis as it is given in question that means that if ending is there it will have opening and stack cannot go empty without that
                    s.pop();
                    count++;

                }
                if(count<1){
                    return true; // duplicate
                }else{
                    s.pop();
                }
            } else{ // opeing case
                s.push(ch);
            }
        }
        return false;
    }


    public static void main(String args[]){

        // StackAL s = new StackAL();
        // StackLL s = new StackLL();
        // Stack<Integer> s = new Stack<>();

        // s.push(2);
        // s.push(3);
        // s.push(6);
        // s.push(8);

        // pushBottom(s, 100);
        // printStack(s); 
     
        // String str = "abc";
        // System.out.print(reverseStr(str));
        
        //*REV STACK  
        // printStack(s);
        // s.push(2);
        // s.push(3);
        // s.push(6);
        // s.push(8);
        // revStack(s);
        // printStack(s);

        //*  STOCK SPAN 
        // int stocks[] = {100,80,60,70,60,85,100};
        // int span[] = new int[stocks.length];
        // stockSpan(stocks, span);

        // for(int i = 0;i<span.length;i++){
        //     System.out.print(span[i]+" ");
        // }

        //*   DUPLICATE PARENTHESIS 
        String str = "((a+b))"; // true
        String str2 = "(a+b)"; // false
        System.out.println(isDuplicate(str2));
        



    }
}