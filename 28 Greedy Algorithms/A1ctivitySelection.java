import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class A1ctivitySelection {
    
//*   O ( n ) 
    public static void main(String args[]){
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};
        // End time basis sorted

        //^SORTING______________________________________________________________________________________________________________________
        int activities[][] = new int[start.length][3];
        for(int i = 0;i<start.length;i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];

        }
                        // THIS PART IS      LAMBDA FUNCTION -> Shortform for a bigger function.  =  Comparator = Define How sorting done = Interface for sorting Java objects 
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2])); // this means sorting to be done on basis of 2nd column that is end time. If wanted start time basis we could have done o[1]
        //^  TILL HERE___________________________________________________________________________________________________________________ 
        
        
        int maxAct = 0; // count
        ArrayList<Integer> ans  = new ArrayList<>(); // stores index of activity

        // Initially first activity choosen, then 
        maxAct = 1;
        ans.add(0);
        //! ans.add(activities[0][0]);    */  //^ 0th me index hai

        int lastEnd = end[0]; // last ending time
        //! int lastEnd = activities[0][2];  // 2 END TIME 


        for(int i = 1;i<end.length;i++){
         
            if(start[i]>=lastEnd){
        //! if(activities[i][1])     // START TIME
                // activity select
                maxAct++;    
                ans.add(i);
            //! ans.add(activities[i][0]);
                lastEnd = end[i];
            //! lastEnd = activities[i][2];
            
            }
        }
        
        // Print answer
        System.out.println("Max activity = "+maxAct);
        for(int i = 0;i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }
}
