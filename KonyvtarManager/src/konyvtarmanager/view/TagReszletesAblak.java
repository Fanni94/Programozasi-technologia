package konyvtarmanager.view;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import konyvtarmanager.controller.KonyvtarManager;
import konyvtarmanager.modell.Kolcsonzes;
import konyvtarmanager.modell.Tag;

/**
 *
 * @author n
 */
public class TagReszletesAblak extends javax.swing.JPanel {
    private Tag tag;
    private KonyvtarManager km;
    /**
     * Creates new form ReszletesAblak
     */
    public TagReszletesAblak(Tag t, KonyvtarManager km) {
        initComponents();
        this.tag = t;
        this.km = km;
        konyvtarjegyszam.setText(((Integer)t.getKonyvtarjegyszam()).toString());
        nev.setText(t.getNev());
        cim.setText(t.getCim());
        buntetes.setText(t.getBuntetes().toString());
        kolcsonzesi_lista.setListData(km.getKolcsonzesListaByTag(t.getKonyvtarjegyszam()).toArray());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        konyvtarjegyszam = new javax.swing.JLabel();
        nev = new javax.swing.JTextField();
        cim = new javax.swing.JTextField();
        buntetes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        kolcsonzesi_lista = new javax.swing.JList<>();
        kolcsonzes_gomb = new javax.swing.JButton();
        visszahozatal_gomb = new javax.swing.JButton();
        modositas_gomb = new javax.swing.JButton();
        torles_gomb = new javax.swing.JButton();
        masol_gomb = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        konyvtarjegyszam.setText("<konytarjegyszam>");

        nev.setText("jTextField1");

        cim.setText("jTextField2");

        buntetes.setText("jLabel2");

        kolcsonzesi_lista.setModel(new javax.swing.AbstractListModel<Object>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(kolcsonzesi_lista);

        kolcsonzes_gomb.setLabel("Kölcsönzés");
        kolcsonzes_gomb.setName(""); // NOI18N
        kolcsonzes_gomb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kolcsonzes_gombMouseClicked(evt);
            }
        });

        visszahozatal_gomb.setLabel("Visszahozás");
        visszahozatal_gomb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                visszahozatal_gombMouseClicked(evt);
            }
        });

        modositas_gomb.setLabel("Módosítás");
        modositas_gomb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modositas_gombMouseClicked(evt);
            }
        });

        torles_gomb.setLabel("Törlés");
        torles_gomb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                torles_gombMouseClicked(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buntetes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cim, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nev, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kolcsonzes_gomb)
                        .addGap(18, 18, 18)
                        .addComponent(visszahozatal_gomb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(modositas_gomb)
                        .addGap(18, 18, 18)
                        .addComponent(torles_gomb))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(konyvtarjegyszam, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(masol_gomb)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(konyvtarjegyszam, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(masol_gomb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buntetes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kolcsonzes_gomb)
                    .addComponent(visszahozatal_gomb)
                    .addComponent(modositas_gomb)
                    .addComponent(torles_gomb))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void kolcsonzes_gombMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kolcsonzes_gombMouseClicked
        // TODO add your handling code here:
        JFrame frame = new JFrame("Kölcsönzés");

        frame.setContentPane(new KolcsonzesDialog(km, kolcsonzesi_lista, konyvtarjegyszam.getText()));
        frame.pack();   
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }//GEN-LAST:event_kolcsonzes_gombMouseClicked

    private void visszahozatal_gombMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visszahozatal_gombMouseClicked
        // TODO add your handling code here:
        Kolcsonzes k = (Kolcsonzes)kolcsonzesi_lista.getSelectedValue();
        int kszam = k.getTag().getKonyvtarjegyszam();
        String ISBNsz = k.getKonyv().getISBNszam();
        km.kolcsonzes(ISBNsz, kszam, true);
        JOptionPane.showMessageDialog(null, "Sikerült a visszahozatal!", "Üzenet", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_visszahozatal_gombMouseClicked

    private void torles_gombMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_torles_gombMouseClicked
        // TODO add your handling code here:
        km.tagTorles(this.tag.getKonyvtarjegyszam());
        JOptionPane.showMessageDialog(null, "Sikeres törlés!", "Üzenet", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_torles_gombMouseClicked

    private void modositas_gombMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modositas_gombMouseClicked
        // TODO add your handling code here:
        tag.setNev(nev.getText());
        tag.setCim(cim.getText());
        km.setTag(tag);
        JOptionPane.showMessageDialog(null, "Sikeres módosítás!", "Üzenet", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_modositas_gombMouseClicked

    private void masol_gombMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masol_gombMouseClicked
        StringSelection stringSelection = new StringSelection(konyvtarjegyszam.getText());
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
    }//GEN-LAST:event_masol_gombMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel buntetes;
    private javax.swing.JTextField cim;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kolcsonzes_gomb;
    private javax.swing.JList<Object> kolcsonzesi_lista;
    private javax.swing.JLabel konyvtarjegyszam;
    private javax.swing.JButton masol_gomb;
    private javax.swing.JButton modositas_gomb;
    private javax.swing.JTextField nev;
    private javax.swing.JButton torles_gomb;
    private javax.swing.JButton visszahozatal_gomb;
    // End of variables declaration//GEN-END:variables
}
