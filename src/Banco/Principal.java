package Banco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Principal {

	 public static void main(String[] args){
	    	
		    
		 CuentasService cuentaService = new CuentasService();
		 ClientesService clienteService1 = new ClientesService();
		 
		 Cliente cliente1 = clienteService1.crearCliente("40047555",TipoIdentificacion.CC,TipoCliente.REGULAR);
		 Cliente cliente2 = clienteService1.crearCliente("40047555",TipoIdentificacion.CC,TipoCliente.REGULAR);
		 
		 Cuenta cuenta1 = new Cuenta(10000, TipoCuenta.AHORROS, BigDecimal.valueOf(56789), EstadoCuenta.ACTIVA, cliente1) ;
		 Cuenta cuenta2 = new Cuenta(10000, TipoCuenta.AHORROS, BigDecimal.valueOf(56789), EstadoCuenta.ACTIVA, cliente1) ;
		 
		 //int identificadorTransferencia, Cuenta cuentaOrigen, Cuenta cuentaDestino, BigDecimal valorTransfer
		 TransferenciasService transferencia = new TransferenciasService();
		 
		 transferencia.realizarTransferencia(cuenta1, cuenta2, BigDecimal.valueOf(50000));
		 
		 
		
		 
				
		 
	 	}       
	 }
