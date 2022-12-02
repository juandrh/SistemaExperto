
public class OpNo extends Operador{
	
	Expresion exp;
	
	
	public OpNo(Expresion exp) {
		this.exp  = exp;
		descripcion = " No "+exp.descripcion; 
	}
	
	public boolean evaluar()
	{		
		return !(exp.evaluar());
		
	}
	
	public String getDescripcion()
	{
		return descripcion;
		
	}
	
	public String toString() {		
		return "No "+ descripcion;
	}

}
