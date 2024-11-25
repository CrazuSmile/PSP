public class Casilla extends Thread {

    private Hilo1 h1;
    private Hilo2 h2;
    private int[] board;


    Casilla(Hilo1 h1, Hilo2 h2) {
        this.h1 = h1;
        this.h2 = h2;
        this.board = new int[10];
    }

    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println("--------------------------------------");

        for (int i = 0; i < 5; i++) {
            board[i] = h1.getValue();
            System.out.print(board[i] + "\t");

        }
        for (int i = 9; i >= 5; i--) {
            board[i] = h2.getValue();
            System.out.print(board[i] + "\t");
        }
        System.out.println();

        for (int i = 0; i < 5; i++) {
            System.out.print(h1.getName() + "\t");

        }
        for (int i = 9; i >= 5; i--) {
            System.out.print(h2.getName() + "\t");
        }
    }
}
