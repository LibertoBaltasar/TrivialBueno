package preguntas;

import jugadores.JugadorGenerico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PreguntaLengua extends PreguntaGenerica{
    JugadorGenerico jugador;
    public static ArrayList<String> preguntas;

    public PreguntaLengua(JugadorGenerico jugador) {
        this.jugador = jugador;
    }

    public static void inicializarArrayPreguntasLengua(){
        preguntas = new ArrayList<>();
        Path path = Paths.get(utilidades.Rutas.RUTA_LENGUA);
        try {
            preguntas = (ArrayList<String>) Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    @Override
    public void mostrarPregunta() {
        //TODO: 07/05/2024 pulir mensaje mostrado
        int numeroPregunta;
        String respuestaCorrecta;
        String preguntaMostrada;
        int[] letrasOcultas;
        numeroPregunta = utilidades.Metodos.generarNumeroAleatorio(0, preguntas.size());
        respuestaCorrecta = preguntas.get(numeroPregunta);
        letrasOcultas =new int[respuestaCorrecta.length()/3];
        letrasAOcultar(respuestaCorrecta,letrasOcultas);
        preguntaMostrada=formatearPregunta(respuestaCorrecta,letrasOcultas);
        System.out.println(preguntaMostrada);
        this.jugador.responderLengua(respuestaCorrecta);

    }
    private void letrasAOcultar(String respuestaCorrecta, int[] letrasOcultas){
        int longitud;
        int cantidadLetras;
        int letraNueva;
        longitud=respuestaCorrecta.length();
        cantidadLetras=longitud/3;
        for(int i=0;i<cantidadLetras;i++){
            //TODO: 07/05/2024 ver como afinar los índices del array
            //empiezo en uno y termino en longitud+1 para evitar el valor por defecto del array
            letraNueva=utilidades.Metodos.generarNumeroAleatorio(1,longitud);
            for(int j=0;j<letrasOcultas.length;j++){
                if(letrasOcultas[j]==letraNueva){
                    letraNueva=-1;
                }
            }
            if(letraNueva!=-1) {
                letrasOcultas[i] = letraNueva;
            }
        }
    }
    public String formatearPregunta(String respuestaCorrecta, int[] letrasOcultas){
        String preguntaFormateada;
        char[] respuestaArray;
        respuestaArray=respuestaCorrecta.toCharArray();
        for(int i=0;i<respuestaArray.length;i++){
            for(int j=0;j<letrasOcultas.length;j++){
                if(i==letrasOcultas[j]-1){
                    respuestaArray[i]='_';
                }
            }
        }
        preguntaFormateada=String.valueOf(respuestaArray);
        return preguntaFormateada;
    }
}
