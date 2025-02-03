import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
    public static void main(String[] args) throws IOException {
        //Esperando Datagrama
        System.out.println("Servidor esperando datagrama...");
        DatagramPacket recibo;

        byte[] bufer = new byte[1024];
        recibo = new DatagramPacket(bufer, bufer.length);

        //Asocio el socket al puerto 12345 y me quedo esperando
        DatagramSocket socket = new DatagramSocket(12345);
        socket.receive(recibo);

        String mensaje = new String(recibo.toString().trim());
        System.out.println("Servidor recibe: " + mensaje);

        //Contar el numero de letras a
        int contador = 0;
        for (int i = 0; i < mensaje.length(); i++) {
            if (mensaje.charAt(i) == 'a') {
                contador++;
            }
        }

        //Direccion origen del mensaje
        InetAddress IPOrigen = recibo.getAddress();
        int puerto = recibo.getPort();

        //Enviando datagrama al cliente
        System.out.println("Enviando numero de aparaciones de la letra 'a': " + contador);
        byte b = (byte) contador;
        byte[] enviados = new byte[1024];
        enviados[0] = b;

        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
        socket.send(envio);

        //Cerrar socket
        System.out.println("Cerrando conexion...");
        socket.close();
    }
}
