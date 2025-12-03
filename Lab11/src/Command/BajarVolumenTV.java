package Command;

class BajarVolumenTV implements Command {
	private TVFunciones estado;
	public BajarVolumenTV (TVFunciones estado) {
		this.estado = estado;
	}
	public void execute() {
		estado.bajarVolumen();
	}
}

