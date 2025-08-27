package Actividad1;

public class Coche{
	
	private String marca;
	private String modelo;
	private int anio;
	private double precio;
	private boolean encendido;
	private int velocidad;
	
	public Coche() {
		this.marca = "Desconocido";
		this.modelo = "Sin modelo";
		this.anio = 2000;
		this.precio = 0.0;
		this.encendido = false;
		this.velocidad = 0;
	}
	
	public Coche(String marca, String modelo, int anio, double precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.precio = precio;
		this.encendido = false;
		this.velocidad = 0;
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

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean estaEncendido() {
		return encendido;
	}

	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public void encender() {
		if (!encendido) {
			encendido = true;
			System.out.println(modelo + " ha sido encendido.");
		} else {
			System.out.println(modelo + " ya está encendido");
		}
	}

	public void aplicarDescuento() {
		if (anio < 2010) {
			double descuento = precio * 0.15;
			precio -= descuento;
			System.out.println("El auto es más antiguo al año 2010. Se aplicó un descuento de S/" + descuento + ". El nuevo precio es S/" + precio);
		} else {
			System.out.println("No se han aplicado descuentos porque el auto no es más antiguo al año 2010.");
		}
	}
	
	public void mostrarInfo() {
		System.out.println("INFORMACIÓN DEL VEHÍCULO");
		System.out.println("Marca: " + marca);
		System.out.println("Modelo: " + modelo);
		System.out.println("Año: " + anio);
		System.out.println("Precio: " + precio);
		aplicarDescuento();
		System.out.println("------------------------");
	}
	
	public void acelerar(int incremento) {
		if (encendido) {
			velocidad += incremento;
			System.out.println(modelo + " está acelenado a " + velocidad + " km/h");
		} else {
			System.out.println(modelo + " está apagado. No se puede acelerar");
		}
	}
	
	public void frenar(int decremento) {
		if (encendido) {
			velocidad -= decremento;
			
			if (velocidad > 0) {
				System.out.println(modelo + " está frenando. Su velocidad actual es " + velocidad);
			}
			
			if (velocidad <= 0) {
				velocidad = 0;
				System.out.println(modelo + " está frenando. Su velocidad actual es " + velocidad);	
			}
		} else {
			System.out.println(modelo + " está apagado. No se puede frenar");
		}
	}
	
	public static void main(String[] args) {
		
		Coche coche1 = new Coche();
		coche1.mostrarInfo();
		
		Coche coche2 = new Coche("Toyota", "Yaris", 2014, 40000);
		coche2.mostrarInfo();
		
		Coche coche3 = new Coche("Daewoo", "Tico", 2005, 3000);
		coche3.mostrarInfo();
	}
}
