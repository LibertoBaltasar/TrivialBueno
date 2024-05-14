package log;

import utilidades.Rutas;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    public static void inicializarLog() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String fecha = formato.format(new Date(System.currentTimeMillis()));
        Path path = Paths.get(Rutas.RUTA_LOG + "log" + fecha + ".txt");
        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
            } catch (Exception e) {
                System.out.println("No se puede crear el fichero historico.txt");
            }
        }
    }
    public static void escribirLog(String mensaje) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String fecha = formato.format(new Date(System.currentTimeMillis()));
        Path path = Paths.get(Rutas.RUTA_LOG + "log" + fecha + ".txt");
        try {
            Files.writeString(path, fecha + " " + mensaje + "\n");
        } catch (Exception e) {
            System.out.println("No se puede escribir en el fichero log");
        }
    }
}
