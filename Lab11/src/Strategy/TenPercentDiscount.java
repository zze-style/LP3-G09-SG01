package Strategy;

class TenPercentDiscount implements DiscountStrategy {
	public double applyDiscount(double price) {
		return price * 0.9;
	}
} 

