package StrategyVideo;

class TarjetaStrategy implements ComisionEstrategia {
	public double calcularMontoFinal (double montoBase) {
		if (montoBase > 100) {
			return montoBase * 1.03;
		}
		else {
			return montoBase;
		}
	}
} 