package Actividades;

public class CuentaBancaria {
    private String numCuenta;
    private String titular;
    private double saldo;
    private boolean activa = true;

    public CuentaBancaria(String numCuenta, String titular, double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("Se ha intentado crear una cuenta con saldo negativo");
        }
        this.numCuenta = numCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo");
        }
        this.saldo += monto;
    }
    
    public void retirar(double monto) throws SaldoInsuficienteException{
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo");
        }
        if (this.saldo < monto) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        this.saldo -= monto;
    }
    
    public void transferir(CuentaBancaria destino, double monto) throws CuentaNoEncontradaException, SaldoInsuficienteException{
    	if (destino == null || !destino.isActiva()) {
    		throw new CuentaNoEncontradaException("No se ha encontrado la cuenta o está inactiva");
    	}
    	if (this.saldo < monto) {
    		throw new SaldoInsuficienteException("No hay saldo suficiente para transferir");
    	}
    	this.saldo -= monto;
    	destino.depositar(monto);
    }
    
    public void cerrarCuenta() throws SaldoNoCeroException{
    	if (this.saldo != 0) {
    		throw new SaldoNoCeroException("No se puede cerrar la cuenta, tiene dinero dentro. Para cerrarlo, el saldo tiene que ser cero");
    	}
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}
    
}