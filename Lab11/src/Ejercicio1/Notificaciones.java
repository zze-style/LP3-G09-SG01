package Ejercicio1;
import java.util.ArrayList;
import java.util.List;

class Notificaciones {
	private List<Observer> suscriptores = new ArrayList<>();
	public void suscribir(Observer observer) {
		suscriptores.add(observer);
		System.out.println("Suscripción exitosa");
	}
	public void desuscribir(Observer observer) {
		suscriptores.remove(observer);
		System.out.println("Te has desuscrito de forma exitosa");
	}
	public void notificarSuscriptores(String message) {
		for (Observer observer : suscriptores) {
			observer.enviarNotificacion(message);
		}
	}
} 
