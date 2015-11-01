package Banco;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// debitar y acreditar 

public class CuentasService {

	private static final int ID_INICIAL_CUENTA = 10000;
	private static int consecutivoActualCuenta = ID_INICIAL_CUENTA ;
	private static List <Cuenta> listaCuentaCliente = new ArrayList<Cuenta>();
	
	private List<Cuenta> listaCuenta = new ArrayList<Cuenta>(); 
	private BigDecimal NuevoSaldocuentaOrigen;
	
	public Cuenta crearCuenta(TipoCuenta tipoCuenta, BigDecimal saldo, EstadoCuenta estadoCuenta, Cliente cliente){
		 
		Cuenta cuenta = new Cuenta(consecutivoActualCuenta, tipoCuenta, saldo, estadoCuenta, cliente);
		consecutivoActualCuenta++;
		listaCuenta.add(cuenta);
		return cuenta;
	}
	
		public 	void imprimirLista(){
		
		for(int i=0; i < listaCuenta.size();i ++){
			
			System.out.println("Lista de cuentas: "+listaCuenta.get(i));
		}
		
		
	}
	public BigDecimal debitarValorCuentaOrigen(BigDecimal valorDebitar, BigDecimal saldoCuentaOrigen){
		
		
		saldoCuentaOrigen = saldoCuentaOrigen.subtract(valorDebitar);
		
		return saldoCuentaOrigen;
		
	}
    public BigDecimal acreditarValorCuentaDestino(BigDecimal valorAcreditar, BigDecimal saldoCuentadestino){
		
    	saldoCuentadestino = saldoCuentadestino.add(valorAcreditar);
		
		return saldoCuentadestino;
		
	}

}

