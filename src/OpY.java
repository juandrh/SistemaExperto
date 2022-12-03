
public class OpY extends Operador {

	Expresion exp1;
	Expresion exp2;
	
	
	public OpY(Expresion exp1, Expresion exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
		
	}
	
	public boolean evaluar()
	{
		return exp1.evaluar() && exp2.evaluar();
	}
	
	public String getDescripcion()
	{
		return exp1.descripcion + " Y " + exp2.descripcion ;  
		
	}
	
	public String toString() {		
		return getDescripcion();
	}

	@Override
	public boolean contiene(Expresion exp) {
		
		return exp1.contiene(exp) || exp2.contiene(exp);
	}


}
