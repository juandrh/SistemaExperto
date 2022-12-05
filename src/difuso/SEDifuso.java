package difuso;

import java.util.ArrayList;
import java.util.List;

public class SEDifuso {

	public static void main(String[] args) {

		// Crear variables
		Variable E = new Variable("E", -1.0f, 1.0f);
		Variable T = new Variable("T", -0.5f, 0.5f);
		Variable VC = new Variable("VC", -0.5f, 0.5f);

		List<OpY> operadores = new ArrayList<OpY>();
		List<Regla> reglas = new ArrayList<Regla>();
		List<Regla> conflictos = new ArrayList<Regla>();
		List<Float> limitesConflictos = new ArrayList<Float>();
		// List<Operador> opConsecuentes = new ArrayList<Operador>();

		float inputE, inputT;
		float resultadoAntecedente = 0.0f;

		for (int i = 0; i < 9; i++) {
			operadores.add(new OpY());
		}

		operadores.get(0).anadir(new FSMenos(), E);
		operadores.get(0).anadir(new FSMenos(), T);
		Regla R0 = new Regla(operadores.get(0), new FSMas(), VC);
		reglas.add(R0);

		operadores.get(1).anadir(new FSMenos(), E);
		operadores.get(1).anadir(new FSIgual(), T);
		Regla R1 = new Regla(operadores.get(1), new FSMas(), VC);
		reglas.add(R1);

		operadores.get(2).anadir(new FSMenos(), E);
		operadores.get(2).anadir(new FSMas(), T);
		Regla R2 = new Regla(operadores.get(2), new FSIgual(), VC);
		reglas.add(R2);

		operadores.get(3).anadir(new FSIgual(), E);
		operadores.get(3).anadir(new FSMenos(), T);
		Regla R3 = new Regla(operadores.get(3), new FSMas(), VC);
		reglas.add(R3);

		operadores.get(4).anadir(new FSIgual(), E);
		operadores.get(4).anadir(new FSIgual(), T);
		Regla R4 = new Regla(operadores.get(4), new FSIgual(), VC);
		reglas.add(R4);

		operadores.get(5).anadir(new FSIgual(), E);
		operadores.get(5).anadir(new FSMas(), T);
		Regla R5 = new Regla(operadores.get(5), new FSMenos(), VC);
		reglas.add(R5);

		operadores.get(6).anadir(new FSMas(), E);
		operadores.get(6).anadir(new FSMenos(), T);
		Regla R6 = new Regla(operadores.get(6), new FSIgual(), VC);
		reglas.add(R6);

		operadores.get(7).anadir(new FSMas(), E);
		operadores.get(7).anadir(new FSIgual(), T);
		Regla R7 = new Regla(operadores.get(7), new FSMenos(), VC);
		reglas.add(R7);

		operadores.get(8).anadir(new FSMas(), E);
		operadores.get(8).anadir(new FSMas(), T);
		Regla R8 = new Regla(operadores.get(8), new FSMenos(), VC);
		reglas.add(R8);

		// Añadir hechos (valores de entrada)

		inputE = -0.5f;
		inputT = 0.7f;

		// Motor inferencia

		// Paso 1. Evaluación del antecedente de cada regla

		for (int i = 0; i < reglas.size(); i++) {

			resultadoAntecedente = reglas.get(i).evaluaAntecedente(inputE, inputT);
			if (resultadoAntecedente != 0) {
				conflictos.add(reglas.get(i));
				limitesConflictos.add(resultadoAntecedente);

			}
		}
		System.out.println("Nº reglas que se activan: " + conflictos.size());

		// Paso 2. Obtener la conclusión de cada regla y agregar 
		OpO agregacion = new OpO(VC);

		for (int i = 0; i < conflictos.size(); i++) {

			agregacion.anadir(conflictos.get(i).getFConsecuente(),limitesConflictos.get(i) );
		}
		// Paso 5. Nitidificación, búsqueda del centroide	
		
		float x[]= {-1.0f,-0.5f,-0.33f,-0.25f,0.25f,0.5f}; // Puntos donde hay un cambio de tendencia
		float sumaNumerador=0.0f;
		float sumaDenominador=0.0f;
		for (int i=0;i < x.length;i++) {
			sumaNumerador +=x[i]* agregacion.evaluar(x[i]); 
			sumaDenominador +=agregacion.evaluar(x[i]);
		}
		
		float valorNitidificado = sumaNumerador /  sumaDenominador;		
		System.out.println("valor nitidificado  : " + valorNitidificado);
		
	}

}
