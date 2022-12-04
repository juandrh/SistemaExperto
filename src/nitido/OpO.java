package nitido;

import java.util.List;

public class OpO extends Operador {

	
	public OpO(String descripcion) {
		super(descripcion); 
		
	}
	
	public boolean evaluar(List<Hecho> hechos)
	{
		
			for (int i = 0; i < expresiones.size(); i++) {
				if (expresiones.get(i).evaluar(hechos)) return true;
			}		
			return false;
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
