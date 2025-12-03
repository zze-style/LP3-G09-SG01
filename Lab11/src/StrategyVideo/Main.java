package StrategyVideo;

public class Main {
	public static void main(String[] args) {
		PriceCalculator calculator = new PriceCalculator();
		
		double montoOperacion = 150.0;

		calculator.setMetodoPagoStrategy(new EfectivoStrategy());
		System.out.println("Precio con efectivo: " + calculator.calcularMontoFinal(montoOperacion));

		calculator.setMetodoPagoStrategy(new TarjetaStrategy());
		System.out.println("Precio de pago con tarjeta: " + calculator.calcularMontoFinal(montoOperacion));

		calculator.setMetodoPagoStrategy(new BilleteraVirtualStrategy());
		System.out.println("Precio de pago con billetera virtual: " + calculator.calcularMontoFinal(montoOperacion));
		
;
	}
} 