package jugadores;

import log.Log;
import log.LogStrings;
import preguntas.PreguntaIngles;

import static utilidades.Constantes.*;

public class JugadorHumano extends JugadorGenerico{
    private int puntuacionHistorica;

    public JugadorHumano(String nombre, int puntuacionHistorica) {
        this.puntuacion =0;
        this.nombre = nombre;
        this.puntuacionHistorica = puntuacionHistorica;
    }

    public JugadorHumano(String nombre) {
        this.puntuacion =0;
        this.nombre = nombre;
        this.puntuacionHistorica = 0;
    }

    public int getPuntuacionHistorica() {
        return puntuacionHistorica;
    }

    public void setPuntuacionHistorica(int puntuacionHistorica) {
        this.puntuacionHistorica = puntuacionHistorica;
    }

    public void mostrarJugadorConPuntuacion(int indice){
        System.out.println(indice+".-Nombre:" + nombre + " // Puntuacion Historica:" + puntuacionHistorica);
        Log.escribirLog(LogStrings.mensajeMostrarJugadorConPuntuacion(this.getNombre(), this.getPuntuacionHistorica()));
    }

    public void mostrarJugadorSimple(int indice){
        System.out.println(indice+".-Nombre:" + nombre);
        Log.escribirLog(LogStrings.mensajeMostrarJugadorSimple(this.getNombre()));
    }
    @Override
    public void responderLengua(String respuestaCorrecta) {
        String respuestaJugador;
        System.out.println(INTRODUCE_LA_RESPUESTA);
        respuestaJugador = utilidades.Metodos.pedirCadena();
        if (respuestaJugador.equals(respuestaCorrecta)) {
            System.out.println(RESPUESTA_CORRECTA);
            puntuacion++;
            Log.escribirLog(LogStrings.mensajeRespuestaCorrecta(this.getNombre(), respuestaCorrecta, respuestaJugador));
        } else {
            System.out.println(RESPUESTA_INCORRECTA);
            Log.escribirLog(LogStrings.mensajeRespuestaIncorrecta(this.getNombre(), respuestaCorrecta, respuestaJugador));
        }
    }

    @Override
    public void responderMatematicas(int respuestaCorrecta) {
        int respuestaJugador;
        System.out.println(INTRODUCE_LA_RESPUESTA);
        respuestaJugador = utilidades.Metodos.pedirEntero();
        if (respuestaJugador == respuestaCorrecta) {
            System.out.println(RESPUESTA_CORRECTA);
            puntuacion++;
            Log.escribirLog(LogStrings.mensajeRespuestaCorrecta(this.getNombre(), ""+respuestaCorrecta, ""+respuestaJugador));
        } else {
            System.out.println(RESPUESTA_INCORRECTA);
            Log.escribirLog(LogStrings.mensajeRespuestaIncorrecta(this.getNombre(), ""+respuestaCorrecta, ""+respuestaJugador));
        }
    }

    @Override
    public void responderIngles(String RespuestaCorrecta, String[] posiblesRespuestas) {
        int respuestaJugadorInt;
        char respuestaJugadorChar;
        String  repuestaTeclado;
        String respuestaJugadorString;
        do {
            System.out.println(INTRODUCE_LA_RESPUESTA);
            respuestaJugadorChar = utilidades.Metodos.pedirCaracter();
            respuestaJugadorInt=utilidades.Metodos.cambiarCharNumero(respuestaJugadorChar);
            if (respuestaJugadorInt==5){
                System.out.println("Introduce una respuesta válida");
            }
        }while(respuestaJugadorInt==5);
        respuestaJugadorString=PreguntaIngles.devolverRespuestaSeleccionada(respuestaJugadorInt,posiblesRespuestas);
        if (respuestaJugadorString.equals(RespuestaCorrecta)) {
            System.out.println(RESPUESTA_CORRECTA);
            puntuacion++;
        } else {
            System.out.println(RESPUESTA_INCORRECTA);
        }
    }
}
