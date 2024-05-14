package log;

public class Log {
//mensajes Main
    public static final String mensajeMain="Se ha entrado en el método main";

    public static final String mensajemenuPrincipal="Se ha entrado al menú principal";

    public static final String mensajeFinPrograma="El programa ha finalizado";

//Mensajes menú opciones partida
    //TODO: 07/05/2024 mejorar este log
    public static String mensajemenuPartidaOpciones(int numJugadores, int numJugadoresHumanos, int opcion){
        System.out.println("Se ha elegido la opción "+opcion+" con "+numJugadores+" jugadores y "+numJugadoresHumanos+" jugadores humanos en el menú partida");
    }

//mensajes inicializar
    public static final String mensajeComprobarFicheros="Se ha comprobado si los ficheros existen";

    public static String mensajeInicializarGestionJugadores(){
        System.out.println("Se ha inicializado el arrayList de jugadores");
    }

//mensajes gestión jugadores
    public static final String mensajeMenuGestionJugadores="Se ha entrado en el menú de gestión de jugadores";

    public static String mensajeComprobarJugador(String nombreJugador){
        System.out.println("Se ha comprobado si el jugador "+nombreJugador+" existe");
    }

    public static String mensajeDevolverJugador(String nombreJugador){
        System.out.println("Se ha devuelto el jugador "+nombreJugador);
    }

    public static final String mensajeVerJugadoresConPuntuacion="Se han mostrado los jugadores con puntuación o Ranking";

    public static final String mensajeVerJugadorSimple="Se han mostrado los jugadores sin puntuación";

    public static String mensajeEliminarJugador(String nombre){
        System.out.println("Se ha eliminado el jugador "+nombre);
    }

    public static String mensajeAnnadirJugador(String nombre){
        System.out.println("Se ha añadido el jugador "+nombre);
    }

    public static final String mensajeOrdenarJugadores="Se han ordenado los jugadores por puntuación";

    public static final String mensajeGuardarNuevoRanking="Se ha actualizado el ranking";
    //mensajes partida
    public static final String mensajeCrearPartida(int numTurnos, int numJugadores, int numJugadoresHumanos){
        System.out.println("Se ha creado una partida con "+numTurnos+" turnos, "+numJugadores+" jugadores y "+numJugadoresHumanos+" jugadores humanos");
    }

    public static final String mensajeBuclePartida="Se ha entrado en el bucle de la partida";

    public static String mensajeCrearTurno(String nombreJugador){
        System.out.println("Se ha creado un turno para el jugador "+nombreJugador);
    }

    public static final String mensajeFinPartida="La partida ha finalizado";

//mensajes turnos
    public static String mensajeturnoElegirPregunta(String nombreJugador, int tipoPregunta){
        System.out.println("Al jugador "+nombreJugador+" le ha tocado una pregunta de tipo "+tipoPregunta);
    }
//mensajes historico
    public static final String mensajeInicializarHistorico="Se ha inicializado el historico";

    public static final String mensajeMostrarHistorico(){
        System.out.println("Se ha mostrado el historico");
    }

    public static final String mensajeGuardarNuevoHistorico(){
        System.out.println("Se ha guardado el histórico actualizado");
    }
    //mensajes preguntas
    public static String mensajeRespuestaCorrecta(String nombreJugador, int respuestaCorrecta, int respuestaJugador){
        System.out.println("El jugador "+nombreJugador+" ha acertado la respuesta "+respuestaCorrecta+" con "+respuestaJugador);
    }

    public static String mensajeRespuestaIncorrecta(String nombreJugador, String respuestaCorrecta, String respuestaJugador){
        System.out.println("El jugador "+nombreJugador+" ha fallado la respuesta "+respuestaCorrecta+" con "+respuestaJugador);
    }
//mensajes métodos
    public static String mensajePedirEntero(int entero){
        System.out.println("Se ha pedido un entero y se ha introducido: "+entero);
    }

    public static String mensajePedirCadena(String cadena){
        System.out.println("Se ha pedido una cadena y se ha introducido: "+cadena);
    }

    public static String mensajeGenerarNumeroAleatorio(int min, int max){
        System.out.println("Se ha generado un número aleatorio entre "+min+" y "+max);
    }

    public static String mensajeTieneEspacios(String cadenaAEvaluar){
        System.out.println("Se ha comprobado si la cadena "+cadenaAEvaluar+" tiene espacios");
    }

    public static String mensajeCambiarCharNumero(char c){
        System.out.println("Se ha cambiado el char "+c+" a número");
    }

    public static String mensajeCambiarNumeroChar(int numero){
        System.out.println("Se ha cambiado el número "+numero+" a char");
    }

    public static final String mensajeLimpiarBufferTeclado="Se ha limpiado el buffer del teclado";

    public static String mensajePedirCaracter(char caracter){
        System.out.println("Se ha pedido un caracter y se ha introducido: "+caracter);
    }


}
