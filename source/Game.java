/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package connectfour;

/**
 *
 * @author Eli
 */
class Game {
    public char[][] board;
    Player p1;
    Player p2;
    Player currentPlayer;
    
    public Game(Player p1, Player p2){
        this.board = new char[6][7];
        this.p1 = p1;
        this.p2 = p2;
        this.currentPlayer = this.p1;
    }
    
    public void clearBoard(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = 'x';
            }
        }
    }
    
    public boolean checkWinner(){
        boolean isOver = false;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                isOver = checkVertical(i,j) || checkHorizontal(i,j) || 
                         checkMainDiagonals(i,j) || checkBackDiagonals(i,j);
                if (isOver) {
                    return true;
                }
            }
        }
        return isOver;
    }
    
    public void move(int column){
        for (int i = 5; i >= 0; i--) {
            if (board[i][column] == 'x'){
                board[i][column] = currentPlayer.gamePiece;
                return;
            }
        }
    }

    private boolean checkVertical(int i, int j) {
        boolean isOver = false;
        if(board[i][j] !='x'){
            try {
                isOver =(board[i][j] == board[i+1][j] &&
                         board[i][j] == board[i+2][j] &&
                         board[i][j] == board[i+3][j]);
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                return false;
            }
        }
        return isOver;
    }

    private boolean checkHorizontal(int i, int j) {
        boolean isOver = false;
        if(board[i][j] !='x'){
            try {
                isOver =(board[i][j] == board[i][j+1] &&
                         board[i][j] == board[i][j+2] &&
                         board[i][j] == board[i][j+3]);
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                return false;
            }
        }
        return isOver;
    }
    
    private boolean checkMainDiagonals(int i, int j) {
        boolean isOver = false;
        if(board[i][j] !='x'){
            try {
                isOver =(board[i][j] == board[i+1][j+1] &&
                         board[i][j] == board[i+2][j+2] &&
                         board[i][j] == board[i+3][j+3]);
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                return false;
            }
        }
        return isOver;
    }

    private boolean checkBackDiagonals(int i, int j) {
        boolean isOver = false;
        if(board[i][j] !='x'){
            try {
                isOver =(board[i][j] == board[i-1][j-1] &&
                         board[i][j] == board[i-2][j-2] &&
                         board[i][j] == board[i-3][j-3]);
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                return false;
            }
        }
        return isOver;
    }

    void printBoard() {
        /*
          1   2   3   4   5   6   7
        |___|___|___|___|___|___|___|
        |___|___|___|___|___|___|___|
        |___|___|___|___|___|___|___|
        |___|___|___|___|___|___|___|
        |___|___|___|___|___|___|___|
        |___|___|___|___|___|___|___|
        */
        String boardString = "";
        boardString += ("  1   2   3   4   5   6   7" + System.lineSeparator());
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                char currentChar = board[i][j];
                if(currentChar == 'x'){currentChar = '_';}
                boardString += ("|_" + currentChar + "_");
                if(j==6){boardString += "|"+System.lineSeparator();}
            }
        }
        System.out.print(boardString);
    }

    void switchPlayers() {
        if(currentPlayer == p1){
           currentPlayer = p2;
        }else{
            currentPlayer = p1;
        }
    }

}
