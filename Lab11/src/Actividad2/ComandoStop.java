package Actividad2;

public class ComandoStop implements Comando {
    private ReproductorVideo reproductor;

    public ComandoStop(ReproductorVideo reproductor) {
        this.reproductor = reproductor;
    }

    @Override
    public void ejecutar() {
        reproductor.stop();
    }
}
