package StrategyVideo;

class PriceCalculator {
	private ComisionEstrategia comisionStrategy;
	public void setMetodoPagoStrategy(ComisionEstrategia comisionStrategy) {
		this.comisionStrategy = comisionStrategy;
	}
	public double calcularMontoFinal(double montoBase) {
		return comisionStrategy.calcularMontoFinal(montoBase);
	}
} 
