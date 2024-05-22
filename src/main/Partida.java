package main;

import jugadores.JugadorGenerico;
import log.Log;
import log.LogStrings;
import menus.GestionJugadores;
/**
 * La clase Partida se encarga de la gestión de las partidas del juego.
 */
public class Partida {
    int numTurnos;
    JugadorGenerico[] arrayJugadores;
    String resultadoPartida;
    /**
     * Este constructor inicializa una nueva partida.
     * Crea un array de jugadores y establece el número de turnos de la partida.
     * @param numTurnos El número de turnos de la partida.
     * @param numJugadores El número total de jugadores en la partida.
     * @param numJugadoresHumanos El número de jugadores humanos en la partida.
     */
    public Partida(int numTurnos, int numJugadores, int numJugadoresHumanos) {
        String nombreJugador;
        this.numTurnos = numTurnos;
        this.arrayJugadores = new JugadorGenerico[numJugadores];

        for (int i = 0; i < numJugadoresHumanos; i++) {
            System.out.println("Introduce el nombre de un jugador");
            nombreJugador= utilidades.Metodos.pedirCadena();
            /*if(!menus.GestionJugadores.comprobarJugadorNoExiste(nombreJugador)){
                arrayJugadores[i]= GestionJugadores.devolverJugador(nombreJugador);
            }else{
                System.out.println("El jugador no existe.¿Quieres añadirlo?");
                System.out.println("1.-Si");
                System.out.println("2.-No");
                if(utilidades.Metodos.pedirEntero()==1){
                    GestionJugadores.annadirJugador(nombreJugador);
                    arrayJugadores[i]= GestionJugadores.devolverJugador(nombreJugador);
                }else{
                    i--;
                }
             */
            if (GestionJugadores.comprobarNombreValido(nombreJugador)){
                if(GestionJugadores.comprobarJugadorExiste(nombreJugador)) {
                    arrayJugadores[i] = GestionJugadores.devolverJugador(nombreJugador);
                }else{
                    System.out.println("El jugador no existe. ¿Quieres añadirlo?");
                    System.out.println("1.-Si");
                    System.out.println("2.-No");
                    if(utilidades.Metodos.pedirEntero()==1){
                        GestionJugadores.annadirJugador(nombreJugador);
                        arrayJugadores[i]= GestionJugadores.devolverJugador(nombreJugador);
                    }else{
                        i--;
                    }
                }
            }else{
                System.out.println("El nombre introducido no es válido. Introduce un nombre válido");
                i--;
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
    /**
     * Este método gestiona el bucle principal de la partida.
     * Crea un nuevo turno para cada jugador en cada ronda hasta que se alcanza el número de turnos.
     */
    public void buclePartida(){
        int turnosJugados=0;
        Turno turno;
        do{
            System.out.println("Ronda: "+ (turnosJugados+1));
            for (int i=0; i<arrayJugadores.length;i++){
                turno=new Turno(arrayJugadores[i]);
                turno.elegirPregunta();
            }
            System.out.println("Fin de la ronda");
            turnosJugados++;
        }while(turnosJugados<numTurnos);
        resultadoPartida=this.generarResultadoPartida();
        Historico.actualizarHistorico(resultadoPartida);
        GestionJugadores.actualizarRanking(arrayJugadores);
        Log.escribirLog(LogStrings.mensajeFinPartida);
    }
    /**
     * Este método genera el resultado de la partida.
     * Imprime la puntuación de cada jugador en la partida.
     * @return Un String con el resultado de la partida.
     */
    private void generarResutltadoRonda(){
        for (int i=0; i<arrayJugadores.length;i++) {
            System.out.println(arrayJugadores[i].getNombre() + " ha obtenido " + arrayJugadores[i].getPuntuacion() + " puntos");
        }
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
