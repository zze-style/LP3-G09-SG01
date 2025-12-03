package Command;

public class Main {
	public static void main(String[] args) {
		TVFunciones estado = new TVFunciones();

		Command encender = new EncenderTV(estado);
		Command apagar = new ApagarTV(estado);
		Command subirVolumen = new SubirVolumenTV(estado);
		Command bajarVolumen = new BajarVolumenTV(estado);
		Command mutear = new MuteTV(estado);

		RemoteControl remote = new RemoteControl();

		// Encender TV
		remote.setCommand(encender);
		remote.pressButton();

		// Apagar TV
		remote.setCommand(apagar);
		remote.pressButton();
		
		// Subir volumen 
		remote.setCommand(subirVolumen);
		remote.pressButton();
		// Bajar Volumen
		remote.setCommand(bajarVolumen);
		remote.pressButton();
		// Mutear TV
		remote.setCommand(mutear);
		remote.pressButton();
	}
}