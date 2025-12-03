package Ejercicio1;

public class Main {
	public static void main(String[] args) {
		Notificaciones suscriptores = new Notificaciones();
		Usuario user1 = new Usuario("José");
		Usuario user2 = new Usuario("Roberto");
		Usuario user3 = new Usuario("Ariana");
		suscriptores.suscribir(user1);
		suscriptores.suscribir(user2);
		
		suscriptores.notificarSuscriptores("MENSAJES DE PREUBA");
		
		suscriptores.suscribir(user3);
		suscriptores.desuscribir(user1);
		suscriptores.notificarSuscriptores("Feliz navidad a todos nuestros clientes");
		
	}
}