package menus;

import log.Log;
import log.LogStrings;
import main.Historico;

public class MenuPrincipal implements MenuGenerico{
    int opcion;
    @Override
    public void mostrarMenu(){

        do {
            System.out.println("Introduce un número para seleccionar la opción deseada");
            System.out.println("1.-Jugar");
            System.out.println("2.-Jugadores");
            System.out.println("3.-Ranking");
            System.out.println("4.-Histórico");
            System.out.println("5.-Salir");
            opcion=utilidades.Metodos.pedirEntero();
            if(opcion<1 || opcion>5){
                System.out.println("Opción no válida");
            }
            this.gestionarOpcion();
            Log.escribirLog(LogStrings.mensajemenuPrincipal);
        }while(opcion!=5);
        Log.escribirLog(LogStrings.mensajeMensajeMostrarMenuMenuPrincipal);
        System.out.println("Has salido del menú principal");

    }
    @Override
    public void gestionarOpcion(){
        MenuGenerico menu;
        switch (this.opcion) {
            case 1:
                menu = new MenuPartidaOpciones();
                Log.escribirLog(LogStrings.mensajeGestionarOpcionMenuPrincipal);
                menu.mostrarMenu();
                break;
            case 2:
                menu = new GestionJugadores();
                menu.mostrarMenu();
                break;
            case 3:
                GestionJugadores.verJugadoresConPuntuacion();
                break;
            case 4:
                Historico.mostrarHistorico();
                break;
            default:
                break;
        }
    }
}
