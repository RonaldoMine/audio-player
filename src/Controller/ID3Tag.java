/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.IOException;
import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.filename.FilenameTag;
import org.farng.mp3.id3.ID3v1;

/**
 *
 * @author Mine
 */
public class ID3Tag {

    private ID3v1 id3Tag;
    private FilenameTag filenameTag;

    public ID3Tag(File musicFile) {
        try {
            MP3File mp3file = new MP3File(musicFile);
            this.id3Tag =   mp3file.getID3v1Tag();
            this.filenameTag = mp3file.getFilenameTag();
        } catch (IOException | TagException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getNomArtist() {
        if (this.id3Tag != null) {
            return this.id3Tag.getArtist();
        }
        return "Artiste inconnu";
    }

    public String getAlbum() {
        if (this.id3Tag != null) {
            return this.id3Tag.getAlbum();
        }
        return "Album inconnu";
    }

    public String getSong() {
        if (this.id3Tag != null) {
            return this.id3Tag.getSongTitle();
        }
        return "Titre inconnu";
    }

    public String getTrackNumberOnAlbum() {
        if (this.id3Tag != null) {
            return this.id3Tag.getTrackNumberOnAlbum();
        }
        return "nul";
    }

    public String getSongYear() {
        if (!this.id3Tag.getYearReleased().isEmpty()) {
            return this.id3Tag.getYearReleased();
        }
        return "Année inconnue";
    }

    @Override
    public String toString() {
        return " \n Artiste : " + this.id3Tag.getLeadArtist()
                + "\n Album : " + this.id3Tag.getAlbumTitle()
                + "\n Son Title : " + this.id3Tag.getSongTitle()
                + "\n Years : " + this.id3Tag.getYearReleased()
                + "\n size : " + this.id3Tag.getSize();
    }

}
