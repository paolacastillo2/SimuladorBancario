package banco;

public class Cliente {
	
	private	int codAnteBanco;
	private	String numId; 
	private TipoCliente tipoCliente;
	private TipoIdentificacion tipoIdCliente;
	
	public Cliente(int codAnteBanco, String numId, TipoIdentificacion tipoIdCliente, TipoCliente tipoCliente){
		this.codAnteBanco = codAnteBanco;
		this.numId = numId;
		this.tipoCliente = tipoCliente;
		this.tipoIdCliente = tipoIdCliente;
	}
	
	public int getCodAnteBanco(){
		
		return codAnteBanco;
	}
	
    public String getNumId(){
		return numId;
	}
    
    public TipoIdentificacion getTipoIdCliente(){
    	return tipoIdCliente;
    }
    
    public TipoCliente getTipoCliente(){
    	return tipoCliente;
    }

    @Override
	public String toString() {
		return "Cliente [codAnteBanco=" + codAnteBanco + 
				", tipoIdCliente=" + tipoIdCliente +
				", numId=" + numId +
				", tipoCliente="+ tipoCliente +"]";
	}
}
