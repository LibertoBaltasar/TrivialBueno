package utilidades;

import java.util.Random;
import java.util.Scanner;

public class Metodos {
    private static final Scanner teclado = new Scanner(System.in);
    public static int generarNumeroAleatorio(int min, int max) {
        Random rand = new Random();
        log.Log.mensajeGenerarNumeroAleatorio(min, max);
        return rand.nextInt((max - min) + 1) + min;

    }

    public static boolean tieneEspacios(String cadenaAEvaluar) {
        log.Log.mensajeTieneEspacios(cadenaAEvaluar);
        return !cadenaAEvaluar.contains(" ");
    }

    public static String pedirCadena() {
        String cadena;
        cadena = teclado.nextLine();
        Metodos.limpiarBufferTecladoInt();
        log.Log.mensajePedirCadena(cadena);
        return cadena;
        // TODO: 06/05/2024 controlar excepcion

    }
    public static int pedirEntero() {
        int entero;
        boolean valido=false;
        do {
            try {
                entero = teclado.nextInt();
                log.Log.mensajePedirEntero(entero);
                Metodos.limpiarBufferTecladoInt();
                valido = true;
            } catch (Exception e) {
                System.out.println("Introduce un número");
                entero = 0;
                log.Log.mensajePedirEntero(entero);
            }
        }while(!valido);
        return entero;
        // TODO: 06/05/2024 controlar excepcion
    }
    public static char pedirCaracter(){
        String entrada = teclado.nextLine();
        Metodos.limpiarBufferTeclado();
        char caracter = entrada.charAt(0);
        log.Log.mensajePedirCaracter(caracter);
        return caracter;
    }
    public static int cambiarCharNumero(char c) {
        switch (c) {
            case 'a':
                c = '1';
                break;
            case 'b':
                c = '2';
                break;
            case 'c':
                c = '3';
                break;
            case 'd':
                c = '4';
                break;
            default:
                c=5;
                break;
        }
        log.Log.mensajeCambiarCharNumero(c);
        return (int) c;
    }
    public static char cambiarNumeroChar(int numero) {
        char caracterCambiado;
        switch (numero) {
            case 1:
                caracterCambiado = 'a';
                break;
            case 2:
                caracterCambiado = 'b';
                break;
            case 3:
                caracterCambiado = 'c';
                break;
            case 4:
                caracterCambiado = 'd';
                break;
            default:
                caracterCambiado='e';
                break;
        }
        log.Log.mensajeCambiarNumeroChar(numero);
        return caracterCambiado;
    }
    public static void limpiarBufferTecladoInt() {
        if(teclado.hasNextLine()){
            teclado.nextLine();
            log.Log.mensajeLimpiarBufferTeclado();
        }
    }
    public static void limpiarBufferTeclado() {
        if(teclado.hasNext()){
            teclado.nextLine();
            log.Log.mensajeLimpiarBufferTeclado();
        }
    }
    public static void guardarNuevoRanking(){

    }
}
