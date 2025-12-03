package Strategy;

class TwentyPercentDiscount implements DiscountStrategy {
	public double applyDiscount(double price) {
		return price * 0.8;
	}
} 
