import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Servidor {
    public static void main(String[] args) throws IOException {
        int numeroPuerto = 6000;
        Socket clienteConectado = null;
        ServerSocket servidor = new ServerSocket(numeroPuerto);

        BufferedWriter buffer = null;
        DataInputStream flujoEntrada = null;
        String linea;
        File directorio = new File("./output/");
        if (!directorio.exists()) {
            directorio.mkdirs();
        }
        do {
            System.out.println("Esperando al cliente...");
            clienteConectado = servidor.accept();

            String titulo = calcula_timestap();

            //Crear Archivo
            File listaCompra = new File(directorio, titulo + ".txt");

            InputStream entrada = null;
            entrada = clienteConectado.getInputStream();
            flujoEntrada = new DataInputStream(entrada);

            FileWriter escritor = new FileWriter(listaCompra, true);
            buffer = new BufferedWriter(escritor);

            //Sobreescribir archivo
            linea = flujoEntrada.readUTF();
            if (!linea.equalsIgnoreCase("Salida")) {
                buffer.write(linea + "\n");
                System.out.println("Producto recibido: " + linea);
                buffer.flush();
            }

            flujoEntrada.close();
            clienteConectado.close();
        } while ((!linea.equalsIgnoreCase("salida")));

        buffer.close();
        servidor.close();
        System.out.println("La conexion ha finalizado");
    }

    public static String calcula_timestap() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String cadena = dateFormat.format(new Date());
        cadena = cadena.substring(0, 10);
        return cadena;
    }
}