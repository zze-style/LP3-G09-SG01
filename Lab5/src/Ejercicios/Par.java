package Ejercicios;

public class Par<F, S> {
    private F primero;
    private S segundo;

    public Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public F getPrimero() {
        return primero;
    }

    public S getSegundo() {
        return segundo;
    }

    public void setPrimero(F primero) {
        this.primero = primero;
    }

    public void setSegundo(S segundo) {
        this.segundo = segundo;
    }

    @Override
    public String toString() {
        return "(Primero: " + primero + ", Segundo: " + segundo + ")";
    }
    
    //MÉTODO ES ESIGUAL
    public boolean esIgual(Par<F, S> otro) {
        if (otro == null) {
            return false;
        }

        return (primero == null ? otro.primero == null : primero.equals(otro.primero)) &&
               (segundo == null ? otro.segundo == null : segundo.equals(otro.segundo));
    }
}
