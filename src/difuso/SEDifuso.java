package difuso;

import java.util.ArrayList;
import java.util.List;

import principal.SistemaExperto;

public class SEDifuso implements SistemaExperto {

	Variable E;
	Variable T;
	Variable VC;

	List<OpY> operadores;
	List<Regla> reglas;
	List<Regla> conflictos;
	List<Float> limitesConflictos;
	float inputE, inputT;
	float resultadoAntecedente;
	float valorNitidificado;

	// Añadir hechos (valores de entrada)
	@Override
	public void crearVariables() {
		E = new Variable("E", -1.0f, 1.0f);
		T = new Variable("T", -0.5f, 0.5f);
		VC = new Variable("VC", -0.5f, 0.5f);

		operadores = new ArrayList<OpY>();
		reglas = new ArrayList<Regla>();
		conflictos = new ArrayList<Regla>();
		limitesConflictos = new ArrayList<Float>();

		resultadoAntecedente = 0.0f;

	}

	@Override
	public void añadirDatosEntrada() {
		inputE = -0.5f;
		inputT = 0.7f;

	}

	@Override
	public void añadirReglas() {
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

	}

	@Override
	public void ejecutarMotor() {
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

			agregacion.anadir(conflictos.get(i).getFConsecuente(), limitesConflictos.get(i));
		}
		// Paso 5. Nitidificación, búsqueda del centroide

		float x[] = { -1.0f, -0.5f, -0.33f, -0.25f, 0.25f, 0.5f }; // Puntos donde hay un cambio de tendencia
		float sumaNumerador = 0.0f;
		float sumaDenominador = 0.0f;
		for (int i = 0; i < x.length; i++) {
			sumaNumerador += x[i] * agregacion.evaluar(x[i]);
			sumaDenominador += agregacion.evaluar(x[i]);
		}

		valorNitidificado = sumaNumerador / sumaDenominador;

	}

	@Override
	public void mostrarResultado() {
		System.out.println("valor nitidificado  : " + valorNitidificado);

	}

}
