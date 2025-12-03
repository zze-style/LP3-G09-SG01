package Strategy;

public class Main {
	public static void main(String[] args) {
		PriceCalculator calculator = new PriceCalculator();

		calculator.setDiscountStrategy(new NoDiscount());
		System.out.println("Precio sin descuento: " + calculator.calculatePrice(100.0));

		calculator.setDiscountStrategy(new TenPercentDiscount());
		System.out.println("Precio con 10% de descuento: " + calculator.calculatePrice(100.0));

		calculator.setDiscountStrategy(new TwentyPercentDiscount());
		System.out.println("Precio con 20% de descuento: " + calculator.calculatePrice(100.0));
		
		calculator.setDiscountStrategy(new MitadDescuento());
		System.out.println("Precio con mitad de descuento: " + calculator.calculatePrice(100.0));
	}
} 