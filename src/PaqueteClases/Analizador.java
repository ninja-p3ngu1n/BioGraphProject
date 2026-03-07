
package PaqueteClases;




public class Analizador {
    
    //Reinicia el estado de 'visitado' de todos los vertices
    private void limpiarVisitas(Grafo grafo){
        Nodo<Vertice> actual = grafo.getVertices().getNodoInicial();
        while(actual != null){
            actual.getDato().setVisitando(false);
            actual = actual.getSiguiente();
        }
    }
    
    
    
    public Lista<Lista<Vertice>> encontrarComplejos(Grafo grafo){
        limpiarVisitas(grafo);
        Lista<Lista<Vertice>> todosLosComplejos = new Lista<>();
        
        Nodo<Vertice> actualNodo = grafo.getVertices().getNodoInicial();
        
        while(actualNodo != null){
            Vertice proteinaActual =actualNodo.getDato();
            
            
            if(!proteinaActual.isVisitando()){
                Lista<Vertice> nuevoComplejo = explorarComplejo(proteinaActual);
                todosLosComplejos.insertar(nuevoComplejo);
            }
            actualNodo = actualNodo.getSiguiente();
        }
        return todosLosComplejos;
    }
    
    
    
    
    private Lista<Vertice> explorarComplejo (Vertice inicio){
        Lista<Vertice> complejo =new Lista<>();
        Cola<Vertice> cola =new Cola<>();
        
        
        inicio.setVisitando(true);
        cola.encolar(inicio);
        while(!cola.estaVacia()){
            Vertice actualVertice = cola.desencolar();
            complejo.insertar(actualVertice);
            
            
            Nodo<Arista> nodoArista = actualVertice.getVecinos().getNodoInicial();
            while(nodoArista != null){
                Vertice vecinoVertice= nodoArista.getDato().getDestino();
                if(!vecinoVertice.isVisitando()){
                    vecinoVertice.setVisitando(true);
                    cola.encolar(vecinoVertice);
                }
                nodoArista=nodoArista.getSiguiente();
                
            }
        }
        return complejo;
    }
    
    
    
    public String encontrarRutaMasCorta(Grafo grafo, String nombreOrigen, String nombreDestino){
        Vertice origen = grafo.buscarVertice(nombreOrigen);
        Vertice destino = grafo.buscarVertice(nombreDestino);
        
        if(origen == null || destino == null){
            return "Error: una o ambas de las proteinas especificadas no existen en la red";
        }
        
        
        //fase de inicio
        Nodo<Vertice> actualNodo = grafo.getVertices().getNodoInicial();
        while(actualNodo != null){
            Vertice v= actualNodo.getDato();
            v.setDistancia(Double.MAX_VALUE);
            v.setPrevio(null);
            v.setVisitando(false);
            actualNodo = actualNodo.getSiguiente();
            
            
        }
        //distancia al nodo origen siemore sera 0
        origen.setDistancia(0);
        //fase de exploracion con dijkstra
        Vertice actual= obtenerNoVisitandoConMenorDistancia(grafo);
        
        while(actual != null){
            actual.setVisitando(true);
            
            
            //esta parte es de optimizacion, al llegar al detino, ya encontramos la ruta mas corta
            if(actual == destino){
                break;
            }
            
            
            //Revisamos nodos vecinos 
            Nodo<Arista> nodoArista= actual.getVecinos().getNodoInicial();
            while(nodoArista != null){
                Arista arista = nodoArista.getDato();
                Vertice vecinoVertice = arista.getDestino();
                
                if(!vecinoVertice.isVisitando()){
                    double nuevaDistancia = actual.getDistancia() + arista.getPeso();
                    
                    // si se encuentra un camino mas corto, se actualiza la informacion
                    if(nuevaDistancia < vecinoVertice.getDistancia()){
                        vecinoVertice.setDistancia(nuevaDistancia);
                        vecinoVertice.setPrevio(actual);
                    }
                }
                nodoArista= nodoArista.getSiguiente();
            }
            
            //se busca el siguiente vertice a evaluar
            actual = obtenerNoVisitandoConMenorDistancia(grafo);
            
        }
        
        //Ultima fase, se reecontruye la ruta
        if(destino.getDistancia()== Double.MAX_VALUE){
            return "No existe una ruta conectada entre " +nombreOrigen+ " y "+nombreDestino;
        }
        return  construirRuta(destino);
    }
    
