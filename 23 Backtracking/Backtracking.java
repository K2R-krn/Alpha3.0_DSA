public class Backtracking {

    public static boolean isSafe(char board[][], int row,int col){
        // If safe VERTICALLY UP
        for(int i = row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false; 
            }
        }
        // If safe LEFT DIAGNOL UP
        for(int i = row-1,j=col-1; i>=0&&j>=0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        } 
        // If safe RIGHT DIAGNOL UP
        for(int i = row-1,j=col+1; i>=0&&j<board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void nQueens(char board[][], int row){
        // BASE
        if(row == board.length){
            printBoard(board);
            ways++;
            return;
        }

        // Coloumn loop
        for(int j = 0; j<board.length;j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueens(board, row+1);
                board[row][j] = '.';
            }
        }
    }

    static int ways = 0;
    public static void printBoard(char board[][]){
        for(int i = 0;i<board.length;i++){
            for(int j=0; j<board.length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------");
    }
    public static void main(String args[]){
        int n = 5;
        // Created 2D array  B O A R D
        char board[][] = new char[n][n];
        
        //initialise
        for(int i = 0;i<n;i++){
            for(int j=0; j<n;j++){
                board[i][j] = '.';
            }
        }
        nQueens(board, 0);
        System.out.println("TOTAL WAYS TO SOLVE N Queen = "+ ways);
    }
}
