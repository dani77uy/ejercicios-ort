package util;

/**
 *
 * @author Vicky
 */
public interface ILista {

    //Pre: e no pertenece a la lista
    //Pos: agrega e al final de la lista
    void agregar(int e);

    //Pos: elimina e de la lista si existe
    void eliminar(int e);

    //Pos: vacía la lista
    void vaciar();

    //Pos: retorna true sii la lista es vacía
    boolean esVacia();
    //Pre: lista no vacía
    //Pos: retorna true sii e pertenece a la lista
    boolean existe(int e);
    
    //Pre: lista no vacía
    //Pos: retorna el primer elemento de la lista
    int elementoInicial();

    //Pos: retorna una copia de lista independiente en memoria
    ILista clone();

    //Pos: muestra en pantalla el contenido de la lista
    void mostrar();
}
