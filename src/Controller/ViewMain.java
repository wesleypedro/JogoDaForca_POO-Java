/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Game;
import java.awt.event.KeyEvent;

/**
 *
 * @author Equipe Forca
 */
public class ViewMain {
    public void InName(String InName){
        if(InName.length() > 0){
            BtnStart.setEnabled(true);
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                Game g = new Game();
                g.setVisible(true);
                g.setLocationRelativeTo(null);
            }
        }
        else{
            BtnStart.setEnabled(false);
        }
    }
}
