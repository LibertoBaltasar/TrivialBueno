package jugadores;

public abstract class JugadorGenerico {
    int puntuacion;
    String nombre;
    public void puntuar(){
        this.puntuacion++;
    }
    public abstract void responderLengua(String repuestaCorrecta);
    public abstract void responderMatematicas(int respuesta);
    public abstract void responderIngles(String RespuestaCorrecta, String[] posiblesRespuestas);

    public int getPuntuacion() {
        return puntuacion;
    }

    public String getNombre() {
        return nombre;
    }
}
