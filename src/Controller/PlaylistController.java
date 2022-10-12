/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Frame.CreatePlaylist;
import Frame.FreshPlayer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mine
 */
public class PlaylistController {

    private static String absoluteFilePath = "C:/Users/Public/FreshPlayer/Playlist/";
    private static File dossierPlaylist = new File(absoluteFilePath);
    public static ArrayList<String> arrayList;

    public PlaylistController() {

    }

    public void createFilePlaylist(String nomPlayList) {
        CreatePlaylist cp = new CreatePlaylist();
        cp.nomPlaylist.setText(nomPlayList);
        FreshPlayer.panPlaylist.add(cp);
        if (!dossierPlaylist.exists()) {
            dossierPlaylist.mkdir();
        }
        Path pathFile = (Path) Paths.get(absoluteFilePath + nomPlayList + ".txt");
        try {
            Files.createFile(pathFile);
        } catch (IOException ex) {
            System.out.println("Playlist : " + ex.getMessage());
        }

    }

    public static void getAllPlaylist() {
        for (File filenamePlaylist : dossierPlaylist.listFiles()) {
            CreatePlaylist cp = new CreatePlaylist();
            cp.nomPlaylist.setText(filenamePlaylist.getName().replace(".txt", ""));
            cp.nomPlaylist.setToolTipText(filenamePlaylist.getName().replace(".txt", ""));
            JMenuItem menuItem = new JMenuItem("Ajouter à " + filenamePlaylist.getName().replace(".txt", ""));
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //FreshPlayer.arrayFile.get(FreshPlayer.table.getSelectedRow());
                    int[] rowSelected = {FreshPlayer.table.getSelectedRow()};
                    PlaylistController.writeInFilePlaylist(rowSelected, filenamePlaylist.getName().replace(".txt", ""), FreshPlayer.arrayFile);
                    System.out.println("Bien joué" + filenamePlaylist.getName().replace(".txt", ""));
                }
            });
            FreshPlayer.popupAjout.add(menuItem);
            FreshPlayer.panPlaylist.add(cp);
        }
    }

    public void actionPerformed(ActionEvent arg0) {

//Lorsque l'on clique sur le bouton, on met à jour le JLabel
    }

    public static void writeInFilePlaylist(int[] rowSelected, String textNom, ArrayList array) {
        File fileExist = new File(absoluteFilePath + textNom + ".txt");
        if (fileExist.exists()) {
            try (BufferedWriter buffwriter = new BufferedWriter(new FileWriter(fileExist, true))) {
                for (int i : rowSelected) {
                    buffwriter.write(array.get(i).toString());
                    buffwriter.newLine();
                    System.out.println(array.get(i).toString());
                }
            } catch (Exception e) {
                System.out.println("write file " + e.getMessage());
            }
        }
    }

    public void writePlaylistInTable(String nom, JTable table) {
        arrayList = new ArrayList();
        DefaultTableModel mode = (DefaultTableModel) table.getModel();
        Object[] row = new Object[6];
        table.getColumnModel().getColumn(0).setCellRenderer(new ImageIconCellRenderer());
        mode.setRowCount(0);
        File fileplaylist = new File(absoluteFilePath + nom + ".txt");
        if (fileplaylist.exists()) {
            try {
                int i = 0;
                for (String ligne : Files.readAllLines(fileplaylist.toPath())) {
                    TagsOfFiles tof = new TagsOfFiles(ligne);
                    row[0] = new ImageIcon("src/images/icons8_Play_50px_2.png");
                    row[1] = tof.getNomArtiste();
                    row[2] = tof.getTitre();
                    row[3] = tof.getValueDuration();
                    row[4] = tof.getAnnee();
                    row[5] = tof.getGenre();
                    arrayList.add(ligne);
                    i++;
                    mode.addRow(row);
                }
            } catch (IOException ex) {
                System.out.println("getValue : " + ex);
            }
        }
    }

}
