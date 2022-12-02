
public class Hecho extends Expresion {

	
	public Hecho(boolean valor,String descripcion ) {
		this.valor = valor;
		this.descripcion = descripcion;
	}
	
	public boolean evaluar()
	{
	return valor;
	}
	
	public String getDescripcion()
	{
		return descripcion;
		
	}
	
	public void setValor(boolean v)
	{
		valor = v;
		
	}
	
	public String toString() {		
		return descripcion;
	}

}
