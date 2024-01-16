package buscadorWoW.Interfaces;

import java.io.CharConversionException;
import java.util.List;

import buscadorWoW.backend.Fachada;

class Interface extends javax.swing.JFrame {
    private Fachada fachada;
    
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(letrasEntrada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(botaoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botaoConfig)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(letrasEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoBuscar)
                    .addComponent(botaoConfig))
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addGap(22, 22, 22))
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

        resultadoBusca.setText(String.join("\n", resultado));
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoBuscar;
    private javax.swing.JButton botaoConfig;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField letrasEntrada;
    private javax.swing.JTextArea resultadoBusca;
    // End of variables declaration//GEN-END:variables
}
