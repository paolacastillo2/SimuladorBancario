package Banco;

//papa
public abstract class LiquidadorIntereses {

	public abstract void liquidarIntereses();
	public abstract void acreditarIntereses();
	
	public void liquidar(){
		
		liquidarIntereses();
		acreditarIntereses();
	
	}
}


//consultar c
