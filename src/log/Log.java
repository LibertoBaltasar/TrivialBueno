package log;

import utilidades.Rutas;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * La clase Log se encarga de la gestión de los logs de la aplicación.
 * Cada vez que se llama a los métodos de esta clase, se escribe una entrada en el archivo de log.
 * El archivo de log se crea al inicio de la ejecución del programa y se le añaden entradas a lo largo de la ejecución.
 */
public class Log {
    private static String rutaConstruida;
    /**
     * Este método inicializa el archivo de log.
     * Crea un nuevo archivo de log con la fecha actual si no existe ya.
     */
    public static void inicializarLog() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
        String fecha = formato.format(new Date(System.currentTimeMillis()));
        rutaConstruida=Rutas.RUTA_LOG + "log." + fecha + ".txt";
        Path path = Paths.get(rutaConstruida);
        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
            } catch (Exception e) {
                System.out.println("No se puede crear el fichero log"+fecha+".txt");
            }
        }
        Log.escribirLog(LogStrings.mensajeInicializarLog, 1);
    }
    /**
     * Este método escribe un mensaje en el archivo de log.
     * Añade una nueva entrada al archivo de log con la fecha y hora actuales y el mensaje proporcionado.
     * @param mensaje El mensaje que se va a escribir en el archivo de log.
     */
    public static void escribirLog(String mensaje) {
        SimpleDateFormat formato = new SimpleDateFormat("[yyyy/MM/dd][HH:mm]");
        String fecha = formato.format(new Date(System.currentTimeMillis()));
        Path path = Paths.get(rutaConstruida);
        try {
            Files.writeString(path, fecha + " " + mensaje + "\n", StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se puede escribir en el fichero log");
        }
    }
    /**
     * Este método escribe un mensaje en el archivo de log.
     * Añade una nueva entrada al archivo de log con la fecha y hora actuales y el mensaje proporcionado.
     * Si la opción es enviada, sobrescribe el archivo de log en lugar de añadir la entrada.
     * @param mensaje El mensaje que se va a escribir en el archivo de log.
     * @param opcion La opción que determina si se debe sobrescribir el archivo de log.
     */
    public static void escribirLog(String mensaje, int opcion) {
        SimpleDateFormat formato = new SimpleDateFormat("[yyyy/MM/dd][HH:mm]");
        String fecha = formato.format(new Date(System.currentTimeMillis()));
        Path path = Paths.get(rutaConstruida);
        try {
                Files.writeString(path, fecha + " " + mensaje + "\n", java.nio.file.StandardOpenOption.WRITE);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se puede escribir en el fichero log");
        }
    }
}
