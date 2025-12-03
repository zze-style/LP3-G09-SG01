package Actividad2;

public class ComandoAvanzar implements Comando {
    private ReproductorVideo reproductor;
    private int segundos;

    public ComandoAvanzar(ReproductorVideo reproductor, int segundos) {
        this.reproductor = reproductor;
        this.segundos = segundos;
    }

    @Override
    public void ejecutar() {
        reproductor.avanzar(segundos);
    }
}
