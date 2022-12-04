import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {

		List<Hecho> hechos = new ArrayList<Hecho>();
		List<Regla> reglas = new ArrayList<Regla>();
		List<Regla> conflictos = new ArrayList<Regla>();
		List<Hecho> resultados = new ArrayList<Hecho>();
		Hecho resultado = null;

		Hecho P = new Hecho("Pedido recibido");		
		Hecho CN = new Hecho("Cliente nuevo");		
		Hecho TD = new Hecho("Tomar datos");
		Hecho AD = new Hecho("Art�culo disponible");		
		Hecho CM = new Hecho("Cliente moroso");		
		Hecho EP = new Hecho("Exigir pago deuda pendiente");
		Hecho DL = new Hecho("Deuda liquidada");
		Hecho DC = new Hecho("Datos de cliente completos");
		Hecho PP = new Hecho("Procesar pedido");
		Hecho RL = new Hecho("Robot libre");		
		Hecho RC = new Hecho("Robot cargado");		
		Hecho RD = new Hecho("Robot disponible para uso");
		Hecho ET = new Hecho("Encargar tarea a robot");	
		Hecho CB = new Hecho("Cargar bater�a");		
		Hecho ER = new Hecho("Esperar robot est� libre");		
		Hecho PA = new Hecho( "Pedir art�culo a f�brica");
		
		
		hechos.add(P);
		//hechos.add(CM);
		hechos.add(AD);	
		hechos.add(RL);
		hechos.add(RC);
		
		
		
		
		
		resultados.add(ET); // fijar objetivo
		
		// R1:=  CN -> TD
		Regla R1 = new Regla(CN, TD,hechos);	
		reglas.add(R1);	
		// R2:= (NO(CN) Y CM) -> EP
		Operador O1 = new OpY("Y");
		Operador O2 = new OpNo("No");
		O2.anadir(CN);
		O1.anadir(O2);O1.anadir(CM);
		Regla R2 = new Regla(O1, EP,hechos);
		reglas.add(R2);	
		// R3: EP -> DL
		Regla R3 = new Regla(EP, DL,hechos);
		reglas.add(R3);			
		// R4:= TD O  DL O (NoCN y NoCM)  -> DC	
		Operador O3 = new OpO("O");		
		Operador O4 = new OpNo("No");
		Operador O5 = new OpNo("No");
		Operador O6 = new OpY("Y");
		O4.anadir(CN);O5.anadir(CM);		
		O6.anadir(O4);O6.anadir(O5);
		O3.anadir(TD);O3.anadir(DL);O3.anadir(O6);
		Regla R4 = new Regla(O3, DC,hechos);
		reglas.add(R4);		
		
		// R5:= P Y  DC Y AD  -> PP	
		Operador O7 = new OpY("Y");
		O7.anadir(P);O7.anadir(DC);O7.anadir(AD);		
		Regla R5 = new Regla(O7, PP,hechos);
		reglas.add(R5);				
				
				
		// R6:= RL Y RC -> RD  
		Operador O8 = new OpY("Y");
		O8.anadir(RL);O8.anadir(RC);
		Regla R6 = new Regla(O8, RD,hechos);
		reglas.add(R6);
		
		// R6:= PP Y RD -> ET 
		Operador O9 = new OpY("Y");
		O9.anadir(PP);O9.anadir(RD);
		Regla R7 = new Regla(O9, ET,hechos);
		reglas.add(R7);
		
		
		/*
		 * Regla R8 = new Regla(new OpNo(CN), CB); reglas.add(R8); Regla R9 = new
		 * Regla(new OpNo(RL), ER); reglas.add(R9); Regla R10 = new Regla(new OpNo(AD),
		 * PA); reglas.add(R10);
		 */

		
		
		// Hechos iniciales y las reglas System.out.println("Hechos inciales: \n");
		for (int i = 0; i < hechos.size(); i++) {
			System.out.println(hechos.get(i).toString());
		}

		System.out.println("\nReglas: \n");
		for (int i = 0; i < reglas.size(); i++) {
			System.out.println(reglas.get(i).toString());
		}
		

		/*
		// Hechos a�adidos
		System.out.println("\nHechos a�adidos: \n");
		for (int i = 0; i < reglas.size(); i++) {
			for (int j = 0; j < hechos.size(); j++) {

				if (reglas.get(i).esAntecedente(hechos.get(j))) {
					Hecho consecuente = reglas.get(i).getConsecuente();
					if (!hechos.contains(consecuente)) {
						hechos.add(consecuente);
						consecuente.setValor(true);
						System.out.println(consecuente.getDescripcion() + "(" + consecuente.valor + ")");
					}
				}

			}
		}
	*/
		// N�mero de hechos totales = 16
		int ronda = 1;
		boolean terminado = false;
		while (ronda < 20 && !terminado) {
			// Buscar conflictos
			for (int i = 0; i < reglas.size(); i++) {
				for (int j = 0; j < hechos.size(); j++) {
					Regla regla = reglas.get(i);
					if (regla.esAplicable() && !conflictos.contains(regla)) {							
							conflictos.add(regla);	
					}
				}
			}
			
			System.out.println("\nConflictos ronda " + ronda + ":\n");
			for (int i = 0; i < conflictos.size(); i++) {
				System.out.println(conflictos.get(i).toString());
			}
			System.out.println("\nHechos ronda " + ronda + ":\n");
			for (int i = 0; i < hechos.size(); i++) {
				System.out.println(hechos.get(i).toString() + "(" + hechos.get(i).evaluar(hechos) + ")");
			}


			// Elegir la primera regla que aporte conocimiento
			Regla conflicto = null;
			for (int i = 0; i < conflictos.size(); i++) {
				conflicto = conflictos.get(i);
				
				if (!hechos.contains(conflicto.getConsecuente())) {
					System.out.println("\nA�adido a hechos: " + conflicto.getConsecuente().toString());
					conflicto.aplicarRegla();	
					reglas.remove(conflicto);
					if (resultados.contains(conflicto.getConsecuente())) {
						terminado = true;
						resultado = conflicto.getConsecuente();	
					}
					conflictos.remove(conflicto);
					break;
				}
			}
			conflictos.clear();
			ronda++;

		}
		
		

		System.out.println("Resultado: " + resultado);

	}

}
