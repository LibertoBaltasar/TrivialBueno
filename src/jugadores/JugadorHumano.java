package jugadores;

import preguntas.PreguntaIngles;

public class JugadorHumano extends JugadorGenerico{
    int puntuacionHistorica;
    public JugadorHumano(String nombre, int puntuacionHistorica) {
        this.puntuacion =0;
        this.nombre = nombre;
        this.puntuacionHistorica = puntuacionHistorica;
    }

    public void mostrarJugadorConPuntuacion(){
        System.out.println("Nombre:" + nombre + " // Puntuacion Historica:" + puntuacionHistorica);
    }

    public void mostrarJugadorSimple(){
        System.out.println("Nombre:" + nombre);
    }
    @Override
    public void responderLengua(String respuestaCorrecta) {
        String respuestaJugador;
        System.out.println("Introduce la respuesta");
        respuestaJugador = utilidades.Metodos.pedirCadena();
        if (respuestaJugador.equals(respuestaCorrecta)) {
            System.out.println("Respuesta correcta");
            puntuacion++;
        } else {
            System.out.println("Respuesta incorrecta");
        }
    }

    @Override
    public void responderMatematicas(int respuestaCorrecta) {
        int respuestaJugador;
        System.out.println("Introduce la respuesta");
        respuestaJugador = utilidades.Metodos.pedirEntero();
        if (respuestaJugador == respuestaCorrecta) {
            System.out.println("Respuesta correcta");
            puntuacion++;
            log.Log.mensajeRespuestaCorrecta(this.getNombre(), respuestaCorrecta, respuestaJugador);
        } else {
            System.out.println("Respuesta incorrecta");
        }
    }

    @Override
    public void responderIngles(String RespuestaCorrecta, String[] posiblesRespuestas) {
        int respuestaJugadorInt;
        char respuestaJugadorChar;
        String  repuestaTeclado;
        String respuestaJugadorString;
        do {
            System.out.println("Introduce la respuesta");
            respuestaJugadorChar = utilidades.Metodos.pedirCaracter();
            respuestaJugadorInt=utilidades.Metodos.cambiarCharNumero(respuestaJugadorChar);
            if (respuestaJugadorInt==5){
                System.out.println("Introduce una respuesta válida");
            }
        }while(respuestaJugadorInt!=5);
        respuestaJugadorString=PreguntaIngles.devolverRespuestaSeleccionada(respuestaJugadorInt,posiblesRespuestas);
        if (respuestaJugadorString.equals(RespuestaCorrecta)) {
            System.out.println("Respuesta correcta");
            puntuacion++;
        } else {
            System.out.println("Respuesta incorrecta");
        }
    }
}
