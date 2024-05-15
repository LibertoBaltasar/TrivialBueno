package main;

import log.Log;
import log.LogStrings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
/**
 * La clase Historico se encarga de la gestión del historial de partidas.
 * Cada vez que se llama a los métodos de esta clase, se actualiza el historial de partidas.
 */
public class Historico {
    /**
     * Este método inicializa el historial de partidas.
     * Carga el historial de partidas desde un archivo si existe.
     */
    public static ArrayList<String> historico;
    public static void inicializarHistorico(){
        Path path = Paths.get(utilidades.Rutas.RUTA_HISTORICO);
        try {
            historico = (ArrayList<String>) Files.readAllLines(path);
            Log.escribirLog(LogStrings.mensajeInicializarHistorico);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    /**
     * Este método muestra el historial de partidas.
     * Imprime todas las partidas guardadas en el historial.
     */
    public static void mostrarHistorico(){
        if(historico.isEmpty()){
            System.out.println("No hay partidas guardadas");
        }else{
            for (String linea : historico) {
                System.out.println(linea);
            }
        }
        Log.escribirLog(LogStrings.mensajeMostrarHistorico);
    }
    /**
     * Este método inicializa el historial de partidas.
     * Carga el historial de partidas desde un archivo si existe.
     */
    private static void guardarNuevoHistorico(){
        Path path = Paths.get(utilidades.Rutas.RUTA_HISTORICO);
        String lineaAIntroducir;
        try {
            if (Files.exists(path)) {
                Files.delete(path);
            }
            Files.createFile(path);

            for (int i = 0; i < historico.size(); i++) {
                lineaAIntroducir= historico.get(i)+"\n";

                if (i == 0) {
                    Files.write(path, lineaAIntroducir.getBytes(), StandardOpenOption.WRITE);
                }else{
                    Files.write(path, lineaAIntroducir.getBytes(), StandardOpenOption.APPEND);
                }
            }
            Log.escribirLog(LogStrings.mensajeGuardarNuevoHistorico);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Este método actualiza el historial de partidas.
     * Añade el resultado de una partida al historial y guarda el historial actualizado.
     * @param resultadoPartida El resultado de la partida que se va a añadir al historial.
     */
    public static void actualizarHistorico(String resultadoPartida){
        historico.add(resultadoPartida);
        Historico.guardarNuevoHistorico();
        Log.escribirLog(LogStrings.mensajeActualizarHistorico(resultadoPartida));
    }
}
