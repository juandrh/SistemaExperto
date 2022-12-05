package principal;

import nitido.SENitido;

public class CreadorSistemaExpertoNitido extends CreadorSistemaExperto{

	@Override
	public SistemaExperto crearSistemaExperto() {
		System.out.println("Creando sistema experto nítido ...");
		return new SENitido();
		
	}
}