    //Metodo auxiliar para recionstruir una ruta desde el destino hacia el origen
    //usando los apuntadores dde "previo"
        private String construirRuta(Vertice destino){
        String resultado = "";
        Vertice paso = destino;
        
        //Lo recorremos hacia atras y se construye el string de manera inversa 
        //esto para que el programa lo lea como origen->destino
        while(paso!= null){
            if(resultado.equals("")){
                resultado = paso.getNombrePreoteina();
            }
            else{
                resultado = paso.getNombrePreoteina()+ "-->"+resultado;
                
            }
            paso = paso.getPrevio();
        }
        return "Ruta optima:\n"+resultado+ 
                "\n\nCosto total de la resistencia: "+destino.getDistancia();
        
    }
    
    
    
    //Esto es un metodo auxiliar
    // lo que hace, es buscar el vertice no visitado que tenfa menos distancia acumulada
    private Vertice obtenerNoVisitandoConMenorDistancia(Grafo grafo){
        Vertice menorVertice = null;
        double menorDistancia = Double.MAX_VALUE;
        
        
        Nodo<Vertice> actualNodo = grafo.getVertices().getNodoInicial();
        while(actualNodo != null){
            Vertice v = actualNodo.getDato();
            if(!v.isVisitando() && v.getDistancia() < menorDistancia){
                menorDistancia = v.getDistancia();
                menorVertice = v;
            }
            actualNodo = actualNodo.getSiguiente();
            
        }
        return menorVertice;
               
        
    }
    
    
    

    
    
    
    //El hub es la proteina con mayores intereacciones 
    public String Hubs(Grafo grafo){
        if(grafo.getVertices().getNodoInicial() == null){
            return "El grafo esta vacio. No hay proteinas por analizar";
        }
        
        int maxConexiones = -1;
        Nodo<Vertice> actual =grafo.getVertices().getNodoInicial();
        
        
        //Ciclo para encontrar el numero maximo de conexiones entr proteinas
        while(actual!=null){
            //obtenemos cuantas conexiones tiene el vertice actual
            int numConexiones = actual.getDato().getVecinos().getTamano();
            
            if (numConexiones> maxConexiones){
                maxConexiones = numConexiones;    
            }
            actual = actual.getSiguiente();
        }
        
        
        //si nuestro maximo es 0, significa que si hay proteinas pero no interactua ninguna
        if(maxConexiones ==0){
            return "Ninguna proteina tiene conexiones";
        }
        
        
        //recopilamos toas las proteinas que tengan el numero maximo de conexiones
        Lista<Vertice> hubs= new Lista<>();
        actual = grafo.getVertices().getNodoInicial();
        
        
        while(actual != null){
            if(actual.getDato().getVecinos().getTamano() == maxConexiones){
                hubs.insertar(actual.getDato());
            }
            actual = actual.getSiguiente();
        }
        
        
        
        //se contruye la cadena de texto que se mostrara en la interfaz
        StringBuilder resultado= new StringBuilder(); 
        resultado.append("Analisis de centralidad de grado(Se detectaron Hubs):\n");
        resultado.append("Numero de interacciones maximas: ").append(maxConexiones).append("\n\n");
        resultado.append("Proteinas Hub:\n");
        
        
        Nodo<Vertice> hubActual = hubs.getNodoInicial();
        while(hubActual!= null){
            resultado.append(" - ").append(hubActual.getDato().getNombrePreoteina()).append("\n");
            hubActual = hubActual.getSiguiente();
        }
        
        return resultado.toString();
        
    }
    
    
}
