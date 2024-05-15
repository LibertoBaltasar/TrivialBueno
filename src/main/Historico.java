package main;

import log.Log;
import log.LogStrings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Historico {
    //TODO Probar a opner privado el array
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
    public static void guardarNuevoHistorico(){
        Path path = Paths.get(utilidades.Rutas.RUTA_HISTORICO);
        try {
            if (Files.exists(path)) {
                Files.delete(path);
            }
            Files.createFile(path);

            for (int i = 0; i < historico.size(); i++) {

                if (i == 0) {
                    Files.write(path, historico.get(i).getBytes(), StandardOpenOption.WRITE);
                }else{
                    Files.write(path, historico.get(i).getBytes(), StandardOpenOption.APPEND);
                }
            }
            Log.escribirLog(LogStrings.mensajeGuardarNuevoHistorico);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void actualizarHistorico(String resultadoPartida){
        historico.add(resultadoPartida);
        Historico.guardarNuevoHistorico();
        Log.escribirLog(LogStrings.mensajeActualizarHistorico(resultadoPartida));
    }
}
