package Command;

class MuteTV implements Command {
	private TVFunciones estado;
	public MuteTV (TVFunciones estado) {
		this.estado = estado;
	}
	public void execute() {
		estado.mute();
	}
}

