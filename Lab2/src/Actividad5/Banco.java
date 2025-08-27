package Actividad5;
import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
	private static ArrayList <Cuenta> cuentas = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);
	
	private static Cuenta buscarCuenta(int numCuenta) {
		for (Cuenta c : cuentas) {
			if (c.getNumCuenta() == numCuenta) {
				return c;
			}
		}
		return null;
	}
	
	private static void realizarDeposito() {
		System.out.println("Ingrese el número de la cuenta: ");
		int num = sc.nextInt();
		Cuenta c = buscarCuenta(num);
		if (c != null) {
			System.out.print("Ingrese el monto a depositar: ");
			double monto = sc.nextDouble();
			c.depositar(monto);
		} else {
			System.out.println("La cuenta no se ha encontrado.");
		}
	}
	
	private static void realizarRetiro() {
		System.out.println("Ingrese el número de la cuenta: ");
		int num = sc.nextInt();
		Cuenta c = buscarCuenta(num);
		if (c != null) {
			System.out.print("Ingrese el monto a retirar: ");
			double monto = sc.nextDouble();
			c.retirar(monto);
		} else {
			System.out.println("No se ha encontrado la cuenta.");
		}
	}
	
	private static void consultarCuenta() {
		System.out.print("Ingrese el número de cuenta: ");
		int num = sc.nextInt();
		Cuenta c = buscarCuenta(num);
		if (c != null) {
			c.consultar();
		} else {
			System.out.println("No se ha encontrado la cuenta.");
		}
	}
		

	public static void main(String[] args) {
		
		cuentas.add(new CuentaAhorro(1000,5000));
		cuentas.add(new CuentaAhorro(1001,300));
		cuentas.add(new CuentaCorriente(2001,1050));
		cuentas.add(new CuentaCorriente(2002,10000));
		
		boolean salir = false;
		
		while(!salir) {
			System.out.println("Menú de Banco");
			System.out.println("D) Depositar");
			System.out.println("R) Retirar");
			System.out.println("C) Consultar");
			System.out.println("S) Salir");
			System.out.print("Ingrese una opción: ");
			String opcion = sc.next().toUpperCase();
			
			switch (opcion) {
			case "D":
				realizarDeposito();
				break;
			case "R":
				realizarRetiro();
				break;
			case "C":
				consultarCuenta();
				break;
			case "S":
				break;
			default:
				System.out.println("Ingresaste una opción inválida.");
			}
			
			
		}
	}

}
