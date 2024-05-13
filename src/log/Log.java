package log;

public class Log {
//mensajes Main
    public static void mensajeMain(){
            System.out.println("Se ha entrado en el método main");
    }

    public static void mensajemenuPrincipal(){
        System.out.println("Se ha entrado al menú principal");
    }

//Mensajes menú opciones partida
    //TODO: 07/05/2024 mejorar este log
    public static void mensajemenuPartidaOpciones(int numJugadores, int numJugadoresHumanos, int opcion){
        System.out.println("Se ha elegido la opción "+opcion+" con "+numJugadores+" jugadores y "+numJugadoresHumanos+" jugadores humanos en el menú partida");
    }

//mensajes inicializar
    public static void mensajeComprobarFicheros(){
        System.out.println("Se ha comprobado si los ficheros existen");
    }

    public static void mensajeInicializarGestionJugadores(){
        System.out.println("Se ha inicializado el arrayList de jugadores");
    }

//mensajes gestión jugadores
    public static void mensajeMenuGestionJugadores() {
        System.out.println("Se ha entrado en el menú de gestión de jugadores");
    }

    public static void mensajeComprobarJugador(String nombreJugador){
        System.out.println("Se ha comprobado si el jugador "+nombreJugador+" existe");
    }

    public static void mensajeDevolverJugador(String nombreJugador){
        System.out.println("Se ha devuelto el jugador "+nombreJugador);
    }

    public static void mensajeVerJugadoresConPuntuacion(){
        System.out.println("Se han mostrado los jugadores con puntuación o Ranking");
    }

    public static void mensajeVerJugadorSimple(){
        System.out.println("Se han mostrado los jugadores sin puntuación");
    }

    public static void mensajeEliminarJugador(String nombre){
        System.out.println("Se ha eliminado el jugador "+nombre);
    }

    public static void mensajeAnnadirJugador(String nombre){
        System.out.println("Se ha añadido el jugador "+nombre);
    }

    public static void mensajeOrdenarJugadores(){
        System.out.println("Se han ordenado los jugadores por puntuación");
    }

    public static void mensajeGuardarNuevoRanking() {
        System.out.println("Se ha actualizado el ranking");
    }
    //mensajes partida
    public static void mensajeCrearPartida(int numTurnos, int numJugadores, int numJugadoresHumanos){
        System.out.println("Se ha creado una partida con "+numTurnos+" turnos, "+numJugadores+" jugadores y "+numJugadoresHumanos+" jugadores humanos");
    }

    public static void mensajeBuclePartida(){
        System.out.println("Se ha entrado en el bucle de la partida");
    }

    public static void mensajeCrearTurno(String nombreJugador){
        System.out.println("Se ha creado un turno para el jugador "+nombreJugador);
    }

    public static void mensajeFinPartida(){
        System.out.println("La partida ha finalizado");
    }
//mensajes turnos
    public static void mensajeturnoElegirPregunta(String nombreJugador, int tipoPregunta){
        System.out.println("Al jugador "+nombreJugador+" le ha tocado una pregunta de tipo "+tipoPregunta);
    }
//mensajes historico
    public static void mensajeInicializarHistorico(){
        System.out.println("Se ha inicializado el historico");
    }

    public static void mensajeMostrarHistorico(){
        System.out.println("Se ha mostrado el historico");
    }

    public static void mensajeGuardarNuevoHistorico(){
        System.out.println("Se ha guardado el histórico actualizado");
    }
    //mensajes preguntas
    public static void mensajeRespuestaCorrecta(String nombreJugador, int respuestaCorrecta, int respuestaJugador){
        System.out.println("El jugador "+nombreJugador+" ha acertado la respuesta "+respuestaCorrecta+" con "+respuestaJugador);
    }

    public static void mensajeRespuestaIncorrecta(String nombreJugador, String respuestaCorrecta, String respuestaJugador){
        System.out.println("El jugador "+nombreJugador+" ha fallado la respuesta "+respuestaCorrecta+" con "+respuestaJugador);
    }
//mensajes métodos
    public static void mensajePedirEntero(int entero){
        System.out.println("Se ha pedido un entero y se ha introducido: "+entero);
    }

    public static void mensajePedirCadena(String cadena){
        System.out.println("Se ha pedido una cadena y se ha introducido: "+cadena);
    }

    public static void mensajeGenerarNumeroAleatorio(int min, int max){
        System.out.println("Se ha generado un número aleatorio entre "+min+" y "+max);
    }

    public static void mensajeTieneEspacios(String cadenaAEvaluar){
        System.out.println("Se ha comprobado si la cadena "+cadenaAEvaluar+" tiene espacios");
    }

    public static void mensajeCambiarCharNumero(char c){
        System.out.println("Se ha cambiado el char "+c+" a número");
    }

    public static void mensajeCambiarNumeroChar(int numero){
        System.out.println("Se ha cambiado el número "+numero+" a char");
    }

    public static void mensajeLimpiarBufferTeclado(){
        System.out.println("Se ha limpiado el buffer del teclado");
    }

    public static void mensajePedirCaracter(char caracter){
        System.out.println("Se ha pedido un caracter y se ha introducido: "+caracter);
    }


}
