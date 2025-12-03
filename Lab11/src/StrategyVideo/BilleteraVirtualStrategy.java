package StrategyVideo;

class BilleteraVirtualStrategy implements ComisionEstrategia {
	public double calcularMontoFinal(double montoBase) {
		return montoBase + 1.50;
	}
} 

