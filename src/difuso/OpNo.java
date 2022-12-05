package difuso;

/**
 * Aplicación creadora de sistemas expertos nítidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Sistema Experto Difuso
 * Operador de complementación
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */

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
