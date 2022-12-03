import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {

		List<Hecho> hechos = new ArrayList<Hecho>();
		List<Regla> reglas = new ArrayList<Regla>();
		List<Regla> conflictos = new ArrayList<Regla>();
		List<Hecho> resultados = new ArrayList<Hecho>();
		Hecho resultado = null;

		Hecho P = new Hecho(true, "Pedido recibido");
		hechos.add(P);
		Hecho CN = new Hecho(true, "Cliente nuevo");
		hechos.add(CN);
		Hecho DC = new Hecho(false, "Datos de cliente Recogidos");
		Hecho TD = new Hecho(false, "Tomar datos");
		Hecho AD = new Hecho(true, "Artículo disponible");
		hechos.add(AD);
		Hecho CM = new Hecho(true, "Cliente moroso");
		hechos.add(CM);
		Hecho EP = new Hecho(false, "Exigir pago deuda pendiente");
		Hecho DL = new Hecho(false, "Deuda liquidada");
		Hecho PP = new Hecho(false, "Procesar pedido");
		Hecho RL = new Hecho(true, "Robot libre");
		hechos.add(RL);
		Hecho RC = new Hecho(true, "Robot cargado");
		hechos.add(RC);
		Hecho RD = new Hecho(false, "Robot disponible");
		Hecho ET = new Hecho(false, "Encargar tarea a robot");
		resultados.add(ET);
		Hecho CB = new Hecho(false, "Cargar batería");
		resultados.add(CB);
		Hecho ER = new Hecho(false, "Esperar robot esté libre");
		resultados.add(ER);
		Hecho PA = new Hecho(false, "Pedir artículo a fábrica");
		resultados.add(PA);
		Regla R1 = new Regla(new OpY(P, CN), TD);
		reglas.add(R1);
		Regla R2 = new Regla(new OpO(TD, new OpNo(CN)), DC);
		reglas.add(R2);
		Regla R3 = new Regla(CM, EP);
		reglas.add(R3);
		Regla R4 = new Regla(EP, DL);
		reglas.add(R4);
		Regla R5 = new Regla(new OpY(new OpO(DL, DC), AD), PP);
		reglas.add(R5);
		Regla R6 = new Regla(new OpY(RL, RC), RD);
		reglas.add(R6);
		Regla R7 = new Regla(new OpY(PP, RD), ET);
		reglas.add(R7);
		Regla R8 = new Regla(new OpNo(CN), CB);
		reglas.add(R8);
		Regla R9 = new Regla(new OpNo(RL), ER);
		reglas.add(R9);
		Regla R10 = new Regla(new OpNo(AD), PA);
		reglas.add(R10);

		
		/*
		// Hechos iniciales y las reglas System.out.println("Hechos inciales: \n");
		for (int i = 0; i < hechos.size(); i++) {
			System.out.println(hechos.get(i).getDescripcion() + "(" + hechos.get(i).valor + ")");
		}

		System.out.println("\nReglas: \n");
		for (int i = 0; i < reglas.size(); i++) {
			System.out.println(reglas.get(i).toString());
		}
		*/

		/*
		// Hechos añadidos
		System.out.println("\nHechos añadidos: \n");
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
		// Número de hechos totales = 16
		int ronda = 1;
		boolean terminado = false;
		while (ronda < 20 && !terminado) {
			// Buscar conflictos
			for (int i = 0; i < reglas.size(); i++) {
				for (int j = 0; j < hechos.size(); j++) {
					Regla regla = reglas.get(i);
					if (regla.esAntecedente(hechos.get(j)) && !conflictos.contains(regla)) {							
							conflictos.add(regla);	
							//reglas.remove(regla);
							System.out.println("Regla añadida a conflictos: "+ regla.toString());		
						
					}
				}
			}

			
			
			
			
			System.out.println("\nConflictos ronda " + ronda + ":\n");
			for (int i = 0; i < conflictos.size(); i++) {
				System.out.println(conflictos.get(i).toString());
			}
			System.out.println("\nHechos ronda " + ronda + ":\n");
			for (int i = 0; i < hechos.size(); i++) {
				System.out.println(hechos.get(i).getDescripcion() + "(" + hechos.get(i).valor + ")");
			}


			// Elegir la primera regla que aporte conocimiento
			Regla conflicto = null;
			for (int i = 0; i < conflictos.size(); i++) {
				conflicto = conflictos.get(i);
				
				if (!hechos.contains(conflicto.getConsecuente())) {
					System.out.println("\nAñadido a hechos: " + conflicto.getConsecuente().getDescripcion());
					hechos.add(conflicto.getConsecuente());					
					conflicto.getConsecuente().setValor(true);	
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
