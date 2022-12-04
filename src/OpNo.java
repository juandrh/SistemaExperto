import java.util.List;

public class OpNo extends Operador {

	public OpNo(String descripcion) {
		super(descripcion);

	}

	public void anadir(Expresion e) {
		
		// Operador unario, sólo admite una expresión
		if (expresiones.size() == 0) {
			expresiones.add(e);
		}
	}

	public boolean evaluar(List<Hecho> hechos) {		
		return !expresiones.get(0).evaluar(hechos);
	}

	
	public String toString() {
		return "No " + expresiones.get(0).toString();
	}

}
