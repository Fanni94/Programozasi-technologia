/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konyvtarmanager.view;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.JFrame;
import konyvtarmanager.controller.KonyvtarManager;
import konyvtarmanager.modell.Konyv;

/**
 *
 * @author n
 */
public class KonyvReszletesAblak extends javax.swing.JPanel {
    private Konyv konyv;
    private KonyvtarManager km;
    /**
     * Creates new form KonyvReszletesAblak
     */
    public KonyvReszletesAblak(Konyv k, KonyvtarManager konyvtar) {
        initComponents();
        this.konyv = k;
        this.km = konyvtar;
        ISBN_cimke.setText(k.getISBNszam());
        cim_cimke.setText(k.getCim());
        szerzo_cimke.setText(k.getSzerzo());
        peldanyszam_cimke.setText(((Integer)k.getPeldanyszam()).toString());
        kiadas_cimke.setText(((Integer)k.getKiadaseve()).toString());
        kikolcsonzes_szam.setText(((Integer)k.getKikolcsonzesSzam()).toString());
        zarolt_toggle.setSelected(k.getZarolte());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ISBN_cimke = new javax.swing.JLabel();
        cim_cimke = new javax.swing.JLabel();
        szerzo_cimke = new javax.swing.JLabel();
        peldanyszam_cimke = new javax.swing.JLabel();
        kiadas_cimke = new javax.swing.JLabel();
        zarolt_toggle = new javax.swing.JToggleButton();
        kikolcsonzes_szam = new javax.swing.JLabel();
        kolcsonzes_gomb = new javax.swing.JButton();
        masol_gomb = new javax.swing.JButton();

        ISBN_cimke.setText("jLabel1");

        cim_cimke.setText("jLabel2");

        szerzo_cimke.setText("jLabel3");

        peldanyszam_cimke.setText("jLabel4");

        kiadas_cimke.setText("jLabel5");

        zarolt_toggle.setLabel("Zárolt");
        zarolt_toggle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zarolt_toggleMouseClicked(evt);
            }
        });

        kikolcsonzes_szam.setText("jLabel6");

        kolcsonzes_gomb.setLabel("Kölcsönzés");
        kolcsonzes_gomb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kolcsonzes_gombMouseClicked(evt);
            }
        });

        masol_gomb.setText("Másol");
        masol_gomb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masol_gombMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kikolcsonzes_szam, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kiadas_cimke, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(peldanyszam_cimke, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(szerzo_cimke, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cim_cimke, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ISBN_cimke, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(masol_gomb)))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(kolcsonzes_gomb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(zarolt_toggle)
                        .addGap(54, 54, 54))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ISBN_cimke, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(masol_gomb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cim_cimke, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(szerzo_cimke, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(peldanyszam_cimke, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kiadas_cimke, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kikolcsonzes_szam, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zarolt_toggle)
                    .addComponent(kolcsonzes_gomb))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void kolcsonzes_gombMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kolcsonzes_gombMouseClicked
        // TODO add your handling code here:
        JFrame frame = new JFrame("Kölcsönzés");

        frame.setContentPane(new KolcsonzesDialog(km, ISBN_cimke.getText()));
        frame.pack();   
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }//GEN-LAST:event_kolcsonzes_gombMouseClicked

    private void zarolt_toggleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zarolt_toggleMouseClicked
        this.konyv.setZarolte(!(zarolt_toggle.isSelected()));
        this.km.setKonyv(konyv);
    }//GEN-LAST:event_zarolt_toggleMouseClicked

    private void masol_gombMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masol_gombMouseClicked
        StringSelection stringSelection = new StringSelection(ISBN_cimke.getText());
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
    }//GEN-LAST:event_masol_gombMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ISBN_cimke;
    private javax.swing.JLabel cim_cimke;
    private javax.swing.JLabel kiadas_cimke;
    private javax.swing.JLabel kikolcsonzes_szam;
    private javax.swing.JButton kolcsonzes_gomb;
    private javax.swing.JButton masol_gomb;
    private javax.swing.JLabel peldanyszam_cimke;
    private javax.swing.JLabel szerzo_cimke;
    private javax.swing.JToggleButton zarolt_toggle;
    // End of variables declaration//GEN-END:variables
}