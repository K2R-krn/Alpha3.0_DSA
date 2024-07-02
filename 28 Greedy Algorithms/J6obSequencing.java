import java.util.ArrayList;
import java.util.Collections;

public class J6obSequencing {

    static class Job{
        int deadline;
        int profit;
        int id; // 0means A job  1 means B job etcc..   0(A) 1(B) 2(C) and so on
    
        public Job(int i, int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String args[]){
        
        int jobInfo[][] = {{4,20},{1,10},{1,40},{1,30}};
        
        // define above jobIndo in form of Job class

        // Job jobs[] = new Job[jobInfo.length];
        //!  1 Jobs ka arraylist banaa diya,  Job ki info ko Object bana ke Arraylist created
        ArrayList<Job> jobs = new ArrayList<>();

        // to store data in this
        for(int i = 0;i<jobInfo.length;i++){
            jobs.add(new Job(i,jobInfo[i][0], jobInfo[i][1]));

        }    
        //!  2 Jobs ka object bana ke   SORT kr diya
        // SORT 
        Collections.sort(jobs, (obj1,obj2) -> obj2.profit-obj1.profit); // with this we get ascending order of profit // as proft ke base pr sort kiya .profit
        // we have defined a compoarator to sort object // use Collections.sort  // this is the syntax for descending order 
        // for ascending order we do 1-2

        //! 3 Task
        // now store sequence
        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;

        for(int i = 0;i<jobs.size();i++){
            Job curr = jobs.get(i);

            if(curr.deadline>time){
                seq.add(curr.id);
                time++;
            }
        }

        //! 4  Print answers
        //PRINT SEQ
        System.out.println("Max jobs = "+seq.size());
        for(int i = 0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");
        }
        System.out.println();
    }
}
