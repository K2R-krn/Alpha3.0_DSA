public class DiagnolSum {
    public static void DiagnolSum(int matrix[][]){
        int sum = 0;

        //*      THIS HAS TC = O ( n ^ 2 )
    //     for(int i = 0;i<matrix.length;i++){
    //        for (int j = 0; j<matrix[0].length;j++){
    //            if(i==j){                               //*  PD sum    
    //                sum+=matrix[i][j];
    //             }
    //             else if(i+j==matrix.length-1){
    //                 sum+=matrix[i][j];                  //*  SD sum
    //             }
    //         }
    //     }
    // System.out.println("Sum of diagnol is : "+sum);    
    // }

        //*     Algo with   TC = O ( n )
        
        for(int i = 0; i<matrix.length;i++){
            sum+= matrix[i][i];    //*    PD  sum
            if(i != matrix.length-i-1){
                sum+= matrix[i][matrix.length-1-i];
            }
        }
        System.out.println("Sum of diagnol is : "+sum);
    }
    public static void main(String args[]){
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        DiagnolSum(matrix);
    }
}
