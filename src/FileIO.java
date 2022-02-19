
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
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
public class FileIO {
    
    public static void saveDataToFile(String fileName, ArrayList<String> fileData) {
        try {
            FileWriter myWriter = new FileWriter(fileName, true);
            for (String s: fileData) {    
               myWriter.write(s + "\r\n");
            }
            myWriter.close();
            JOptionPane.showMessageDialog(null, "Successfully wrote to the file");
            
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred");
        }
    }
    
    public static void saveDataToFileTemp(String fileName, ArrayList<String> fileData) {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            for (String s: fileData) {    
               myWriter.write(s + "\r\n");
            }
            myWriter.close();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred");
        }
    }
    
    public static ArrayList<String> readDataFromFile(String fileName) {
        ArrayList<String> fileData = new ArrayList<>();
        try{
            File dataFile = new File(fileName);
            Scanner myReader = new Scanner(dataFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();  
                fileData.add(data.replaceAll("[\r\n]", ""));
            }
            myReader.close();         
        }
        catch(FileNotFoundException e) {
            //JOptionPane.showMessageDialog(null, "File not found");   
        }
        return fileData;
    }

    public boolean checkDuplication(String fileName, String usernameInput) {
        ArrayList<String> fileData = readDataFromFile(fileName);
        for (int i = 0; i < fileData.size(); i++) {
            if (fileData.get(i).startsWith("userName=" + usernameInput)) { 
                return true;
            }
        }
        return false;
    }
    
    public static void dataSync (UserData ud, int index) {
        String str = "";
        String name = FileIO.readDataFromFile("TempFile.dat").get(index);
        ArrayList arr = FileIO.readDataFromFile("userData.dat");
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).toString().startsWith("userName=" + name)) {
                str = str + arr.get(i).toString();
            }
        }
        String password = str.substring(str.indexOf(", password=") + 11, str.indexOf(", highestScore=")); 
        int highestScore = Integer.valueOf(str.substring(str.indexOf(", highestScore=") + 15, str.indexOf(", numPlayed")));
        int numPlayed = Integer.valueOf(str.substring(str.indexOf(", numPlayed=") + 12, str.indexOf(", ach1=")));
        
        ud.setUserName(name);
        ud.setPassword(password);
        ud.setHighestScore(highestScore);
        ud.setNumPlayed(numPlayed); 
        ud.setAch1(str.substring(str.indexOf(", ach1=") + 7, str.indexOf(", ach2")));
        ud.setAch2(str.substring(str.indexOf(", ach2=") + 7, str.indexOf(", ach3")));
        ud.setAch3(str.substring(str.indexOf(", ach3=") + 7, str.length()));
    }
}
