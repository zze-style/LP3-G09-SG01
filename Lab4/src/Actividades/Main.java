package Actividades;

public class Main {

	public static void main(String[] args) {
		
		try {
			CuentaBancaria cuenta1 = new CuentaBancaria("0001","Jose",100);
			CuentaBancaria cuenta2 = new CuentaBancaria("0002","Mateo",400);
			CuentaCredito cc1 = new CuentaCredito("0003","Rooney",200,300);
			
			cuenta1.transferir(cuenta2, 30);
			System.out.println("Cuenta 1: "+cuenta1.getSaldo());
			System.out.println("Cuenta 2: "+cuenta2.getSaldo());
			
			
			cc1.retirar(200);
			cc1.retirar(500);
			System.out.println("Cuentacredito 1: "+cc1.getSaldo());
			
			cuenta1.retirar(10);
			cuenta1.cerrarCuenta();
			System.out.println("Se ha cerrado la cuenta 1");

			
			
		} catch (CuentaNoEncontradaException | SaldoInsuficienteException | SaldoNoCeroException e) {
			System.out.println("Error: "+e.getMessage());
		}

	}

}
