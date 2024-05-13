package menus;

import jugadores.JugadorHumano;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;

public class GestionJugadores implements MenuGenerico{
    int opcion;
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
            log.Log.mensajeInicializarGestionJugadores();
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
            this.opcionElegida();
            log.Log.mensajeMenuGestionJugadores();
        }while(opcion!=4);

    }

    @Override
    public void opcionElegida() {
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
            default:
                break;
        }
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
        log.Log.mensajeComprobarJugador(nombreJugador);
        return valido;
    }
    public static JugadorHumano devolverJugador(String nombreJugador){
        JugadorHumano jugadorADevolver=new JugadorHumano("JugadorPorDefecto",0);
        for (JugadorHumano jugador : jugadores) {
            if (jugador.getNombre().equals(nombreJugador)) {
                jugadorADevolver = jugador;
            }
        }
        log.Log.mensajeDevolverJugador(jugadorADevolver.getNombre());

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
        log.Log.mensajeVerJugadoresConPuntuacion();

    }
    public static void verJugadoresSimple(){
        for (JugadorHumano jugador : jugadores) {
            jugador.mostrarJugadorSimple();
        }
        log.Log.mensajeVerJugadorSimple();
    }
    public static void annadirJugador(String nombre){
            if(comprobarJugadorNoExiste(nombre)) {
                JugadorHumano jugador = new JugadorHumano(nombre, 0);
                jugadores.add(jugador);
            }
            log.Log.mensajeAnnadirJugador(nombre);
    }

    public static void eliminarJugador(String nombre){
        jugadores.removeIf(jugador -> jugador.getNombre().equals(nombre));
        log.Log.mensajeEliminarJugador(nombre);
    }

    public static void ordenarJugadores() {
        jugadores.sort(Comparator.comparingInt(JugadorHumano::getPuntuacion));
        log.Log.mensajeOrdenarJugadores();
    }

    public static void actualizarRanking(){
        ordenarJugadores();
        String jugadorString;
        Path path = Paths.get(utilidades.Rutas.RUTA_RANKING);
        try {

            if (Files.exists(path)) {
                Files.delete(path);
            }

            Files.createFile(path);

            for (int i = 0; i < jugadores.size(); i++) {
                JugadorHumano jugador = jugadores.get(i);
                jugadorString = jugador.getNombre() + "," + jugador.getPuntuacion();
                if (i == 0) {
                    Files.write(path, jugadorString.getBytes(), StandardOpenOption.WRITE);
                }else{
                    Files.write(path, jugadorString.getBytes(), StandardOpenOption.APPEND);
                }
            }
            log.Log.mensajeGuardarNuevoRanking();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
