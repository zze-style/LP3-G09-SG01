package CommandVideo;

public class SubirVolumenCommand implements Command{
	private ReproductorMusica reproductor;
	
	public SubirVolumenCommand(ReproductorMusica reproductor) {
		this.reproductor = reproductor;
	}
	
	@Override
	public void ejecutar() {
		reproductor.subirVolumen();
	}
}
