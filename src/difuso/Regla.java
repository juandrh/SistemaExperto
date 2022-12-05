package difuso;


public class Regla {

	OpY op;	
	FSemantica fConsecuente;
	Variable vConsecuente;
		

	public Regla(OpY op,FSemantica fConsecuente, Variable vConsecuente) {
		this.op = op;
		this.fConsecuente = fConsecuente;
		this.vConsecuente = vConsecuente;
		
	}

	public float evaluaAntecedente(float x,float y) {
			
		return op.evaluar(x,y);
	}
	
	public FSemantica getFConsecuente() {
		
		return fConsecuente;
	}
		
	public String toString() {		
		return "";
	}
	
	

}
