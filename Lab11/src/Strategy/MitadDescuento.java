package Strategy;

class MitadDescuento implements DiscountStrategy {
	public double applyDiscount(double price) {
		return price * 0.50;
	}
} 