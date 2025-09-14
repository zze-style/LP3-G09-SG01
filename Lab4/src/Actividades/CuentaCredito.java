package Actividades;

public class CuentaCredito extends CuentaBancaria{
	
	private double limiteCredito;
	
	public CuentaCredito(String numCuenta, String titular, double saldo, double limiteCredito) {
		super(numCuenta, titular, saldo);
		if (limiteCredito < 0) {
			throw new IllegalArgumentException("El límite no puede ser negativo");
		}
		this.limiteCredito = limiteCredito;
	}
	
	@Override
	public void retirar(double monto) throws LimiteCreditoExcedidoException {
		if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo");
        }
        if ( getSaldo() + this.limiteCredito < monto) {
            throw new LimiteCreditoExcedidoException("La operación supera el límite de crédito");
        }
        setSaldo(getSaldo()-monto);
	}
	
	@Override
	public void transferir(CuentaBancaria destino, double monto) throws LimiteCreditoExcedidoException{
		if (monto <= 0) {
            throw new IllegalArgumentException("El monto a transferir debe ser positivo");
        }
        if (getSaldo() + this.limiteCredito < monto) {
            throw new LimiteCreditoExcedidoException("La operación de transferencia supera el límite de crédito disponible.");
        }
        setSaldo(getSaldo() - monto);
        destino.depositar(monto);
	}
	
	public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

}
