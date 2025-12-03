package Actividad2;

public class ControlRemoto {
    private Comando comando;

    public void setComando(Comando comando) {
        this.comando = comando;
    }

    public void presionarBoton() {
        if (comando != null) {
            System.out.print("Pulsando botón: ");
            comando.ejecutar();
        } else {
            System.out.println("No hay comando asignado al botón");
        }
    }
}
