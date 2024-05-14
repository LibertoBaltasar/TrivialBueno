package main;

import jugadores.JugadorGenerico;
import log.LogStrings;
import preguntas.PreguntaGenerica;
import preguntas.PreguntaIngles;
import preguntas.PreguntaLengua;
import preguntas.PreguntaMatematica;
import utilidades.Metodos;

public class Turno {
    JugadorGenerico jugador;

    public Turno(JugadorGenerico jugador) {
        this.jugador = jugador;
        LogStrings.mensajeCrearTurno(this.jugador.getNombre());
    }

    public void elegirPregunta(){
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
        LogStrings.mensajeturnoElegirPregunta(jugador.getNombre(), tipoPregunta);
    }
}
