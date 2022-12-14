/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Controller.PlaylistController;
import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Mine
 */
public class CreatePlaylist extends javax.swing.JPanel {

    PlaylistController plc;

    public CreatePlaylist() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        gestionPlaylist = new javax.swing.JMenuItem();
        suprrimerMitem = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        nomPlaylist = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        gestionPlaylist.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        gestionPlaylist.setText("Gérer ma playlist");
        gestionPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionPlaylistActionPerformed(evt);
            }
        });
        jPopupMenu1.add(gestionPlaylist);

        suprrimerMitem.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        suprrimerMitem.setText("Supprimer la playlist");
        suprrimerMitem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suprrimerMitemMouseClicked(evt);
            }
        });
        suprrimerMitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suprrimerMitemActionPerformed(evt);
            }
        });
        jPopupMenu1.add(suprrimerMitem);

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });

        nomPlaylist.setBackground(new java.awt.Color(255, 255, 255));
        nomPlaylist.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        nomPlaylist.setForeground(new java.awt.Color(63, 63, 63));
        nomPlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Playlist_30px.png"))); // NOI18N
        nomPlaylist.setText("Nom de la playlist");
        nomPlaylist.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                nomPlaylistMouseMoved(evt);
            }
        });
        nomPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nomPlaylistMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nomPlaylistMouseExited(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Plus_Math_30px_4.png"))); // NOI18N
        jLabel1.setToolTipText("Selectionner et ajouter");
        jLabel1.setComponentPopupMenu(jPopupMenu1);
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel1MouseMoved(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(nomPlaylist)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nomPlaylist, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new Color(64, 64, 64)));
        jPanel1.setBackground(new Color(250, 250, 250));

    }//GEN-LAST:event_jPanel1MouseMoved

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        jPanel1.setBorder(null);
        jPanel1.setBackground(new Color(255, 255, 255));

    }//GEN-LAST:event_jPanel1MouseExited

    private void suprrimerMitemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suprrimerMitemMouseClicked
    }//GEN-LAST:event_suprrimerMitemMouseClicked

    private void suprrimerMitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suprrimerMitemActionPerformed
        Path path = Paths.get("C:/Users/Public/FreshPlayer/Playlist/" + nomPlaylist.getText() + ".txt");
        try {
            Files.deleteIfExists(path);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        FreshPlayer.panPlaylist.removeAll();
        FreshPlayer.panPlaylist.setVisible(false);
        FreshPlayer.panPlaylist.setVisible(true);
    }//GEN-LAST:event_suprrimerMitemActionPerformed

    private void nomPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nomPlaylistMouseClicked
        plc = new PlaylistController();
        plc.writePlaylistInTable(nomPlaylist.getText(), FreshPlayer.tablePlaylist);
        FreshPlayer.panInfoPlalist.setVisible(true);
        FreshPlayer.panMain.setVisible(false);
        FreshPlayer.panSound.setVisible(false);
        FreshPlayer.infoNomPlaylist.setText(nomPlaylist.getText());
    }//GEN-LAST:event_nomPlaylistMouseClicked

    private void gestionPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionPlaylistActionPerformed
        plc = new PlaylistController();
        plc.writePlaylistInTable(nomPlaylist.getText(), FreshPlayer.tablePlaylist);
        FreshPlayer.panInfoPlalist.setVisible(true);
        FreshPlayer.panMain.setVisible(false);
        FreshPlayer.panSound.setVisible(false);
        FreshPlayer.infoNomPlaylist.setText(nomPlaylist.getText());
    }//GEN-LAST:event_gestionPlaylistActionPerformed

    private void nomPlaylistMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nomPlaylistMouseMoved
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new Color(64, 64, 64)));
        jPanel1.setBackground(new Color(250, 250, 250));
    }//GEN-LAST:event_nomPlaylistMouseMoved

    private void nomPlaylistMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nomPlaylistMouseExited
        jPanel1.setBorder(null);
        jPanel1.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_nomPlaylistMouseExited

    private void jLabel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseMoved
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new Color(64, 64, 64)));
        jPanel1.setBackground(new Color(250, 250, 250));
    }//GEN-LAST:event_jLabel1MouseMoved

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        jPanel1.setBorder(null);
        jPanel1.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_jLabel1MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem gestionPlaylist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    public javax.swing.JLabel nomPlaylist;
    private javax.swing.JMenuItem suprrimerMitem;
    // End of variables declaration//GEN-END:variables
}
