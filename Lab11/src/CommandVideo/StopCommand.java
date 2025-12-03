package CommandVideo;

public class StopCommand implements Command {
	private ReproductorMusica reproductor;
	
	public StopCommand(ReproductorMusica reproductor) {
		this.reproductor = reproductor;
	}
	
	@Override
	public void ejecutar() {
		reproductor.pause();
	}

}
