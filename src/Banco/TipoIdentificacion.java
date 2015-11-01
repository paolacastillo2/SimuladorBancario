package Banco;

public enum TipoIdentificacion {
	
	CC("Cedula de ciudadania"), 
	P("Pasaporte"), 
	CE("Cedula de extranjeria"), //tilde,
	TI("Tarjeta de Identidad"); 
	
	
	TipoIdentificacion(){
		
	}
	
	private String descripcion;
	
	TipoIdentificacion(String descripcion){
		this.descripcion = descripcion;
	}
   
	public String getDescripcion(){
		return descripcion;
	}
 }