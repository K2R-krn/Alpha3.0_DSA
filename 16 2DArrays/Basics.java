import java.util.*;       //TODO  1.CREATING    2.TAKING INPUT AND OUTPUT    3.SEARCHING    4.LARGEST,SMALLEST
public class Basics {
    public static void main(String args[]){
        //^ Creating 2D array.
        int matrix[][] = new int[3][3];
        int n = matrix.length /*ROWS */, m = matrix[0].length /*COLOUMNS */;

        Scanner sc = new Scanner(System.in);
        //^ Taking input for elements.    
        for(int i = 0; i<n;i++){
            for(int j =0;j<m;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        //^ Output
        for(int i = 0; i<n;i++){
            for(int j =0;j<m;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


        Search(matrix, 6);
        LargestndSmallestIN2D(matrix);
    }
    //^ S E A R C H I N G    I N     2D ARRAY

    public static boolean Search(int matrix[][], int key){
        for(int i = 0; i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j] == key){
                    System.out.println("Found at cell ("+i+","+j+")");
                    return true;
                }
            }
        }System.out.println("Key not found.");
        return false;
    }

    public static void LargestndSmallestIN2D(int matrix[][]){
        int Largest = Integer.MIN_VALUE;
        int Smallest = 20;//Integer.MAX_VALUE;
        for(int i =0; i<matrix.length; i++){
            for(int j = 0 ;j<matrix[0].length;j++){
                if(matrix[i][j] > Largest){
                    Largest = matrix[i][j];
                }
                if(matrix[i][j] < Smallest){
                Smallest = matrix[i][j];
                }
            }
        }
        System.out.println("Largest in the 2D array is : "+Largest);
        System.out.println("Smallest in the 2D array is : "+Smallest);
    }
}
