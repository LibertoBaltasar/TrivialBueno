package main;

import log.LogStrings;
import menus.MenuPrincipal;
import utilidades.Inicializar;

public class Main {
    public static void main(String[] args) {
        LogStrings.mensajeMain();
        Inicializar.inicializar();
        MenuPrincipal menu=new MenuPrincipal();
        menu.mostrarMenu();
        LogStrings.mensajeFinPrograma();
    }
}