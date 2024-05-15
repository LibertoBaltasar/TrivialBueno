package menus;

import log.Log;
import log.LogStrings;
import main.Partida;

import static utilidades.Constantes.OPCION_NO_VALIDA;
/**
 * La clase MenuPartidaOpciones se encarga de la gestión del menú de opciones de la partida.
 */
public class MenuPartidaOpciones implements MenuGenerico{
    int opcion;
    int numJugadores;
    int numJugadoresHumanos;
    int numTurnos;
    Partida partida;
    /**
     * Este método muestra el menú de opciones de la partida.
     * Permite al usuario seleccionar una opción para configurar la partida.
     */
    @Override
    public void mostrarMenu() {
        do {
            this.elegirTipoPartida();
            if(opcion!=5){
                this.elegirNumeroJugadores();
                this.elegirNumeroJugadoresHumanos();
                this.numTurnos= obtenerNumeroDeTurnos(opcion);
                this.gestionarOpcion();
            }
            Log.escribirLog(LogStrings.mensajemenuPartidaOpciones(this.numJugadores,this.numJugadoresHumanos,this.opcion));
            LogStrings.mensajemenuPartidaOpciones(this.numJugadores,this.numJugadoresHumanos,this.opcion);
        }while(this.opcion!=5);
    }
    /**
     * Este método gestiona la opción seleccionada por el usuario.
     * Ejecuta la acción correspondiente a la opción seleccionada por el usuario.
     */
    @Override
    public void gestionarOpcion() {
        this.partida=new Partida(this.numTurnos,this.numJugadores,this.numJugadoresHumanos);
        partida.buclePartida();
    }
    /**
     * Este método obtiene el número de turnos basado en la opción seleccionada.
     * @param opcion La opción seleccionada por el usuario.
     * @return El número de turnos correspondiente a la opción seleccionada.
     */
    private int obtenerNumeroDeTurnos(int opcion) {
        switch (opcion) {
            case 1:
                Log.escribirLog(LogStrings.mensajeObtenerNumeroTurnos(3));
                return 3;
            case 2:
                Log.escribirLog(LogStrings.mensajeObtenerNumeroTurnos(5));
                return 5;
            case 3:
                Log.escribirLog(LogStrings.mensajeObtenerNumeroTurnos(10));
                return 10;
            case 4:
                Log.escribirLog(LogStrings.mensajeObtenerNumeroTurnos(20));
                return 20;
            default:
                Log.escribirLog(LogStrings.mensajeObtenerNumeroTurnos(0));
                return 0;
            }

    }
    /**
     * Este método permite al usuario elegir el tipo de partida.
     */
    private void elegirTipoPartida(){
        do {
            System.out.println("Introduce un número para seleccionar la opción deseada");
            System.out.println("1.-Partida Rápida(3 turnos)");
            System.out.println("2.-Partida Corta(5 turnos)");
            System.out.println("3.-Partida Normal(10 turnos)");
            System.out.println("4.-Partida Larga(20 turnos)");
            System.out.println("5.-Salir");
            opcion = utilidades.Metodos.pedirEntero();
            if (opcion < 1 || opcion > 5) {
                System.out.println(OPCION_NO_VALIDA);
            }
        }while(opcion<1|| opcion>5);
        Log.escribirLog(LogStrings.mensajeElegirTipoPartida(opcion));
    }
    /**
     * Este método permite al usuario elegir el número de jugadores.
     */
    private void elegirNumeroJugadores(){
        do {
            System.out.println("¿Cuántos jugadores van a jugar?(Introduce un número de 1 a 4)");
            numJugadores = utilidades.Metodos.pedirEntero();
            if (numJugadores < 1 || numJugadores > 5) {
                System.out.println("Introduce un número de jugadores válido");
            }
        }while (numJugadores < 1 || numJugadores > 5) ;
        Log.escribirLog(LogStrings.mensajeElegirNumerosJugadores(numJugadores));
    }
    /**
     * Este método permite al usuario elegir el número de jugadores humanos.
     */
    private void elegirNumeroJugadoresHumanos(){
        do {
            System.out.println("¿Cuántos jugadores humanos van a jugar?(Introduce un número de 0 a "+numJugadores+")");
            numJugadoresHumanos = utilidades.Metodos.pedirEntero();
            if (numJugadoresHumanos < 0 || numJugadoresHumanos > numJugadores) {
                //todo: 07/05/2024 mensaje repetido
                System.out.println("Introduce un número de jugadores válido");
            }
        }while (numJugadoresHumanos < 0 || numJugadoresHumanos > numJugadores) ;
        Log.escribirLog(LogStrings.mensajeElegirNumerosJugadoresHumanos(numJugadoresHumanos));
    }
}
