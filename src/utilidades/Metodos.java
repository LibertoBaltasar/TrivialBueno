package utilidades;

import log.Log;
import log.LogStrings;

import java.util.Random;
import java.util.Scanner;
/**
 * La clase Metodos proporciona varios métodos de utilidad que se utilizan en todo el programa.
 */
public class Metodos {
    private static final Scanner teclado = new Scanner(System.in);
    /**
     * Este método genera un número aleatorio entre un rango dado.
     * @param min El límite inferior del rango.
     * @param max El límite superior del rango.
     * @return Un número aleatorio entre min y max.
     */
    public static int generarNumeroAleatorio(int min, int max) {
        Random rand = new Random();
        int numero=rand.nextInt((max - min) + 1) + min;
        Log.escribirLog(LogStrings.mensajeGenerarNumeroAleatorio(min,max));
        return numero;
    }
    /**
     * Este método comprueba si una cadena contiene espacios.
     * @param cadenaAEvaluar La cadena a evaluar.
     * @return Verdadero si la cadena no contiene espacios, falso en caso contrario.
     */
    public static boolean tieneEspacios(String cadenaAEvaluar) {
        Log.escribirLog(LogStrings.mensajeTieneEspacios(cadenaAEvaluar));
        return !cadenaAEvaluar.contains(" ");
    }
    /**
     * Este método solicita al usuario que introduzca una cadena.
     * @return La cadena introducida por el usuario.
     */
    public static String pedirCadena() {
        String cadena;
        cadena = teclado.nextLine();
        Log.escribirLog(LogStrings.mensajePedirCadena(cadena));
        return cadena;
    }
    /**
     * Este método solicita al usuario que introduzca un número entero.
     * @return El número entero introducido por el usuario.
     */
    public static int pedirEntero() {
        int entero;
        boolean valido=false;
        do {
            try {
                entero = teclado.nextInt();
                Metodos.limpiarBufferTeclado();
                Log.escribirLog(LogStrings.mensajePedirEntero(entero));
                valido = true;
            } catch (Exception e) {
                System.out.println("Introduce un número");
                entero = 0;
            }
        }while(!valido);
        return entero;
    }
    /**
     * Este método solicita al usuario que introduzca un carácter.
     * @return El carácter introducido por el usuario en formato String.
     */
    public static char pedirCaracter(){
        String entrada = teclado.nextLine();
        char caracter = entrada.charAt(0);
        Log.escribirLog(LogStrings.mensajePedirCaracter(caracter));
        return caracter;
    }
    /**
     * Este método convierte un carácter en un número.
     * @param c El carácter a convertir.
     * @return El número correspondiente al carácter.
     */
    public static int cambiarCharNumero(char c) {
        int numero;
        switch (c) {
            case 'a':
                numero = 0;
                break;
            case 'b':
                numero = 1;
                break;
            case 'c':
                numero = 2;
                break;
            case 'd':
                numero = 3;
                break;
            default:
                numero=5;
                break;
        }
        Log.escribirLog(LogStrings.mensajeCambiarCharNumero(c));
        return numero;
    }
    /**
     * Este método convierte un número en un carácter.
     * @param numero El número a convertir.
     * @return El carácter correspondiente al número.
     */
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
        Log.escribirLog(LogStrings.mensajeCambiarNumeroChar(numero));
        return caracterCambiado;
    }
    /**
     * Este método limpia el buffer del teclado.
     */
    public static void limpiarBufferTeclado() {

        teclado.nextLine();
        Log.escribirLog(LogStrings.mensajeLimpiarBufferTeclado);
    }
}
