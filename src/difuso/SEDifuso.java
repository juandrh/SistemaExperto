package difuso;

import java.util.ArrayList;
import java.util.List;
import principal.SistemaExperto;

/**
 * Aplicación creadora de sistemas expertos nítidos o difusos
 * con base de conocimiento de ejemplo.
 * Implementa los patrones: Interpreter, Composite y factory
 * 
 * Sistema Experto Difuso
 * Clase principal
 * 
 * 
 * @author Juan Del Rio
 * @version 1.0 Dic-2022
 */


public class SEDifuso implements SistemaExperto {

	Variable V;
	Variable B;
	Variable VC;
	List<Operador> operadores;
	List<Regla> reglas;
	List<Regla> conflictos;
	List<Float> limitesConflictos;
	float entradaVelocidad, entradaBateria;	 // datos recogidos por los sensores
	float valorNitidificado;

	
	@Override
	public void crearVariables() {
		V = new Variable("Diferencia con velocidad media", -1.0f, 1.0f); // negativa, cero, positiva
		B = new Variable("Diferencia con nivel medio bateria", -1.0f, 1.0f); // negativa, cero, positiva
		VC = new Variable("Potencia a aplicar", -0.5f, 0.50f); // reducir, mantener, aumentar

		operadores = new ArrayList<Operador>();  // lista de operadores que formarán los antecedentes de las reglas
		reglas = new ArrayList<Regla>();
		conflictos = new ArrayList<Regla>(); // lista de reglas a aplicar con una entrada de datos
		limitesConflictos = new ArrayList<Float>(); // lista valores límite que se obtienen de los antecedentes

	}

	@Override
	public void datosEntrada() {
		
		// datos de entrada de ejemplo
		entradaVelocidad = -0.1f;
		entradaBateria = 0.7f;

	}

	@Override
	public void anadirReglas() {
		
		// lista de operadores de intersección para crear los antecedentes
		for (int i = 0; i < 9; i++) {
			operadores.add(new OpY());
		}
		// R1: (
		operadores.get(0).anadir(new FSMenos(), V);
		operadores.get(0).anadir(new FSMenos(), B);
		Regla R0 = new Regla(operadores.get(0), new FSMenos(), VC);
		reglas.add(R0);

		operadores.get(1).anadir(new FSMenos(), V);
		operadores.get(1).anadir(new FSIgual(), B);
		Regla R1 = new Regla(operadores.get(1), new FSIgual(), VC);
		reglas.add(R1);

		operadores.get(2).anadir(new FSMenos(), V);
		operadores.get(2).anadir(new FSMas(), B);
		Regla R2 = new Regla(operadores.get(2), new FSMas(), VC);
		reglas.add(R2);

		operadores.get(3).anadir(new FSIgual(), V);
		operadores.get(3).anadir(new FSMenos(), B);
		Regla R3 = new Regla(operadores.get(3), new FSMenos(), VC);
		reglas.add(R3);

		operadores.get(4).anadir(new FSIgual(), V);
		operadores.get(4).anadir(new FSIgual(), B);
		Regla R4 = new Regla(operadores.get(4), new FSIgual(), VC);
		reglas.add(R4);

		operadores.get(5).anadir(new FSIgual(), V);
		operadores.get(5).anadir(new FSMas(), B);
		Regla R5 = new Regla(operadores.get(5), new FSMas(), VC);
		reglas.add(R5);

		operadores.get(6).anadir(new FSMas(), V);
		operadores.get(6).anadir(new FSMenos(), B);
		Regla R6 = new Regla(operadores.get(6), new FSMenos(), VC);
		reglas.add(R6);

		operadores.get(7).anadir(new FSMas(), V);
		operadores.get(7).anadir(new FSIgual(), B);
		Regla R7 = new Regla(operadores.get(7), new FSIgual(), VC);
		reglas.add(R7);

		operadores.get(8).anadir(new FSMas(), V);
		operadores.get(8).anadir(new FSMas(), B);
		Regla R8 = new Regla(operadores.get(8), new FSMas(), VC);
		reglas.add(R8);

	}

	// Motor de inferencia
	@Override
	public void ejecutarMotor() {
		
		float resultadoAntecedente = 0.0f;
		// Paso 1. Evaluación del antecedente de cada regla
		for (int i = 0; i < reglas.size(); i++) {

			resultadoAntecedente = reglas.get(i).evaluaAntecedente(entradaVelocidad, entradaBateria);
			if (resultadoAntecedente != 0) {
				conflictos.add(reglas.get(i));
				limitesConflictos.add(resultadoAntecedente);
			}
		}
		System.out.println("Nº reglas que se activan: " + conflictos.size());

		// Paso 2. Obtener la conclusión de cada regla y agregar
		Operador agregacion = new OpO();

		for (int i = 0; i < conflictos.size(); i++) {
			agregacion.anadir(conflictos.get(i).getFConsecuente(), VC);
			agregacion.setLimite(limitesConflictos.get(i));
		}
		
		// Paso 3. Nitidificación, búsqueda del centro de masa
		
		float sumaNumerador = 0.0f;
		float sumaDenominador = 0.0f;
		float intervalo = 0.02f;
		for (float i = -1.0f; i <= 1.0f; i=i+intervalo) {
			float v = agregacion.evaluar(i,0.0f);
			sumaNumerador += i * v;
			sumaDenominador += v;
		}

		valorNitidificado = sumaNumerador / sumaDenominador;

	}

	@Override
	public void mostrarResultado() {
		System.out.println("valor nitidificado  : " + valorNitidificado);

	}

}
