import java.util.*;
import java.util.LinkedList;
import java.util.Stack;
public class QueueB {

    //*   Q U E U E    U S I N G    A R R A Y
    static class QueueA{
    
        static int arr[];
        static int size;
        
        static int rear;

        QueueA(int n){
            arr = new int[n];
            size = n;
            rear = -1; 
        }

        public static boolean isEmpty(){
            return rear == -1;
        }

        // ADD Function    //!  initially rear at -1   So to add a elemtent we Increment rear by 1 and add element again increment add another element
        public static void add(int data){
            if(rear == size-1){
                System.out.println("Queue is full.");
                return;
            }

            rear = rear+1;
            arr[rear]= data;
        }


        //REMOVE Funtion
        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;}

            int front = arr[0];
            for(int i = 0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear =rear-1;
            return front;

        }
 

        // PEEK FUNCTION
        public static int peek(){
            if(isEmpty()){
                System.out.println("QUEUE EMPTY");
                return -1;
            }
            return arr[0];
        }
    }


    //*   C I R C U L A R    Q U E U E     U S I N G    A R R A Y
    static class CircularQueue{
        static int front;
        static int rear;
        static int arr[];
        static int size;

        CircularQueue(int n){
            arr = new int[n];
            size = n;
            front = -1;
            rear = -1;
        }
        //! IS EMPTY
        public static boolean isEmpty(){
            return (front==-1 && rear ==-1);
        }
        //! IS FULL
        public static boolean isFull(){
            return (rear+1)%10==front;
        }
        //!   ADD
        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            // if adding first element
            if(front ==-1){
                front = 0;
            }
            rear = (rear+1)%10;
            arr[rear] = data;
        }
        //!  REMOVE
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty.");
                return -1;
            }
            int result = arr[front];
            
            if(rear == front){
                rear = front = -1;
            }else{
                front = (front+1)%10;
            }
            return result;
        }

        //! PEEK
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty.");
                return -1;
            }
            return arr[front];
        }

    }


    // *   Q u e u e s    U s i n g     L I N K E D   L I S T
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class QueueLinked{
        static Node head;
        static Node tail;

        public static boolean isEmpty(){
            return head==null && tail == null;
        }
        
        //!   NO NEED OF IS FULL AS LINKED LIST IS NOT FIXED SIZE

        public static void add(int data){
            Node newNode = new Node(data);

            if(head == null){
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue empty.");
                return -1;
            }
            int front = head.data;
            if(tail == head ){
                tail = head = null;
            }else {
                head = head.next;
            }
            return front;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("QUEUE EMPTY.");
                return -1;
            }
            return head.data;
        }

    }


    //*   2.  IMPLEMENTING  Q U E U E   using 2 STACKS
    //  We use 2 stacks.  To add an element we check if s1 is emepty and if so we add else put all elements of s1 in s2 and then add element in s1 and then put all s2 elements back
    //                    To remove just pop from s1
    static class QueueUStack{
        static java.util.Stack<Integer> s1 = new java.util.Stack<>();
        static java.util.Stack<Integer> s2 = new java.util.Stack<>();

        public static boolean isEmpty(){    //! IS EMPTY
            return s1.isEmpty();
        }
        public static void add(int data){   //! ADD
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        public static int remove(){     //! REMOVE
            if(isEmpty()){
                System.out.println("QUEUE EMPTY.");
                return -1;
            }
            return s1.pop();
        }
        public static int peek(){       //! PEEK
            if(isEmpty()){
                System.out.println("QUEUE EMPTY.");
                return -1;
            }
            return s1.peek();
        }

    }

    //^  PRINT QUEUE
    public static void printQ(Queue<Integer> q){
        while(!q.isEmpty()){
            System.out.print( q.remove()+" ");
        }
    }

    //*  3.  Stack using 2 Queue 

    static class Stack{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void add(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }else{
                q2.add(data);
            }
        }

        public static int pop(){
            if(isEmpty()){
                System.out.println("Empty stack.");
                return -1;
            }
            int top = -1;
            // Case 1
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }else{// case 2
                while(!q2.isEmpty()){
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }    
            }
            return top;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty stack.");
                return -1;
            }
            int top = -1;
            // Case 1
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    q2.add(top);
                }
            }else{// case 2
                while(!q2.isEmpty()){
                    top = q2.remove();
                    q1.add(top);
                }    
            }
            return top;
        }
    }
    //*  3  First Non repeating Letter in a stream of characters 
    public static void printNonRepeating(String str){
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i = 0;i<str.length();i++){ 
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print("-1 ");
            }else{
                System.out.print(q.peek()+" ");
            }
        }
    }

    // *  4  Interleave 2 halves of a queue(even length queue)  
    // i.e.   We have a queue - [1,2,3,4,5,6,7,8,9,10] as input and we want following output - [1,6,2,7,3,8,4,9,5,10]
    public static void interLeaf(Queue<Integer> q){
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size(); //  size taken earlier and not in loop below (as i<q.size()/2) because in loop when run once for i=0 one element popped and size reduce so change everytime so its better to find it earlier
        
        for(int i = 0;i<size/2;i++){
            firstHalf.add(q.remove());
        }

        while(!firstHalf.isEmpty()){
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    //*  5     Reverse Queue / Queue Reversal
    public static void queueReverse(Queue<Integer> q ){
        java.util.Stack<Integer> s = new java.util.Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    //*  6. Creating Stack and Queue using DEQUE
    
    //! STACK
    static class StackDeq{
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data){
            deque.addLast(data);
        }
        public int pop(){
            return deque.removeLast();
        
        }
        public int peek(){
            return deque.getLast();
        }
    }
    //! QUEUE
    static class QueueDeq{
        Deque<Integer> deque = new LinkedList<>();

        public void add(int data){
            deque.addLast(data);
        }
        public int remove(){
            return deque.removeFirst();
        
        }
        public int peek(){
            return deque.getFirst();
        }
    }

    public static void main(String args[]){
        // QueueLinked q = new QueueLinked();
        // QueueA q = new Queue(5);
        // CircularQueue q = new CircularQueue(5);

        // Queue<Integer> q = new LinkedList<>();

        //!2
        // QueueUStack q = new QueueUStack();
        // q.add(1);
        // q.add(2);
        // q.add(3);

        // printQ(q);
        // }
        //! 3
        // String str = "aabccxb";
        // printNonRepeating(str);
    
        //! 4
        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.add(7);
        // q.add(8);
        // q.add(9);
        // q.add(10);
        
        // interLeaf(q);
        // printQ(q);
        // }
    
        //!  5
        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // queueReverse(q);
        // printQ(q);
        
        //!  6



    }
}