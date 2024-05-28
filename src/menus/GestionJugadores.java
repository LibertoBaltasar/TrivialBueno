package menus;

import jugadores.JugadorGenerico;
import jugadores.JugadorHumano;
import log.Log;
import log.LogStrings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;

import static utilidades.Constantes.INTRODUCE_EL_NOMBRE_DEL_JUGADOR;
import static utilidades.Constantes.OPCION_NO_VALIDA;
/**
 * La clase GestionJugadores se encarga de la gestión de los jugadores.
 */
public class GestionJugadores implements MenuGenerico{

    public int opcion;
    public static ArrayList<JugadorHumano> jugadores=new ArrayList<JugadorHumano>();

    /**
     * Este método inicializa la gestión de jugadores.
     * Carga la lista de jugadores desde un archivo si existe.
     * @param ruta La ruta del archivo donde se guardan los jugadores.
     */
    public static void inicializarGestionJugadores(String ruta){
        //JugadorHumano jugadorPorDefecto = new JugadorHumano("JugadorPorDefecto", 0);
        Path path = Paths.get(utilidades.Rutas.RUTA_RANKING);

        try {
            ArrayList<String> lineas = (ArrayList<String>)Files.readAllLines(path);
            for (String linea : lineas) {
                String[] partes = linea.split(",");
                JugadorHumano jugador = new JugadorHumano(partes[0], Integer.parseInt(partes[1]));
                jugadores.add(jugador);
            }
            //jugadores.add(jugadorPorDefecto);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            log.Log.escribirLog(LogStrings.mensajeInicializarGestionJugadores);
        }
    }
    /**
     * Este método muestra el menú de gestión de jugadores.
     * Permite al usuario seleccionar una opción para gestionar los jugadores.
     */
    @Override
    public void mostrarMenu() {
        do{
            System.out.println("Introduce un número para seleccionar la opción deseada");
            System.out.println("1.-Ver jugadores");
            System.out.println("2.-Añadir jugador");
            System.out.println("3.-Eliminar jugador");
            System.out.println("4.-Atrás");
            opcion=utilidades.Metodos.pedirEntero();
            if (opcion<1 || opcion>4){
                System.out.println(OPCION_NO_VALIDA);
            }
            this.gestionarOpcion();
            Log.escribirLog(LogStrings.mensajeMenuGestionJugadores);
        }while(opcion!=4);
    }
    /**
     * Este método gestiona la opción seleccionada por el usuario.
     * Ejecuta la acción correspondiente a la opción seleccionada por el usuario.
     */
    @Override
    public void gestionarOpcion() {
        switch (this.opcion){
            case 1:
                verJugadoresSimple();
                break;
            case 2:
                System.out.println(INTRODUCE_EL_NOMBRE_DEL_JUGADOR);
                String nombre=utilidades.Metodos.pedirCadena();
                annadirJugador(nombre);
                break;
            case 3:
                System.out.println(INTRODUCE_EL_NOMBRE_DEL_JUGADOR);
                String nombreEliminar=utilidades.Metodos.pedirCadena();
                eliminarJugador(nombreEliminar);
                break;
            case 4:
                break;
            default:
                utilidades.Metodos.limpiarBufferTeclado();
                break;
        }
        Log.escribirLog(LogStrings.mensajeGestionarOpcionGestionJugadores);
    }
    /*
    /**
     * Este método comprueba si un jugador no existe en la lista de jugadores.
     * @param nombreJugador El nombre del jugador a comprobar.
     * @return Verdadero si el jugador no existe, falso en caso contrario.
     */
   /* public static boolean comprobarJugadorNoExiste(String nombreJugador){
        boolean valido=true;
        if(utilidades.Metodos.tieneEspacios(nombreJugador)) {
            if(nombreJugador.isEmpty()){
                System.out.println("El nombre no puede estar vacío");
                //TODO: 07/05/2024 REVISAR CONDICIÓN
            } else if (nombreJugador.equalsIgnoreCase("CPU1") || nombreJugador.equalsIgnoreCase("CPU2") || nombreJugador.equalsIgnoreCase("CPU3") || nombreJugador.equalsIgnoreCase("CPU4")){
                System.out.println("El nombre no puede ser CPU1, CPU2, CPU3 o CPU4");
            }else {
                for (JugadorHumano jugador : jugadores) {
                    if (jugador.getNombre().equals(nombreJugador)) {
                        valido = false;
                    }
                }
            }
        }else{
            System.out.println("El nombre tiene espacios");
        }
        Log.escribirLog(LogStrings.mensajeComprobarJugador(nombreJugador));
        return valido;
    }
    */
    public static boolean comprobarNombreValido(String nombreJugador){
        boolean valido=true;
        if(utilidades.Metodos.tieneEspacios(nombreJugador)){
            valido=false;
        }else if(nombreJugador.isEmpty()){
            System.out.println("El nombre no puede estar vacío");
            valido=false;
        } else if (nombreJugador.equalsIgnoreCase("CPU1") || nombreJugador.equalsIgnoreCase("CPU2") || nombreJugador.equalsIgnoreCase("CPU3") || nombreJugador.equalsIgnoreCase("CPU4")) {
            System.out.println("El nombre no puede ser CPU1, CPU2, CPU3 o CPU4");
        }
        return valido;
    }
    public static boolean comprobarJugadorExiste(String nombreJugador){
        boolean valido=false;
        for (JugadorHumano jugador : jugadores) {
            if (jugador.getNombre().equals(nombreJugador)) {
                valido = true;
            }
        }
        return valido;
    }
    /**
     * Este método devuelve un jugador de la lista de jugadores.
     * @param nombreJugador El nombre del jugador a devolver.
     * @return El jugador con el nombre indicado.
     */
    public static JugadorHumano devolverJugador(String nombreJugador){
        JugadorHumano jugadorADevolver=new JugadorHumano("JugadorPorDefecto",0);
        for (JugadorHumano jugador : jugadores) {
            if (jugador.getNombre().equals(nombreJugador)) {
                jugadorADevolver = jugador;
            }
        }
        Log.escribirLog(LogStrings.mensajeDevolverJugador(jugadorADevolver.getNombre()));
         return jugadorADevolver;
    }

