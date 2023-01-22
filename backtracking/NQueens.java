public class NQueens {
    
    public static void placeQueen(
        char[][] board,
        int row
    ){
        //base class
        if(row == board.length){
            printBoard(board);
            return;
        }

        //recursion
        for(int j = 0; j<board.length; j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                placeQueen(board,row+1);
                board[row][j] = '.';
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col){
        for(int j = row-1; j>=0; j--){
            if(board[j][col] == 'Q') {return false; }
        }

        for(int i = row-1 , j = col -1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q') {return false;}
        }

        for(int i = row-1 , j = col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q') {return false;}
        }

        return true;
    }

    public static void printBoard(char[][] board){
        for(int i =0; i<board.length;i++){
            for(int j =0; j<board.length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        placeQueen(board, 0);
    }
}
