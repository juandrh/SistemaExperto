package difuso;

import java.util.ArrayList;

import java.util.List;
/**
 * Aplicación creadora de sistemas expertos nítidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Sistema Experto Difuso
 * Operador de agregación
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */
public class OpO {

	List<FSemantica> funciones;
	Variable variable;
	float limite;

	public OpO(Variable variable) {

		funciones = new ArrayList<FSemantica>();
		this.variable = variable;
		
	}

	public void anadir(FSemantica f, float limite) {
		funciones.add(f);
		this.limite = limite;
	}

	public float evaluar(float x) {

		float max = 0.0f;

		for (int i = 0; i < funciones.size(); i++) {
			
			//mínimo entre el valor del consecuente y el valor del antecedente
			float valor = Math.min(funciones.get(i).call(variable.a, variable.b, x),limite);			
			if (valor > max) {
				max = valor;
			}
		}
		return max;
	}

	

}
