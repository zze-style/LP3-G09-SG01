package Actividad2;

public class ComandoPlay implements Comando {
    private ReproductorVideo reproductor;

    public ComandoPlay(ReproductorVideo reproductor) {
        this.reproductor = reproductor;
    }

    @Override
    public void ejecutar() {
        reproductor.play();
    }
}