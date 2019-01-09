import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Game {

    JFrame window;
    Container con;
    JPanel titlePagePanel, startButtonPanel, mainTextPanel, choiceButtonPanel;
    JLabel titlePageLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 80);
    Font playButtonFont = new Font("Arial", Font.PLAIN, 30);
    JButton playButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;

    TitleScreenHandler tsHandler = new TitleScreenHandler();

    public static void main(String[] args){

        new Game();
    }

    public Game() {

        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.red);
        window.setLayout(null);
        con = window.getContentPane();

        titlePagePanel = new JPanel();
        titlePagePanel.setBounds(100, 100, 600, 150);
        titlePagePanel.setBackground(Color.red);
        titlePageLabel = new JLabel("Bandit Trail");
        titlePageLabel.setForeground(Color.WHITE);
        titlePageLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,400,180,50);
        startButtonPanel.setBackground(Color.red);

        playButton = new JButton("PLAY");
        playButton.setBackground(Color.DARK_GRAY);
        playButton.setForeground(Color.BLACK);
        playButton.setFont(playButtonFont);
        playButton.addActionListener(tsHandler);

        titlePagePanel.add(titlePageLabel);
        startButtonPanel.add(playButton);

        con.add(startButtonPanel);
        con.add(titlePagePanel);

        window.setVisible(true);
    }

    public void createGameScreen(){

        titlePagePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.BLUE);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("Main text Area");
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(playButtonFont);
        mainTextArea.setLineWrap(true); //allows to text to lap automatically
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250,350,300,150);
        choiceButtonPanel.setBackground(Color.DARK_GRAY);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        choice1 = new JButton("Button 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.black);
        choice1.setFont(playButtonFont);
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Button 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.black);
        choice2.setFont(playButtonFont);
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("Button 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.black);
        choice3.setFont(playButtonFont);
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("Button 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.black);
        choice4.setFont(playButtonFont);
        choiceButtonPanel.add(choice4);

    }

    public class TitleScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            createGameScreen();

        }
    }

}
