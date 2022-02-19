
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leon
 */
public class PyramidDiceGame {
    Dice myDice = new Dice();
    int[] diceArr;
    
    
    public void rollDice(UserData ud) {
        int score = ud.getScore();
        int sc = 0;//score in this roll
        int change = 0;//records the【base/centre/top】in this roll
        
        ud.setDices(myDice.getDice());
        diceArr = ud.getDices();
        if (ud.getBase().equals("No") && ud.getCentre().equals("No") && ud.getTop().equals("No")) {
            if (myDice.checkBase(diceArr)) {
                ud.setBase("Yes");
                change = change + 6;
            }
        }
        if (ud.getBase().equals("Yes") && ud.getCentre().equals("No") && ud.getTop().equals("No")) {
            if (myDice.checkCentre(diceArr)) {
                ud.setCentre("Yes");
                change = change + 5;
            }
        }
        if (ud.getBase().equals("Yes") && ud.getCentre().equals("Yes") && ud.getTop().equals("No")) {
            if (myDice.checkTop(diceArr)) {
                ud.setTop("Yes");
                change = change + 4;
            }
        }
        if (ud.getBase().equals("Yes") && ud.getCentre().equals("Yes") && ud.getTop().equals("Yes")) {
            for (int i = 0; i < 5.; i++) {
                sc = sc + diceArr[i];//add up all the numbers in the array
            }
            sc = sc - change;//subtract the extra score
        }
        ud.setScore(score + sc);
        ud.setRound(ud.getRound()+1);
    }
    
    public void save (UserData ud, int ind) {
        ArrayList fileData = FileIO.readDataFromFile("userData.dat");
        String name = ud.getUserName();
        int score = ud.getScore();//score in this round
        int index = 0;
        
        for (int i = 0; i < fileData.size(); i++) {
            if (fileData.get(i).toString().startsWith("userName=" + name)) {
                index = index + i;
            }
        }
        UserData oldDat = new UserData();
        FileIO.dataSync(oldDat, ind);
        
        
        if (score > oldDat.getHighestScore()) {
            oldDat.setHighestScore(score);
        }
        oldDat.setNumPlayed(oldDat.getNumPlayed()+1); 
        achHelper(ud,oldDat);
        
        String str = oldDat.toString();// new Data now
        fileData.set(index, str);
        FileIO.saveDataToFileTemp("userData.dat", fileData);// update stats
    }
    
    public void achHelper(UserData ud, UserData oldDat){
        if (oldDat.getAch1().equals("No")) {
            if (ud.getAch1().equals("Yes")) {
                oldDat.setAch1("Yes"); 
            }
        }
        if (oldDat.getAch2().equals("No")) {
            if (ud.getAch2().equals("Yes")) {
                oldDat.setAch2("Yes"); 
            }
        }
        if (oldDat.getAch3().equals("No")) {
            if (ud.getAch3().equals("Yes")) {
                oldDat.setAch3("Yes"); 
            }
        }
    }
}