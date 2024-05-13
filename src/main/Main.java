package main;

import menus.MenuPrincipal;
import utilidades.Inicializar;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        log.Log.mensajeMain();
        Inicializar.inicializar();
        MenuPrincipal menu=new MenuPrincipal();
        menu.mostrarMenu();
        // TODO: REINICIAR OPCIONES EN MENÚS
    }
}