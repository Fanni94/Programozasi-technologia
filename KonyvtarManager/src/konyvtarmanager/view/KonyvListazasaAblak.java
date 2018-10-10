/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konyvtarmanager.view;

import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import konyvtarmanager.controller.KonyvtarManager;
import konyvtarmanager.modell.Konyv;

/**
 *
 * @author n
 */
public class KonyvListazasaAblak extends KeresoAblak{
    private KonyvtarManager manager;
    
    public KonyvListazasaAblak() {
        bovebbenGomb.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            bovebbenGombMouseClicked(evt);
            }
        });
        
        keresGomb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keresGombMouseClicked(evt);
            }
        });
        
        this.manager = new KonyvtarManager();        
    }
        private void keresGombMouseClicked(java.awt.event.MouseEvent evt) {                                       
        // TODO add your handling code here:
            ArrayList<Konyv> konyvek = this.manager.getKonyvByNev(keresoMezo.getText().toLowerCase());
            eredmenyLista.setListData(konyvek.toArray());
        }   
    
        private void bovebbenGombMouseClicked(java.awt.event.MouseEvent evt) {                                          
        
        Konyv k = (Konyv)eredmenyLista.getSelectedValue();
         
        JFrame frame = new JFrame("Könyv adatok");
        KonyvReszletesAblak kra = new KonyvReszletesAblak(k, this.manager);
        frame.setContentPane(kra);
        frame.pack();   
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    } 
    
}
