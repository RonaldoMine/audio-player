package Controller;

import java.io.File;
import java.io.IOException;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer implements Runnable, Observable {

    protected SourceDataLine line;
    protected AudioInputStream audioInputStream;
    protected AudioFormat audioFormat;
    protected long frames;
    protected double durationInSeconds, elapsedTime, remainedTime;
    protected boolean stop = false;

    public void stop() {
        stop = true;
    }

    public AudioPlayer(File file) {
        init(file);
    }

    public void init(File f) {
        //Obtention d'un flux audio a partir d'un fichier (objet file)
        try {
            audioInputStream = AudioSystem.getAudioInputStream(f);
        } catch (UnsupportedAudioFileException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        //Il est necessaire de connaitre le format audio du fichier d'entree
        //pour permettre a JAVA de creer l'objet DataLine adequat
        audioFormat = audioInputStream.getFormat();
        System.out.println(audioFormat);

        //On calcule la duree totale du morceau
        //en divisant le nombre total de frames par le frame rate par secondes
        frames = audioInputStream.getFrameLength();
        durationInSeconds = frames / audioFormat.getFrameRate();
        System.out.println("Duration : " + durationInSeconds);

        //En plus du format du flux audio d'entree,
        //il est necessaire de specifier le type de DataLine que l'on veut
        //Ici, le DataLine souhaite est un SourceDataLine
        //qui permet la lecture (TargetDataLine permet l'enregistrement)
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        System.out.println(info);

        //On recupere le DataLine et on l'ouvre
        try {
            line = (SourceDataLine) AudioSystem.getLine(info);
        } catch (LineUnavailableException e) {
           System.out.println(e);
        }

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        stop = false;
        //Avant toute chose, il faut ouvrir la ligne avec le bon format audio
        try {
            line.open(audioFormat);
        } catch (LineUnavailableException e) {
           System.out.println(e);
        }

        //Pour que le flux soit effectivement redirige vers la carte son,
        //il faut demarrer la ligne
        line.start();

        //Il faut ensuite ecrire sur la ligne.
        //On travaille comme sur un InputStream classique
        try {
            byte bytes[] = new byte[1024];
            int bytesRead = 0;
            while (((bytesRead = audioInputStream.read(bytes, 0, bytes.length)) != -1) && !stop) {
                System.out.println("Level : ");
                line.write(bytes, 0, bytesRead);
                elapsedTime = line.getMicrosecondPosition() / (double) 1000000;
                //remainedTime = durationInSeconds-elapsedTime;
                //System.out.println(durationInSeconds + " - " + elapsedTime + " - " + remainedTime);
            }

        } catch (IOException io) {
           System.out.println(io);
        }

        //On ferme la ligne a la fin
        line.close();
    }

    public void setFile(File file) {
        //this.file = file;
    }

    public SourceDataLine getLine() {
        return line;
    }

    public double getDurationInSeconds() {
        return durationInSeconds;
    }

    @Override
    public void addListener(InvalidationListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
