/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Equipe Forca
 */
public class ObjectManager {
    private static CController Controller = null;
    public static CController getInstance() {
        if (Controller == null) {
            Controller = new CController("forca");
        }
        return Controller;
    }
}
