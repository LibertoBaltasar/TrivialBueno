package main;

import jugadores.JugadorGenerico;
import log.Log;
import log.LogStrings;
import menus.GestionJugadores;

public class Partida {
    int numTurnos;
    JugadorGenerico[] arrayJugadores;
    String resultadoPartida;
    public Partida(int numTurnos, int numJugadores, int numJugadoresHumanos) {
        String nombreJugador;
        this.numTurnos = numTurnos;
        this.arrayJugadores = new JugadorGenerico[numJugadores];

        for (int i = 0; i < numJugadoresHumanos; i++) {
            System.out.println("Introduce el nombre de un jugador");
            nombreJugador= utilidades.Metodos.pedirCadena();
            // TODO: 07/05/2024 revisar la condición del if
            if(!menus.GestionJugadores.comprobarJugadorNoExiste(nombreJugador)){
                arrayJugadores[i]= GestionJugadores.devolverJugador(nombreJugador);
            }else{
                System.out.println("El jugador no existe, pero quieres añadirlo?");
                System.out.println("1.-Si");
                System.out.println("2.-No");
                if(utilidades.Metodos.pedirEntero()==1){
                    GestionJugadores.annadirJugador(nombreJugador);
                    arrayJugadores[i]= GestionJugadores.devolverJugador(nombreJugador);
                }else{
                    i--;
                }
            }

        }
        if (numJugadores>numJugadoresHumanos){
            int numJugadoresCPU=numJugadores-numJugadoresHumanos;
            for (int i = 0; i < numJugadoresCPU; i++){
                arrayJugadores[numJugadoresHumanos+i]=new jugadores.JugadorCpu("CPU"+(1+i));
            }
        }
        Log.escribirLog(LogStrings.mensajeCrearPartida(numTurnos, numJugadores, numJugadoresHumanos));
    }

    public void buclePartida(){
        int turnosJugados=0;
        Turno turno;
        do{
            for (int i=0; i<arrayJugadores.length;i++){
                turno=new Turno(arrayJugadores[i]);
                turno.elegirPregunta();
            }
            turnosJugados++;
        }while(turnosJugados<numTurnos);
        resultadoPartida=this.generarResultadoPartida();
        Historico.actualizarHistorico(resultadoPartida);
        GestionJugadores.actualizarRanking(arrayJugadores);
        Log.escribirLog(LogStrings.mensajeFinPartida);
    }
    private String generarResultadoPartida(){
        this.resultadoPartida="";
        for (int i=0; i<arrayJugadores.length;i++){
            System.out.println(arrayJugadores[i].getNombre()+" ha obtenido "+arrayJugadores[i].getPuntuacion()+" puntos");
            if(i!= arrayJugadores.length-1) {
                this.resultadoPartida = this.resultadoPartida + arrayJugadores[i].getNombre() + ":" + arrayJugadores[i].getPuntuacion() + " puntos//";
            }else{
            this.resultadoPartida=this.resultadoPartida+arrayJugadores[i].getNombre()+":"+arrayJugadores[i].getPuntuacion()+" puntos\n";
            }
        }
        Log.escribirLog(LogStrings.mensajeGenerarResultadoPartida(this.resultadoPartida));
        return this.resultadoPartida;

    }
}
