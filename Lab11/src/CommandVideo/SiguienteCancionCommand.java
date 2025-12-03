package CommandVideo;

public class SiguienteCancionCommand implements Command{
	private ReproductorMusica reproductor;

	public SiguienteCancionCommand(ReproductorMusica reproductor) {
		this.reproductor = reproductor;
	}
	
	@Override
	public void ejecutar() {
		reproductor.siguienteCancion();
	}

}

