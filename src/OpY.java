
public class OpY extends Operador {

	Expresion exp1;
	Expresion exp2;
	
	
	public OpY(Expresion exp1, Expresion exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
		descripcion =  exp1.descripcion + " Y " + exp2.descripcion ;  
	}
	
	public boolean evaluar()
	{
		return exp1.evaluar() && exp2.evaluar();
	}
	
	public String descripcion()
	{
		return descripcion;
		
	}
	
	public String toString() {		
		return descripcion  ;
	}


}
