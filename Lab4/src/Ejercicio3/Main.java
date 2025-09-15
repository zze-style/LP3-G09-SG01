package Ejercicio3;

public class Main {

	public static void main(String[] args) {
		
		Numero numero = new Numero();
		
		try {
			numero.setValor(5.0);
			System.out.println("El valor de numero es: "+ numero.getValor());
			
			numero.setValor(-2.0);
			System.out.println("El valor de numero es: "+ numero.getValor());

		} catch (IllegalArgumentException e){
			System.err.println("Se ha encontrado un error: "+e.getMessage());
		}
	}
}
