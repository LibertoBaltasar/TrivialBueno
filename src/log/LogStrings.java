package log;

public class LogStrings {
//mensajes log
    public static final String mensajeInicializarLog="Se ha inicializado el log";
//mensajes Main
    public static final String mensajeMain="Se ha entrado en el método main";

    public static final String mensajemenuPrincipal="Se ha entrado al menú principal";

    public static final String mensajeFinPrograma="El programa ha finalizado";

//Mensajes menú opciones partida
    //TODO: 07/05/2024 mejorar este log
    public static String mensajemenuPartidaOpciones(int numJugadores, int numJugadoresHumanos, int opcion){
        return("Se ha elegido la opción "+opcion+" con "+numJugadores+" jugadores y "+numJugadoresHumanos+" jugadores humanos en el menú partida");
    }
    public static String mensajeObtenerNumeroTurnos(int numTurnos){
        return("Se ha obtenido el número de turnos: "+numTurnos);
    }

    public static String mensajeElegirTipoPartida(int opcion){
        return("Se ha elegido la opción: "+opcion);
    }

    public static String mensajeElegirNumerosJugadores(int numJugadores){
        return("Se ha elegido el número de jugadores: "+numJugadores);
    }

    public static String mensajeElegirNumerosJugadoresHumanos(int numJugadoresHumanos){
        return("Se ha elegido el número de jugadores humanos: "+numJugadoresHumanos);
    }

//mensajes inicializar
    public static final String mensajeInicializarGeneral="Se ha preparado el programa el programa";

    public static final String mensajeComprobarFicheros="Se ha comprobado si los ficheros existen";

    public static final String mensajeInicializarGestionJugadores="Se ha inicializado el arrayList de jugadores";

//mensajes gestión jugadores
    public static final String mensajeMenuGestionJugadores="Se ha entrado en el menú de gestión de jugadores";

    public static String mensajeComprobarJugador(String nombreJugador){
        return("Se ha comprobado si el jugador "+nombreJugador+" existe");
    }

    public static String mensajeDevolverJugador(String nombreJugador){
        return("Se ha devuelto el jugador "+nombreJugador);
    }

    public static final String mensajeVerJugadoresConPuntuacion="Se han mostrado los jugadores con puntuación o Ranking";

    public static final String mensajeVerJugadorSimple="Se han mostrado los jugadores sin puntuación";

    public static String mensajeEliminarJugador(String nombre){
        return("Se ha eliminado el jugador "+nombre);
    }

    public static String mensajeAnnadirJugador(String nombre){
        return("Se ha añadido el jugador "+nombre);
    }
    public static final String mensajeGestionarOpcionGestionJugadores="Se ha gestionado la opción del menú de gestión de jugadores";

    public static String mensajeAnnadirJugadorPuntuacionHistorica(String nombre, int puntuacion){
        return("Se ha añadido el jugador "+nombre+" con puntuación "+puntuacion+" al histórico");
    }

    public static String mensajeActualizarRanking="Se ha actualizado el Ranking";

    public static final String mensajeOrdenarJugadores="Se han ordenado los jugadores por puntuación";

    public static final String mensajeGuardarNuevoRanking="Se ha actualizado el ranking";
//mensajes partida
    public static final String mensajeCrearPartida(int numTurnos, int numJugadores, int numJugadoresHumanos){
        return("Se ha creado una partida con "+numTurnos+" turnos, "+numJugadores+" jugadores y "+numJugadoresHumanos+" jugadores humanos");
    }

    public static final String mensajeBuclePartida="Se ha entrado en el bucle de la partida";

    public static String mensajeCrearTurno(String nombreJugador){
        return("Se ha creado un turno para el jugador "+nombreJugador);
    }

    public static final String mensajeFinPartida="La partida ha finalizado";

    public static String mensajeGenerarResultadoPartida(String resultado){
        return("Se ha generado el resultado de la partida: "+resultado);
    }

//mensajes turnos
    public static String mensajeTurnoElegirPregunta(String nombreJugador, int tipoPregunta){
        return("Al jugador "+nombreJugador+" le ha tocado una pregunta de tipo "+tipoPregunta);
    }
//mensajes historico
    public static final String mensajeInicializarHistorico="Se ha inicializado el historico";

