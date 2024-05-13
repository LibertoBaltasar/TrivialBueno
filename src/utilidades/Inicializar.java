package utilidades;

import menus.GestionJugadores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Inicializar {
    public static void inicializar(){
        comprobarFicheros();
        inicializarArrayJugadores();
        inicializarHistorico();
        inicializarPreguntas();
    }
    // TODO: 07/05/2024 meter las rutas como constantes 
    public static void comprobarFicheros() {
        Path path = Paths.get("ficheros/historico/historico.txt");
        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
            } catch (Exception e) {
                System.out.println("No se puede crear el fichero historico.txt");
            }
        }
        path = Paths.get("ficheros/ranking/ranking.txt");
        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
            } catch (Exception e) {
                System.out.println("No se puede crear el fichero ranking.txt");
            }
        }
        log.Log.mensajeComprobarFicheros();
    }
    public static void inicializarArrayJugadores(){
        GestionJugadores.inicializarGestionJugadores("/ficheros/ranking/ranking.txt");
    }
    public static void inicializarHistorico() {
        main.Historico.inicializarHistorico();
    }
    public static void inicializarPreguntas(){
        preguntas.PreguntaIngles.inicializarArrayIngles();
        preguntas.PreguntaLengua.inicializarArrayPreguntasLengua();
    }
}
