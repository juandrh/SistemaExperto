package difuso;

import java.util.List;

public class OpO extends Operador {

	
	public OpO(String descripcion, float a, float b ) {
		super(descripcion, a,  b );
		
	}
	
	public float fs(Callable f,float x)	{
		
		return Math.max(expresiones.get(0).fs(f,x),expresiones.get(1).fs(f,x));
	}
		
	
	public String toString() {		
		String texto = "(" +expresiones.get(0).toString();
		for (int i = 1; i < expresiones.size(); i++) {
		 texto += " O "+	expresiones.get(i).toString();
		}	
		texto += ")";
		return texto; 
	}



}
