package main;

import log.Log;
import log.LogStrings;
import menus.MenuPrincipal;
import utilidades.Inicializar;

public class Main {
    public static void main(String[] args) {
        Inicializar.inicializar();
        Log.escribirLog(LogStrings.mensajeMain);
        MenuPrincipal menu=new MenuPrincipal();
        menu.mostrarMenu();
        Log.escribirLog(LogStrings.mensajeFinPrograma);
        //TODO PULIR LOG MENSAJES
        //TODO JAVADOC
        //TODO PULIR SOUTS
        //TODO PRUEBAS
        //TODO VISIBILIDAD ATRIBUTOS Y ATRIBUTOS(poco prioritario
    }
}