/**
 * Name: Saul Ouellet
 * Date: Mar 8th 2022
 * Description: Program takes a pre-made Maze class and Animal interface to create new Rat classes
 * that will traverse the Maze in various ways. This program implements a WallHuggerRat and
 * a RandomRat.
 */
/**
 * WallHuggerRat always goes right. Keeps track of an orientation that determines where the
 * rat will try to go. Priority of move goes counterclockwise relative to the orientation.
 */
public class WallHuggerRat implements Animal {

    // constructors

    /**
     * Constructor
     */
    public WallHuggerRat() {
    }


    int startCol = 0;
    int startRow = 0;
    int currentCol = 0;
    int currentRow = 0;
    String name = "Wally";
    int numMoves = 0;
    int orientation = 0; //0 = Up, 1 = Down, 2 = Left, 3 = Right

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

        while (noMoveFound)
            switch (orientation) {  //switch case based off of orientation.
                case 0:                //when starting facing UP: Right->Up->Left->Down
                    if (maz.canMove(currentRow, currentCol + 1)) {
                        currentCol++;                         //RIGHT
                        this.orientation = 3; //face right
                        noMoveFound = false;
                        break;
                    }
                    if (maz.canMove(currentRow - 1, currentCol)) {
                        currentRow--;                         //UP
                        this.orientation = 0;
                        noMoveFound = false;
                        break;
                    }
                    if (maz.canMove(currentRow, currentCol - 1)) {
                        currentCol--;                         //LEFT
                        this.orientation = 2; //face left
                        noMoveFound = false;
                        break;
                    }
                    if (maz.canMove(currentRow + 1, currentCol)) {
                        currentRow++;                         //DOWN
                        this.orientation = 1; //face down
                        noMoveFound = false;
                        break;
                    }
                case 1:            //when starting facing DOWN: Left->Down->Right->Up
                    if (maz.canMove(currentRow, currentCol - 1)) {
                        currentCol--;                         //Left
                        this.orientation = 2;
                        noMoveFound = false;
                        break;
                    }
                    if (maz.canMove(currentRow + 1, currentCol)) {
                        currentRow++;                         //DOWN
                        this.orientation = 1;
                        noMoveFound = false;
                        break;
                    }
                    if (maz.canMove(currentRow, currentCol + 1)) {
                        currentCol++;                         //RIGHT
                        this.orientation = 3;
                        noMoveFound = false;
                        break;
                    }
                    if (maz.canMove(currentRow - 1, currentCol)) {
                        currentRow--;                         //UP
                        this.orientation = 0;
                        noMoveFound = false;
                        break;
                    }
                case 2:             //when starting facing Left: Up->Left->Down->Right
                    if (maz.canMove(currentRow - 1, currentCol)) {
                        currentRow--;                         //UP
                        this.orientation = 0;
                        noMoveFound = false;
                        break;
                    }
                    if (maz.canMove(currentRow, currentCol - 1)) {
                        currentCol--;                         //Left
                        this.orientation = 2;
                        noMoveFound = false;
                        break;
                    }
                    if (maz.canMove(currentRow + 1, currentCol)) {
                        currentRow++;                         //DOWN
                        this.orientation = 1;
                        noMoveFound = false;
                        break;
                    }
                    if (maz.canMove(currentRow, currentCol + 1)) {
                        currentCol++;                         //RIGHT
                        this.orientation = 3;
                        noMoveFound = false;
                        break;
                    }
                case 3: //when starting facing RIGHT: Down->Right->Up->Left
                    if (maz.canMove(currentRow + 1, currentCol)) {
                        currentRow++;                         //DOWN
                        this.orientation = 1;
                        noMoveFound = false;
                        break;
                    }
                    if (maz.canMove(currentRow, currentCol + 1)) {
                        currentCol++;                         //RIGHT
                        this.orientation = 3;
                        noMoveFound = false;
                        break;
                    }
                    if (maz.canMove(currentRow - 1, currentCol)) {
                        currentRow--;                         //UP
                        this.orientation = 0;
                        noMoveFound = false;
                        break;
                    }
                    if (maz.canMove(currentRow, currentCol - 1)) {
                        currentCol--;                         //Left
                        this.orientation = 2;
                        noMoveFound = false;
                        break;
                    }
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


