package Banco;

import java.math.BigDecimal;

public class FondosInsuficientes extends Exception {

	
	private String cantidad;
	public FondosInsuficientes(String cantidad){
		this.cantidad=cantidad;
		
		
	}
public void verificarFondos(BigDecimal saldoCuenta1,BigDecimal montoTransferirCuenta2) throws FondosInsuficientes{
		
		
		int valor;
		
		valor =  montoTransferirCuenta2.compareTo(saldoCuenta1);
		
		if(valor == 0 ){
			System.out.print("Ambos valores son iguales");
			}
			else if (valor == -1){
				
				System.out.print("El primer valor es mayor");
				
					
			}
				
			else if (valor == 1)
				System.out.print("El segunto valor es mayor");
				
			
				
		
				
		
	}
	
	
	
}