    /**
     * Este método muestra los jugadores con su puntuación.
     */
    public static void verJugadoresConPuntuacion(){
        JugadorHumano jugador;
        int indice=1;
        if(jugadores.isEmpty()){
            System.out.println("No hay jugadores");
        }else {
            for (int i=jugadores.size()-1;i>=0;i--){
                jugador=jugadores.get(i);
                jugador.mostrarJugadorConPuntuacion(indice);
                indice++;
            }
        }
        Log.escribirLog(LogStrings.mensajeVerJugadoresConPuntuacion);
    }
    /**
     * Este método muestra los jugadores sin su puntuación.
     */
    public static void verJugadoresSimple(){
        int indice=1;
        for (JugadorHumano jugador : jugadores) {
            jugador.mostrarJugadorSimple(indice);
            indice++;
        }
        Log.escribirLog(LogStrings.mensajeVerJugadorSimple);
    }
    /**
     * Este método añade un jugador a la lista de jugadores si no existe ya.
     * @param nombre El nombre del jugador a añadir.
     */
    public static void annadirJugador(String nombre){
        if(comprobarNombreValido(nombre)) {
            if (!comprobarJugadorExiste(nombre)) {
                JugadorHumano jugador = new JugadorHumano(nombre, 0);
                jugadores.add(jugador);
            }else{
                System.out.println("El jugador ya existe");
            }
            GestionJugadores.ordenarJugadores();
            GestionJugadores.reescribirRanking();
            Log.escribirLog(LogStrings.mensajeAnnadirJugador(nombre));
        }else{
            System.out.println("No se ha añadido al jugador");
        }
    }
    /**
     * Este método añade la puntuación histórica a un jugador existente o crea un nuevo jugador con la puntuación dada.
     * @param nombre El nombre del jugador al que se va a añadir la puntuación.
     * @param puntuacion La puntuación que se va a añadir al jugador.
     */
    private static void annadirPuntuacionHistoricaJugador(String nombre, int puntuacion){
        if(comprobarJugadorExiste(nombre)) {
            for (JugadorHumano jugador : jugadores) {
                if (jugador.getNombre().equals(nombre)) {
                    jugador.setPuntuacionHistorica(puntuacion);
                }
            }
        }else{
            JugadorHumano jugador = new JugadorHumano(nombre,puntuacion);
            jugadores.add(jugador);
        }
        Log.escribirLog(LogStrings.mensajeAnnadirJugadorPuntuacionHistorica(nombre, puntuacion));
    }
    /**
     * Este método elimina un jugador de la lista de jugadores.
     * @param nombre El nombre del jugador a eliminar.
     */
    public static void eliminarJugador(String nombre){
        boolean borrado=false;
        int indiceJugador=-1;
        for (JugadorHumano jugador: jugadores) {
            if (jugador.getNombre().equals(nombre)){
                indiceJugador=jugadores.indexOf(jugador);
            }
        }
        if(indiceJugador!=-1){
            jugadores.remove(indiceJugador);
            borrado=true;
        }
        if(borrado){
            LogStrings.mensajeEliminarJugador(nombre);
        }else{
            System.out.println("No se ha encontrado el jugador");
        }
    }

