import java.util.Scanner;

public class Principal {
    private static final Scanner TLC = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduzca limite inferior: ");
        int lowLimit = TLC.nextInt();
        TLC.nextLine();

        System.out.println("Introduzca limite superior: ");
        int highLimit = TLC.nextInt();
        TLC.nextLine();

        Hilo1 h1 = new Hilo1("1", lowLimit, highLimit);
        Hilo2 h2 = new Hilo2("2", lowLimit, highLimit);

        Casilla board = new Casilla(h1, h2);

        board.start();
    }
}
