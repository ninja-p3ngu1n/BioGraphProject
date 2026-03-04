package PaqueteClases;


//Lista simplemente enlazada
public class Lista<T>{ 
    private Nodo<T> inicio;
    private int tamano;
    
    // Iniciamos la lista vacia
    public Lista(){
        this.inicio = null;
        this.tamano = 0;
        
    }
    
    // Le insertamos un nuevo elemento al final
    public void insertar(T dato){
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (inicio == null){ //Si no hay datos
            inicio = nuevoNodo; //Le agregamos un nuevo dato
        }
        else{
            Nodo<T> actualNodo = inicio;
            while(actualNodo.getSiguiente() != null){
                actualNodo = actualNodo.getSiguiente();
            }
            actualNodo.setSiguiente(nuevoNodo);
        }
        tamano++; //Se incrementa el tamano de la lista
        
    }
    
    // Obtenemos el primer nodo de la lista para poder iterarla
    public Nodo<T> getNodoInicial(){
        return inicio;
    }
    
    // Retornamos la cantidad de elementos dentro de la lista (su tamaño)
    public int getTamano(){
        return tamano;
    }
    
}
