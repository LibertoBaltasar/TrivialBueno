package utilidades;

import log.Log;
import log.LogStrings;
import menus.GestionJugadores;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * La clase Inicializar se encarga de dejar el programa preparado para el inicio del juego.
 */
public class Inicializar {
    /**
     * Este método inicializa varios componentes del programa.
     */
    public static void inicializar(){
        inicializarLog();
        comprobarFicheros();
        inicializarArrayJugadores();
        inicializarHistorico();
        inicializarPreguntas();
        Log.escribirLog(LogStrings.mensajeInicializarGeneral);
    }
    /**
     * Este método comprueba si los ficheros necesarios para el programa existen.
     * Si no existen, los crea.
     */
    public static void comprobarFicheros() {
        Path path = Paths.get(Rutas.RUTA_HISTORICO);
        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("No se puede crear el fichero historico.txt");
            }
        }
        path = Paths.get(Rutas.RUTA_RANKING);
        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("No se puede crear el fichero ranking.txt");
            }
        }
        Log.escribirLog(LogStrings.mensajeComprobarFicheros);
    }

    /**
     * Este método inicializa el arraylist donde se almacenan los jugadores.
     */
    private static void inicializarArrayJugadores(){
        GestionJugadores.inicializarGestionJugadores(Rutas.RUTA_RANKING);
    }
    /**
     * Este método inicializa el historico de partidas.
     */
    private static void inicializarHistorico() {
        main.Historico.inicializarHistorico();
    }
    /**
     * Este método inicializa las preguntas de los distintos tipos.
     */
    private static void inicializarPreguntas(){
        preguntas.PreguntaIngles.inicializarArrayIngles();
        preguntas.PreguntaLengua.inicializarArrayPreguntasLengua();
    }
    /**
     * Este método inicializa el log.
     */
    private static void inicializarLog(){
        Log.inicializarLog();
    }
}
