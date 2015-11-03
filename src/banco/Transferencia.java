package banco;

import java.math.BigDecimal;

public class Transferencia {
	
	private Cuenta cuentaOrigen;
	private Cuenta cuentaDestino;
	private BigDecimal valor;
	private int identificadorTransferencia;
	
public Transferencia (int identificadorTransferencia, Cuenta cuentaOrigen, Cuenta cuentaDestino, BigDecimal valor){
	this.identificadorTransferencia=identificadorTransferencia;
	this.cuentaOrigen=cuentaOrigen;
	this.cuentaDestino=cuentaDestino;
	this.valor=valor;
	}

public Cuenta getCuentaOrigen(){
	return cuentaOrigen;
}

public Cuenta getCuentaDestino(){
	return cuentaDestino;
}

public BigDecimal getValor(){
	return valor;
}

public int getidentificadorTransferencia(){
	return identificadorTransferencia;
}

}


