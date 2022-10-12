/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Controller.Application;
import Controller.ClassPlayer;
import Controller.CellObjectRenderer;
import Controller.PlaylistController;
import Controller.TagsOfFiles;
import Controller.VolumeControl;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mine
 */
public class FreshPlayer extends javax.swing.JFrame {

    //pour le repeat
    public static int count = 0;
    //pour la lecture aleatoire
    public static int etatLecture = 0;
    //La classe qui gère la musique
    ClassPlayer cp = new ClassPlayer();
    //la classe qui gere le volume
    VolumeControl vc = new VolumeControl();
    //la variable superglobale
    private int i = 0;
    //j'en sais trop rien
    int sonLenghtCount = 0;
    //Liste des fichier de lecture
    File[] files;
    //contenu de la table
    Object[] row;
    //liste des musiques
    public static ArrayList<String> arrayFile = new ArrayList<>();
    //Noms des musiques
    static ArrayList<String> arrayFileName = new ArrayList<>();
    //Types de fichiers des musiques
    ArrayList<String> arrayFileType = new ArrayList<>();
    Timer timer;
    int x, y, xMouse, yMouse;

    private SwingWorker swingWorke = new SwingWorker<Void, String>() {
        @Override
        protected Void doInBackground() throws Exception {
            Thread.sleep(500);
            Application.getDU().checkIsFileExist();
            cp.addSonsWithFolder(arrayFile, arrayFileName, row, Application.getDU().getFolder(), table);
            File lastFolder = new File(Application.getDU().getFolder());
            fileChooser.setSelectedFile(lastFolder);
            return null;
        }

        @Override
        protected void done() {
            TagsOfFiles tof = new TagsOfFiles(arrayFile.get(i));
            labArtiste.setText(tof.getNomArtiste());
            labNameFile.setText(tof.getTitre());
            labDurationOfSon.setText(tof.getValueDuration());
        }
    };

