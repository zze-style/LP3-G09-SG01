package Actividad2;
import java.util.ArrayList;
import java.util.List;

class Subject {
	private List<Observer> observers = new ArrayList<>();
	private List<Serie> catalogo = new ArrayList<>();
	public void suscribir(Observer observer) {
		observers.add(observer);
	}
	public void desuscribir(Observer observer) {
		observers.remove(observer);
	}
	public void notificar(Serie serie) {
		for (Observer observer : observers) {
			observer.actualizar(serie);
		}
	}
	
	public void agregarSerie(Serie nuevaSerie) {
		System.out.println("Se ha agregado la serie " + nuevaSerie.getTitulo());
		catalogo.add(nuevaSerie);
		notificar(nuevaSerie);
		System.out.println("Se ha notificado a los usuarios de la inclusión de " + nuevaSerie.getTitulo());
	}
}
