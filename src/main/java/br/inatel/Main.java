package br.inatel;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        /**
         *  O código demonstra como uma matriz de duas dimensões pode ser preenchida com Threads.
         *  As dimensões podem ser alteradas pelo construtor -> Grid(x, y).
         *  A matriz já vem inicializada; porém, ela pode ser reinicializada com a função init().
         *
         *  Grid: Instância responsável por criar e gerenciar uma matriz de dimensões x * y.
         *  GridFiller: Instância que implementa Runnable; ela é responsável por preencher a matriz com o caractere desejado.
         */
        Grid grid = new Grid(10, 10);

        GridFiller gf1 = new GridFiller(grid, "1");
        GridFiller gf2 = new GridFiller(grid, "2");
        GridFiller gf3 = new GridFiller(grid, "3");

        Thread t1 = new Thread(gf1);
        Thread t2 = new Thread(gf2);
        Thread t3 = new Thread(gf3);

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        grid.displayGrid();
    }
}