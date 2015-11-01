package Banco;


import java.util.ArrayList;
import java.util.List;

public class ClientesService {
	
	private static final int ID_INICIAL_DE_CLIENTE = 30000;
	private static int consecutivoActualCliente = ID_INICIAL_DE_CLIENTE;
	
	private static List<Cliente> listaCliente = new ArrayList<Cliente>();
	
	public Cliente crearCliente(String numId, TipoIdentificacion tipoId, TipoCliente tipoCliente){
		
		Cliente cliente = new Cliente(consecutivoActualCliente,numId, tipoId, tipoCliente);
		consecutivoActualCliente++;
		listaCliente.add(cliente);
	
		return cliente;
	}
	
	public 	void imprimirLista(){
		
		for(int i=0; i < listaCliente.size();i ++) {
			
			System.out.println("Lista de clientes: "+listaCliente.get(i));
		}
	}

	public  Cliente getListaCliente(TipoIdentificacion tipoIdCliente, String numId){
		
		for(int indice=0; indice < listaCliente.size(); indice++){
			if (listaCliente.get(indice).getNumId().equals(numId) && listaCliente.get(indice).getTipoIdCliente().equals(tipoIdCliente) ){
				return listaCliente.get(indice);
			}
		}
		return null;
	}
	
		 
	
	
	
	
}
