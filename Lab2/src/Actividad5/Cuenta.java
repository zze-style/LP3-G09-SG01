package Actividad5;

import java.util.Scanner;

public class Cuenta {
	protected int numCuenta;
	protected double saldo;
	
	public Cuenta(int numCuenta, double saldo) {
		this.numCuenta = numCuenta;
		this.saldo = saldo;
	}
	
	public int getNumCuenta() {
		return numCuenta;
	}
	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void depositar(double monto) {
		if (monto > 0) {
			saldo += monto;
			System.out.println("Su nuevo saldo es: "+ saldo);
		} else {
			System.out.println("Ha ingresado una cantidad no válida");
		}
	}
	
	public void retirar(double montoretiro) {
		if (montoretiro <= saldo && montoretiro > 0) {
			saldo -= montoretiro;
			System.out.println("Su nuevo saldo es: "+ saldo);
		} else {
			System.out.println("Has ingresado una cantidad no válida.");
		}
	}
	
	public void consultar() {
	}

	public static void main(String[] args) {
		
		/*
		Cuenta c1 = new Cuenta(1000, 1000);
		c1.consultar();
		
		Cuenta c2 = new Cuenta(1000, 5000);
		c2.consultar();
		*/
	}

}
