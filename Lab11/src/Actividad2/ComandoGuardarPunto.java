package Actividad2;

public class ComandoGuardarPunto implements Comando {
    private ReproductorVideo reproductor;

    public ComandoGuardarPunto (ReproductorVideo reproductor) {
        this.reproductor = reproductor;
    }

    @Override
    public void ejecutar() {
        reproductor.guardarPunto();
    }
}

