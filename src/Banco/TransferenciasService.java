package Banco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


//validar q sea posible

public class TransferenciasService{

	private static final int ID_INICIAL_DE_TRANSFERENCIA = 40000;
	private static int consecutivoActualTransferencia = ID_INICIAL_DE_TRANSFERENCIA;
	//private List<Transferencia> listaTransferencias = new ArrayList<Transferencia>() ;

	
	
	
	public int realizarTransferencia(Cuenta cuentaOrigen, Cuenta cuentaDestino, BigDecimal valorTransferir) {
		
		Transferencia transferencia = new Transferencia(consecutivoActualTransferencia, cuentaOrigen, cuentaDestino, valorTransferir);
		consecutivoActualTransferencia++;
	
		String[] resultadoValidacion = new String[] {
				comprobarDisponibilidadFondos(cuentaOrigen, valorTransferir),
				comprobarCuentasSeanDiferente(cuentaOrigen.getNumeroCuenta(), cuentaDestino.getNumeroCuenta()),
				comprobarCuentaActiva(cuentaOrigen, cuentaDestino)
		};
		
		List<String> erroresValidaciones = armarListaErroresValidacion(resultadoValidacion);
		
		if(erroresValidaciones.isEmpty()) {
			//Luz verde para hacer la transferencia
		} else {
			//Lanzar Excepción
		}
		
		//listaTransferencias.add(transferencia);
		return consecutivoActualTransferencia;
	}
	
	private List<String> armarListaErroresValidacion(String[] resultadoValidacion) {
		List<String> mensajesValidaciones = new ArrayList<String>();
		for(String resultado : resultadoValidacion) {
			if(resultado != null) {
				mensajesValidaciones.add(resultado);
			}
		}
		return mensajesValidaciones;
	}
	
	private String comprobarDisponibilidadFondos(Cuenta cuentaOrigen, BigDecimal valorTransferir) {	
		String mensajeSaldoInsuficiente = "No se puede hacer la transferencia por saldo insuficiente";
		
		if (!cuentaOrigen.esValorValidoDebitar(valorTransferir)) {
			return mensajeSaldoInsuficiente;
		}
		
		return null;
	}
	
	private String comprobarCuentasSeanDiferente(int cuentaOrigen, int cuentaDestino) {
		String mensajeComprobarCuentaOrigenDestinoNoIguales = "No se puede hacer la transferencia, la cuenta de origen y destino son iguales";
		if (cuentaOrigen == cuentaDestino) {
			return mensajeComprobarCuentaOrigenDestinoNoIguales;
		} 
		return null;
	}
	
	private String comprobarCuentaActiva(Cuenta cuentaOrigen, Cuenta cuentaDestino) {
		String mensajeEstadoCuentas = "El estado de las cuentas origen y destino No es ACTIVO";
		String mensajeEstadoCuentaOrigen = "El estado de la cuenta de origen No es ACTIVO";
		String mensajeEstadoCuentaDestino = "El estado de la cuenta de destino No es ACTIVO";
		
		if(!cuentaOrigen.isActiva() && !cuentaDestino.isActiva()) {			
			return mensajeEstadoCuentas;
		} else if(!cuentaOrigen.isActiva()) {			
			return mensajeEstadoCuentaOrigen;			
		} else if (!cuentaDestino.isActiva()) {			
			return mensajeEstadoCuentaDestino;	
		}
		return null;	
	}
	

/*
 * static void rango(int num, int den)throws ExcepcionIntervalo{
        if((num>100)||(den<-5)){
            throw new ExcepcionIntervalo("N�meros fuera del intervalo");
        }
 * */
	
	public static void main(String[] args) {
		List<String> mensajesValidaciones = new ArrayList<String>();
		mensajesValidaciones.add(null);
		System.out.println("Tamaño: " + mensajesValidaciones.size());
	}
}
 