package difuso;

import java.util.ArrayList;
import java.util.List;

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
			System.out.println("Valor a agregar " + valor);
			if (valor > max) {
				max = valor;
			}
		}
		System.out.println("Valor operador O-> " + max);

		return max;
	}

	

}
