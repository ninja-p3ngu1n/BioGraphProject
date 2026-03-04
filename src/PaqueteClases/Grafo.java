package PaqueteClases;



public class Grafo{
    private Lista<Vertice> vertices;
    
    // Iniciamos el grafo vacio
    public Grafo(){
        this.vertices = new Lista<>();
    }
    
    
    
    /**
     * Buscamos una proteina por su nombre dentro del grafo
     *@return  Retornamos el vertice que corresponde, si no existe entonces nulo (null)
     *@param 
     */
    
    public Vertice buscarVertice(String nombre){
        Nodo<Vertice> actualNodo = vertices.getNodoInicial();
        
        while (actualNodo != null){
            if(actualNodo.getDato().getNombrePreoteina().equals(nombre)){
                return actualNodo.getDato();
            }
            
            actualNodo = actualNodo.getSiguiente();
        }
        return null;
        
    }
    
    
    /*
    Para agregar una nueva proteina al grafo si es que no existe de antes
    */
    public void agregarVertice(String nombre){
        if(buscarVertice(nombre)== null){
            vertices.insertar(new Vertice(nombre));
        }
    }
    
    /* Crear una interaccion con dos protinas con un peso en especifico
    como el grafo no es dirigido, la conexion es bidireaccional
    */
    public void agregarArista(String origen, String destino, double peso){
        Vertice vOrigen =buscarVertice(origen);
        Vertice vDestino = buscarVertice(destino);
        
        
        if(vOrigen != null && vDestino !=null) {
            vOrigen.getVecinos().insertar(new Arista(vDestino, peso));
            vDestino.getVecinos().insertar(new Arista(vOrigen, peso));
        }
    }
    
    
    public Lista<Vertice> getVertices(){
        return vertices;
    }
    
    
}
