package main;

import log.Log;
import log.LogStrings;
import menus.MenuPrincipal;
import utilidades.Inicializar;

public class Main {
    public static void main(String[] args) {
        Log.escribirLog(LogStrings.mensajeMain);
        Inicializar.inicializar();
        MenuPrincipal menu=new MenuPrincipal();
        menu.mostrarMenu();
        Log.escribirLog(LogStrings.mensajeFinPrograma);
        //TODO ANNADIR INDICE AL RANKING
        //TODO PULIR LOG MENSAJES (implementado en todos los metodos queda annadir el resto de mensajes)
        //TODO PULIR LOG(CÓMO GENERA EL ARCHIVO)
        //TODO JAVADOC
        //TODO PULIR SOUTS(después de acabar con logs
        //TODO PRUEBAS
        //TODO VISIBILIDAD ATRIBUTOS Y ATRIBUTOS(poco prioritario
    }
}