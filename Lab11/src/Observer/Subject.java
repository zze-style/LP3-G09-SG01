package Observer;
import java.util.ArrayList;
import java.util.List;

class Subject {
	private List<Observer> observers = new ArrayList<>();
	public void suscribir(Observer observer) {
		String name = observer.getUserName();
		observers.add(observer);
		System.out.println("Se han activado las notificaciones de " + name);
	}
	public void desuscribir(Observer observer) {
		String name = observer.getUserName();
		observers.remove(observer);
		System.out.println("Se han desactivado las notificaciones de " + name);
	}
	public void notifyObservers(String message) {
		for (Observer observer : observers) {
			observer.enviarNotificacion(message);
		}
	}
} 
