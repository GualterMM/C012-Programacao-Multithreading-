package br.inatel;

public class Grid {
    private int x, y;
    private int currentX, currentY;
    boolean insertInUse;
    private String[][] grid;

    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
        this.grid = new String[x][y];
        this.insertInUse = false;
        this.init();
    }

    public void init(){
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                grid[i][j] = "-";
            }

        }

        currentX = 0;
        currentY = 0;
    }

    public void displayGrid(){
        for(int i = 0; i < y; i++){
            System.out.print("| ");

            for(int j = 0; j < x; j++){
                System.out.print(grid[j][i] + " | ");
            }

            System.out.println("\n");
        }
    }

    public boolean insertCharIntoGrid(String character){
        if(!insertInUse){
            insertInUse = true;
            grid[currentX][currentY] = character;
            if(!isFull()){
                if(currentX + 1 >= x){
                    currentX = 0;
                    currentY++;
                } else{
                    currentX++;
                }

                insertInUse = false;
                return true;
            }
        }
        return false;
    }

    public boolean isFull(){
        if(currentX + 1 >= x && currentY + 1 >= y){
            return true;
        }

        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }
}
