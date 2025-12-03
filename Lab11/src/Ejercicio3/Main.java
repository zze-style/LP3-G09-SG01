package Ejercicio3;

public class Main {
	public static void main(String[] args) {
		
		//OBSERVERS
		Notificaciones subject = new Notificaciones();
		Observer observer1 = new ConcreteObserver("Emma");
		Observer observer2 = new ConcreteObserver("Jonathan");
		subject.suscribir(observer1);
		subject.suscribir(observer2);
		subject.notifyObservers("Nueva canción de Billie Eilish");
		
		subject.desuscribir(observer2);
		Observer observer3 = new ConcreteObserver("Matias");
		subject.suscribir(observer3);
		subject.notifyObservers("Nueva canción de Bad Bunny");
		
		//ESTRATEGIAS
		
		double precioServicio = 20;
		PriceCalculator calculadora = new PriceCalculator();
		calculadora.setEstrategiaDescuento(new EstudianteStrategy());
		System.out.println("El precio por el descuento estudiante es: $" + calculadora.calcularPrecio(precioServicio));
		
		calculadora.setEstrategiaDescuento(new UsuarioFrecuenteStrategy());
		System.out.println("El precio final por el descuento usuario frecuente es: $" + calculadora.calcularPrecio(precioServicio));
		
		calculadora.setEstrategiaDescuento(new NoDiscount());
		System.out.println("El precio final sin descuento es: $" + calculadora.calcularPrecio(precioServicio));
		
		//COMANDOS
		
		ReproductorMusica reproductor = new ReproductorMusica();
		ControlRemoto control = new ControlRemoto();
		
		Command play = new PlayCommand(reproductor);
		Command stop = new StopCommand(reproductor);
		Command subirvol = new SubirVolumenCommand(reproductor);
		Command bajarvol = new BajarVolumenCommand(reproductor);
		
		control.setCommand(play);
		control.presionarBoton();
		
		control.setCommand(stop);
		control.presionarBoton();
		
		control.setCommand(subirvol);
		control.presionarBoton();
		
		control.setCommand(bajarvol);
		control.presionarBoton();
		control.presionarBoton();
		control.presionarBoton();
		control.presionarBoton();
		control.presionarBoton();
		control.presionarBoton();
		control.presionarBoton();
		control.presionarBoton();
		
		
		
	}
}