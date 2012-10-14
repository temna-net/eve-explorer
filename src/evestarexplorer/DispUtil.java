/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package evestarexplorer;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 *
 * @author gyv
 */

public class DispUtil {

    static void SStatus(Label l, double ss) {
        final Color clr;
        clr = ssColor(ss);
        
        l.setText(String.format("%1$.2f", ss));
        l.setTextFill(clr);
    }

    static Color ssColor(Double ss) {
        
        Color clr = (ss <= 0) ? Color.RED : (ss < 0.45) ? Color.ORANGE : Color.GREEN;
        return clr;
    }
    
    public static Valid starNameInputValidate(TextField t) {
        
        String name = t.getText();
        Valid res = EveStarExplorer.world.isStarValid(name);
        
        switch (res) {
            case FULL:
                t.setStyle("-fx-text-fill: green");
                break;
            case PARTIAL:
                t.setStyle("-fx-text-fill: black");
                break;
            case BAD:
                t.setStyle("-fx-text-fill: red");
                break;
        }
        
        return res;
    }
    
}