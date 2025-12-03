package Strategy;

class PriceCalculator {
	private DiscountStrategy discountStrategy;
	public void setDiscountStrategy(DiscountStrategy discountStrategy) {
		this.discountStrategy = discountStrategy;
	}
	public double calculatePrice(double price) {
		return discountStrategy.applyDiscount(price);
	}
} 
