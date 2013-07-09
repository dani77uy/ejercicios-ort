package util;

/**
 *
 * @author Vicky
 */
public interface IGrafo {
	//Pre: 	v no pertenece al grafo. 0<v<=capacidad grafo
	//Pos: Agrega el vértice v al grafo
	public void agregarVertice(int v);

	//Pre:	origen y destino son los índices de vértices existentes en el grafo
	//Pos:	Agrega la arista origen-destino de peso "peso" en el grafo
	public void agregarArista(int origen, int destino, int peso);

	//Pre: 	El v´wrtice v existe en el grafo
	//Pos:	Elimina el vértice y todos los arcos a los que pertenezca
	public void eliminarVertice(int v);

	//Pre: 	La arista origen - destino existe en el grafo
	//Pos:	Elimina la arista origen - destino
	public void eliminarArista(int origen, int destino);

	//Pre:	El vértice v existe en el grafo
	//Pos: Retorna una lista con los vértices adyacentes de v o lista vacía si no tiene adyacentes
	public ILista verticesAdyacentes(int v);

	//Pre: 	a y b son vértices del grafo
	//Pos: Retorna true sii los vértices a y b son adyacentes. La arista a-b existe en el grafo
	public boolean sonAdyacentes(int a, int b);

	//Pos: Retorna true sii el vértice v existe en el grafo
	public boolean estaVertice(int v);

	//Post: Retorna true sii el grafo esta vacío
	public boolean esVacio();

}
