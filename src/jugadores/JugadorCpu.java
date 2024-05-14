package jugadores;

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
        LogStrings.mensajeRespuestaIncorrecta(this.getNombre(), respuestaCorrecta, respuestaJugador);
    }

    @Override
    public void responderMatematicas(int respuesta) {
        System.out.println("Su respuesta es: " + respuesta);
        this.puntuar();
        LogStrings.mensajeRespuestaCorrecta(this.getNombre(), respuesta, respuesta);
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
        }else{
            System.out.println("Respuesta escogida: " + posiblesRespuestasImpresas[respuestaCpu]);
            System.out.println("Respuesta incorrecta");
        }
        //TODO: 07/05/2024 añadir mensaje de log
    }
}
