package Command;

class ApagarTV implements Command {
	private TVFunciones estado;
	public ApagarTV(TVFunciones estado) {
		this.estado = estado;
	}
	public void execute() {
		estado.apagar();
	}
}
