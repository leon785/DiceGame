
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leon
 */
public class Dice {
    private int[] dice;
    public static final int MAX = 5;
    
    public Dice() {
        this.dice = new int[MAX];
    }
    
    public int[] getDice() {
        for (int i = 0; i < MAX; i++) {
            dice[i] = (int) (Math.random() * 6) + 1;
        }
        return dice;
    }
    
    //check if the array has 6
    public boolean checkBase(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            if (arr[i] == 6) {
                return true;
            }
        }
        return false;
    }
    
    //check if the array has 5
    public boolean checkCentre(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            if (arr[i] == 5) {
                return true;
            }
        }
        return false;
    }
    
    //check if the array has 4
    public boolean checkTop(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            if (arr[i] == 4) {
                return true;
            }
        }
        return false;
    }
}
