import java.util.LinkedList;
public class LLBasics {
    
    public static void main(String args[]){
        // C R E A T E
        LinkedList<Integer> ll = new LinkedList<>();

        // A D D
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);

        System.out.println(ll);

        // R E M O V E
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);

    }
}
