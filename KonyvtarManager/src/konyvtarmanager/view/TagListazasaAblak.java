/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konyvtarmanager.view;

import java.util.ArrayList;
import javax.swing.JFrame;
import konyvtarmanager.controller.KonyvtarManager;
import konyvtarmanager.modell.Tag;

/**
 *
 * @author n
 */
public class TagListazasaAblak extends KeresoAblak{
    private KonyvtarManager manager;
    
    public TagListazasaAblak() {
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
        ArrayList<Tag> tagok = this.manager.getTagByNev(keresoMezo.getText().toLowerCase());
        eredmenyLista.setListData(tagok.toArray());
            
    }  
    
        private void bovebbenGombMouseClicked(java.awt.event.MouseEvent evt) {                                          
        // TODO add your handling code here:
        Tag t = (Tag)eredmenyLista.getSelectedValue();
            
        JFrame frame = new JFrame("Tag adatok");
        TagReszletesAblak tra = new TagReszletesAblak(t, this.manager);
        frame.setContentPane(tra);
        frame.pack();   
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    } 
}
