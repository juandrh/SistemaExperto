import java.util.List;

public class OpY extends Operador {


	
	
	public OpY(String descripcion) {
		super(descripcion); 
		
	}
	
	public boolean evaluar(List<Hecho> hechos)
	{
		for (int i = 0; i < expresiones.size(); i++) {
			if (!expresiones.get(i).evaluar(hechos)) return false;
		}		
		return true;
	}
	
	public String toString() {		
		String texto = "(" +expresiones.get(0).toString();
		for (int i = 1; i < expresiones.size(); i++) {
		 texto += " Y "+	expresiones.get(i).toString();
		}	
		texto += ")";
		return texto; 
	}


}
