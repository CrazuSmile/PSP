import java.util.Scanner;

public class Main {
    private static final Scanner TCL = new Scanner(System.in);
    public static void main(String[] args) {
        Runnable hilo1 = () -> {
            for (int i = 0; i <= 100; i++){
                if (i%2 == 0){
                    System.out.println(i);
                }
                try {
                    Thread.sleep(3000);
                } catch (Exception e){}
            }
        };
        Runnable hilo2 = () -> {
            for (int i = 1; i <= 3; i++){
                String frase = TCL.nextLine();
                System.out.println("Has escrito: "+frase+" ("+i+"/3)");
            }
        };

        Thread t1 = new Thread(hilo1);
        Thread t2 = new Thread(hilo2);
        t1.start();
        t2.start();
    }
}