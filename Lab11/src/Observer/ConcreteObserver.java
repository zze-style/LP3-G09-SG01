package Observer;

class ConcreteObserver implements Observer {
	private String name;
	public ConcreteObserver(String name) {
		this.name = name;
	}
	
	public void enviarNotificacion(String message) {
		System.out.println(name + " ha sido notificado sobre el nuevo ingreso de " + message);
	}
	
	@Override
	public String getUserName() {
		return name;
	}
}
