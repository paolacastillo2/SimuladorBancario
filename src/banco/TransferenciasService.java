package banco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


//validar q sea posible

public class TransferenciasService{

	private static final int ID_INICIAL_DE_TRANSFERENCIA = 40000;
	private static int consecutivoActualTransferencia = ID_INICIAL_DE_TRANSFERENCIA;


	public Transferencia realizarTransferencia(Cuenta cuentaOrigen, Cuenta cuentaDestino, BigDecimal valorTransferir) throws TransferenciaException {
		
		Transferencia transferencia = new Transferencia(consecutivoActualTransferencia, cuentaOrigen, cuentaDestino, valorTransferir);
		consecutivoActualTransferencia++;
	
		String[] resultadoValidacion = new String[] {
				comprobarDisponibilidadFondos(cuentaOrigen, valorTransferir),
				comprobarCuentasSeanDiferente(cuentaOrigen.getNumeroCuenta(), cuentaDestino.getNumeroCuenta()),
				comprobarCuentaActiva(cuentaOrigen, cuentaDestino)
		};
		
		List<String> erroresValidaciones = armarListaErroresValidacion(resultadoValidacion);
		if(erroresValidaciones.isEmpty()) {
			cuentaOrigen.debitar(valorTransferir);
			cuentaDestino.acreditar(valorTransferir);
			
		} else {
			
			throw new TransferenciaException(""+erroresValidaciones);
		
		}
		return transferencia;
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
		String mensajeSaldoInsuficiente = "No se puede hacer la transferencia porque el valor a transferir no cumple las restricciones";
		
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
	
	public static void main(String[] args) throws TransferenciaException {
		BigDecimal debitar = new BigDecimal(260);
		Cuenta cuentaOrigen = new Cuenta(10001, TipoCuenta.AHORROS, BigDecimal.valueOf(10000), EstadoCuenta.ACTIVA, null);
		Cuenta cuentaDestino = new Cuenta(10002, TipoCuenta.AHORROS, BigDecimal.valueOf(20000), EstadoCuenta.ACTIVA, null);
		TransferenciasService trasferencia = new TransferenciasService();
		trasferencia.comprobarDisponibilidadFondos(cuentaOrigen, debitar);
		trasferencia.comprobarCuentaActiva(cuentaOrigen, cuentaDestino);
		trasferencia.comprobarCuentasSeanDiferente(cuentaOrigen.getNumeroCuenta(), cuentaDestino.getNumeroCuenta());
		trasferencia.realizarTransferencia(cuentaOrigen, cuentaDestino, debitar);
	

	}
}
 