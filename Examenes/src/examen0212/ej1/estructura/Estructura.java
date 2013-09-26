package examen0212.ej1.estructura;

import java.util.List;

public interface Estructura<C,A> {

	boolean isCarpeta();
	void setCarpeta();
	void agregarSubCarpeta(C carpeta);
	void agregarArchivo(A archivo);
	C getPadre();
	void setPadre(C padre);
	List<A> getArchivos();
	List<C> getSubCarpetas();
	String getNombre();
	void setNombre(String nombre);
	
}
