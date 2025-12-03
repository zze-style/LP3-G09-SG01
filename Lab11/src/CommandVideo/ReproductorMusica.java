package CommandVideo;

public class ReproductorMusica {
	public boolean isPlaying = false;
	private int volumen = 50;
	
	public void play() {
		if (!isPlaying) {
			isPlaying = true;
			System.out.println("Se está reproduciendo la canción");
		} else {
			System.out.println("Ya se está reproduciendo la canción");
		}
	}
	
	public void pause() {
		if (isPlaying) {
			isPlaying = false;
			System.out.println("Se ha pauseado la canción");
		} else {
			System.out.println("Ya se ha pauseado la canción");
		}
	}
	
	public void subirVolumen() {
		if (volumen < 100) {
			volumen += 10;
			System.out.println("Se está subiendo el volumen. Nivel actual: " + volumen);
		} else {
			System.out.println("Se ha subido el nivel al máximo");
		}
	}
	
	public void bajarVolumen() {
		if (volumen > 0) {
			volumen -= 10;
			System.out.println("Se está bajando el volumen. El nivel actual es: " + volumen);
		} else {
			System.out.println("Se ha bajado el volumen al máximo");
		}
	}
	
	public void siguienteCancion() {
		System.out.println("Se ha skipeado la canción.");
	}
	
	public void anteriorCancion() {
		System.out.println("Se ha regresado a la canción anterior.");
	}
	
	public void agregarFavoritos() {
		System.out.println("Se ha agregado a las canciones favoritas favoritas");
	}
}
