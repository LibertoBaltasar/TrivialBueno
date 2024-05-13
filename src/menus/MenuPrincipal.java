package menus;

import java.util.Scanner;

import main.Historico;
import utilidades.Metodos;
public class MenuPrincipal implements MenuGenerico{
    int opcion;
    @Override
    public void mostrarMenu(){
        // TODO: 01/05/2024 muestra el menú y llama a opcionElegida dentro del bucle
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
            this.opcionElegida();
            log.Log.mensajemenuPrincipal();
        }while(opcion!=5);
        // TODO: 05/05/2024 después de cada vuelta actualiza Ranking e histórico
        System.out.println("Has salido del menú principal");

    }
    @Override
    public void opcionElegida(){
        MenuGenerico menu;
        switch (this.opcion) {
            case 1:
                menu = new MenuPartidaOpciones();
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
