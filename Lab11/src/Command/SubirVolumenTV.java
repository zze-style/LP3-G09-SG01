package Command;

class SubirVolumenTV implements Command {
	private TVFunciones estado;
	public SubirVolumenTV (TVFunciones estado) {
		this.estado = estado;
	}
	public void execute() {
		estado.subirVolumen();
	}
}
