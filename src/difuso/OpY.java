package difuso;

import java.util.ArrayList;
import java.util.List;

public class OpY  {

	List<FSemantica> funciones;
	List<Variable> variables;

	public OpY () {		
		funciones = new ArrayList<FSemantica>();
		variables = new ArrayList<Variable>();
	}
	
	public void anadir(FSemantica f, Variable v)  {
		// Máximo de operandos = 2
		if (funciones.size() <2) {
			funciones.add(f);
			variables.add(v);
		}
		
	}
	
	public float evaluar(float x, float y) {
		
		float r1=funciones.get(0).call(variables.get(0).a, variables.get(0).b, x);
		float r2=funciones.get(1).call(variables.get(1).a, variables.get(1).b, y);		 
		System.out.println("Operador Y: operando 1-> " +r1);
		System.out.println("Operador Y: operando 2-> " +r2);
		
		float resultado = Math.min(r1,r2);
		System.out.println("Valor operador Y-> " +resultado);
		
		return resultado;
	}

	
}