    public FreshPlayer() {
        initComponents();
        PlaylistController.getAllPlaylist();
        panNextSon.setVisible(false);
        swingWorke.execute();
        Image IIcone;
        IIcone = getToolkit().getImage("src/images/icons8_Overwatch_48px.png");
        this.setIconImage(IIcone);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        i = Application.getDU().getLastIndicePlaying();
        ChangeValueIcon();
        //pour l'heure et la date 
        new Timer(0, (ActionEvent e) -> {
            Date d1 = new Date();
            SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat spf = new SimpleDateFormat("dd MMMM yyyy");
            time.setText(s.format(d1) + " " + spf.format(d1));
        }).start();
        this.timer = new Timer(1000, new SonsAleatoire());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        dialogPlaylist = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        closeDialogPlaylist = new javax.swing.JLabel();
        txtNamePlaylist = new javax.swing.JTextField();
        ajoutPlaylist = new javax.swing.JButton();
        popupAjout = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        panelEntete = new javax.swing.JPanel();
        labLogo = new javax.swing.JLabel();
        labArtiste = new javax.swing.JLabel();
        labLoop = new javax.swing.JLabel();
        labRepeat = new javax.swing.JLabel();
        butBack = new javax.swing.JLabel();
        butPlay = new javax.swing.JLabel();
        butForward = new javax.swing.JLabel();
        butSonActive = new javax.swing.JLabel();
        butSoundSearch = new javax.swing.JLabel();
        butParametre = new javax.swing.JLabel();
        labNameFile = new javax.swing.JLabel();
        progressSon = new javax.swing.JProgressBar();
        sliderManageSound = new javax.swing.JSlider();
        labDurationOfSon = new javax.swing.JLabel();
        labVariationSec = new javax.swing.JLabel();
        labVariationMin = new javax.swing.JLabel();
        slidePan = new diu.swe.habib.JPanelSlider.JPanelSlider();
        panMain = new javax.swing.JPanel();
        labMusic = new javax.swing.JLabel();
        labDeleteMusique = new javax.swing.JLabel();
        labDeleteAll = new javax.swing.JLabel();
        labAjoutMusique = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        labGetFolderSound = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        panNextSon = new javax.swing.JPanel();
        nextSon = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panSound = new javax.swing.JPanel();
        labCoul = new javax.swing.JLabel();
        labCoulBlanc = new javax.swing.JLabel();
        labTextCoulBlanc = new javax.swing.JLabel();
        labCoulNoir = new javax.swing.JLabel();
        labTextCoulNoir = new javax.swing.JLabel();
        butSoundReturn = new javax.swing.JLabel();
        panInfoPlalist = new javax.swing.JPanel();
        infoNomPlaylist = new javax.swing.JLabel();
        butPlayPlaylist = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePlaylist = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labAjoutPlaylist = new javax.swing.JLabel();
        scrollPlaylist = new javax.swing.JScrollPane();
        panPlaylist = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        fileChooser.setApproveButtonMnemonic(1);
        fileChooser.setApproveButtonText("Ajouter");
        fileChooser.setApproveButtonToolTipText("");
        fileChooser.setCurrentDirectory(null);
        fileChooser.setDialogTitle("Indiquer un emplacement de musique");
        fileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        fileChooser.setForeground(new java.awt.Color(64, 64, 64));
        fileChooser.setAutoscrolls(true);
        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });

        dialogPlaylist.setBackground(new java.awt.Color(255, 255, 255));
        dialogPlaylist.setModal(true);
        dialogPlaylist.setUndecorated(true);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        closeDialogPlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Delete_30px_1.png"))); // NOI18N
        closeDialogPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeDialogPlaylistMouseClicked(evt);
            }
        });

        txtNamePlaylist.setBackground(new java.awt.Color(255, 255, 255));
        txtNamePlaylist.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        txtNamePlaylist.setForeground(new java.awt.Color(69, 73, 74));
        txtNamePlaylist.setText("Nom de la Playlist");

        ajoutPlaylist.setBackground(new java.awt.Color(102, 102, 102));
        ajoutPlaylist.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ajoutPlaylist.setForeground(new java.awt.Color(255, 255, 255));
        ajoutPlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Plus_Math_30px_1.png"))); // NOI18N
        ajoutPlaylist.setText("Ajouter");
        ajoutPlaylist.setBorderPainted(false);
        ajoutPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajoutPlaylistMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNamePlaylist, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(closeDialogPlaylist, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ajoutPlaylist, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeDialogPlaylist)
                .addGap(18, 18, 18)
                .addComponent(txtNamePlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ajoutPlaylist)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dialogPlaylistLayout = new javax.swing.GroupLayout(dialogPlaylist.getContentPane());
        dialogPlaylist.getContentPane().setLayout(dialogPlaylistLayout);
        dialogPlaylistLayout.setHorizontalGroup(
            dialogPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogPlaylistLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        dialogPlaylistLayout.setVerticalGroup(
            dialogPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogPlaylistLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        popupAjout.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        popupAjout.setBorderPainted(false);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jMenuItem1.setText("Jouer");
        jMenuItem1.setBorderPainted(false);
        jMenuItem1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuItem1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jMenuItem1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jMenuItem1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        popupAjout.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AudioPlayer");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        panelEntete.setBackground(new java.awt.Color(250, 250, 250));
        panelEntete.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 3, 1, 3));
        panelEntete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Music_Record_60px_2.png"))); // NOI18N
        panelEntete.add(labLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 1, -1, -1));

        labArtiste.setFont(new java.awt.Font("Segoe UI Symbol", 0, 11)); // NOI18N
        labArtiste.setText("Artiste");
        panelEntete.add(labArtiste, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 15, 260, -1));

        labLoop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLoop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Infinity_30px_2.png"))); // NOI18N
        labLoop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labLoop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labLoopMouseClicked(evt);
            }
        });
        panelEntete.add(labLoop, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 1, -1, 47));

        labRepeat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labRepeat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Repeat_30px_2.png"))); // NOI18N
        labRepeat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labRepeat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labRepeatMouseClicked(evt);
            }
        });
        panelEntete.add(labRepeat, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 1, -1, 47));

        butBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Back_40px_2.png"))); // NOI18N
        butBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butBackMouseClicked(evt);
            }
        });
        panelEntete.add(butBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 1, -1, 47));

        butPlay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Play_45px_2.png"))); // NOI18N
        butPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butPlayMouseClicked(evt);
            }
        });
        panelEntete.add(butPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 1, -1, 47));

        butForward.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butForward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Forward_40px_2.png"))); // NOI18N
        butForward.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butForward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butForwardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butForwardMouseEntered(evt);
            }
        });
        panelEntete.add(butForward, new org.netbeans.lib.awtextra.AbsoluteConstraints(637, 1, -1, 47));

        butSonActive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Speaker_30px_2.png"))); // NOI18N
        butSonActive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butSonActive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butSonActiveMouseClicked(evt);
            }
        });
        panelEntete.add(butSonActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 7, -1, 41));

        butSoundSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Plus_Math_30px_2.png"))); // NOI18N
        butSoundSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butSoundSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butSoundSearchMouseClicked(evt);
            }
        });
        panelEntete.add(butSoundSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 1, -1, 47));

        butParametre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Settings_30px_2.png"))); // NOI18N
        butParametre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butParametre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butParametreMouseClicked(evt);
            }
        });
        panelEntete.add(butParametre, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 1, -1, 47));

        labNameFile.setFont(new java.awt.Font("Segoe UI Symbol", 0, 11)); // NOI18N
        labNameFile.setText("Titre");
        panelEntete.add(labNameFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 36, 260, -1));

        progressSon.setBackground(new java.awt.Color(255, 255, 255));
        progressSon.setForeground(new java.awt.Color(64, 64, 64));
        panelEntete.add(progressSon, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 47, 364, 5));

        sliderManageSound.setBackground(new java.awt.Color(255, 255, 255));
        sliderManageSound.setForeground(new java.awt.Color(64, 64, 64));
        sliderManageSound.setToolTipText("");
        sliderManageSound.setValue(100);
        sliderManageSound.setPreferredSize(new java.awt.Dimension(36, 26));
        sliderManageSound.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                sliderManageSoundMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                sliderManageSoundMouseMoved(evt);
            }
        });
        panelEntete.add(sliderManageSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 7, 253, 41));

        labDurationOfSon.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        labDurationOfSon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDurationOfSon.setText("00:00");
        labDurationOfSon.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panelEntete.add(labDurationOfSon, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 42, 30, 15));

        labVariationSec.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        labVariationSec.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labVariationSec.setText("00");
        labVariationSec.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panelEntete.add(labVariationSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 42, 17, 15));

        labVariationMin.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        labVariationMin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labVariationMin.setText("00:");
        labVariationMin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        panelEntete.add(labVariationMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 42, 20, 15));

        panMain.setBackground(new java.awt.Color(250, 250, 250));

        labMusic.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        labMusic.setForeground(new java.awt.Color(64, 64, 64));
        labMusic.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labMusic.setText("Ma musique :");

        labDeleteMusique.setBackground(new java.awt.Color(238, 238, 238));
        labDeleteMusique.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labDeleteMusique.setForeground(new java.awt.Color(64, 64, 64));
        labDeleteMusique.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Cancel_20px.png"))); // NOI18N
        labDeleteMusique.setText("Selectionner et supprimer une musique");
        labDeleteMusique.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labDeleteMusique.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labDeleteMusiqueMouseClicked(evt);
            }
        });

        labDeleteAll.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labDeleteAll.setForeground(new java.awt.Color(64, 64, 64));
        labDeleteAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Trash_20px.png"))); // NOI18N
        labDeleteAll.setText("Supprimer tous les morceaux");
        labDeleteAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labDeleteAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labDeleteAllMouseClicked(evt);
            }
        });

        labAjoutMusique.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labAjoutMusique.setForeground(new java.awt.Color(64, 64, 64));
        labAjoutMusique.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Add_20px_2.png"))); // NOI18N
        labAjoutMusique.setText("Ajouter");
        labAjoutMusique.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labAjoutMusique.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labAjoutMusiqueMouseClicked(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        table.setBackground(new java.awt.Color(255, 255, 255));
        table.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(0, 0, 0));
        table.setIntercellSpacing(new java.awt.Dimension(0, 0));
        table.setRowHeight(40);
        table.setSelectionBackground(new java.awt.Color(64, 64, 64));
        table.setSelectionForeground(new java.awt.Color(204, 204, 204));
        table.setShowVerticalLines(false);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(0).setPreferredWidth(5);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(1).setPreferredWidth(5);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(2).setPreferredWidth(150);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(3).setPreferredWidth(530);
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(4).setPreferredWidth(30);
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(5).setPreferredWidth(20);
            table.getColumnModel().getColumn(6).setResizable(false);
        }

        jSeparator1.setForeground(new java.awt.Color(170, 170, 170));

        jSeparator2.setForeground(new java.awt.Color(170, 170, 170));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Add_18px.png"))); // NOI18N
        jLabel2.setText("Plus de musique?");

        labGetFolderSound.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        labGetFolderSound.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labGetFolderSound.setText("Selectionner un emplacement de musique");
        labGetFolderSound.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labGetFolderSound.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labGetFolderSoundMouseClicked(evt);
            }
        });

        time.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        time.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        panNextSon.setBackground(new java.awt.Color(255, 255, 255));
        panNextSon.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(60, 63, 65), 1, true));

        nextSon.setFont(new java.awt.Font("Lucida Calligraphy", 0, 14)); // NOI18N
        nextSon.setForeground(new java.awt.Color(60, 63, 65));
        nextSon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nextSon.setText("Nom du morceau suivant");

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Next_50px.png"))); // NOI18N
        jLabel4.setText("Next");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout panNextSonLayout = new javax.swing.GroupLayout(panNextSon);
        panNextSon.setLayout(panNextSonLayout);
        panNextSonLayout.setHorizontalGroup(
            panNextSonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panNextSonLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(nextSon, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        panNextSonLayout.setVerticalGroup(
            panNextSonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panNextSonLayout.createSequentialGroup()
                .addGroup(panNextSonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nextSon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout panMainLayout = new javax.swing.GroupLayout(panMain);
        panMain.setLayout(panMainLayout);
        panMainLayout.setHorizontalGroup(
            panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panMainLayout.createSequentialGroup()
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(panMainLayout.createSequentialGroup()
                                .addComponent(labMusic)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labAjoutMusique)
                                .addGap(18, 18, 18)
                                .addComponent(labDeleteMusique)
                                .addGap(18, 18, 18)
                                .addComponent(labDeleteAll)
                                .addGap(18, 18, 18)
                                .addComponent(time, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))))
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panMainLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(labGetFolderSound, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panNextSon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panMainLayout.setVerticalGroup(
            panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMainLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labAjoutMusique)
                        .addComponent(labDeleteMusique)
                        .addComponent(labDeleteAll)
                        .addComponent(labMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(labGetFolderSound))
                    .addGroup(panMainLayout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(panNextSon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        slidePan.add(panMain, "card2");

        panSound.setBackground(new java.awt.Color(255, 255, 255));
        panSound.setForeground(new java.awt.Color(255, 255, 255));
        panSound.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labCoul.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labCoul.setForeground(new java.awt.Color(64, 64, 64));
        labCoul.setText("Couleur du Thème");
        panSound.add(labCoul, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        labCoulBlanc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labCoulBlanc.setForeground(new java.awt.Color(64, 64, 64));
        labCoulBlanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_New_Moon_80px.png"))); // NOI18N
        labCoulBlanc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labCoulBlanc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labCoulBlanc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labCoulBlancMouseClicked(evt);
            }
        });
        panSound.add(labCoulBlanc, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 80, 70));

        labTextCoulBlanc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labTextCoulBlanc.setForeground(new java.awt.Color(64, 64, 64));
        labTextCoulBlanc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTextCoulBlanc.setText("Par default");
        panSound.add(labTextCoulBlanc, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 90, 20));

        labCoulNoir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labCoulNoir.setForeground(new java.awt.Color(64, 64, 64));
        labCoulNoir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_New_Moon_80px_2.png"))); // NOI18N
        labCoulNoir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labCoulNoir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labCoulNoir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labCoulNoirMouseClicked(evt);
            }
        });
        panSound.add(labCoulNoir, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 80, 70));

        labTextCoulNoir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labTextCoulNoir.setForeground(new java.awt.Color(64, 64, 64));
        labTextCoulNoir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTextCoulNoir.setText("Noir");
        panSound.add(labTextCoulNoir, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 90, 20));

        butSoundReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Left_40px_2.png"))); // NOI18N
        butSoundReturn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butSoundReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butSoundReturnMouseClicked(evt);
            }
        });
        panSound.add(butSoundReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 36));

        slidePan.add(panSound, "card4");

        panInfoPlalist.setBackground(new java.awt.Color(255, 255, 255));

        infoNomPlaylist.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        infoNomPlaylist.setText("Nom de la playlist");

        butPlayPlaylist.setFont(new java.awt.Font("Segoe UI Symbol", 0, 16)); // NOI18N
        butPlayPlaylist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butPlayPlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Play_20px.png"))); // NOI18N
        butPlayPlaylist.setText("Jouer");
        butPlayPlaylist.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                butPlayPlaylistMouseMoved(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 0, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Waste_20px.png"))); // NOI18N
        jLabel5.setText("Supprimer");

        jLabel6.setFont(new java.awt.Font("Segoe UI Symbol", 0, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Plus_20px.png"))); // NOI18N
        jLabel6.setText("Ajouter des morceaux");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);

        tablePlaylist.setBackground(new java.awt.Color(255, 255, 255));
        tablePlaylist.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        tablePlaylist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePlaylist.setComponentPopupMenu(popupAjout);
        tablePlaylist.setGridColor(new java.awt.Color(0, 0, 0));
        tablePlaylist.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablePlaylist.setRowHeight(40);
        tablePlaylist.setSelectionBackground(new java.awt.Color(64, 64, 64));
        tablePlaylist.setSelectionForeground(new java.awt.Color(204, 204, 204));
        tablePlaylist.setShowVerticalLines(false);
        tablePlaylist.getTableHeader().setResizingAllowed(false);
        tablePlaylist.getTableHeader().setReorderingAllowed(false);
        tablePlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePlaylistMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablePlaylist);
        if (tablePlaylist.getColumnModel().getColumnCount() > 0) {
            tablePlaylist.getColumnModel().getColumn(0).setResizable(false);
            tablePlaylist.getColumnModel().getColumn(0).setPreferredWidth(5);
            tablePlaylist.getColumnModel().getColumn(1).setResizable(false);
            tablePlaylist.getColumnModel().getColumn(1).setPreferredWidth(150);
            tablePlaylist.getColumnModel().getColumn(2).setResizable(false);
            tablePlaylist.getColumnModel().getColumn(2).setPreferredWidth(530);
            tablePlaylist.getColumnModel().getColumn(3).setResizable(false);
            tablePlaylist.getColumnModel().getColumn(3).setPreferredWidth(30);
            tablePlaylist.getColumnModel().getColumn(4).setResizable(false);
            tablePlaylist.getColumnModel().getColumn(4).setPreferredWidth(20);
            tablePlaylist.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout panInfoPlalistLayout = new javax.swing.GroupLayout(panInfoPlalist);
        panInfoPlalist.setLayout(panInfoPlalistLayout);
        panInfoPlalistLayout.setHorizontalGroup(
            panInfoPlalistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panInfoPlalistLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoNomPlaylist)
                .addGap(83, 83, 83)
                .addComponent(butPlayPlaylist)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(334, Short.MAX_VALUE))
            .addComponent(jSeparator3)
            .addGroup(panInfoPlalistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panInfoPlalistLayout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(jScrollPane2)
                    .addContainerGap()))
        );
        panInfoPlalistLayout.setVerticalGroup(
            panInfoPlalistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panInfoPlalistLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panInfoPlalistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butPlayPlaylist, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoNomPlaylist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(644, 644, 644))
            .addGroup(panInfoPlalistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panInfoPlalistLayout.createSequentialGroup()
                    .addContainerGap(60, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        slidePan.add(panInfoPlalist, "card4");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_International_Music_30px.png"))); // NOI18N
        jLabel1.setText("Ma Musique");
        jLabel1.setToolTipText("Ma Musique");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        labAjoutPlaylist.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        labAjoutPlaylist.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labAjoutPlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Playlist_30px.png"))); // NOI18N
        labAjoutPlaylist.setText("Ajouter une Playlist");
        labAjoutPlaylist.setToolTipText("Ajouter une Playlist");
        labAjoutPlaylist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labAjoutPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labAjoutPlaylistMouseClicked(evt);
            }
        });

        scrollPlaylist.setBackground(new java.awt.Color(250, 250, 250));
        scrollPlaylist.setBorder(null);

        panPlaylist.setBackground(new java.awt.Color(255, 255, 255));
        panPlaylist.setLayout(new java.awt.GridLayout(10, 0, 1, 0));
        scrollPlaylist.setViewportView(panPlaylist);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Menu_30px_2.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labAjoutPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(labAjoutPlaylist)
                .addGap(18, 18, 18)
                .addComponent(scrollPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEntete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(slidePan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(panelEntete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slidePan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void butSoundSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butSoundSearchMouseClicked

    }//GEN-LAST:event_butSoundSearchMouseClicked

    private void butSoundReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butSoundReturnMouseClicked
        slidePan.nextPanel(10, panMain, slidePan.right);
    }//GEN-LAST:event_butSoundReturnMouseClicked

    private void butPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butPlayMouseClicked
        if (table.getRowCount() != 0) {
            if (areIconsEqual(butPlay, new ImageIcon("src/images/icons8_Play_45px_1.png"))) {
                butPlay.setIcon(new ImageIcon("src/images/icons8_Pause_40px_1.png"));
                if (cp.player == null) {
                    cp.Play((arrayFile.get(i)));
                    changeEtatColonne(i, table);
                    Application.getDU().writeDataLastFile(arrayFile.get(i), i);
                } else {
                    cp.Resume();
                }
            } else if (areIconsEqual(butPlay, new ImageIcon("src/images/icons8_Pause_40px_1.png"))) {
                butPlay.setIcon(new ImageIcon("src/images/icons8_Play_45px_1.png"));
                cp.Pause();
            }
            if (areIconsEqual(butPlay, new ImageIcon("src/images/icons8_Play_45px_2.png"))) {
                butPlay.setIcon(new ImageIcon("src/images/icons8_Pause_40px_2.png"));
                if (cp.player == null) {
                    cp.Play(arrayFile.get(i));
                    changeEtatColonne(i, table);
                    Application.getDU().writeDataLastFile(arrayFile.get(i), i);
                } else {
                    cp.Resume();
                }

            } else if (areIconsEqual(butPlay, new ImageIcon("src/images/icons8_Pause_40px_2.png"))) {
                butPlay.setIcon(new ImageIcon("src/images/icons8_Play_45px_2.png"));
                cp.Pause();
            }
        }
    }//GEN-LAST:event_butPlayMouseClicked

    private void labAjoutMusiqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labAjoutMusiqueMouseClicked

    }//GEN-LAST:event_labAjoutMusiqueMouseClicked

    private void labDeleteMusiqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labDeleteMusiqueMouseClicked
        DefaultTableModel mode = (DefaultTableModel) table.getModel();
        mode.removeRow(table.getSelectedRow());
    }//GEN-LAST:event_labDeleteMusiqueMouseClicked

    private void labDeleteAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labDeleteAllMouseClicked
        DefaultTableModel mode = (DefaultTableModel) table.getModel();
        mode.setRowCount(0);
        arrayFile.removeAll(arrayFile);
    }//GEN-LAST:event_labDeleteAllMouseClicked

    private void butSonActiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butSonActiveMouseClicked
        if (areIconsEqual(butSonActive, new ImageIcon("src/images/icons8_Speaker_30px_1.png"))) {
            butSonActive.setIcon(new ImageIcon("src/images/icons8_Mute_30px_1.png"));
        } else if (areIconsEqual(butSonActive, new ImageIcon("src/images/icons8_Mute_30px_1.png"))) {
            butSonActive.setIcon(new ImageIcon("src/images/icons8_Speaker_30px_1.png"));
        }
        if (areIconsEqual(butSonActive, new ImageIcon("src/images/icons8_Speaker_30px_2.png"))) {
            butSonActive.setIcon(new ImageIcon("src/images/icons8_Mute_30px_2.png"));

        } else if (areIconsEqual(butSonActive, new ImageIcon("src/images/icons8_Mute_30px_2.png"))) {
            butSonActive.setIcon(new ImageIcon("src/images/icons8_Speaker_30px_2.png"));

        }
    }//GEN-LAST:event_butSonActiveMouseClicked

    private void butForwardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butForwardMouseClicked
        if (cp != null && table.getRowCount() - 1 > i && etatLecture == 0) {
            i++;
            nextSon.setText(arrayFileName.get(i + 1));
            cp.Stop();
            cp.Play(arrayFile.get(i));
            Application.getDU().writeDataLastFile(arrayFile.get(i), i);
            changeEtatColonne(i, table);
        } else if (cp != null && i > 0 && etatLecture == 1) {
            i = referenceGen();
            nextSon.setText(arrayFileName.get(i));
            cp.Stop();
            cp.Play(arrayFile.get(i));
            Application.getDU().writeDataLastFile(arrayFile.get(i), i);
            changeEtatColonne(i, table);
        }
    }//GEN-LAST:event_butForwardMouseClicked

    private void butBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butBackMouseClicked
        if (cp != null && i > 0 && etatLecture == 0) {
            i--;
            nextSon.setText(arrayFileName.get(i + 1));
            cp.Stop();
            cp.Play(arrayFile.get(i));
            changeEtatColonne(i, table);
            Application.getDU().writeDataLastFile(arrayFile.get(i), i);
        } else if (cp != null && i > 0 && etatLecture == 1) {
            i = referenceGen();
            nextSon.setText(arrayFileName.get(i));
            cp.Stop();
            cp.Play(arrayFile.get(i));
            Application.getDU().writeDataLastFile(arrayFile.get(i), i);
            changeEtatColonne(i, table);

        }
    }//GEN-LAST:event_butBackMouseClicked

    private void labCoulBlancMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labCoulBlancMouseClicked
        theme(2, 1);
        labCoul.setForeground(new Color(64, 64, 64));
        labTextCoulBlanc.setForeground(new Color(64, 64, 64));
        labTextCoulNoir.setForeground(new Color(64, 64, 64));
        labAjoutMusique.setForeground(new Color(64, 64, 64));
        labDeleteMusique.setForeground(new Color(64, 64, 64));
        labDeleteAll.setForeground(new Color(64, 64, 64));
        labNameFile.setForeground(new Color(64, 64, 64));
        labArtiste.setForeground(new Color(64, 64, 64));
        labMusic.setForeground(new Color(64, 64, 64));
        panMain.setBackground(new Color(255, 255, 255));
        panSound.setBackground(new Color(255, 255, 255));
        panelEntete.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_labCoulBlancMouseClicked

    private void labCoulNoirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labCoulNoirMouseClicked
        theme(1, 2);
        labCoul.setForeground(new Color(255, 255, 255));
        labTextCoulNoir.setForeground(new Color(255, 255, 255));
        labTextCoulBlanc.setForeground(new Color(255, 255, 255));
        labAjoutMusique.setForeground(new Color(255, 255, 255));
        labAjoutMusique.setForeground(new Color(255, 255, 255));
        labDeleteMusique.setForeground(new Color(255, 255, 255));
        labDeleteAll.setForeground(new Color(255, 255, 255));
        labNameFile.setForeground(new Color(255, 255, 255));
        labArtiste.setForeground(new Color(255, 255, 255));
        labMusic.setForeground(new Color(255, 255, 255));
        panMain.setBackground(new Color(64, 64, 64));
        panSound.setBackground(new Color(64, 64, 64));
        panelEntete.setBackground(new Color(64, 64, 64));
    }//GEN-LAST:event_labCoulNoirMouseClicked

    private void butParametreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butParametreMouseClicked
        slidePan.nextPanel(10, panSound, slidePan.left);
    }//GEN-LAST:event_butParametreMouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int selectRow = table.getSelectedRow();
        int selectColumn = table.getSelectedColumn();
        table.setComponentPopupMenu(popupAjout);
        if (selectColumn == 0) {
            i = selectRow;
            cp.Stop();
            cp.Play(arrayFile.get(i));
            nextSon.setText(arrayFileName.get(selectRow + 1));
            Application.getDU().writeDataLastFile(arrayFile.get(i), i);
            changeEtatColonne(selectRow, table);
        }
        if (selectColumn == 1) {
            popupAjout.show(true);
        } else {
            popupAjout.show(false);

        }
    }//GEN-LAST:event_tableMouseClicked

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserActionPerformed
        DefaultTableModel mode = (DefaultTableModel) table.getModel();
        fileChooser.setMultiSelectionEnabled(true);
        files = fileChooser.getSelectedFiles();
        row = new Object[files.length];
        for (File file : files) {
            if (!file.isDirectory()) {
                row[0] = file.getName();
                mode.addRow(row);
            }
        }
        for (File file : files) {
            if (!file.isDirectory()) {
                arrayFile.add(file.toString());
            }
        }
        for (File file : files) {
            if (!file.isDirectory()) {
                arrayFileName.add(file.getName());
            }
        }
        for (File file : files) {
            if (!file.isDirectory()) {
                arrayFileType.add(fileChooser.getTypeDescription(file));
            }
        }
    }//GEN-LAST:event_fileChooserActionPerformed

    private void labGetFolderSoundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labGetFolderSoundMouseClicked
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            if (!fileChooser.getSelectedFile().toString().equals(Application.getDU().getFolder())) {
                cp.addSonsWithFolder(arrayFile, arrayFileName, row, fileChooser.getSelectedFile().toString(), table);
            } else {
                JOptionPane.showMessageDialog(null, "Ce dossier est deja pris en compte");

            }
        }

    }//GEN-LAST:event_labGetFolderSoundMouseClicked

    private void butForwardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butForwardMouseEntered
        if (etatLecture == 0) {
            butForward.setToolTipText(arrayFile.get(i + 1));
        } else {
            i = referenceGen();
            butForward.setToolTipText(arrayFile.get(i));
        }
    }//GEN-LAST:event_butForwardMouseEntered

    private void labRepeatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labRepeatMouseClicked
        switch (count) {
            case 0:
                count = 1;
                labRepeat.setIcon(new ImageIcon("src/images/icons8_Repeat_One_30px_2.png"));
                break;
            case 1:
                count = 0;
                labRepeat.setIcon(new ImageIcon("src/images/icons8_Repeat_30px_2.png"));
                break;
        }
    }//GEN-LAST:event_labRepeatMouseClicked

    private void labLoopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labLoopMouseClicked
        switch (etatLecture) {
            case 0:
                etatLecture = 1;
                System.out.println("Aleatoire activé");
                timer.start();
                break;
            case 1:
                etatLecture = 0;
                timer.stop();
                System.out.println("Aleatoire desactivée");
                break;
        }
    }//GEN-LAST:event_labLoopMouseClicked

    private void sliderManageSoundMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sliderManageSoundMouseMoved

    }//GEN-LAST:event_sliderManageSoundMouseMoved

    private void sliderManageSoundMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sliderManageSoundMouseDragged
        vc.setVolume((float) sliderManageSound.getValue());
        System.out.println(sliderManageSound.getValue());
    }//GEN-LAST:event_sliderManageSoundMouseDragged

    private void labAjoutPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labAjoutPlaylistMouseClicked
        closeDialogPlaylist.setFocusable(true);
        dialogPlaylist.setSize(385, 195);
        dialogPlaylist.setLocationRelativeTo(null);
        dialogPlaylist.setVisible(true);
    }//GEN-LAST:event_labAjoutPlaylistMouseClicked

    private void closeDialogPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeDialogPlaylistMouseClicked
        dialogPlaylist.dispose();
    }//GEN-LAST:event_closeDialogPlaylistMouseClicked

    private void ajoutPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajoutPlaylistMouseClicked
        PlaylistController pc = new PlaylistController();
        pc.createFilePlaylist(txtNamePlaylist.getText());
        dialogPlaylist.dispose();
    }//GEN-LAST:event_ajoutPlaylistMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tablePlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePlaylistMouseClicked
        int selectRow = tablePlaylist.getSelectedRow();
        int selectColumn = tablePlaylist.getSelectedColumn();
        if (selectColumn == 0) {
            i = selectRow;
            cp.Stop();
            cp.Play(PlaylistController.arrayList.get(i));
            Application.getDU().writeDataLastFile(arrayFile.get(i), i);
            changeEtatColonne(selectRow, tablePlaylist);
        }
    }//GEN-LAST:event_tablePlaylistMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        slidePan.nextPanel(1, panMain, slidePan.right);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void butPlayPlaylistMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butPlayPlaylistMouseMoved
        butPlayPlaylist.setBorder(BorderFactory.createSoftBevelBorder(1));
    }//GEN-LAST:event_butPlayPlaylistMouseMoved

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        if (jPanel3.getWidth() == 262) {
            jPanel3.setPreferredSize(new Dimension(48, 699));
        } else if (jPanel3.getWidth() == 48) {
            jPanel3.setPreferredSize(new Dimension(262, 699));
        }
    }//GEN-LAST:event_jLabel3MouseClicked
    //commparer les icons
    public boolean areIconsEqual(JLabel firstLabel, ImageIcon secondIcon) {
        boolean res = false;
        if (firstLabel.getIcon().toString().equals(secondIcon.toString())) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    //chahger l'icon du morceau courant
    public void changeEtatColonne(int k, JTable table) {
        for (int j = 0; j < table.getRowCount(); j++) {
            if (j == k) {
                table.setValueAt(new ImageIcon("src/images/icons8_Pause_40px.png"), j, 0);
                butPlay.setIcon(new ImageIcon("src/images/icons8_Pause_40px_2.png"));

            } else {
                table.setValueAt(new ImageIcon("src/images/icons8_Play_50px_2.png"), j, 0);
            }

        }
    }

    //Jouer successivement plusieurs morceaux
    /* public void playSuccessiveSons() {
        new Thread() {
            @Override
            public void run() {
                do {
                    if (cp.player.isComplete()) {
                        if (FreshPlayer.count == 1) {
                            cp.Play(arrayFile.get(i));
                            Application.getDU().writeDataLastFile(arrayFile.get(i), i);
                        } else {
                            i++;
                            butPlay.setIcon(new ImageIcon("src/images/icons8_Pause_40px.png"));
                            cp.Play(arrayFile.get(i));
                            butPlay.setIcon(new ImageIcon("src/images/icons8_Play_45px_2.png"));
                            changeEtatColonne(i);
                            Application.getDU().writeDataLastFile(arrayFile.get(i), i);
                        }

                    } else {
                        sonLenghtCount = sonLenghtCount;
                    }
                } while (!arrayFile.isEmpty());
            }
        }.start();

    }*/
    //changer les icons 
    public void ChangeValueIcon() {
        butSonActive.setIcon(new ImageIcon("src/images/icons8_Speaker_30px_2.png"));
        butPlay.setIcon(new ImageIcon("src/images/icons8_Play_45px_2.png"));
    }

    //designer le tableau
    public void tableCDesign(JTable table) {
        for (int k = 0; k < table.getColumnCount(); k++) {
            table.getColumnModel().getColumn(k).setCellRenderer(new CellObjectRenderer());
        }
        table.setShowVerticalLines(false);
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Segeo UI Symbol", Font.PLAIN, 12));
        table.getTableHeader().setForeground(Color.white);
    }

    public int referenceGen() {
        Random random = new Random();
        return random.nextInt(arrayFile.size());
    }

    //pour la lecture aleatoire
    class SonsAleatoire implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            i = referenceGen();
            nextSon.setText(arrayFileName.get(i));
            if (cp.player.isComplete() & cp != null && count == 0) {
                cp.Play(arrayFile.get(i));
                changeEtatColonne(i, table);
                Application.getDU().writeDataLastFile(arrayFile.get(i), i);
            }
        }
    }

    /* public void aleatoir() {
        new Thread() {
            @Override
            public void run() {
                do {
                    if (cp.player.isComplete() & cp != null && count == 0) {
                        i = referenceGen();
                        cp.Play(arrayFile.get(i));
                        changeEtatColonne(i);
                    }
                } while (!arrayFile.isEmpty());
            }
        }.start();
    }*/
    //different theme de l'application
    public void theme(int i1, int i2) {
        butBack.setIcon(new ImageIcon("src/images/icons8_Back_40px_" + i1 + ".png"));
        butForward.setIcon(new ImageIcon("src/images/icons8_Forward_40px_" + i1 + ".png"));
        butSoundReturn.setIcon(new ImageIcon("src/images/icons8_Left_40px_" + i1 + ".png"));
        if (areIconsEqual(butSonActive, new ImageIcon("src/images/icons8_Speaker_30px_" + i2 + ".png"))) {
            butSonActive.setIcon(new ImageIcon("src/images/icons8_Speaker_30px_" + i1 + ".png"));
        } else if (areIconsEqual(butSonActive, new ImageIcon("src/images/icons8_Mute_30px_" + i2 + ".png"))) {
            butSonActive.setIcon(new ImageIcon("src/images/icons8_Mute_30px_" + i1 + ".png"));
        }
        if (areIconsEqual(butPlay, new ImageIcon("src/images/icons8_Play_45px_" + i2 + ".png"))) {
            butPlay.setIcon(new ImageIcon("src/images/icons8_Play_45px_" + i1 + ".png"));
        } else if (areIconsEqual(butPlay, new ImageIcon("src/images/icons8_Pause_40px_" + i2 + ".png"))) {
            butPlay.setIcon(new ImageIcon("src/images/icons8_Pause_40px_" + i1 + ".png"));
        }
        labLogo.setIcon(new ImageIcon("src/images/icons8_Music_Record_60px_" + i1 + ".png"));
        butSoundSearch.setIcon(new ImageIcon("src/images/icons8_Plus_Math_30px_" + i1 + ".png"));
        butParametre.setIcon(new ImageIcon("src/images/icons8_Settings_30px_" + i1 + ".png"));
        labLoop.setIcon(new ImageIcon("src/images/icons8_Infinity_30px_" + i1 + ".png"));
        labRepeat.setIcon(new ImageIcon("src/images/icons8_Repeat_30px_" + i1 + ".png"));
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FreshPlayer.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FreshPlayer().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajoutPlaylist;
    private javax.swing.JLabel butBack;
    private javax.swing.JLabel butForward;
    private javax.swing.JLabel butParametre;
    private javax.swing.JLabel butPlay;
    private javax.swing.JLabel butPlayPlaylist;
    private javax.swing.JLabel butSonActive;
    private javax.swing.JLabel butSoundReturn;
    private javax.swing.JLabel butSoundSearch;
    private javax.swing.JLabel closeDialogPlaylist;
    private javax.swing.JDialog dialogPlaylist;
    private javax.swing.JFileChooser fileChooser;
    public static javax.swing.JLabel infoNomPlaylist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labAjoutMusique;
    private javax.swing.JLabel labAjoutPlaylist;
    public static javax.swing.JLabel labArtiste;
    private javax.swing.JLabel labCoul;
    private javax.swing.JLabel labCoulBlanc;
    private javax.swing.JLabel labCoulNoir;
    private javax.swing.JLabel labDeleteAll;
    private javax.swing.JLabel labDeleteMusique;
    public static javax.swing.JLabel labDurationOfSon;
    private javax.swing.JLabel labGetFolderSound;
    private javax.swing.JLabel labLogo;
    private javax.swing.JLabel labLoop;
    public static javax.swing.JLabel labMusic;
    public static javax.swing.JLabel labNameFile;
    private javax.swing.JLabel labRepeat;
    private javax.swing.JLabel labTextCoulBlanc;
    private javax.swing.JLabel labTextCoulNoir;
    public static javax.swing.JLabel labVariationMin;
    public static javax.swing.JLabel labVariationSec;
    public static javax.swing.JLabel nextSon;
    public static javax.swing.JPanel panInfoPlalist;
    public static javax.swing.JPanel panMain;
    public static javax.swing.JPanel panNextSon;
    public static javax.swing.JPanel panPlaylist;
    public static javax.swing.JPanel panSound;
    private javax.swing.JPanel panelEntete;
    public static javax.swing.JPopupMenu popupAjout;
    public static javax.swing.JProgressBar progressSon;
    private javax.swing.JScrollPane scrollPlaylist;
    public static diu.swe.habib.JPanelSlider.JPanelSlider slidePan;
    public static javax.swing.JSlider sliderManageSound;
    public static javax.swing.JTable table;
    public static javax.swing.JTable tablePlaylist;
    private javax.swing.JLabel time;
    private javax.swing.JTextField txtNamePlaylist;
    // End of variables declaration//GEN-END:variables
}
