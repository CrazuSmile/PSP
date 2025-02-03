import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private static final Scanner TCL = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String Host = "localhost";
        int Puerto = 6000;

        System.out.println("PROGRAMA CLIENTE INICIADO...");
        Socket Cliente = new Socket(Host, Puerto);

        String producto;
        DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
        System.out.println("Introduzca producto para insertarlo en la lista de la compra: ");
        producto = TCL.next();
        TCL.nextLine();
        flujoSalida.writeUTF(producto);
        if (!producto.equalsIgnoreCase("salida")) {
            System.out.println("Se ha volcado el producto " + producto + " a la lista de la compra");
        } else {
            System.out.println("Adios");
        }

        Cliente.close();
        flujoSalida.close();
    }
}
