package preguntas;

import jugadores.JugadorGenerico;
import log.Log;
import log.LogStrings;
import utilidades.Rutas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PreguntaIngles extends PreguntaGenerica{
    JugadorGenerico jugador;
    public static ArrayList<String> preguntas;

    public PreguntaIngles(JugadorGenerico jugador) {
        this.jugador = jugador;
    }

    public static void inicializarArrayIngles(){
        preguntas = new ArrayList<>();
        Path path = Paths.get(Rutas.RUTA_INGLES);
        try {
            preguntas = (ArrayList<String>) Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        Log.escribirLog(LogStrings.mensajeInicializarArrayIngles);
    }
    @Override
    public void mostrarPregunta() {
        int preguntaElegida;
        String respuestaCorrecta;
        String[] posiblesRespuestas= new String[4];
        int numCambios=utilidades.Metodos.generarNumeroAleatorio(4,10);
        do {
            preguntaElegida = utilidades.Metodos.generarNumeroAleatorio(0, preguntas.size() / 5);
        }while(preguntaElegida*5>=preguntas.size());
        preguntaElegida=preguntaElegida*5;
        respuestaCorrecta = preguntas.get(preguntaElegida+1);
        for(int i=0;i<4;i++){
            posiblesRespuestas[i]=preguntas.get(preguntaElegida+1+i);
        }
        this.desordenarRespuestas(posiblesRespuestas);
        System.out.println("Pregunta: "+ preguntas.get(preguntaElegida));
        for(int i=0;i<4;i++){
            System.out.println(utilidades.Metodos.cambiarNumeroChar(i+1)+".- "+posiblesRespuestas[i]);
        }
        Log.escribirLog(LogStrings.mensajeMostrarPreguntaIngles);
        this.jugador.responderIngles(respuestaCorrecta, posiblesRespuestas);
    }

    private void desordenarRespuestas(String[] posiblesRespuestas){
        String respuestaDesordenada;
        int posicion2;
        int posicion1;
        int numCambios=utilidades.Metodos.generarNumeroAleatorio(4,10);
        for(int i=0;i<numCambios;i++){
            posicion1=utilidades.Metodos.generarNumeroAleatorio(0,3);
            posicion2=utilidades.Metodos.generarNumeroAleatorio(0,3);
            respuestaDesordenada=posiblesRespuestas[posicion1];
            posiblesRespuestas[posicion1]=posiblesRespuestas[posicion2];
            posiblesRespuestas[posicion2]=respuestaDesordenada;
        }
        Log.escribirLog(LogStrings.mensajeDesordenarRespuestas(numCambios));
    }
    public static String devolverRespuestaSeleccionada(int numeroRespuesta, String respuestasPosibles[]){
        System.out.println("Respuesta seleccionada: "+ respuestasPosibles[numeroRespuesta]);
        Log.escribirLog(LogStrings.mensajeDevolverRespuestaSeleccionada);
        return respuestasPosibles[numeroRespuesta];
    }
}
