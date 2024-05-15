package utilidades;

import log.Log;
import log.LogStrings;

import java.util.Random;
import java.util.Scanner;

public class Metodos {
    private static final Scanner teclado = new Scanner(System.in);
    public static int generarNumeroAleatorio(int min, int max) {
        Random rand = new Random();
        int numero=rand.nextInt((max - min) + 1) + min;
        Log.escribirLog(LogStrings.mensajeGenerarNumeroAleatorio(min,max));
        return numero;

    }

    public static boolean tieneEspacios(String cadenaAEvaluar) {
        Log.escribirLog(LogStrings.mensajeTieneEspacios(cadenaAEvaluar));
        return !cadenaAEvaluar.contains(" ");
    }

    public static String pedirCadena() {
        String cadena;
        cadena = teclado.nextLine();
        Log.escribirLog(LogStrings.mensajePedirCadena(cadena));
        return cadena;
    }
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
    public static char pedirCaracter(){
        String entrada = teclado.nextLine();
        char caracter = entrada.charAt(0);
        Log.escribirLog(LogStrings.mensajePedirCaracter(caracter));
        return caracter;
    }
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

    public static void limpiarBufferTeclado() {

        teclado.nextLine();
        Log.escribirLog(LogStrings.mensajeLimpiarBufferTeclado);
    }
}
