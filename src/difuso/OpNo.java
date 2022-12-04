package difuso;

import java.util.List;

public class OpNo extends Operador {

	public OpNo(String descripcion, float a, float b ) {
		super(descripcion, a,  b );
	}

	public void anadir(Expresion e) {
		
		// Operador unario, s�lo admite una expresi�n
		if (expresiones.size() == 0) {
			expresiones.add(e);
		}
	}

	public float fs(Callable f,float x)	{
		
		return 1.0f-f.call(a, b, x);
		
	}

	
	public String toString() {
		return "No " + expresiones.get(0).toString();
	}

}
