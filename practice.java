import java.util.*;
import java.util.LinkedList;
public class practice {
    static class Edge{
        int src;
        int dest;
        // int wt;
        public Edge(int s, int d/*  ,int w  */){
            this.src = s;
            this.dest = d;
            // this.wt = w;
        }
    }
    public static int bfs(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        int cnt = 0;
        for(int i = 0;i<graph.length;i++){
            if(!visited[i]){
                BFSUtil(graph, visited);
            }
            cnt++;
        }
        return cnt;
    }
    public static void BFSUtil(ArrayList<Edge>[] graph, boolean visited[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                System.out.print(curr+" ");
                visited[curr] = true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
        
    
    public static void main(String args[]){
        
        


    }
}
