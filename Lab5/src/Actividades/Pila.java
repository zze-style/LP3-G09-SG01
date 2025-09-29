package Actividades;


class ExcepcionPilaLlena extends RuntimeException {
    public ExcepcionPilaLlena(String mensaje) {
        super(mensaje);
    }
}

class ExcepcionPilaVacia extends RuntimeException {
    public ExcepcionPilaVacia(String mensaje) {
        super(mensaje);
    }
}

public class Pila<E> {
    
    private final int tamanio;
    private int superior;
    private E[] elementos;

    public Pila() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public Pila(int s) {
        tamanio = s > 0 ? s : 10;
        superior = -1;
        elementos = (E[]) new Object[tamanio];
    }

    
    public void push(E valorAMeter) {
        if (superior == tamanio - 1) {
            throw new ExcepcionPilaLlena(String.format(
                "La Pila esta llena, no se puede meter %s", valorAMeter));
        }
        elementos[++superior] = valorAMeter;
    }


    public E pop() {
        if (superior == -1) {
            throw new ExcepcionPilaVacia("Pila vacia, no se puede sacar");
        }
        return elementos[superior--];
    }

    
    public boolean contains(E elemento) {
        
        for (int i = superior; i >= 0; i--) {
            E elementoActual = elementos[i];

            if (elementoActual == null && elemento == null) {
                return true;
            }
            
            if (elementoActual != null && elementoActual.equals(elemento)) {
                return true;
            }
        }
        
        return false;
    }

}