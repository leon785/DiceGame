   
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leon
 */
public class UserData {
    private String userName;
    private String password;
    private int highestScore;
    private int numPlayed;
    private String ach1 = "No";
    private String ach2 = "No";
    private String ach3 = "No";
    
    private String mode;
    private int[] dices;
    private String base = "No";
    private String centre = "No";
    private String top = "No";
    private int score = 0;
    private int round = 0;
    
    
    public UserData(){
        userName = "";
        mode = "";
    }
    
    public UserData(String userName, String password){
        this.userName = userName;
        this.password = password;
        this.highestScore = 0;
        this.numPlayed = 0;
        this.ach1 = "No";
        this.ach2 = "No";
        this.ach3 = "No";
    }
    
    //To game data below
    public String getUserName() {
        return userName;
    }
    public void setUserName(String name) {
        if (name == null || "".equals(name)) {	
            throw new IllegalArgumentException();	 
        }
        this.userName = name;
    }

    
    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        if (mode == null || "".equals(mode)) {	
            throw new IllegalArgumentException();	
        }
        this.mode = mode;
    }

    
    public int[] getDices() {
        return dices;
    }
    public void setDices(int[] dices) {
        this.dices = dices;
    }

    
    public String getBase() {
        return base;
    }
    public void setBase(String base) {
        this.base = base;
    }

    
    public String getCentre() {
        return centre;
    }
    public void setCentre(String centre) {
        this.centre = centre;
    }

    
    public String getTop() {
        return top;
    }
    public void setTop(String top) {
        this.top = top;
    }

    
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    
    
    public int getRound() {
        return round;
    }
    public void setRound(int round) {
        this.round = round;
    }

    
    //To file data below
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getHighestScore() {
        return highestScore;
    }
    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    public int getNumPlayed() {
        return numPlayed;
    }
    public void setNumPlayed(int numPlayed) {
        this.numPlayed = numPlayed;
    }

    public String getAch1() {
        return ach1;
    }
    public void setAch1(String ach1) {
        this.ach1 = ach1;
    }

    public String getAch2() {
        return ach2;
    }
    public void setAch2(String ach2) {
        this.ach2 = ach2;
    }

    public String getAch3() {
        return ach3;
    }
    public void setAch3(String ach3) {
        this.ach3 = ach3;
    }
    
    
    
    public String toGame(String player) {
        return "\nPlayer: " + player + "'s turn";
    }

    @Override
    public String toString() {
        return "userName=" + userName + ", password=" + password + ", highestScore=" + highestScore 
                + ", numPlayed=" + numPlayed + ", ach1=" + ach1 + ", ach2=" + ach2 + ", ach3=" + ach3;
    }
    
    
    
   
    
    
}
