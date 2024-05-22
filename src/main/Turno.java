package main;

import jugadores.JugadorGenerico;
import log.Log;
import log.LogStrings;
import preguntas.PreguntaGenerica;
import preguntas.PreguntaIngles;
import preguntas.PreguntaLengua;
import preguntas.PreguntaMatematica;
import utilidades.Metodos;
/**
 * La clase Turno se encarga de la gestión de los turnos de una partida.
 */
public class Turno {
    private JugadorGenerico jugador;
    /**
     * La clase Turno se encarga de la gestión de los turnos de una partida.
     * Cada vez que se llama a los métodos de esta clase, se actualiza el estado del turno.
     */
    public Turno(JugadorGenerico jugador) {
        this.jugador = jugador;
        Log.escribirLog(LogStrings.mensajeCrearTurno(this.jugador.getNombre()));
    }
    /**
     * Este método permite al jugador elegir una pregunta.
     * Genera una pregunta de un tipo aleatorio y la muestra al jugador.
     */
    public void elegirPregunta(){
        System.out.println("Turno de "+jugador.getNombre());
        int tipoPregunta;
        PreguntaGenerica pregunta;
        tipoPregunta=Metodos.generarNumeroAleatorio(1,3);
        switch(tipoPregunta){
            case 2:
                pregunta=new PreguntaLengua(jugador);
                break;
            case 3:
                pregunta=new PreguntaIngles(jugador);
                break;
            default:
                pregunta=new PreguntaMatematica(jugador);
                break;
        }
        pregunta.mostrarPregunta();
        Log.escribirLog(LogStrings.mensajeTurnoElegirPregunta(jugador.getNombre(), tipoPregunta));
    }
}
