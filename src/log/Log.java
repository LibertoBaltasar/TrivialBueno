package log;

import utilidades.Rutas;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    private static String rutaConstruida;
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
