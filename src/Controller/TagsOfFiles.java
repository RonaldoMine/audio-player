/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Mine
 */
public class TagsOfFiles {

    private double duration = 2;
    private String valueDuration = "";
    private String nomArtiste = "";
    private String titre = "";
    private String annee = "";
    private String genre = "";
    FileInputStream input;
    DefaultHandler handler;

    private SwingWorker swingWorker = new SwingWorker() {
        @Override
        protected Void doInBackground() throws IOException, SAXException, TikaException {
            System.out.println(Thread.activeCount());
            //parser.parse(new FileInputStream(filen), new DefaultHandler(), metadata, new ParseContext());

            return null;
        }

        @Override
        public void done() {

        }

    };

    public TagsOfFiles(String filename) {
        try {
            File filen = new File(filename);
            input = new FileInputStream(filen);
            Metadata metadata = new Metadata();
            handler = new DefaultHandler();
            Parser parser = new Mp3Parser();
            ParseContext parseCtx = new ParseContext();
            new SwingWorker() {
                @Override
                protected Void doInBackground() throws IOException, SAXException, TikaException, InterruptedException {
                    parser.parse(input, handler, metadata,parseCtx);
                    return null;
                }
            }.run();
            if (metadata.get("xmpDM:artist") != null) {
                setNomArtiste(metadata.get("xmpDM:artist"));
            } else {
                setNomArtiste("Artise inconnu");
            }
            if (metadata.get("title") != null) {
                setTitre(metadata.get("title"));
            } else {
                setTitre(filen.getName());
            }
            if (metadata.get("xmpDM:releaseDate") != null) {
                setAnnee(metadata.get("xmpDM:releaseDate"));
            } else {
                setAnnee("");
            }
            if (metadata.get("xmpDM:genre") != null) {
                setGenre(metadata.get("xmpDM:genre"));
            } else {
                setGenre("");
            }
            String durationSon = metadata.get("xmpDM:duration");
            double flot = Double.parseDouble(durationSon);
            setDuration(flot);
            int duree = (int) (getDuration() / 1000);
            duree = duree % 3600;
            int nbMin = duree / 60;
            String textNbMin = "";
            int nbSec = duree % 60;
            String textNbSec = "";
            if (nbMin < 10) {
                textNbMin += "0" + nbMin;
            } else {
                textNbMin += nbMin;
            }
            if (nbSec < 10) {
                textNbSec += "0" + nbSec;
            } else {
                textNbSec += nbSec;
            }
            setValueDuration(textNbMin + ":" + textNbSec);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TagsOfFiles.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                input.close();
                handler.endDocument();
            } catch (IOException | SAXException ex) {
                Logger.getLogger(TagsOfFiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void swingW(String filename) throws FileNotFoundException, IOException, SAXException, TikaException, InterruptedException {
        Metadata metadata = new Metadata();
        File filen = new File(filename);
        new Mp3Parser().parse(new FileInputStream(filen), new DefaultHandler(), metadata, new ParseContext());
        if (metadata.get("xmpDM:artist") != null) {
            setNomArtiste(metadata.get("xmpDM:artist"));
        } else {
            setNomArtiste("Artise inconnu");
        }
        if (metadata.get("title") != null) {
            setTitre(metadata.get("title"));
        } else {
            setTitre(filen.getName());
        }
        if (metadata.get("xmpDM:releaseDate") != null) {
            setAnnee(metadata.get("xmpDM:releaseDate"));
        } else {
            setAnnee("");
        }
        if (metadata.get("xmpDM:genre") != null) {
            setGenre(metadata.get("xmpDM:genre"));
        } else {
            setGenre("");
        }
        String durationSon = metadata.get("xmpDM:duration");
        double flot = Double.parseDouble(durationSon);
        setDuration(flot);
        int duree = (int) (getDuration() / 1000);
        duree = duree % 3600;
        int nbMin = duree / 60;
        String textNbMin = "";
        int nbSec = duree % 60;
        String textNbSec = "";
        if (nbMin < 10) {
            textNbMin += "0" + nbMin;
        } else {
            textNbMin += nbMin;
        }
        if (nbSec < 10) {
            textNbSec += "0" + nbSec;
        } else {
            textNbSec += nbSec;
        }
        setValueDuration(textNbMin + ":" + textNbSec);
        Thread.sleep(500);
    }

    public double getDuration() {
        return duration;
    }

    public String getTitre() {
        return titre;
    }

    public String getNomArtiste() {
        return nomArtiste;
    }

    public String getValueDuration() {
        return valueDuration;
    }

    public String getAnnee() {
        return annee;
    }

    public String getGenre() {
        return genre;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setNomArtiste(String nomArtiste) {
        this.nomArtiste = nomArtiste;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setValueDuration(String valueDuration) {
        this.valueDuration = valueDuration;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre(int genre) {
        return "";
    }
}
