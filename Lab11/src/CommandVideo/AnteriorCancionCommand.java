package CommandVideo;

public class AnteriorCancionCommand implements Command{
	private ReproductorMusica reproductor;

	public AnteriorCancionCommand(ReproductorMusica reproductor) {
		this.reproductor = reproductor;
	}
	
	@Override
	public void ejecutar() {
		reproductor.anteriorCancion();
	}

}

