/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.gestao.venda.view.componentes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;



/**
 *
 * @author Luan Bressanin
 */
public class Mensagem extends javax.swing.JPanel {
    
    private TipoMensagem tipoMensagem;
    private boolean mostra;
    
    public Mensagem() {
        initComponents();
        setVisible(false);
        setOpaque(false);
    }
     public enum TipoMensagem{
         SUCESSO, ERRO
     }
     
     public void mostraMensagem(TipoMensagem tipo, String mensagem){
         this.tipoMensagem = tipo;
         labelMensagem.setText(mensagem);
         
         String caminho = System.getProperty("user.dir") +"\\src\\main\\java\\com\\gestao\\venda\\view\\icon";
         
         if(tipo.equals(TipoMensagem.SUCESSO)){
             labelMensagem.setIcon(new ImageIcon(caminho+"sucesso.png"));
         }else{
             labelMensagem.setIcon(new ImageIcon(caminho+"erro.png"));
         }
     }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        
        if (this.tipoMensagem == TipoMensagem.SUCESSO){
            graphics2D.setColor(new Color(15,174,34));
        }else{
            graphics2D.setColor(new Color(240,52,53));
        }
        super.paintComponent(g);
    }

    public boolean isMostra() {
        return mostra;
    }

    public void setMostra(boolean mostra) {
        this.mostra = mostra;
    }
     
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelMensagem = new javax.swing.JLabel();

        labelMensagem.setForeground(new java.awt.Color(255, 255, 255));
        labelMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMensagem.setText("Mensagem");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelMensagem;
    // End of variables declaration//GEN-END:variables
}