    /**
     * Este método ordena los jugadores por puntuación.
     */
    private static void ordenarJugadores() {
        jugadores.sort(Comparator.comparingInt(JugadorHumano::getPuntuacion));
        Log.escribirLog(LogStrings.mensajeOrdenarJugadores);
    }
    /**
     * Este método actualiza el ranking de jugadores.
     * @param jugadoresPartida El array de jugadores de la partida.
     */
    public static void actualizarRanking(JugadorGenerico[] jugadoresPartida){
        String nombre;
        int puntuacionHistorica;
        for (int i=0;i<jugadoresPartida.length;i++){
            if(jugadoresPartida[i] instanceof JugadorHumano){
              nombre=jugadoresPartida[i].getNombre();
              puntuacionHistorica= ((JugadorHumano) jugadoresPartida[i]).getPuntuacionHistorica()+((JugadorHumano) jugadoresPartida[i]).getPuntuacion();
              GestionJugadores.annadirPuntuacionHistoricaJugador(nombre, puntuacionHistorica);
            }
        }
        ordenarJugadores();
        reescribirRanking();
        Log.escribirLog(LogStrings.mensajeActualizarRanking);
    }

    /**
     * Este método reescribe el ranking de jugadores en el archivo de ranking.
     */
    private static void reescribirRanking(){
        String jugadorString;
        Path path = Paths.get(utilidades.Rutas.RUTA_RANKING);
        try {
            if (Files.exists(path)) {
                Files.delete(path);
            }
            Files.createFile(path);
            JugadorHumano jugador;
            for (int i = 0; i < jugadores.size(); i++) {
                jugador = jugadores.get(i);
                jugadorString = jugador.getNombre() + "," + jugador.getPuntuacion()+"\n";
                if (i == 0) {
                    Files.write(path, jugadorString.getBytes(), StandardOpenOption.WRITE);
                }else{
                    Files.write(path, jugadorString.getBytes(), StandardOpenOption.APPEND);
                }
            }
            Log.escribirLog(LogStrings.mensajeGuardarNuevoRanking);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void reiniciarRacha(JugadorGenerico[] arrayJugadores){
        for (int i = 0; i < arrayJugadores.length; i++) {
            arrayJugadores[i].fallar();
        }
    }

}
