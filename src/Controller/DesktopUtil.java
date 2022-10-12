package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Mine
 */
public class DesktopUtil {

    private String absoluteFilePath = "C:/Users/Public/FreshPlayer";
    private String lastFolder = "/utils.txt";
    private String lastFilePlaying = "/lastFile.txt";

    public DesktopUtil() {
        this.checkIsFileExist();
    }

    public void checkIsFileExist() {
        File fileDossier = new File(this.absoluteFilePath);
        if (!fileDossier.exists()) {
            try {
                fileDossier.mkdir();
                Path pathFolder = (Path) Paths.get(fileDossier.getPath() + this.lastFolder);
                File isFolderExist = new File(fileDossier.getPath() + this.lastFolder);
                Path pathFile = (Path) Paths.get(fileDossier.getPath() + this.lastFilePlaying);
                File isFileExist = new File(fileDossier.getPath() + this.lastFilePlaying);
                if (!isFolderExist.exists()) {
                    Files.createFile(pathFolder);
                }
                if (!isFileExist.exists()) {
                    Files.createFile(pathFile);
                }
                removeData();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    public String getFolder() {
        return this.getValue(0, this.lastFolder);
    }

    public String getLastFilePlaying() {
        return this.getValue(0, this.lastFilePlaying);
    }

    public int getLastIndicePlaying() {
        return Integer.parseInt(this.getValue(1, this.lastFilePlaying));
    }

    public String getValue(int position, String path) {
        String val = "0";
        File fileExist = new File(this.absoluteFilePath + path);
        if (fileExist.exists()) {
            try {
                int i = 0;
                for (String ligne : Files.readAllLines(fileExist.toPath())) {
                    if (i == position) {
                        val = ligne;
                        break;
                    }
                    i++;
                }
            } catch (IOException ex) {
                System.out.println("getValue : " + ex);
            }
        }
        return val;
    }

    public void writeDataUtils(String path) {
        ArrayList liste = new ArrayList();
        liste.add(path);
        writeInFile(liste, this.lastFolder);
    }

    public void writeDataLastFile(String path, int i) {
        ArrayList liste = new ArrayList();
        liste.add(path);
        liste.add(i);
        writeInFile(liste, this.lastFilePlaying);
    }

    public void removeData() {
        ArrayList liste = new ArrayList();
        liste.add("0");
        writeInFile(liste, this.lastFolder);
    }

    public void writeInFile(ArrayList array, String path) {
        File fileExist = new File(this.absoluteFilePath + path);
        if (fileExist.exists()) {
            try (BufferedWriter buffwriter = new BufferedWriter(new FileWriter(fileExist))) {
                for (int i = 0; i < array.size(); i++) {
                    buffwriter.write(array.get(i).toString());
                    buffwriter.newLine();
                }
            } catch (Exception e) {
                System.out.println("write file " + e.getMessage());
            }
        }
    }

}
