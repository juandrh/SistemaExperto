
public class OpO extends Operador {

	Expresion exp1;
	Expresion exp2;
	
	
	public OpO(Expresion exp1, Expresion exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
		descripcion = exp1.descripcion + " O " + exp2.descripcion; 
	}
	
	public boolean evaluar()
	{
		return exp1.evaluar() || exp2.evaluar();
	}
	
	public String getDescripcion()
	{
		return descripcion;
		
	}
	
	public String toString() {		
		return descripcion  ;
	}

}
