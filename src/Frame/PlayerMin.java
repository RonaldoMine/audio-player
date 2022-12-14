/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Controller.FiltreExtension;
import Controller.AudioPlayer;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Mine
 */
public class PlayerMin extends javax.swing.JFrame {

    Media pick;
    MediaPlayer player;
    AudioPlayer audio;
    Timer t;
    int i = 0;
    int xMouse;
    int yMouse;

    public PlayerMin() {
        initComponents();
        this.t = new Timer(1000, new Check());
        Image IIcone;
        IIcone = getToolkit().getImage("src/images/icons8_Overwatch_48px.png");
        this.setIconImage(IIcone);
        ChangeValueIcon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slidePan = new diu.swe.habib.JPanelSlider.JPanelSlider();
        panMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        butSound = new javax.swing.JLabel();
        butPlay = new javax.swing.JLabel();
        butAnim = new javax.swing.JLabel();
        labExit = new javax.swing.JLabel();
        labStop = new javax.swing.JLabel();
        butSon = new javax.swing.JLabel();
        labName = new javax.swing.JLabel();
        labExit1 = new javax.swing.JLabel();
        labPochette = new javax.swing.JLabel();
        panSound = new javax.swing.JPanel();
        butSoundReturn = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labNameFile = new javax.swing.JLabel();
        labCheminFile = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labTypeFile = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GhostPlayer");
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        panMain.setBackground(new java.awt.Color(0, 0, 0));
        panMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_View_Details_50px_1.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        panMain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, -1, -1));

        butSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Plus_Math_30px_1.png"))); // NOI18N
        butSound.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butSound.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butSoundMouseClicked(evt);
            }
        });
        panMain.add(butSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        butPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Play_45px_1.png"))); // NOI18N
        butPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butPlayMouseClicked(evt);
            }
        });
        panMain.add(butPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, -1, -1));

        butAnim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Wait_50px_1.png"))); // NOI18N
        butAnim.setToolTipText("Mode Animation desactiv??");
        butAnim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butAnim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butAnimMouseClicked(evt);
            }
        });
        panMain.add(butAnim, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, -1, -1));

        labExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Sign_Out_50px_1.png"))); // NOI18N
        labExit.setToolTipText("Quiter");
        labExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labExitMouseClicked(evt);
            }
        });
        panMain.add(labExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        labStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Stop_40px_1.png"))); // NOI18N
        labStop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labStopMouseClicked(evt);
            }
        });
        panMain.add(labStop, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, -1, 50));

        butSon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Speaker_30px_1.png"))); // NOI18N
        butSon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butSon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butSonMouseClicked(evt);
            }
        });
        panMain.add(butSon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        labName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labName.setForeground(new java.awt.Color(255, 255, 255));
        labName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panMain.add(labName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 320, 30));

        labExit1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        labExit1.setForeground(new java.awt.Color(255, 255, 255));
        labExit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Horizontal_Line_50px.png"))); // NOI18N
        labExit1.setToolTipText("Reduire");
        labExit1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labExit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labExit1MouseClicked(evt);
            }
        });
        panMain.add(labExit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 30, -1));

        labPochette.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPochette.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Music_Record_60px_1.png"))); // NOI18N
        panMain.add(labPochette, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 470));

        slidePan.add(panMain, "card2");

        panSound.setBackground(new java.awt.Color(0, 0, 0));

        butSoundReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Left_40px_1.png"))); // NOI18N
        butSoundReturn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butSoundReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butSoundReturnMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nom du fichier :");

        labNameFile.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        labNameFile.setForeground(new java.awt.Color(255, 255, 255));
        labNameFile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        labCheminFile.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        labCheminFile.setForeground(new java.awt.Color(255, 255, 255));
        labCheminFile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel9.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Chemin d'acces :");

        jLabel10.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Type de fichier :");

        labTypeFile.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        labTypeFile.setForeground(new java.awt.Color(255, 255, 255));
        labTypeFile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel2.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Infomations sur le fichier");

        jLabel11.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Version 1.0");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panSoundLayout = new javax.swing.GroupLayout(panSound);
        panSound.setLayout(panSoundLayout);
        panSoundLayout.setHorizontalGroup(
            panSoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSoundLayout.createSequentialGroup()
                .addGroup(panSoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panSoundLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labTypeFile, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panSoundLayout.createSequentialGroup()
                        .addGroup(panSoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(butSoundReturn)
                            .addGroup(panSoundLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panSoundLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labNameFile, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panSoundLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labCheminFile, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panSoundLayout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addGroup(panSoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        panSoundLayout.setVerticalGroup(
            panSoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSoundLayout.createSequentialGroup()
                .addComponent(butSoundReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panSoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labNameFile, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panSoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labCheminFile, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panSoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labTypeFile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(208, 208, 208)
                .addGroup(panSoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panSoundLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        slidePan.add(panSound, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slidePan, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slidePan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void butSoundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butSoundMouseClicked
        FiltreExtension filtreE = new FiltreExtension("mp3", "Fichier MP3");
        FiltreExtension filtreE2 = new FiltreExtension("mpeg", "Fichier MPEG");
        JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File("R:/Musique"));
        jfc.addChoosableFileFilter(filtreE);
        jfc.addChoosableFileFilter(filtreE2);
        int resultat = jfc.showOpenDialog(this);
        if (resultat == JFileChooser.APPROVE_OPTION) {
            File f;
            f = jfc.getSelectedFile();
            if (filtreE.accept(f) || filtreE2.accept(f)) {
                JFXPanel jf = new JFXPanel();
                if (player != null) {
                    player.stop();

                }
                butPlay.setIcon(new ImageIcon("src/images/icons8_Pause_50px_1.png"));
                pick = new Media(f.toURI().toString());
                player = new MediaPlayer(pick);
                player.play();
                f.toURI().toString();
                labName.setText(f.getName());
                labNameFile.setText(f.getName());
                labCheminFile.setText(f.getPath());
                labTypeFile.setText(filtreE.getDescription());
                labPochette.setIcon(new ImageIcon("src/gifs/animCircle.gif"));
            } else {
                JOptionPane.showMessageDialog(null, "Le format du ficier est invalide!Choississez un fichier au format mp3");
            }

        }
    }//GEN-LAST:event_butSoundMouseClicked

    private void labExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_labExitMouseClicked

    private void butSoundReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butSoundReturnMouseClicked
        slidePan.nextPanel(10, panMain, slidePan.right);
    }//GEN-LAST:event_butSoundReturnMouseClicked

    private void butSonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butSonMouseClicked
        if (player != null) {
            if (areIconsEqual(butSon, new ImageIcon("src/images/icons8_Speaker_30px_1.png"))) {
                butSon.setIcon(new ImageIcon("src/images/icons8_Mute_30px_1.png"));
                player.setMute(true);
            } else if (areIconsEqual(butSon, new ImageIcon("src/images/icons8_Mute_30px_1.png"))) {
                butSon.setIcon(new ImageIcon("src/images/icons8_Speaker_30px_1.png"));
                player.setMute(false);
            }
        }

    }//GEN-LAST:event_butSonMouseClicked

    private void labStopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labStopMouseClicked
        player.stop();
        butPlay.setIcon(new ImageIcon("src/images/icons8_Play_50px_1.png"));
        labPochette.setIcon(new ImageIcon("src/images/icons8_Music_100px_1.png"));
        t.stop();
    }//GEN-LAST:event_labStopMouseClicked

    private void butPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butPlayMouseClicked
        if (!labName.getText().equals("")) {
            if (areIconsEqual(butPlay, new ImageIcon("src/images/icons8_Pause_50px_1.png"))) {
                butPlay.setIcon(new ImageIcon("src/images/icons8_Play_50px_1.png"));
                player.pause();
                labPochette.setIcon(new ImageIcon("src/images/icons8_Music_100px_1.png"));
            } else if (areIconsEqual(butPlay, new ImageIcon("src/images/icons8_Play_50px_1.png"))) {
                butPlay.setIcon(new ImageIcon("src/images/icons8_Pause_50px_1.png"));
                player.play();
                labPochette.setIcon(new ImageIcon("src/gifs/animCircle.gif"));
            }
        }
        /*  //System.out.println(player.getBalance());
        audio = new AudioPlayer(new File("R:\\khalid.wav"));
        AudioInputStream audioInputStream;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("R:\\khalid.wav"));

            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            if (!clip.isRunning()) {
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(0.0f); // Reduce volume by 10 decibels.
                clip.start();
                slider.setMaximum((int) audio.durationInSeconds);
                t.start();
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(PlayerMin.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_butPlayMouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();

        setOpacity((float) 0.8);
    }//GEN-LAST:event_formMousePressed

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited

    }//GEN-LAST:event_formMouseExited

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        setOpacity((float) 1.0);
    }//GEN-LAST:event_formMouseReleased

    private void butAnimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAnimMouseClicked
        if (areIconsEqual(butAnim, new ImageIcon("src/images/icons8_In_Progress_50px.png"))) {
            butAnim.setIcon(new ImageIcon("src/images/icons8_Wait_50px_1.png"));
            butAnim.setToolTipText("Mode animation d??sactiv??");
            t.stop();
            labPochette.setIcon(new ImageIcon("src/images/icons8_Music_100px.png"));

        } else if (areIconsEqual(butAnim, new ImageIcon("src/images/icons8_Wait_50px_1.png"))) {
            butAnim.setIcon(new ImageIcon("src/images/icons8_In_Progress_50px.png"));
            butAnim.setToolTipText("Mode animation activ??");
            t.start();
        }
    }//GEN-LAST:event_butAnimMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        slidePan.nextPanel(10, panSound, slidePan.left);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void labExit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labExit1MouseClicked
        this.setState(WIDTH);
    }//GEN-LAST:event_labExit1MouseClicked
    public boolean areIconsEqual(JLabel firstLabel, ImageIcon secondIcon) {
        boolean res = false;
        if (firstLabel.getIcon().toString().equals(secondIcon.toString())) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    public void ChangeValueIcon() {
        butSon.setIcon(new ImageIcon("src/images/icons8_Speaker_30px_1.png"));
        butAnim.setIcon(new ImageIcon("src/images/icons8_Wait_50px_1.png"));
    }

    String[] anim = {"src/gifs/animCircle.gif", "src/gifs/cercle.gif",
        "src/gifs/disco.gif", "src/gifs/tourcercle.gif",
        "src/gifs/infini.gif", "src/gifs/vague.gif"};

    class Check implements ActionListener {

        int seconde = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            seconde++;
            labPochette.setIcon(new ImageIcon(anim[i]));
            if (seconde == 10) {
                i++;
                seconde = 0;
                if (i == anim.length) {
                    i = 0;
                }
            }

        }
    }

    /* class Check implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (i < audio.durationInSeconds) {
                slider.setValue(i);
                i++;
            }
            else {
                slider.setValue(0);
                slider.setMaximum(100);
                i=0;
                t.stop();
            }
                    
                
        }
    }*/
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayerMin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayerMin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayerMin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayerMin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayerMin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel butAnim;
    private javax.swing.JLabel butPlay;
    private javax.swing.JLabel butSon;
    private javax.swing.JLabel butSound;
    private javax.swing.JLabel butSoundReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labCheminFile;
    private javax.swing.JLabel labExit;
    private javax.swing.JLabel labExit1;
    private javax.swing.JLabel labName;
    private javax.swing.JLabel labNameFile;
    private javax.swing.JLabel labPochette;
    private javax.swing.JLabel labStop;
    private javax.swing.JLabel labTypeFile;
    private javax.swing.JPanel panMain;
    private javax.swing.JPanel panSound;
    private diu.swe.habib.JPanelSlider.JPanelSlider slidePan;
    // End of variables declaration//GEN-END:variables
}
