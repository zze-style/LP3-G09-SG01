package Actividad4;

public class Cuenta {
	
	private int numero;
	private double saldo;
	
	public Cuenta(int numero, double saldo) {
		this.numero = numero;
		this.saldo = saldo;
	}
	
	public Cuenta(int numero) {
		this(numero, 0);
	}
		
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return ", cuenta: "+numero+", saldo: "+saldo+" ]";
	}
	
	public static void main(String[] args) {
		Persona p1 = new Persona(0,"Jose","Martinez",2024001234,0);
		Persona p2 = new Persona(1,"Brandon","Mendoza",2024001235,40000);
		
		System.out.println(p1);
		System.out.println(p2);

	}

}
