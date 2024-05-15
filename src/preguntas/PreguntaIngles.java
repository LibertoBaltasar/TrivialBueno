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
/**
 * La clase PreguntaIngles se encarga de la gestión de las preguntas en inglés.
 * Extiende de la clase abstracta PreguntaGenerica.
 */
public class PreguntaIngles extends PreguntaGenerica{
    JugadorGenerico jugador;
    public static ArrayList<String> preguntas;
    /**
     * Este constructor inicializa una nueva pregunta en inglés.
     * Asigna el jugador que va a responder esta pregunta.
     * @param jugador El jugador que va a responder esta pregunta.
     */
    public PreguntaIngles(JugadorGenerico jugador) {
        this.jugador = jugador;
    }
    /**
     * Este método inicializa el array de preguntas en inglés.
     * Carga las preguntas desde un archivo si existe.
     */
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
    /**
     * Este método muestra la pregunta en inglés.
     * Genera una pregunta de inglés y la muestra al jugador.
     */
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
    /**
     * Este método desordena las respuestas posibles a la pregunta.
     * @param posiblesRespuestas Las respuestas posibles a la pregunta.
     */
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
    /**
     * Este método devuelve la respuesta seleccionada por el jugador.
     * @param numeroRespuesta El número de la respuesta seleccionada por el jugador.
     * @param respuestasPosibles Las respuestas posibles a la pregunta.
     * @return La respuesta seleccionada por el jugador.
     */
    public static String devolverRespuestaSeleccionada(int numeroRespuesta, String respuestasPosibles[]){
        System.out.println("Respuesta seleccionada: "+ respuestasPosibles[numeroRespuesta]);
        Log.escribirLog(LogStrings.mensajeDevolverRespuestaSeleccionada);
        return respuestasPosibles[numeroRespuesta];
    }
}
