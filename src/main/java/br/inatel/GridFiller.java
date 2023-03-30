package br.inatel;

public class GridFiller implements Runnable {
    private Grid grid;
    private String character;
    private int iterationLimit;

    public GridFiller(Grid grid, String character) {
        this.grid = grid;
        this.character = character;
        this.iterationLimit = grid.getX() * grid.getY();
    }

    @Override
    public void run() {
        for(int i = 0; i < iterationLimit; i++){
            if(!grid.insertCharIntoGrid(character)){
                break;
            } else{
                System.out.println(Thread.currentThread().getName() + " inserindo caractere " + character + " na posição (" + grid.getCurrentX() + ", " + grid.getCurrentY() + ").");
            }
        }

    }

}
