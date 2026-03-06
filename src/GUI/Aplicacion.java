
package GUI;
import LectorDeArchivos.GestorArchivos;
import PaqueteClases.*;




public class Aplicacion extends javax.swing.JFrame {
    
    private Grafo grafoActual = new Grafo();
    private  GestorArchivos gestorArchivos = new GestorArchivos();
    private Analizador analizador= new Analizador();
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Aplicacion.class.getName());

    public Aplicacion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panelGrafo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txResultados = new javax.swing.JTextArea();
        GuardarBTN = new javax.swing.JButton();
        CargarBTN = new javax.swing.JButton();
        AgregarBTN = new javax.swing.JButton();
        eliminarBTN = new javax.swing.JButton();
        complejosBTN = new javax.swing.JButton();
        dijkstraBTN = new javax.swing.JButton();
        hubsBTN = new javax.swing.JButton();

        jButton2.setText("jButton2");

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setText("<html><center>Cargar <br>Archivos CSV</html>");
        jButton3.setToolTipText("");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGrafo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelGrafoLayout = new javax.swing.GroupLayout(panelGrafo);
        panelGrafo.setLayout(panelGrafoLayout);
        panelGrafoLayout.setHorizontalGroup(
            panelGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 722, Short.MAX_VALUE)
        );
        panelGrafoLayout.setVerticalGroup(
            panelGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        txResultados.setColumns(20);
        txResultados.setRows(5);
        jScrollPane1.setViewportView(txResultados);

        GuardarBTN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        GuardarBTN.setText("<html><center>Actualizar/Guardar<br>Repositorio</html>");
        GuardarBTN.setToolTipText("");
        GuardarBTN.addActionListener(this::GuardarBTNActionPerformed);

        CargarBTN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CargarBTN.setText("<html><center>Cargar <br>Archivos CSV</html>");
        CargarBTN.setToolTipText("");
        CargarBTN.addActionListener(this::CargarBTNActionPerformed);

        AgregarBTN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AgregarBTN.setText("<html><center>Agregar<br>Interaccion</html>");
        AgregarBTN.setToolTipText("");
        AgregarBTN.addActionListener(this::AgregarBTNActionPerformed);

        eliminarBTN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        eliminarBTN.setText("<html><center>Eliminar<br>Proteina</html>");
        eliminarBTN.addActionListener(this::eliminarBTNActionPerformed);

        complejosBTN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        complejosBTN.setText("<html><center>Buscar<br>Complejos<br>Proteicos (BFS)</html>");
        complejosBTN.addActionListener(this::complejosBTNActionPerformed);

        dijkstraBTN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dijkstraBTN.setText("<html><center>Buscar Ruta<br>Metabolica (Djikstra)</html>");
        dijkstraBTN.addActionListener(this::dijkstraBTNActionPerformed);

        hubsBTN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        hubsBTN.setText("<html><Center>Identificar<br>Hubs</html>");
        hubsBTN.addActionListener(this::hubsBTNActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(CargarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))
                            .addComponent(GuardarBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AgregarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eliminarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(complejosBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dijkstraBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hubsBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(panelGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(CargarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GuardarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgregarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eliminarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(complejosBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dijkstraBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hubsBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    
    private void CargarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarBTNActionPerformed
        grafoActual = gestorArchivos.cargarGrafoDesdeArchivo(grafoActual);
        txResultados.setText("Se cargo exitosamente el archivo a la memoria. \nProteinas totales: "
                                + grafoActual.getVertices().getTamano());
        dibujarGrafo();
    }//GEN-LAST:event_CargarBTNActionPerformed

    
    
    
    private void GuardarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarBTNActionPerformed
       gestorArchivos.actualizarRepositorio(grafoActual, "maestro(1).csv");
       txResultados.setText("Se actualizo el repositorio con los datos en memoria");
    }//GEN-LAST:event_GuardarBTNActionPerformed

    
    private void AgregarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarBTNActionPerformed
        String origen = javax.swing.JOptionPane.showInputDialog(this, "Ingrese el ID de la Proteina 1 (Ejemplo: P20: ");
        String destino = javax.swing.JOptionPane.showInputDialog(this, "Ingrese el ID de la proteina a conectar (Ejemplo: P1): ");
        String strPeso = javax.swing.JOptionPane.showInputDialog(this, "Ingrese el peso (resistencia)");
        
        
        if (origen != null && destino != null && strPeso != null && !origen.isEmpty() && !destino.isEmpty()){
            try{
                double peso = Double.parseDouble(strPeso);
                grafoActual.agregarVertice(origen);
                grafoActual.agregarVertice(destino);
                grafoActual.agregarArista(origen, destino, peso);
                
                
                txResultados.setText("La interaccion se agrego: "+origen+ " <--> "+destino+ "(Peso: "+peso+")");
                dibujarGrafo();
            }
            catch(NumberFormatException exception){
                javax.swing.JOptionPane.showMessageDialog(this, "Error!\nEl peso debe ser un numero...");
            }
        }
    }//GEN-LAST:event_AgregarBTNActionPerformed

    
    
    private void eliminarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBTNActionPerformed
        
        String idEliminar =javax.swing.JOptionPane.showInputDialog(this, "Ingrese el ID de la proteina que desea eliminar: ");
        if(idEliminar != null && !idEliminar.trim().isEmpty()){
            if(grafoActual.buscarVertice(idEliminar) != null){
                grafoActual.eliminarVertice(idEliminar);
                txResultados.setText("La proteina "+idEliminar+ " junto con sus conexiones se han eliminado exitosamente");
                dibujarGrafo();
            }
            else{
                javax.swing.JOptionPane.showMessageDialog(this, "No se encuentra esta proteina en la red...");
            }
        }
        
    }//GEN-LAST:event_eliminarBTNActionPerformed

    
    
    private void complejosBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complejosBTNActionPerformed
        Lista<Lista<Vertice>> complejos = analizador.encontrarComplejos(grafoActual);
        StringBuilder sb = new StringBuilder("--- Se detectaron Complejos Proteicos ---\n\n");
        
        
        int cont = 1;
        Nodo<Lista<Vertice>> actualComplejo =complejos.getNodoInicial();
        while (actualComplejo != null){
            sb.append("Complejo ").append(cont).append(": ");
            Nodo<Vertice> v = actualComplejo.getDato().getNodoInicial();
            
            while(v != null){
                sb.append(v.getDato().getNombrePreoteina()).append(" ");
                v = v.getSiguiente();
            }
            sb.append("\n");
            cont++;
            actualComplejo = actualComplejo.getSiguiente();
        }
        txResultados.setText(sb.toString());
    }//GEN-LAST:event_complejosBTNActionPerformed

    private void dijkstraBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dijkstraBTNActionPerformed
        
        String origen = javax.swing.JOptionPane.showInputDialog(this, "Proteina de inicio: ");
        String destino =javax.swing.JOptionPane.showInputDialog(this, "Proteina de destino: ");
        
        
        if(origen != null && destino !=null){
            String resultado = analizador.encontrarRutaMasCorta(grafoActual, origen.trim(), destino.trim());
            txResultados.setText(resultado);
        }
    }//GEN-LAST:event_dijkstraBTNActionPerformed

    
    
    private void hubsBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hubsBTNActionPerformed
        String resultado = analizador.Hubs(grafoActual);
        txResultados.setText(resultado);
        
    }//GEN-LAST:event_hubsBTNActionPerformed

    
    
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new Aplicacion().setVisible(true));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarBTN;
    private javax.swing.JButton CargarBTN;
    private javax.swing.JButton GuardarBTN;
    private javax.swing.JButton complejosBTN;
    private javax.swing.JButton dijkstraBTN;
    private javax.swing.JButton eliminarBTN;
    private javax.swing.JButton hubsBTN;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelGrafo;
    private javax.swing.JTextArea txResultados;
    // End of variables declaration//GEN-END:variables
    
    
    
    /*
    Metodo aux para el dibujo
    */
    private int[] obtenerCoordDestino(String idDestino, Lista<int[]> posiciones){
        Nodo<Vertice> actual = grafoActual.getVertices().getNodoInicial();
        Nodo<int[]> posActual = posiciones.getNodoInicial();
        
        while(actual!=null && posActual != null){
            if(actual.getDato().getNombrePreoteina().equals(idDestino)){
               return posActual.getDato(); 
            }
            actual = actual.getSiguiente();
            posActual=posActual.getSiguiente();
        }
        return null;
    }
    
    
    
    /*
    Dibujamos aristas y nodos en el panle
    */
    private void dibujarGrafo(){
    //Obtenemos el objeto (panelGrafo)
    java.awt.Graphics g = panelGrafo.getGraphics();
    
    
    //Limpiamos nuestro panel'
    g.clearRect(0, 0, panelGrafo.getWidth(), panelGrafo.getHeight());
    
    
    if(grafoActual==null || grafoActual.getVertices().getNodoInicial()==null){
        return;
    }
    
    int radio = Math.min(panelGrafo.getWidth(), panelGrafo.getHeight()) /2 -30;
    int centrox = panelGrafo.getWidth() /2;
    int centroy = panelGrafo.getHeight()/2;
    
    int numNodos = grafoActual.getVertices().getTamano();
    double anguloPeso = 2* Math.PI/ numNodos;
    
    
    //Calculamos posiciones de cada nodo
    Lista<int[]> posiciones = new Lista<>(); // Aqui guardamos las coordenadas de x & y
    Nodo<Vertice> actualVertice =grafoActual.getVertices().getNodoInicial();
    int i = 0;
    
    
    while (actualVertice !=null){
        int x =centrox + (int)(radio*Math.cos(i* anguloPeso));
        int y =centroy + (int)(radio* Math.sin(i*anguloPeso));
        
        posiciones.insertar(new int[]{x,y});
        i++;
        actualVertice = actualVertice.getSiguiente();
        
    }
    
    
    
    ///dibujamoas las aristas, sus lineas y pesoss
    actualVertice =grafoActual.getVertices().getNodoInicial();
    Nodo<int[]> posicionOrigen =posiciones.getNodoInicial();
    
    while (actualVertice != null &&posicionOrigen != null){
        Nodo<Arista> actualArista =actualVertice.getDato().getVecinos().getNodoInicial();
        while(actualArista!= null){
            //buscar posicion del detsino
            String idDestino = actualArista.getDato().getDestino().getNombrePreoteina();
            int[] destCoord = obtenerCoordDestino(idDestino, posiciones);
            
            
            if(destCoord !=null){
                g.setColor(java.awt.Color.GRAY);
                //DIBUNAMOS LA LINEA
                g.drawLine(posicionOrigen.getDato()[0],posicionOrigen.getDato()[1], destCoord[0], destCoord[1]);
                
                
                //dibujar peso en medio de la liena
                g.setColor(java.awt.Color.RED);
                int mediox = (posicionOrigen.getDato()[0]+destCoord[0])/ 2;
                int medioy = (posicionOrigen.getDato()[1]+destCoord[1])/ 2;
                
                g.drawString(String.valueOf(actualArista.getDato().getPeso()), mediox, medioy);
            }
            actualArista = actualArista.getSiguiente();
            posicionOrigen = posicionOrigen.getSiguiente();
            
        }
        
        
        //Dibuamos los nodos, circulos e ids
        actualVertice = grafoActual.getVertices().getNodoInicial();
        posicionOrigen = posiciones.getNodoInicial();
        
        while(actualVertice != null && posicionOrigen != null){
            g.setColor(java.awt.Color.WHITE);
            g.fillOval(posicionOrigen.getDato()[0]- 15, posicionOrigen.getDato()[1]-15,30,30);
            
            g.setColor(java.awt.Color.WHITE);
            g.drawString(actualVertice.getDato().getNombrePreoteina(), posicionOrigen.getDato()[0]-10, posicionOrigen.getDato()[1]+5);
            
        }
        
    }
    
    
}
    
    
    
    
    



}



