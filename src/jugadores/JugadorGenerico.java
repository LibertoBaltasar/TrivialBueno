package jugadores;

public abstract class JugadorGenerico {
    protected int puntuacion;
    protected String nombre;
    protected int racha;
    public void puntuar(){
        this.puntuacion++;
        racha++;
        this.comprobarRacha();
    }
    public void fallar(){
        racha=0;
    }
    protected void comprobarRacha(){
        if (racha>=3){
            puntuacion+=3;
            System.out.println("¡Racha de 3 respuestas correctas!");
            racha=0;
        }
    }
    public abstract void responderLengua(String repuestaCorrecta);
    public abstract void responderMatematicas(int respuesta);
    public abstract void responderIngles(String RespuestaCorrecta, String[] posiblesRespuestas);
    public abstract void responderAzar(int respuestaCorrecta);
    public int getPuntuacion() {
        return puntuacion;
    }

    public String getNombre() {
        return nombre;
    }
}
