package CommandVideo;

public class PlayCommand implements Command{
	private ReproductorMusica reproductor;

	public PlayCommand(ReproductorMusica reproductor) {
		this.reproductor = reproductor;
	}
	
	@Override
	public void ejecutar() {
		reproductor.play();
	}

}
