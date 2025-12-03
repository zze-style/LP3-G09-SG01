package Actividad2;

public class ReproductorVideo {
	public String serieActual;
	public int tiempoActual;
	
	public ReproductorVideo(String serieActual) {
		this.serieActual = serieActual;
		this.tiempoActual = 0;
		System.out.println("Reproductor iniciado, se está reproduciendo: " + serieActual);
	}
	
	public void play() {
		System.out.println("[COMANDO] Reproduciendo " + serieActual + " desde el minuto " + tiempoActual);
	}
	
	public void stop() {
		System.out.println("[COMANDO] Se está deteniendo " + serieActual + " desde el minuto " + tiempoActual);
	}
	
	public void avanzar(int segundos) {
		tiempoActual += (segundos/60);
		System.out.println("[COMANDO] Se ha adelantado " + segundos + " segundos. Actualmente está en " + tiempoActual);
	}
	
	public void guardarPunto(){
		System.out.println("[COMANDO] Se ha guardado la visualización en " + tiempoActual);
	}
	
	public int getTiempoActual() {
		return tiempoActual;
	}
}
