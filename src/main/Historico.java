package main;

import jugadores.JugadorHumano;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Historico {
    public static ArrayList<String> historico;
    public static void inicializarHistorico(){
        Path path = Paths.get(utilidades.Rutas.RUTA_HISTORICO);
        try {
            historico = (ArrayList<String>) Files.readAllLines(path);
            log.Log.mensajeInicializarHistorico();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void mostrarHistorico(){
        if(historico.isEmpty()){
            System.out.println("No hay partidas guardadas");
        }else{
            for (String linea : historico) {
                System.out.println(linea);
            }
        }
        log.Log.mensajeMostrarHistorico();
    }
    public static void guardarNuevoHistorico(){
        Path path = Paths.get(utilidades.Rutas.RUTA_HISTORICO);
        try {
            // Si el archivo existe, lo elimina
            if (Files.exists(path)) {
                Files.delete(path);
            }
            // Crea un nuevo archivo
            Files.createFile(path);
            // Escribe todas las líneas del ArrayList historico en el nuevo archivo
            Files.write(path, historico);
            log.Log.mensajeGuardarNuevoHistorico();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void actualizarHistorico(String resultadoPartida){
        historico.add(resultadoPartida);
        Historico.guardarNuevoHistorico();
    }
}
