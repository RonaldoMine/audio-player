/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import javax.swing.SwingWorker;

/**
 *
 * @author Mine
 */
public class MainPlayer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Loader loader = new Loader();
        loader.setVisible(true);
        new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(1000);
                new FreshPlayer().setVisible(true);
                return null;
            }

            @Override
            protected void done() {
                loader.dispose();
            }
        }.execute();
    }

}