    public static final String mensajeMostrarHistorico="Se ha mostrado el historico";

    public static final String mensajeGuardarNuevoHistorico="Se ha guardado el histórico actualizado";

    public static String mensajeActualizarHistorico(String resultadoPartida){
        return("Se ha actualizado el histórico con el resultado de la partida: "+resultadoPartida);
    }

//mensajes preguntas
    public static String mensajeRespuestaCorrecta(String nombreJugador, String respuestaCorrecta, String respuestaJugador){
        return("El jugador "+nombreJugador+" ha acertado la respuesta "+respuestaCorrecta+" con "+respuestaJugador);
    }

    public static String mensajeRespuestaIncorrecta(String nombreJugador, String respuestaCorrecta, String respuestaJugador){
        return("El jugador "+nombreJugador+" ha fallado la respuesta "+respuestaCorrecta+" con "+respuestaJugador);
    }
//mensajes PreguntaIngles
    public static final String mensajeInicializarArrayIngles="Se ha inicializado el array de preguntas en inglés";

    public static final String mensajeMostrarPreguntaIngles="Se ha mostrado una pregunta de inglés";

    public static String mensajeDesordenarRespuestas(int numCambios){
        return("Se han desordenado las respuestas "+numCambios+" veces");
    }

    public static final String mensajeDevolverRespuestaSeleccionada="Se ha devuelto la respuesta seleccionada";

//mensajes PreguntaLengua
    public static final String mensajeInicializarArrayPreguntasLengua="Se ha inicializado el array de preguntas en lengua";

    public static final String mensajeMostrarPreguntaLengua="Se ha mostrado una pregunta de lengua";

    public static final String mensajeLetrasAOcultar="Se han seleccionado las letras a ocultar en la pregunta";

    public static final String mensajeFormatearPreguntaLengua="Se ha formateado la pregunta";

//mensajes PreguntaMatematica
    public static final String mensajeMostrarPreguntaMatematica="Se ha mostrado una pregunta de matemáticas";

    public static String mensajeElegirSimbolo(String simbolo){
        return("Se ha elegido el símbolo: "+simbolo);
    }
//mensajes métodos
    public static String mensajePedirEntero(int entero){
        return("Se ha pedido un entero y se ha introducido: "+entero);
    }

    public static String mensajePedirCadena(String cadena){
        return("Se ha pedido una cadena y se ha introducido: "+cadena);
    }

    public static String mensajeGenerarNumeroAleatorio(int min, int max){
        return("Se ha generado un número aleatorio entre "+min+" y "+max);
    }

    public static String mensajeTieneEspacios(String cadenaAEvaluar){
        return("Se ha comprobado si la cadena "+cadenaAEvaluar+" tiene espacios");
    }

    public static String mensajeCambiarCharNumero(char c){
        return("Se ha cambiado el char "+c+" a número");
    }

    public static String mensajeCambiarNumeroChar(int numero){
        return("Se ha cambiado el número "+numero+" a char");
    }

    public static final String mensajeLimpiarBufferTeclado="Se ha limpiado el buffer del teclado";

    public static String mensajePedirCaracter(char caracter){
        return("Se ha pedido un caracter y se ha introducido: "+caracter);
    }

//jugadores
    public static String mensajeMostrarJugadorConPuntuacion(String nombre, int puntuacion){
        return("Se ha mostrado el jugador "+nombre+" con puntuación "+puntuacion);
    }

    public static String mensajeMostrarJugadorSimple(String nombre){
        return("Se ha mostrado el jugador "+nombre);
    }

//MenuPrincipal
    public static final String mensajeMensajeMostrarMenuMenuPrincipal="Se ha mostrado el mensaje de mostrar menú en el menú principal";

    public static final String mensajeGestionarOpcionMenuPrincipal="Se ha gestionado la opción del menú principal";
}
