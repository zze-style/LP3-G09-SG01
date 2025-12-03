package Command;

class EncenderTV implements Command {
	private TVFunciones estado;
	public EncenderTV (TVFunciones estado) {
		this.estado = estado;
	}
	public void execute() {
		estado.encender();
	}
} 
