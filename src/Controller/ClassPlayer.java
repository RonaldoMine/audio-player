package Controller;

import AppPackage.AnimationClass;
import Frame.FreshPlayer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ClassPlayer {

    FileInputStream FIS;
    BufferedInputStream BIS;
    //private InputStream is;
    public Player player;
    //la localisation de l'arret du son
    public int pauseLocation;
    //la taille du son
    public int sontotalLenght;
    //la localisation du fichier de lecture 
    public String fileLocation;
    //la durée du morceau
    private double duration;
    //l'evolution depuis le debut du son son jusqu'a sa fin
    private int evolution = 1;
    private Timer t;
    //Conteur des minutes et des secondes
    protected int sec = 0;
    protected int min = 0;

    public ClassPlayer() {
        this.t = new Timer(1000, new Check());
    }

    //La fonction d'arret du player
    public void Stop() {
        if (player != null) {
            player.close();
            pauseLocation = 0;
            sontotalLenght = 0;
            fileLocation = "";
        }
    }

    //la fonction de mise en pause du player
    public void Pause() {
        if (player != null) {
            try {
                t.stop();
                pauseLocation = FIS.available();
                player.close();
            } catch (IOException ex) {
            }
        }
    }

    //la fonction pour resumer le morceau qui etait en pause
    public void Resume() {
        try {
            t.restart();
            FIS = new FileInputStream(fileLocation);
            BIS = new BufferedInputStream(FIS);
            player = new Player(BIS);
            FIS.skip(sontotalLenght - pauseLocation);
        } catch (FileNotFoundException | JavaLayerException ex) {
        } catch (IOException ex) {
        }
        new Thread() {
            @Override
            public void run() {
                try {
                    player.play();
                } catch (JavaLayerException ex) {
                }
            }
        }.start();
    }

    public void Play(String path) {
        evolution = 0;
        sec = 0;
        min = 0;
        new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    fileLocation = path;
                    FIS = new FileInputStream(fileLocation);
                    BIS = new BufferedInputStream(FIS);
                    player = new Player(BIS);
                    sontotalLenght = FIS.available();
                    TagsOfFiles tof = new TagsOfFiles(fileLocation);
                    setDuration(tof.getDuration());
                    int duree = (int) (getDuration() / 1000);
                    FreshPlayer.progressSon.setMaximum((duree));
                    FreshPlayer.labArtiste.setText(tof.getNomArtiste());
                    FreshPlayer.labNameFile.setText(tof.getTitre());
                    FreshPlayer.labDurationOfSon.setText(tof.getValueDuration());

                } catch (FileNotFoundException | JavaLayerException ex) {
                    System.out.println(ex.getMessage());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                return null;
            }

            @Override
            protected void done() {
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(ClassPlayer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            t.start();
                            player.play();
                            if (FreshPlayer.count == 1 && player.isComplete()) {
                                Play(fileLocation);
                            }
                        } catch (JavaLayerException ex) {
                        }

                    }
                }.start();
            }
        }.run();

    }

    //variatio du temps de ecture
    class Check implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (evolution <= (int) (getDuration() / 1000)) {
                if (sec < 10) {
                    FreshPlayer.labVariationSec.setText("0" + sec);
                } else {
                    FreshPlayer.labVariationSec.setText("" + sec);
                }
                sec++;
                if (sec == 60) {
                    min += 1;
                    sec = 0;
                }
                if (min < 10) {
                    FreshPlayer.labVariationMin.setText("0" + min + ":");
                } else {
                    FreshPlayer.labVariationMin.setText(min + ": ");
                }
                if (evolution == (int) (getDuration() / 1000) - 30) {
                    System.out.println("descends " + evolution + " " + ((int) (getDuration() / 1000) - 60));
                    FreshPlayer.panNextSon.setVisible(true);
                }
                if (evolution == (int) (getDuration() / 1000) - 20) {
                    System.out.println("monte " + evolution + " " + ((int) (getDuration() / 1000) - 60));
                    FreshPlayer.panNextSon.setVisible(false);
                }
                FreshPlayer.progressSon.setValue(evolution);
                evolution++;
            } else {
                FreshPlayer.progressSon.setValue(0);
                sec = 0;
                min = 0;
            }
        }
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    //permet de recuperr les morceaux du derniers dossier selectionné
    public void addSonsWithFolder(ArrayList arrayFile, ArrayList arrayFileName, Object[] row, String pathFolder, JTable table) {
        File folder = new File(pathFolder);
        if (folder.exists()) {
            Application.getDU().writeDataUtils(pathFolder);
            File[] listOfFiles = folder.listFiles();
            DefaultTableModel mode = (DefaultTableModel) table.getModel();
            table.getColumnModel().getColumn(0).setCellRenderer(new ImageIconCellRenderer());
            table.getColumnModel().getColumn(1).setCellRenderer(new ImageIconCellRenderer());
            row = new Object[listOfFiles.length];
            FreshPlayer.labMusic.setText("Ma musique(" + String.valueOf(listOfFiles.length) + ")");
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile() && listOfFile.getName().endsWith(".mp3")) {
                    //System.out.println("File " + listOfFile.getName());
                    arrayFile.add(listOfFile.getAbsolutePath());
                    arrayFileName.add(listOfFile.getName().replaceAll(".mp3", ""));
                    TagsOfFiles tof = new TagsOfFiles(listOfFile.getAbsolutePath());
                    row[0] = new ImageIcon("src/images/icons8_Play_50px_2.png");
                    row[1] = new ImageIcon("src/images/icons8_Plus_Math_30px_4.png");
                    row[2] = tof.getNomArtiste();
                    row[3] = tof.getTitre();
                    row[4] = tof.getValueDuration();
                    row[5] = tof.getAnnee();
                    row[6] = tof.getGenre();
                    mode.addRow(row);
                } else if (listOfFile.isDirectory()) {
                    //System.out.println("Directory " + listOfFile.getName());
                    File Sousfolder = new File(listOfFile.getAbsolutePath());
                    File[] listOfSousFiles = Sousfolder.listFiles();
                    for (File listOfSousFile : listOfSousFiles) {
                        if (listOfSousFile.isFile() && listOfSousFile.getName().endsWith(".mp3")) {
                            arrayFile.add(listOfSousFile.getAbsolutePath());
                            arrayFileName.add(listOfSousFile.getName().replaceAll(".mp3", ""));
                            TagsOfFiles tof = new TagsOfFiles(listOfSousFile.getAbsolutePath());
                            row[0] = new ImageIcon("src/images/icons8_Play_50px_2.png");
                            row[1] = new ImageIcon("src/images/icons8_Plus_Math_30px_4.png");
                            row[2] = tof.getNomArtiste();
                            row[3] = tof.getTitre();
                            row[4] = tof.getValueDuration();
                            row[5] = tof.getAnnee();
                            row[6] = tof.getGenre();
                            mode.addRow(row);
                        }
                    }
                }
            }
        }
    }
}
