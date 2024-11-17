package buscadorWoW.Interfaces;

import java.io.CharConversionException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import buscadorWoW.backend.Fachada;

class Interface extends javax.swing.JFrame {
    private final Fachada fachada;
    private List<String> resultado;
    
    public Interface(Fachada fachada) {
        this.fachada = fachada;
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        letrasEntrada = new javax.swing.JTextField();
        botaoBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        botaoConfig = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultadoBusca = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        filtroEntrada = new javax.swing.JTextField();
        botaoFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buscador de palavras para Words of Wonders");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Letras das palavras a serem buscadas:");

        letrasEntrada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        letrasEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                letrasEntradaKeyReleased(evt);
            }
        });

        botaoBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botaoBuscar.setText("Buscar");
        botaoBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoBuscarMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Resultado:");

        botaoConfig.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botaoConfig.setText("Configurações");
        botaoConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoConfigMouseClicked(evt);
            }
        });

        resultadoBusca.setColumns(20);
        resultadoBusca.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        resultadoBusca.setRows(5);
        resultadoBusca.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(resultadoBusca);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Filtro (use * como caractere curinga):");

        filtroEntrada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filtroEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtroEntradaKeyReleased(evt);
            }
        });

        botaoFiltrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botaoFiltrar.setText("Filtrar");
        botaoFiltrar.setEnabled(false);
        botaoFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoFiltrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(filtroEntrada, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(letrasEntrada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(botaoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(botaoFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(botaoConfig)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(letrasEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filtroEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoBuscar)
                    .addComponent(botaoConfig)
                    .addComponent(botaoFiltrar))
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoBuscarMouseClicked
        List<String> resultado;
        
        try {
            resultado = fachada.buscarTermos(letrasEntrada.getText());
        } catch (CharConversionException err) {
            err.printStackTrace();
            return;
        }
        
        this.resultado = resultado;
        resultadoBusca.setText(String.join("\n", resultado));
        botaoFiltrar.setEnabled(true);
    }//GEN-LAST:event_botaoBuscarMouseClicked

    private void letrasEntradaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_letrasEntradaKeyReleased
        if (evt.getKeyCode() == 10)
            for (java.awt.event.MouseListener ml: botaoBuscar.getMouseListeners())
                ml.mouseClicked(null);
        
        String texto = letrasEntrada.getText();
        char[] resultado = new char[texto.length()];
        int resIndex = 0;//, posCursor = letrasEntrada.getCaretPosition();

        for (char c: texto.toCharArray()) {
            if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z')
                resultado[resIndex++] = c;
        }

        if (resIndex < texto.length())
            letrasEntrada.setText(String.valueOf(resultado).trim());
            
    }//GEN-LAST:event_letrasEntradaKeyReleased

    private void botaoConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoConfigMouseClicked
        InterfaceFabrica.getConfigInterface(fachada).setVisible(true);
    }//GEN-LAST:event_botaoConfigMouseClicked

    private void botaoFiltrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoFiltrarMouseClicked
        String filtro = filtroEntrada.getText();
        resultadoBusca.setText(String.join("\n", fachada.filtrarTermos(filtro, resultado)));
    }//GEN-LAST:event_botaoFiltrarMouseClicked

    private void filtroEntradaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroEntradaKeyReleased
        String filtro = filtroEntrada.getText(), texto = letrasEntrada.getText();
        List<String> conj = new ArrayList<>(Arrays.asList(texto.split("")));
        char[] res = new char[filtro.length()];
        int resIndex = 0;
        
        for (char c: filtro.toCharArray()) {
            if (resIndex >= texto.length())
                break;
            
            String cs = String.valueOf(c);
            
            if (conj.contains(cs) || c == '*') {
                res[resIndex++] = c;
                
                if (c != '*')
                    conj.remove(cs);
            }
        }
        
        if (resIndex < filtro.length())
            filtroEntrada.setText(String.valueOf(res).trim());
        
        if (botaoFiltrar.isEnabled())
            for (java.awt.event.MouseListener ml: botaoFiltrar.getMouseListeners())
                ml.mouseClicked(null);
    }//GEN-LAST:event_filtroEntradaKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoBuscar;
    private javax.swing.JButton botaoConfig;
    private javax.swing.JButton botaoFiltrar;
    private javax.swing.JTextField filtroEntrada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField letrasEntrada;
    private javax.swing.JTextArea resultadoBusca;
    // End of variables declaration//GEN-END:variables
}
