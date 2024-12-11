package TicTacToe_Game;
import java.util.Scanner;

public class tictactoeGame {
    public static void main(String[] args) {
        char[][] board=new char[3][3];
        for(int row = 0; row < board.length;row++){
            for(int col = 0; col < board[row].length;col++){
                board[row][col]=' ';
            }
        }
        char player='X';
        boolean gameOver=false;
        Scanner scanner = new Scanner(System.in);

        while(!gameOver){
            printBoard(board);
            System.out.println("Player " + player + " enter: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if(board[row][col]==' '){
                board[row][col]=player;//place the element
                gameOver = haveWon(board, player);
                if(gameOver){
                    System.out.println("Player " + player + " has won: ");
                } else {
                    if(player =='X'){
                        player = '0';
                    }else{
                        player = 'X';
                    }
                }
            }else{
                System.out.println("Invalid move. Try again!");
            }
        }
        printBoard(board);
        scanner.close();
    }

    public static boolean haveWon(char[][] board, char player){
        //check the rows
        for(int row = 0; row < board.length;row++){
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
                return true;
            }
        }
        //check for col
        for(int col = 0; col < board.length;col++){
            if(board[col][0]==player && board[col][1]==player && board[col][2]==player){
                return true;
            }
        }
        //check for first diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        //check for seconde diagonal
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }
    public static void printBoard(char[][] board){
        for(int row = 0; row < board.length;row++){
            for(int col = 0; col < board[row].length;col++){
                System.out.print(board[row][col] + "___|" );
            }
            System.out.println("");
        }
    }
}
