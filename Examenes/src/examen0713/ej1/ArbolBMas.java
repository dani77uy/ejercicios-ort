package examen0713.ej1;

import java.util.Collections;
import java.util.List;

public class ArbolBMas {

	private static final int CAPACIDAD = 4;

	private abstract class Nodo {

		List<Integer> elementos = Collections.emptyList();

		final boolean agregarElemento(int dato) {
			if (elementos.size()>0 && elementos.get(0)>dato)
				return agregarAOtroNodo(dato);
			if (elementos.size() > CAPACIDAD) return agregarAOtroNodo(dato);
			else return agregar(dato);
		}

		abstract boolean agregarAOtroNodo(int dato);
		abstract boolean agregar(int dato);

	}
	
	private class NodoRaiz extends Nodo{

		@Override
		boolean agregarAOtroNodo(int dato) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		boolean agregar(int dato) {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	
	

}
