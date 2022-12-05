package difuso;


public class OpNo   {

	FSemantica funcion;
	Variable variable;
	
	public void anadir(FSemantica f, Variable v) {
		funcion = f;
		variable = v;
		
	}

	public float evaluar(float x) {
		
		return -funcion.call(variable.a, variable.b, x);
	}
	
	

}
