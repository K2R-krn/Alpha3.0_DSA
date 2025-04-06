import java.util.*;
import java.util.PriorityQueue;

    class Heap<T extends Comparable<T>>{
        private ArrayList<T> list;

        //^ HEAP CREATION
        public Heap(){
            list = new ArrayList<>();
        }

        //^ Parent, Left , Right  INDEX
        private int parent(int idx){
            return (idx-1)/2;
        }
        private int left(int idx){
            return (idx*2)+1;
        }
        private int right(int idx){
            return (idx*2)+2;
        }

        //^ SWAP 2 ELEMENTS
        private void swap(int first, int second){
            T temp = list.get(first);
            list.set(first, list.get(second));
            list.set(second, temp);
        }

        //^ INSERT ELEMENT
        public void insert(T value){
            list.add(value);
            upheap(list.size()-1);
        }
        private void upheap(int idx){
            if(idx == 0) return ;
            int p = parent(idx);
            if(list.get(idx).compareTo(list.get(p))<0){
                swap(idx, p);
                upheap(p);
            }
        }

        //^ REMOVE ELEMENT
        public T remove() throws Exception {
            if(list.isEmpty()){
                throw new Exception("REMOVING FROM AN EMPTY HEAP !! ");
            }

            T temp = list.get(0); // Store the root element to return later

            T last = list.remove(list.size()-1);  // Remove the last element

            if(!list.isEmpty()){ // If the heap is not empty after removal, place the last element at root and fix the heap
                list.set(0, last);// Move last element to root
                downheap(0);        // Restore heap order from the root
            }

            return temp; // Return the removed root
        }
        private void downheap(int idx){
            int min = idx;// Start with current index as minimum
            int left = left(idx);     // Get index of left child
            int right = right(idx);   // Get index of right child

            // Check if left child exists // and is smaller than current min
            if(left<list.size() && list.get(min).compareTo(list.get(left))>0){
                min = left;
            }
            // Check if right child exists // and is smaller than current min
            if(right<list.size() && list.get(min).compareTo(list.get(right))>0){
                min = right;
            }

            // If either child is smaller than current node, swap and continue downheaping
            if(min!=idx){
                swap(min,idx);
                downheap(min);
            }
        }

        //^  HEAP SORT
        public ArrayList<T> heapSort() throws Exception{
            ArrayList<T> data = new ArrayList<>();

            while(!list.isEmpty()){ // While list is not empty
                data.add(this.remove()); // keep removing items from list and add in data
            }
            return data;
        }
    }

    class Student {
        int roll;
        String name;
        int marks;
    
        Student(int roll, String name, int marks) {
            this.roll = roll;
            this.name = name;
            this.marks = marks;
        }
    }
    
public class HeapPQcomplete {
    public static void main(String args[]) throws Exception{
        Heap<Integer> heap = new Heap<>();

        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(89);
        heap.insert(76);

        System.out.println(heap.remove());
        ArrayList<Integer> list1 = heap.heapSort();
        System.out.println(list1);


        PriorityQueue<Integer> ans = new PriorityQueue<>();
        
        PriorityQueue<Student> pq = new PriorityQueue<>((a, b) -> b.marks - a.marks ); // MAX HEAP BASDED ON MARKS
        
        Student Bishal = new Student(02, "Bishal", 101);
        Student Karan = new Student(01, "Karan", 100);
        Student Hemant = new Student(03, "Hemant", 102);

        pq.add(Karan);
        pq.add(Bishal);
        pq.add(Hemant);

        
        System.out.println("Peek after Poll who in priority  "+pq.peek().name);
        System.out.println("Polled Student"+pq.poll().name);
        System.out.println("Peek after Poll who in priority  "+pq.peek().name);
        System.out.println("Polled Student"+pq.poll().name);
        System.out.println("Peek after Poll who in priority  "+pq.peek().name);
        // System.out.println("Polled Student"+pq.poll().name);
        // System.out.println("Peek after Poll who in priority  "+pq.peek().name);
        
    }

}
