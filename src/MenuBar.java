
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leon
 */
public class MenuBar {
    public static void exitProgram () {
        System.exit(0);
    }
    
    public static void rule() {
        JOptionPane.showMessageDialog(null, "·Player 'rolls' 5 dice 3 times in their turn\n"
                + "·They must roll a 6 (BASE), then a 5 (CENTRE) then a 4 (TOP) in order with any set of 5 dice.\n"
                + "·Once they have made the pyramid (rolled base, centre & top), they start scoring based on the face values \n"
                + "  of the remaining dice they throw\n"
                + "·The winner has the highest score", "Game Rule", 1, null);
    }
}
