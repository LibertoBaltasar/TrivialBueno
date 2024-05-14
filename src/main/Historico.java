package main;

import log.LogStrings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Historico {
    public static ArrayList<String> historico;
    public static void inicializarHistorico(){
        Path path = Paths.get(utilidades.Rutas.RUTA_HISTORICO);
        try {
            historico = (ArrayList<String>) Files.readAllLines(path);
            LogStrings.mensajeInicializarHistorico();
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
        LogStrings.mensajeMostrarHistorico();
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
            LogStrings.mensajeGuardarNuevoHistorico();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void actualizarHistorico(String resultadoPartida){
        historico.add(resultadoPartida);
        Historico.guardarNuevoHistorico();
        //TODO CREAR LOG
    }
}
