import java.util.Arrays;
import java.util.Collections;

public class C7hocolaProblem {
    
    public static void main(String args[]){
        int n = 4, m=6;
        Integer costVer[]= {2, 1, 3, 1, 4}; // m-1
        Integer costHor[] = {4, 1, 2};   // n-1

        //! First sort both
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());
        

        int h=0,v=0;
        int hp =1, vp =1; // hp = horizontal pieces // vp = vertical pieces
        int cost = 0;

        while( h < costHor.length && v < costVer.length){
          // Now compare
            // vertical < horizontal
            if(costVer[v] <= costHor[h]){//Horz cut
                cost += (costHor[h]*vp);
                hp++;
                h++;
            }   else {//vertical Cut
                cost+=(costVer[v]*hp);
                vp++;
                v++;
            }
        }
        while(h<costHor.length){
            cost += (costHor[h]*vp);
            hp++;
            h++;
        }
        while(v<costVer.length){
            cost+=(costVer[v]*hp);
            vp++;
            v++;
        }

        System.out.println("Min cost of cuts = "+cost);

    }

}
// import java.util.Arrays;
// import java.util.Collections;

// public class C7hocolaProblem {

//     public static void main(String args[]){
//         int n = 4, m=6;
//         Integer costVer[]= {2, 1, 3, 1, 4}; // m-1
//         Integer costHor[] = {4, 1, 2};   // n-1
        
//         Arrays.sort(costVer, Collections.reverseOrder());
//         Arrays.sort(costHor, Collections.reverseOrder());
    
//         int h=0,v=0;
//         int hp = 1,vp=1;
//         int cost = 0;
//         while( v < costVer.length && h < costHor.length){
//             if(costVer[v]<costHor[h]){
//                 cost+=(costHor[h]*vp);
//                 hp++;
//                 h++;
//             }else {
//                 cost+=(costVer[v]*hp);
//                 vp++;
//                 v++;
//             }
//         }
//         while(v < costVer.length){
//             cost+=(costVer[v]*hp);
//             vp++;
//             v++;
//         }
//         while(h < costHor.length){
//             cost+=(costHor[h]*vp);
//             hp++;
//             h++;
//         }
//         System.out.println(cost);
    
//     }
    

// }