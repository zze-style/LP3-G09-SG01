package Strategy;

class NoDiscount implements DiscountStrategy {
	public double applyDiscount(double price) {
		return price;
	}
} 

