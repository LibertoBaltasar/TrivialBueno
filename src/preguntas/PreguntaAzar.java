package preguntas;

import log.Log;
import log.LogStrings;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import utilidades.Metodos;

public class PreguntaAzar extends PreguntaGenerica{
    @Override
    public void mostrarPregunta() {
        int respuestaCorrecta;
        System.out.println("Adivina un número del 1 al 10:");
        respuestaCorrecta= Metodos.generarNumeroAleatorio(1, 10);
        jugador.responderAzar(respuestaCorrecta);
    }
}
