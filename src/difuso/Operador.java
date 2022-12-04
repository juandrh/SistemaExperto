package difuso;

import java.util.ArrayList;
import java.util.List;

// Clase Compuesto del patr�n Composite

public abstract class Operador extends Expresion {

	List<Expresion> expresiones;

	public Operador(String descripcion, float a, float b ) {
		super(descripcion, a,  b );
		expresiones = new ArrayList<Expresion>();
	}

	public void anadir(Expresion e) {
		// M�ximo de operandos = 2
		if (expresiones.size() <2) {
			expresiones.add(e);
		}
		
	}


}
