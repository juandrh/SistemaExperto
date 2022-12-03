
public class OpNo extends Operador{
	
	Expresion exp;
	
	
	public OpNo(Expresion exp) {
		this.exp  = exp;
		
	}
	
	public boolean evaluar()
	{		
		return !(exp.evaluar());
		
	}
	
	public String getDescripcion()
	{
		return "No "+ exp.getDescripcion();
		
	}
	
	public String toString() {		
		return getDescripcion();
	}

	@Override
	public boolean contiene(Expresion exp) {		
		return this.exp.contiene(exp);
	}

}
