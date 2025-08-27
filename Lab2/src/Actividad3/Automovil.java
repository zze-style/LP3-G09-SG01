package Actividad3;

public class Automovil {
	private String placa;
	private int numPuertas;
	private String marca;
	private String modelo;
	private Motor motor;
	
	public Automovil(String placa, int numPuertas, String marca, String modelo, Motor motor) {
		this.placa = placa;
		this.numPuertas = numPuertas;
		this.marca = marca;
		this.modelo = modelo;
		this.motor = motor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public String toString() {
		return "Automovil{ placa: "+placa+", numPuertas: "+numPuertas+". marca: "+marca+", modelo: "+modelo+ motor.toString();
	}
	
	public static void main(String[] args) {
		//Automovil a1 = new Automovil("523 VGF",4,"Ferrari","F8");
		//System.out.println(a1);
	}
}