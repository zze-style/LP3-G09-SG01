package Actividad2;

public class Main {
	public static void main(String[] args) {
		//SUSCRIPCIONES
		GestorSuscripciones gestor = new GestorSuscripciones();
		Suscripcion usuario1 = new Suscripcion("Plan estudiante", 20);
		
		gestor.setEstrategia(new EstrategiaSuscripcionEstudiante());
		gestor.calcularPrecioFinal(usuario1);
		
		
		Suscripcion usuario2 = new Suscripcion("Plan Premium",29);
		gestor.setEstrategia(new EstrategiaSuscripcionPremium());
		gestor.calcularPrecioFinal(usuario2);
		
		
		//COMANDOS
		
		ReproductorVideo reproductor = new ReproductorVideo("Stranger Things");
		ControlRemoto control = new ControlRemoto();
		Comando play = new Comando() {
			public void ejecutar() {
				reproductor.play();
			}
		};
		Comando stop = new Comando() {
			public void ejecutar() {
				reproductor.stop();
			}
		};
		Comando avanzar = new Comando(){
			public void ejecutar() {
				reproductor.avanzar(60);
			}
		};
		
		control.setComando(play);
		control.presionarBoton();
		control.setComando(stop);
		control.presionarBoton();
		control.setComando(avanzar);
		control.presionarBoton();
		
		//OBSERVADORES
		
		Subject catalogo = new Subject();
		ConcreteObserver usuario = new ConcreteObserver("Jose");
		catalogo.suscribir(usuario);
		
		Serie southland = new Serie("Southland","Drama");
		catalogo.agregarSerie(southland);
		
		
		
		
	}
}