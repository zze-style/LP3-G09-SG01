package Actividad2;

class ConcreteObserver implements Observer {
	private String name;
	public ConcreteObserver(String name) {
		this.name = name;
	}
	
	public void enviarNotificacion(Serie serie) {
		System.out.println(name + " se ha actualizado " + serie);
	}

	@Override
	public void actualizar(Serie serie) {
		System.out.println("¡Alerta! " + name + " se ha liberado un nuevo contenido: " + serie.getTitulo());
		
	}
	

}
