/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.LinkedList;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;

/**
 *
 * @author Mine
 */
public final class VolumeControl {

    public VolumeControl() {
    }

    protected static LinkedList<Line> speakers = new LinkedList<Line>();

    public final static void findSpeakers() {
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        for (Mixer.Info mixerInfo : mixers) {
            if (!mixerInfo.getName().equals("Java Sound Audio Engine")) {
                continue;
            }
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            Line.Info[] lines = mixer.getSourceLineInfo();
            for (Line.Info info : lines) {
                try {
                    Line line = mixer.getLine(info);
                    speakers.add(line);
                } catch (LineUnavailableException | IllegalArgumentException e) {
                }
            }
        }
    }

    static {
        findSpeakers();
    }

    public void setVolume(float level) {
        System.out.println("setting volume to " + level);
        for (Line line : speakers) {
            try {
                line.open();
                FloatControl control = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                control.setValue(limit(control, level));
                control.setValue(level);
            } catch (LineUnavailableException | java.lang.IllegalArgumentException e) {
                continue;
            }

        }
    }

    public float limit(FloatControl control, float level) {
        return Math.max(control.getMaximum(), Math.max(control.getMinimum(), level));
    }

}
