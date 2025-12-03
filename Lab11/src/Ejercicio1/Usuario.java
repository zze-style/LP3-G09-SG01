package Ejercicio1;

public class Usuario implements Observer{
	public String nombreUsuario;
	
	Usuario (String nombreUsuario){
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	@Override
	public void enviarNotificacion(String mensaje) {
		System.out.println("Has recibido una alerta " + getNombreUsuario() + ": " + mensaje);
	}
}
