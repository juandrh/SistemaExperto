package principal;

public abstract class CreadorSistemaExperto {
	
	SistemaExperto sistema;
	public abstract SistemaExperto crearSistemaExperto();
	
	public void crearVariables() {
		sistema = crearSistemaExperto();
		sistema.crearVariables();
		}

	public void aņadirDatosEntrada() {		
		sistema.aņadirDatosEntrada();
		}
	public void aņadirReglas() {		
		sistema.aņadirReglas();
		}
	public void ejecutarMotor() {		
		sistema.ejecutarMotor();
		}
	public void mostrarResultado() {		
		sistema.mostrarResultado();
		}
	
	
}
