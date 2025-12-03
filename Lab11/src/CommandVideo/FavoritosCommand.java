package CommandVideo;

public class FavoritosCommand implements Command{
	private ReproductorMusica reproductor;

	public FavoritosCommand(ReproductorMusica reproductor) {
		this.reproductor = reproductor;
	}
	
	@Override
	public void ejecutar() {
		reproductor.agregarFavoritos();
	}

}
