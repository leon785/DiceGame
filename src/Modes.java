
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Leon
 */
public class Modes {
    UserData ud = new UserData();
    PyramidDiceGame pdg = new PyramidDiceGame();
    
    
    public UserData PVCmode() {
        if (ud.getRound() == 3){
            UserData newUD = new UserData();
            ud = newUD;
        }
        if (ud.getUserName().equals("")){
            ud.setUserName("CPU");  
        }
        pdg.rollDice(ud);//CPU rolls
        return ud;
    }
}
