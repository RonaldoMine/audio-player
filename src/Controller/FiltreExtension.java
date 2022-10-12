/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;

/**
 *
 * @author Mine
 */
public class FiltreExtension extends javax.swing.filechooser.FileFilter {

    String extension;
    String description;

    public FiltreExtension(String extension, String description) {
        if (extension.indexOf('.') == -1) {
            extension = "." + extension;
            this.extension = extension;
            this.description = description;
        }
    }

    @Override
    public boolean accept(File fichier) {
        if (fichier.getName().endsWith(extension)) {
            return true;
        } else if (fichier.isDirectory()) {
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return this.description + "(" + extension + ")";
    }

}
