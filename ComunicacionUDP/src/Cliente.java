import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //Datos del Servidor al que enviar mensaje
        InetAddress IPServidor = InetAddress.getLocalHost();
        int puerto = 12345;

        //Introducir datos por teclado
        System.out.println("Introduce mensaje: ");
        String cadena = sc.nextLine();

        byte[] enviados = new byte[1024];
        enviados = cadena.getBytes();

        //Creamos el datagrama que ira al servidor
        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);

        //Realizamos el envio
        DatagramSocket clientSocket = new DatagramSocket(34567);
        clientSocket.send(envio);

        //Recibiendo datagrama del servidor
        byte[] recibidos = new byte[2];
        DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
        System.out.println("Esperando datagrama...");
        clientSocket.receive(recibo);

        //Obtener el numero de caracteres
        byte[] vector_bytes = recibo.getData();
        int numero = vector_bytes[0];
        System.out.println("Recibo numero de caracteres 'a' que son: " + numero);

        clientSocket.close();
    }
}
