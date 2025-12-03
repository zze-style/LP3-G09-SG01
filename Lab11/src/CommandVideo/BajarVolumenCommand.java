package CommandVideo;

public class BajarVolumenCommand implements Command{
	private ReproductorMusica reproductor;
	
	public BajarVolumenCommand(ReproductorMusica reproductor) {
		this.reproductor = reproductor;
	}
	
	@Override
	public void ejecutar() {
		reproductor.bajarVolumen();
	}
	
}
