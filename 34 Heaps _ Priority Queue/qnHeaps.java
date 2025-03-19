import java.util.*;

// *   1.   N e a r b y   C a r s 
public class qnHeaps {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int distSq, int idx){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2){
            return this.distSq - p2.distSq;
        }

    }


    // *  2.  Connect n ropes
    public static void connectNRopes(int ropes[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 1 Add in PQ
        for(int i =0;i<ropes.length;i++){
            pq.add(ropes[i]);
        }

        // 2  A loop which runs till only one element left in pq //
        int cost = 0;
        while(pq.size() > 1){
            // 2 smallest ropes found
            int min = pq.remove();
            int min2 = pq.remove();
            // Cost calculated and added in PQ
            cost+= min+min2;
            pq.add(min+min2);
        }

        System.out.println("Cost of connecting N ropes : "+cost);

    }


    // *  3.  Weakest Soldiers

    // Created a ROW Class
    public static class Row implements Comparable<Row>{
        int soldiers;
        int idx;

        public Row(int soldiers, int idx){
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2){
            if(this.soldiers == r2.soldiers){
                return this.idx - r2.idx;
            }else{
                return this.soldiers - r2.soldiers;
            }
        }
    }

    // Function to find weakest soldier row
    public static void weakestSoldier(int army[][], int k){
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i =0; i<army.length;i++){
            int count = 0;
            for(int j = 0;j<army[0].length;j++){
                count += army[i][j] == 1 ? 1: 0;   // If one then add one else 0
            }
            pq.add(new Row(count, i));
            
        }
        // To print k weakest rows
        for(int i = 0;i<k;i++){
            System.out.println("R" + pq.remove().idx);
        }

    }

    //*  4. Sliding Window Maximum  /  Max of all subarray of size K
    public static class Pair implements Comparable<Pair>{
        int val;
        int idx;

        public Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }

        // Now we will sort pair with value
        @Override
        public int compareTo(Pair p2){
            // Ascending
            // return this.val - p2.val;
            // descending
            return p2.val - this.val; // written like this so that it comes out in descending order
        }
    }
    public static void slidWdwMax(int arr[], int k, int res[]){
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // 1st window
        for(int i =0;i<k;i++){
            pq.add(new Pair(arr[i], i));
        }

        // Store pq ke top ko result me 
        res[0] = pq.peek().val;

        // Now for other elements
        for(int i =k; i<arr.length; i++){
            // first remove those elements which existed before our window
            while(pq.size() > 0 && pq.peek().idx <= (i-k)){
                pq.remove() ;
            }

            pq.add(new Pair(arr[i], i));
            res[i-k+1] = pq.peek().val;
        }

        // Print result
        for(int i =0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }

    public static void main(String args[]){

        // *   1.   N e a r b y   C a r s 
        int pts[][] = {{3,3}, {5,-1}, {-2,4}};
        int q = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i = 0;i<pts.length;i++){ // Points added in proprity queue
            int distSq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }

        // Now print nearest q
        for(int i = 0;i<q;i++){
            System.out.println("C"+ pq.remove().idx);
        }
        
        
        
        //*  2 Connect N ropes ( Minimum cost of connecting n ropes ) 
        int ropes[] = {2,3,3,4,6};
        int ropes2[] = {4,3,2,6};
        connectNRopes(ropes2);
        connectNRopes(ropes);


        
        
        //*  3 Weakest Soldiers 
        int army[][] = {{1,0,0,0},
                       {1,1,1,1},
                       {1,0,0,0},
                       {1,0,0,0}};
        int k = 2;
        weakestSoldier(army,k);
    

        //*  4. Sliding Window Maximum  /  Max of all subarray of size K
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int y = 3;
        int res[] = new int[arr.length-k+1];  // result array ka size if n-k+1
        slidWdwMax(arr, y, res);
    }
}
