package PaqueteClases;


// Relacion y peso entre dos proteinas
public class Arista {
    private Vertice destino;
    private double peso;
    
    
    // Constructor de la arista
    public Arista(Vertice destino, double peso){
        this.destino = destino;
        this.peso = peso;
    }
    
    
    public double getPeso(){
        return peso;
    }
    
    public Vertice getDestino(){
        return destino;
    }
    
    
}
