package ejercicio1;

public class PagoMensual {
	
	public void pagoMensual(Empleado empleado) {
		System.out.println("Se ha pagado al empleado " + empleado.getNombre() + " con salario "+ empleado.getSalario());
	}
	
	public static void main(String[] args) {
		
		Empleado empleado = new Empleado("Jose", 1000, "Sistemas");
		PagoMensual pago = new PagoMensual();
		
		pago.pagoMensual(empleado);

	}

}
