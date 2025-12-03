package Observer;

public class Main {
	public static void main(String[] args) {
		Subject subject = new Subject();
		Observer observer1 = new ConcreteObserver("José");
		Observer observer2 = new ConcreteObserver("Roberto");
		subject.suscribir(observer1);
		subject.suscribir(observer2);
		subject.notifyObservers("Laptop Lenovo Gamer");
		
		subject.desuscribir(observer2);
		Observer observer3 = new ConcreteObserver("Romeo");
		subject.suscribir(observer3);
		subject.notifyObservers("Ipad Pro");
		
	}
}