/**
 * RandomRat will keep track of the it's previous position and not move backwards.
 * If it has more than 1 available move, it will choose randomly between them. If it
 * only has 1 available move (it's previous position), it will turn around and get
 * out of the dead end.
 */
import java.util.Random;

public class RandomRat implements Animal {

    static Random rnd = new Random();

    /**
     * Constructors
     */
    public RandomRat() {
    }


    int startCol = 0;
    int startRow = 0;
    int currentCol = 0;
    int currentRow = 0;
    String name = "Randy";
    int numMoves = 0;
    int availableMoves = 4;
    int behind = 0;


    /**
     * @return returns current row animal is in
     */
    public int getRow() {
        return currentRow;
    }

    /**
     * @return returns current column animal is in
     */
    public int getColumn() {
        return currentCol;
    }

    /**
     * @return returns one letter to represent animal
     */
    public char getLetter() {
        return name.charAt(0);
    }

    /**
     * @return returns animal's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return returns # moves animal has made in maze so far
     */
    public int getNumMoves() {
        return numMoves;
    }

    /**
     * @return returns column where animal started in maze
     */
    public int getStartColumn() {
        return startCol;
    }

    /**
     * @return returns row where animal started in maze
     */
    public int getStartRow() {
        return startRow;
    }



    /**
     * asks animal to make a move in this maze. This is called by the Maze
     * Check top desc for how rat will move
     * @param maz checks to see if we can make move in the Maze
     */
    public void move(Maze maz) {
        boolean noMoveFound = true;
        this.availableMoves = 4; //reset num moves to 4.
        //check how many legal moves we can make. If 1... for sure dead end. Go previous space
        if(!(maz.canMove(currentRow - 1, currentCol)))//check up
                this.availableMoves--;
        if (!(maz.canMove(currentRow, currentCol + 1)))//check right
                this.availableMoves--;
        if(!(maz.canMove(currentRow + 1, currentCol)))//check down
                this.availableMoves--;
        if(!(maz.canMove(currentRow, currentCol - 1)))//check left
                this.availableMoves--;
        if(this.availableMoves == 1){
            System.out.println("Deadend reached!");
            switch (this.behind) {
                case 0:
                    if (maz.canMove(currentRow - 1, currentCol)) {
                        currentRow--;                         //up
                        this.behind = 2;
                        noMoveFound = false;
                    }
                    break;
                case 1:
                    if (maz.canMove(currentRow, currentCol + 1)) {
                        currentCol++;                         //RIGHT
                        this.behind = 3;
                        noMoveFound = false;
                    }
                    break;
                case 2:
                    if (maz.canMove(currentRow + 1, currentCol)) {
                        currentRow++;                         //DOWN
                        this.behind = 0;
                        noMoveFound = false;
                    }
                    break;
                case 3:
                    if (maz.canMove(currentRow, currentCol - 1)) {
                        currentCol--;                         //Left
                        this.behind = 1;
                        noMoveFound = false;
                    }
                    break;
            }
        }
        while (noMoveFound)
            switch (rnd.nextInt(4)) {
                case 0: //Roll UP
                    if(this.behind == 0)
                        break;
                    if (maz.canMove(currentRow - 1, currentCol)) {
                        currentRow--;                         //up
                        this.behind = 2;
                        noMoveFound = false;
                    }
                    break;
                case 1: //Roll RIGHT
                    if(this.behind == 1)
                        break;
                    if (maz.canMove(currentRow, currentCol + 1)) {
                        currentCol++;                         //RIGHT
                        this.behind = 3;
                        noMoveFound = false;
                    }
                    break;
                case 2: //Roll DOWN
                    if(this.behind == 2)
                        break;
                    if (maz.canMove(currentRow + 1, currentCol)) {
                        currentRow++;                         //DOWN
                        this.behind = 0;
                        noMoveFound = false;
                    }
                    break;
                case 3: //Roll Left
                    if(this.behind == 3)
                        break;
                    if (maz.canMove(currentRow, currentCol - 1)) {
                        currentCol--;                         //Left
                        this.behind = 1;
                        noMoveFound = false;
                    }
                    break;
            }
        numMoves++;
    }

    /**
     * moves animal back to starting row/column, wipes # moves to 0
     */
    public void reset() {
        currentRow = startRow;
        currentCol = startCol;
        numMoves = 0;
    }

    /**
     * @param col sets column where animal started in maze
     */
    public void setStartColumn(int col) {
        startCol = col;
    }

    /**
     * @param row sets row where animal started in maze
     */
    public void setStartRow(int row) {
        startRow = row;
    }


}
