package Actividad5;

public class CuentaCorriente extends Cuenta{
	
	private int contadorRetiros = 0;
	private final int retirosGratis = 0;
	private final double tarifaExtra = 3.0;
	
	public CuentaCorriente(int numCuenta, double saldo) {
		super(numCuenta,saldo);
	}
	
	@Override
	public void retirar(double monto) {
        if (monto <= 0 || monto > saldo) {
            System.out.println("Monto inválido o saldo insuficiente.");
            return ;
        }
        
        super.retirar(monto);
        contadorRetiros++;
        
        if (contadorRetiros > retirosGratis) {
        	if (saldo >= tarifaExtra) {
        		saldo -= tarifaExtra;
        		System.out.println("Se aplicó una tarifa de S/. 3 por el retiro adicional.");
        		
        	} else {
        		System.out.println("No se puede aplicar la tarifa, su saldo es insuficiente.");
        	}
        }
	}
	
	@Override
	public void consultar() {
		System.out.println("Cuenta Corriente: "+numCuenta);
		System.out.println("Saldo actual: "+saldo);
		System.out.println("Retiros realizados: "+contadorRetiros);
		contadorRetiros = 0;
	}

}
