package Actividad2;

public class ContadorTest{

	public static void main(String[] args) {
		Contador c1, c2, c3, c4;
		
		System.out.println("El acumulador inicial es: "+Contador.acumulador());
		
		
		System.out.println(Contador.acumulador());
		
		c1 = new Contador(3);
		System.out.println("Valor de c1: "+c1.getValor());
		System.out.println("Valor del contador después de crear c1: "+Contador.acumulador());
		
		c2 = new Contador(10);
		System.out.println("Valor de c2: "+c2.getValor());
		System.out.println("Valor del contador después de crear c2: "+Contador.acumulador());
		
		c3 = new Contador(20);
		c4 = new Contador(30);
		
		c1.inc();
		c1.inc();
		c2.inc();
		System.out.println("Valor de c1 después de incrementarse dos veces: "+c1.getValor());
		System.out.println("Valor del contador después de incrementar c1:" + Contador.acumulador());
		
		System.out.println("Valor de c2 después de incremetarse una vez: "+c2.getValor());
		System.out.println("Valor del contador después de incrementar c2: "+Contador.acumulador());
		
		System.out.println("Cantidad de contadores creados: "+ Contador.getNContadores());
		
		System.out.println("El último contador es: "+Contador.getUltimoContador());
	}

}
