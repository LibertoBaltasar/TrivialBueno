package preguntas;

import jugadores.JugadorGenerico;
import log.Log;
import log.LogStrings;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import utilidades.Metodos;

public class PreguntaMatematica extends PreguntaGenerica{
    String pregunta;
    int respuesta;
    JugadorGenerico jugador;

    public PreguntaMatematica(JugadorGenerico jugador) {
        this.jugador = jugador;
    }

    @Override
    public void mostrarPregunta() {
        int longitud;
        Expression e;
        int numero;
        String simbolo;
        longitud=Metodos.generarNumeroAleatorio(4,8);
        this.pregunta="";
        for(int i=0; i<longitud;i++){
            if(i<longitud-1){
                numero=Metodos.generarNumeroAleatorio(2,12);
                simbolo=this.elegirSimbolo(Metodos.generarNumeroAleatorio(1,3));
                this.pregunta=this.pregunta+numero+simbolo;
            }else{
                this.pregunta=this.pregunta+Metodos.generarNumeroAleatorio(2,12);
            }
        }
        e=new ExpressionBuilder(this.pregunta).build();
        this.respuesta=(int) e.evaluate();
        System.out.println("Resuelve la siguiente operación: "+this.pregunta);
        Log.escribirLog(LogStrings.mensajeMostrarPreguntaMatematica);
        this.jugador.responderMatematicas(this.respuesta);
    }

    private String elegirSimbolo(int simbolo){
        String elegirSimbolo="";
        switch (simbolo){
            case 1:
                elegirSimbolo="+";
                break;
            case 2:
                elegirSimbolo="-";
                break;
            case 3:
                elegirSimbolo="*";
                break;
        }
        Log.escribirLog(LogStrings.mensajeElegirSimbolo(elegirSimbolo));
        return elegirSimbolo;
    }
}
