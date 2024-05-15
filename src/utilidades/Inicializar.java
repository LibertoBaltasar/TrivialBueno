package utilidades;

import log.Log;
import log.LogStrings;
import menus.GestionJugadores;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Inicializar {
    public static void inicializar(){
        comprobarFicheros();
        inicializarArrayJugadores();
        inicializarHistorico();
        inicializarPreguntas();
        inicializarLog();
        Log.escribirLog(LogStrings.mensajeInicializarGeneral);
    }
    // TODO: 07/05/2024 meter las rutas como constantes 
    public static void comprobarFicheros() {
        Path path = Paths.get(Rutas.RUTA_HISTORICO);
        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
            } catch (Exception e) {
                System.out.println("No se puede crear el fichero historico.txt");
            }
        }
        path = Paths.get(Rutas.RUTA_RANKING);
        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
            } catch (Exception e) {
                System.out.println("No se puede crear el fichero ranking.txt");
            }
        }
        Log.escribirLog(LogStrings.mensajeComprobarFicheros);
    }
    private static void inicializarArrayJugadores(){
        GestionJugadores.inicializarGestionJugadores("/ficheros/ranking/ranking.txt");
    }
    private static void inicializarHistorico() {
        main.Historico.inicializarHistorico();
    }
    private static void inicializarPreguntas(){
        preguntas.PreguntaIngles.inicializarArrayIngles();
        preguntas.PreguntaLengua.inicializarArrayPreguntasLengua();
    }
    private static void inicializarLog(){
        Log.inicializarLog();
    }
}
