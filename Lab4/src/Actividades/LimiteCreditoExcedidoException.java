package Actividades;

public class LimiteCreditoExcedidoException extends RuntimeException{
	public LimiteCreditoExcedidoException(String mensaje) {
        super(mensaje);
	}
}
