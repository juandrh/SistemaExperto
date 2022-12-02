import java.util.ArrayList;
import java.util.List;

public class Principal {


	public static void main(String[] args) {

		List<Hecho> hechos = new ArrayList<Hecho>();
		List<Regla> reglas = new ArrayList<Regla>();
		
		Hecho P = new Hecho(true,"Pedido recibido.");                hechos.add(P);
		Hecho CN = new Hecho(true,"Cliente nuevo.");                 hechos.add(CN);
		Hecho DC = new Hecho(false,"Datos de cliente Recogidos.");	
		Hecho TD = new Hecho(false,"Tomar datos.");
		Hecho AD = new Hecho(true,"Artículo disponible.");            hechos.add(AD);
		Hecho CM = new Hecho(true,"Cliente moroso.");                    hechos.add(CM);
		Hecho EP = new Hecho(false,"Exigir pago deuda pendiente."); 
		Hecho DL = new Hecho(false,"Deuda liquidada."); 
		Hecho PP = new Hecho(false,"Procesar pedido."); 
		Hecho RL = new Hecho(true,"Robot libre.");  hechos.add(RL);
		Hecho RC = new Hecho(true,"Robot cargado.");  hechos.add(RC);
		Hecho RD = new Hecho(false,"Robot disponible."); 
		Hecho ET = new Hecho(false,"Encargar tarea a robot.");	
		Hecho CB = new Hecho(false,"Cargar batería.");	
		Hecho ER = new Hecho(false,"Esperar robot esté libre.");	
		Hecho PA = new Hecho(false,"Pedir artículo a fábrica.");	 
		Regla R1 = new Regla(new OpY(P,CN),TD);  reglas.add(R1);
		Regla R2 = new Regla(new OpO(P,new OpNo(CN)),TD);  reglas.add(R2);
		Regla R3 = new Regla(CM,EP);  reglas.add(R3);
		Regla R31 = new Regla(new OpNo(CN),EP);  reglas.add(R31);  
		Regla R4 = new Regla(EP,DL);  reglas.add(R4);		
		Regla R5 = new Regla(new OpY(new OpO(DL,DC),AD),PP);  reglas.add(R5);
		Regla R6 = new Regla(new OpY(RL,RC),RD);  reglas.add(R6);
		Regla R7 = new Regla(new OpY(PP,RD),ET);  reglas.add(R7);
		Regla R8 = new Regla(new OpNo(CN),CB);  reglas.add(R8);
		Regla R9 = new Regla(new OpNo(RL),ER);  reglas.add(R9);
		Regla R10 = new Regla(new OpNo(AD),PA);  reglas.add(R10);
		
		
	
		
		for (int i = 0; i<reglas.size();i++ ) {
		for (int j = 0; j<hechos.size();j++ ) {
			
			if (reglas.get(i).esAntecedente(hechos.get(j)))
			{
				Hecho consecuente = reglas.get(i).getConsecuente();
				if (!hechos.contains(consecuente)){
					hechos.add(consecuente);
					consecuente.setValor(true);
				}
			}
			
			
		}
		 }
		
		 for (int i = 0; i<hechos.size();i++ ) {
		System.out.println(hechos.get(i).getDescripcion()+ "(" + hechos.get(i).valor + ")"  );
		 }
		 for (int i = 0; i<reglas.size();i++ ) {
				System.out.println(reglas.get(i).toString());
				 }
		

	}

}
