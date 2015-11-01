package Banco;

import java.math.BigDecimal;

public class Cuenta {

	private int numeroCuenta;
	private TipoCuenta tipoCuenta;
	private BigDecimal saldo ;
	private EstadoCuenta estadoCuenta;
	private Cliente cliente;

	public Cuenta(int numeroCuenta,TipoCuenta tipoCuenta,BigDecimal saldo,EstadoCuenta estadoCuenta, Cliente cliente){
		this.numeroCuenta=numeroCuenta;
		this.tipoCuenta=tipoCuenta;
		this.saldo=saldo;
		this.estadoCuenta=estadoCuenta;
		this.cliente=cliente;
		}
	
	public int getNumeroCuenta(){
		return numeroCuenta;
	}
	
	public TipoCuenta getTipoCuenta(){
		return tipoCuenta;
	}
	
	public BigDecimal getSaldo(){
		return saldo;
	}
	
	public EstadoCuenta getEstadoCuenta(){
		return estadoCuenta;
	}
	
	public boolean isActiva() {
		return estadoCuenta.equals(EstadoCuenta.ACTIVA);
	}
	
	/**
	 * 
	 * @param valorADebitar
	 * @throws IllegalArgumentException si valorADebitar es mayor al saldo actual de la cuenta
	 */
	public void debitar(BigDecimal valorADebitar) throws IllegalArgumentException {
		if(!esValorValidoDebitar(valorADebitar)) {
			throw new IllegalArgumentException("Valor a debitar mayor al saldo disponible.");
		} else {
			saldo = saldo.subtract(valorADebitar);
		}
	}
	
	public boolean esValorValidoDebitar(BigDecimal valorADebitar) {
		if(saldo.compareTo(valorADebitar) < 1) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + 
				", tipoCuenta=" + tipoCuenta + 
				", saldo=" + saldo+ 
				", estadoCuenta=" + estadoCuenta + 
				", cliente=" + cliente + "]";
	}
	
}


