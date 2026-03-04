package PaqueteClases;


public class Nodo<T>{
    
    private T dato;
    private Nodo<T> siguienteNodo;
    
    
    //constructor del nodo
    public Nodo(T dato){
        this.dato = dato;
        this.siguienteNodo = null; 
        
    }
    
    //Referencias (setters y getters) 
    public T getDato(){
        return dato;
    }
    
    public void setDato(T dato){
        this.dato = dato;
    }
    
    public Nodo<T> getSiguiente(){
        return siguienteNodo;   
    }
    
    public void setSiguiente(Nodo<T> nextNodo){
        this.siguienteNodo = nextNodo;
    }
   
    
}


