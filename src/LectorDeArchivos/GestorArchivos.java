package LectorDeArchivos;
import PaqueteClases.Arista;
import PaqueteClases.Grafo;
import PaqueteClases.Nodo;
import PaqueteClases.Vertice;


import com.sun.source.tree.ContinueTree;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;



// Clase que se encarga de gestionar la carga y la persistencia de los datos
// y conecta el sistema csv con la aplicacion
public class GestorArchivos {
    
    public Grafo cargarGrafoDesdeArchivo(Grafo actualGrafo){
        //Pasamos la alerta de que se tiene que guardar los datos actuales
        if(actualGrafo != null && actualGrafo.getVertices().getTamano()>0){
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "Vas a cargar un nuevo archivo, ¿Seguro qué deseas continuar? \n Recuerda que debes guardar si hiciste algun cambio.",
                    "Alerta!! Datos NO guradados",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            
            
            // Si la respuesta es SI se cancela y se devuelve el grafo
            if(respuesta != JOptionPane.YES_OPTION){
                return actualGrafo;
            }
        }
        
        // Configuramos el JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecionar Dataset de interacciones de proteinas(CSV)");
        
        // Hacemos un filtro para mostrar solo los archivos csv
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos CSV (.csv) y/o de texto (.txt)");
        fileChooser.setFileFilter(filtro);
        
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == fileChooser.APPROVE_OPTION){
            File archivoSelec = fileChooser.getSelectedFile();
            return procesarArchivo(archivoSelec);
        }
        return actualGrafo;
    }
    /*
    Lee el archivo linea por linea y llena el grafo
    agrega (return) un nuevo grafo con los datos guardados
    */
    private Grafo procesarArchivo(File archivo){
        Grafo nuevoGrafo = new Grafo();
        
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            
            while((linea = br.readLine())!= null){
                linea = linea.trim(); 
                
                //Omitiremos las lineas vaccias o posibles encabezados
                if(linea.isEmpty() || linea.toLowerCase().contains("origen")){
                    continue;
                }
                
                //Separaremos los datos por comas(orden: origen, destino, peso)
                String[] datos = linea.split(",");
                if(datos.length == 3){
                    String origen = datos[0].trim();
                    String destino= datos[1].trim();
                    
                    
                    try{
                        double peso = Double.parseDouble(datos[2].trim());
                        
                        //Agregamos primero los vertices(el metodo verifica que no se dupliquen)
                        nuevoGrafo.agregarVertice(origen);
                        nuevoGrafo.agregarVertice(destino);
                        
                        //Agregamos la arista entre ellos
                        nuevoGrafo.agregarArista(origen, destino, peso);
                        
                    }
                    catch(NumberFormatException e){
                        System.err.println("Error al leer el peso en la linea: "+ linea);
                    }
                           
                }
            }
            JOptionPane.showMessageDialog(null, "Error al leer el peso en la linea"+ linea);
            
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: "+ e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return nuevoGrafo;
    }
    
    public void actualizarRepositorio(Grafo grafo, String rutaArchivo){
        // usamos librerias de i/o para la escritura de archivos
        try(java.io.FileWriter fw= new java.io.FileWriter(rutaArchivo)){
            java.io.PrintWriter pw = new java.io.PrintWriter(fw);
        
            Nodo<Vertice> verticeActual = grafo.getVertices().getNodoInicial();
            
            while(verticeActual != null){
                Vertice vOrigen = verticeActual.getDato();
                Nodo<Arista> actualArista = vOrigen.getVecinos().getNodoInicial();
                
                while(actualArista != null){
                    Arista arista = actualArista.getDato();
                    Vertice vDestino =arista.getDestino();
                    
                    
                    //Como el grafo no esta dirigido, a esta conectado a b, y b con a
                    // para no tener que guardar la conexion dos veces, solo la guardamos si
                    // el nombre de origen es alfabeticamente menor al destino
                    if(vOrigen.getNombrePreoteina().compareTo(vDestino.getNombrePreoteina())<= 0){
                        pw.println(vOrigen.getNombrePreoteina()+ ","+ 
                                vDestino.getNombrePreoteina()+ ","+
                                arista.getPeso());
                    }
                    actualArista = actualArista.getSiguiente();
                }
                verticeActual = verticeActual.getSiguiente();
            }
            
            javax.swing.JOptionPane.showMessageDialog(null, "Se ha actualizado el repositorio");
                
        }
        catch(java.io.IOException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Ocurrio un error al guardar: "+ e.getMessage());
        }
    }    
}
