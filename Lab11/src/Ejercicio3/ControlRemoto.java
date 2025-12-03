package Ejercicio3;

public class ControlRemoto {
	private Command comando;
	
	public void setCommand(Command comando) {
		this.comando = comando;
	}
	
	public void presionarBoton() {
		if (comando != null) {
			comando.ejecutar();
		} else {
			System.out.println("No se ha configurado ningún botón");
		}
	}

}
