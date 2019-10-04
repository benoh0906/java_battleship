/*
JB Oh
CSCI 201A Y
Battleship
The program that allows the player to play the sinhle player version of the game Battleship.
*/

import java.util.Scanner;
import java.util.Random;


class Battleship {
    //constructor
    int attempts;
    String playerBoard[][];
    String gameBoard[][];
    String toCheck[][];
    boolean win;

    public Battleship (){
        attempts=0;
        playerBoard = new String[11][11];
        gameBoard = new String[11][11];
        toCheck = new String[11][11];
        win=false;

        createBoard(playerBoard);
        createBoard(gameBoard);
        createBoard(toCheck);

        distributeShip(playerBoard);
    }

    //Create the basic format of the game board by taking the 2D array as a parameter
    public void createBoard(String board[][]){
        //create 0~9
        for (int i = 1; i <=10; i++){
            board[0][i]=Integer.toString(i-1);
            for (int j = 1; j <= 10; j++){
                board[i][j]="-";
            }
        }
        board[0][0]="";
        board[1][0]="A";
        board[2][0]="B";
        board[3][0]="C";
        board[4][0]="D";
        board[5][0]="E";
        board[6][0]="F";
        board[7][0]="G";
        board[8][0]="H";
        board[9][0]="I";
        board[10][0]="J";
    }

    //Returns the random integer for random distribution of battleships
    public static int getRandomNumber(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

    //Randomly distributes battles ships on the game board, takes a 2D array as a parameter
    public void distributeShip(String board[][]){

        int carrier = 5;
        int battleship = 4;
        int destroyer = 3;
        int submarine = 3;
        int patrolBoat = 2;


        //if horizontal
        if (getRandomNumber(1, 2)==1){
            int randX = getRandomNumber(1, 4);
            int randY = getRandomNumber(1, 10);
            for (int i = 0; i < carrier; i ++){
                board[randX+i][randY]="x";
            }
        } else{
            //if vertical
            int randX = getRandomNumber(1, 10);
            int randY = getRandomNumber(1, 6);
            for (int i = 0; i < carrier; i ++){
                board[randX][randY+i]="x";
            }
        }

        //if horizontal
        if (getRandomNumber(1, 2)==1){
            int randX = getRandomNumber(1, 4);
            int randY = getRandomNumber(1, 10);
            for (int i = 0; i < battleship; i ++){
                board[randX+i][randY]="x";
            }
        } else{
            //if vertical
            int randX = getRandomNumber(1, 10);
            int randY = getRandomNumber(1, 6);
            for (int i = 0; i < battleship; i ++){
                board[randX][randY+i]="x";
            }
        }
        //if horizontal
        if (getRandomNumber(1, 2)==1){
            int randX = getRandomNumber(1, 4);
            int randY = getRandomNumber(1, 10);
            for (int i = 0; i < destroyer; i ++){
                board[randX+i][randY]="x";
            }
        } else{
            //if vertical
            int randX = getRandomNumber(1, 10);
            int randY = getRandomNumber(1, 6);
            for (int i = 0; i < destroyer; i ++){
                board[randX][randY+i]="x";
            }
        }        
        //if horizontal
        if (getRandomNumber(1, 2)==1){
            int randX = getRandomNumber(1, 4);
            int randY = getRandomNumber(1, 10);
            for (int i = 0; i < submarine; i ++){
                board[randX+i][randY]="x";
            }
        } else{
            //if vertical
            int randX = getRandomNumber(1, 10);
            int randY = getRandomNumber(1, 6);
            for (int i = 0; i < submarine; i ++){
                board[randX][randY+i]="x";
            }
        }
        //if horizontal
        if (getRandomNumber(1, 2)==1){
            int randX = getRandomNumber(1, 4);
            int randY = getRandomNumber(1, 10);
            for (int i = 0; i < patrolBoat; i ++){
                board[randX+i][randY]="x";
            }
        } else{
            //if vertical
            int randX = getRandomNumber(1, 10);
            int randY = getRandomNumber(1, 6);
            for (int i = 0; i < patrolBoat; i ++){
                board[randX][randY+i]="x";
            }
        }


    }

    //Takes in the player's input and modifies the game boards.
    //Notifies whether the player "hit" or "miss" battleships
    public void makeMove (String letter, String num){
        
        if((num.equals("0")||num.equals("1")||num.equals("2")||num.equals("3")||num.equals("4")||num.equals("5")||num.equals("6")||num.equals("7")||num.equals("8")||num.equals("9"))&&(letter.equals("a")||letter.equals("b")||letter.equals("c")||letter.equals("d")||letter.equals("e")||letter.equals("f")||letter.equals("g")||letter.equals("h")||letter.equals("i")||letter.equals("j"))){

            int numToInt = Integer.parseInt(num);
            int letterToInd=0;


            if (letter.equals("a")){
                letterToInd=1;
            }else if (letter.equals("b")){
                letterToInd=2;
            }else if (letter.equals("c")){
                letterToInd=3;
            }else if (letter.equals("d")){
                letterToInd=4;
            }else if (letter.equals("e")){
                letterToInd=5;
            }else if (letter.equals("f")){
                letterToInd=6;
            }else if (letter.equals("g")){
                letterToInd=7;
            }else if (letter.equals("h")){
                letterToInd=8;
            }else if (letter.equals("i")){
                letterToInd=9;
            }else if (letter.equals("j")){
                letterToInd=10;
            }
            

            if (playerBoard[letterToInd][numToInt+1].equals("x")){
                System.out.println("Hit");
                gameBoard[letterToInd][numToInt+1]="x";
                toCheck[letterToInd][numToInt+1]="x";
            } else{
                gameBoard[letterToInd][numToInt+1]="o";
                System.out.println("Miss");
            }
            attempts+=1;

        } else{
            System.out.println("Wrong Input");
        }
    }

    //prints gameBoard array on the console
    public void printGameBoard(){
        for (int i = 0; i < 11; i++){
            for (int j = 0; j < 11; j++){
                System.out.print(gameBoard[i][j]+"      ");
            }
            System.out.print("\n");
        }
    }

    // prints playerBoard array on the console
    public void printPlayerBoard(){
        for (int i = 0; i < 11; i++){
            for (int j = 0; j < 11; j++){
                System.out.print(playerBoard[i][j]+"      ");
            }
            System.out.print("\n");
        }
    }

    //checks whether the player won the game or not every the move
    public void checkWin(){
        boolean checkBoards=true;
        for (int i = 0; i < 11; i++){
            for (int j = 0; j < 11; j++){
                if (!toCheck[i][j].equals(playerBoard[i][j])
                ){
                    checkBoards=false;
                }
            }
        }
        if (checkBoards == true){
            win=true;
        } else{
            win=false;
        }
    }

    //main
    public static void main(String[] argv) {

        Battleship bs = new Battleship();


        System.out.println("This game implements a single player version of Battleship. There are 5 ships of lengths 5, 4, 3, 3, and 2. Your hit chart is shown after each round.  Enter a coordinate in the form of a letter (A-J) followed by a number (0-9), e.g. E8. The game ends when all ships have been sunk. Good luck!");


        while(bs.win==false){
            bs.printGameBoard();

            System.out.print("Enter a coord (eg. E8): ");
            Scanner sc = new Scanner(System.in);
            String playerInput = sc.next().toLowerCase();
            String[] coordinates;
            coordinates = playerInput.split("");
            
            bs.makeMove(coordinates[0],coordinates[1]);

            bs.checkWin();

        }
        System.out.println(bs.win+"You won after "+bs.attempts+" attempts!");


    }
    
}

