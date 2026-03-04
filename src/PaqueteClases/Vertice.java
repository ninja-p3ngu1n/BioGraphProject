
package PaqueteClases;



// Proteina individual
public class Vertice {
    private String nombreProteina;
    private Lista<Arista> vecinos;
    
    
    /*
        Constructor del vertice
    */ // Tambien el identificador de la proteina 
    public Vertice(String nombre){
        this.nombreProteina = nombre;
        this.vecinos = new Lista<>();
    }
    
    
    public String getNombrePreoteina(){
        return nombreProteina;
    }
    
    
    public Lista<Arista> getVecinos(){
        return vecinos;
    }
    
}
