package Actividad5;

public class CuentaAhorro extends Cuenta {
	private double saldoMinimo = 100;
	private double interes = 0.02;
	
	
	public void setTasaInteres(double interes) {
		this.interes = interes;
	}
	public CuentaAhorro(int numCuenta, double saldo) {
		super(numCuenta, saldo);
		saldoMinimo = saldo;
	}
	
	@Override
	public void retirar(double monto) {
		if (getSaldo() - monto >= 0) {
			super.retirar(monto);
			if (saldo < saldoMinimo) {
				saldoMinimo = saldo;
			}
		} else {
			System.out.println("Retiro no permitido, el saldo es insuficiente");
		}
	}
	
	@Override
	public void consultar() {
		double tasaInteres = saldoMinimo * interes;
		super.depositar(interes);
		System.out.println("Cuenta de ahorro: "+numCuenta);
		System.out.println("Los intereses son: "+ tasaInteres);
		System.out.println("El saldo actualizado es " +saldo);
		saldoMinimo = saldo;
		
	}

}
