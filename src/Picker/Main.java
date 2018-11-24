/*
    Fifa Team Picker
    By Jacob Hagenbaugh
    When run, a dialog comes up assigning the team that each player will play
    with. 
 */

package Picker;

import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class Main {
    
    public static void main(String[] args) {
        
        List<String> teams = new ArrayList<>();
        
        // Read file, then store each new line item in the ArrayList.
        try {
            Scanner s = new Scanner(new File("teams.txt"));
            
            while (s.hasNext()) {
                teams.add(s.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        }
        
        // Take user input from dialog box and store it in variables player1 and player2.
        String player1 = JOptionPane.showInputDialog("Player 1: Enter your name.");
        String player2 = JOptionPane.showInputDialog("Player 2: Enter your name.");
        // Print the values given in the Java console.
        System.out.println("Player 1: " + player1);
        System.out.println("Player 2: " + player2);
        
        // Random team generator within dialog box.
        Random r = new Random();
        String msg1 = player1 + ": " + teams.get(r.nextInt(teams.size()));
        String msg2 = player2 + ": " + teams.get(r.nextInt(teams.size()));
        Component frame = null;
        ImageIcon icon = new ImageIcon("icon2.png");
        JOptionPane.showMessageDialog(frame, msg1 + "\n" + msg2, "Fifa Team Picker", PLAIN_MESSAGE, icon);
    }
}