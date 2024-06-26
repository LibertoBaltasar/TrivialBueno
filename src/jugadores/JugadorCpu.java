package jugadores;

import log.Log;
import log.LogStrings;

public class JugadorCpu extends JugadorGenerico{
    public JugadorCpu(String nombre) {
        this.puntuacion = 0;
        this.nombre = nombre;
    }
    @Override
    public void responderLengua( String respuestaCorrecta) {
        String respuestaJugador = "";
        for (int i = 0; i < respuestaCorrecta.length(); i++) {
            respuestaJugador+=('a');
        }
        if (respuestaJugador.equals(respuestaCorrecta)) {
            respuestaJugador = respuestaJugador.substring(0, respuestaJugador.length() - 1) + 'o';
        }
        System.out.println("Respuesta incorrecta");
        this.fallar();
        Log.escribirLog(LogStrings.mensajeRespuestaIncorrecta(this.getNombre(), respuestaCorrecta, respuestaJugador));
    }

    @Override
    public void responderMatematicas(int respuesta) {
        System.out.println("Su respuesta es: " + respuesta);
        this.puntuar();
        Log.escribirLog(LogStrings.mensajeRespuestaCorrecta(this.getNombre(), ""+respuesta, ""+respuesta));
    }

    @Override
    public void responderIngles(String respuestaCorrecta, String[] posiblesRespuestas){
        char[] posiblesRespuestasImpresas={'a','b','c','d'};
        int respuestaCpu=utilidades.Metodos.generarNumeroAleatorio(0,3);
        String respuestaCpuString = posiblesRespuestas[respuestaCpu];
        if (respuestaCpuString.equals(respuestaCorrecta)){
            System.out.println("Respuesta escogida: " + posiblesRespuestasImpresas[respuestaCpu]);
            System.out.println("Respuesta correcta");
            this.puntuar();
            Log.escribirLog(LogStrings.mensajeRespuestaCorrecta(this.getNombre(), respuestaCorrecta, respuestaCpuString));
        }else{
            System.out.println("Respuesta escogida: " + posiblesRespuestasImpresas[respuestaCpu]);
            System.out.println("Respuesta incorrecta");
            this.fallar();
            Log.escribirLog(LogStrings.mensajeRespuestaIncorrecta(this.getNombre(), respuestaCorrecta, respuestaCpuString));
        }
    }

    @Override
    public void responderAzar(int respuestaCorrecta) {
        int respuestaCpu = utilidades.Metodos.generarNumeroAleatorio(1,10);
        System.out.println("Respuesta escogida: " + respuestaCpu);
        if (respuestaCpu == respuestaCorrecta) {
            System.out.println("Respuesta correcta");
            this.puntuar();
            Log.escribirLog(LogStrings.mensajeRespuestaCorrecta(this.getNombre(), ""+respuestaCorrecta, ""+respuestaCpu));
        } else {
            System.out.println("Respuesta incorrecta");
            this.fallar();
            Log.escribirLog(LogStrings.mensajeRespuestaIncorrecta(this.getNombre(), ""+respuestaCorrecta, ""+respuestaCpu));
        }
    }
}
