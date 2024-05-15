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

public class GestionJugadores implements MenuGenerico{
    public int opcion;
    public static ArrayList<JugadorHumano> jugadores=new ArrayList<JugadorHumano>();

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
                System.out.println("Opción no válida");
            }
            this.gestionarOpcion();
            Log.escribirLog(LogStrings.mensajeMenuGestionJugadores);
        }while(opcion!=4);
    }

    @Override
    public void gestionarOpcion() {
        switch (this.opcion){
            case 1:
                verJugadoresSimple();
                break;
            case 2:
                System.out.println("Introduce el nombre del jugador");
                String nombre=utilidades.Metodos.pedirCadena();
                annadirJugador(nombre);
                break;
            case 3:
                System.out.println("Introduce el nombre del jugador");
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
    public static boolean comprobarJugadorNoExiste(String nombreJugador){
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
    public static void verJugadoresConPuntuacion(){
        if(jugadores.isEmpty()){
            System.out.println("No hay jugadores");
        }else {
            for (JugadorHumano jugador : jugadores) {
                jugador.mostrarJugadorConPuntuacion();
            }
        }
        Log.escribirLog(LogStrings.mensajeVerJugadoresConPuntuacion);
    }
    public static void verJugadoresSimple(){
        int indice=1;
        for (JugadorHumano jugador : jugadores) {
            jugador.mostrarJugadorSimple(indice);
            indice++;
        }
        Log.escribirLog(LogStrings.mensajeVerJugadorSimple);
    }
    public static void annadirJugador(String nombre){
            if(comprobarJugadorNoExiste(nombre)) {
                JugadorHumano jugador = new JugadorHumano(nombre, 0);
                jugadores.add(jugador);
            }
            GestionJugadores.ordenarJugadores();
            GestionJugadores.reescribirRanking();
            Log.escribirLog(LogStrings.mensajeAnnadirJugador(nombre));
    }
    private static void annadirPuntuacionHistoricaJugador(String nombre, int puntuacion){
        if(!comprobarJugadorNoExiste(nombre)) {
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

    public static void eliminarJugador(String nombre){
        boolean borrado=false;
        for (JugadorHumano jugador: jugadores) {
            if (jugador.getNombre().equals(nombre)){
                jugadores.remove(jugador);
                borrado=true;
            }
        }
        if(borrado){
            LogStrings.mensajeEliminarJugador(nombre);
        }else{
            System.out.println("No se ha encontrado el jugador");
        }
    }

    private static void ordenarJugadores() {
        jugadores.sort(Comparator.comparingInt(JugadorHumano::getPuntuacion));
        Log.escribirLog(LogStrings.mensajeOrdenarJugadores);
    }

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
                    //TODO: ME LO AÑADE TODO EN LA MISMA LÍNEA
                    Files.write(path, jugadorString.getBytes(), StandardOpenOption.APPEND);
                }
            }
            Log.escribirLog(LogStrings.mensajeGuardarNuevoRanking);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
