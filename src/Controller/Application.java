package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author chadj
 */
public class Application {

    public static DesktopUtil du;

    public static DesktopUtil getDU() {
        if (du == null) {
            du = new DesktopUtil();
        }
        return du;
    }

}
