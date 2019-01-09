import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Game extends Player {

    JFrame window;
    Container con;
    JPanel titlePagePanel, startButtonPanel, mainTextPanel, inputPanel, playerPanel;
    JLabel titlePageLabel, healthLabel, hpLabelNum, weaponLabel, weaponLabelName, goldLabel, goldLabelNum;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 80);
    Font defaultFont = new Font("Arial", Font.PLAIN, 30);
    Font panelFont = new Font("Helvetica", Font.PLAIN,30);
    JButton playButton, enterB;
    JTextArea mainTextArea;
    JTextField userInputTextField;

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
        playButton.setFont(defaultFont);
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

        mainTextArea = new JTextArea("You have just been released from jail, with just 50 gold to your name you head into town\n What would you like to do?");
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(defaultFont);
        mainTextArea.setLineWrap(true); //allows to text to lap automatically
        mainTextPanel.add(mainTextArea);

        inputPanel = new JPanel();
        inputPanel.setBounds(150,400,500,50);
        inputPanel.setBackground(Color.DARK_GRAY);
        inputPanel.setLayout(new GridLayout(1,2));

        userInputTextField = new JTextField();
        inputPanel.add(userInputTextField);

        enterB = new JButton("ENTER");
        enterB.setForeground(Color.black);
        enterB.setBackground(Color.white);
        inputPanel.add(enterB);
        con.add(inputPanel);

        playerPanel = new JPanel();
        playerPanel.setBounds(100,20,600,50);
        playerPanel.setBackground(Color.blue);
        playerPanel.setLayout(new GridLayout(1,3));
        con.add(playerPanel);

        hpLabelNum = new JLabel();
        hpLabelNum.setFont(panelFont);
        hpLabelNum.setForeground(Color.white);
        playerPanel.add(hpLabelNum);

        goldLabelNum = new JLabel();
        goldLabelNum.setFont(panelFont);
        goldLabelNum.setForeground(Color.white);
        playerPanel.add(goldLabelNum);

        weaponLabelName = new JLabel("");
        weaponLabelName.setFont(panelFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        weaponLabelName.setText("Weapon: "+ weapon);
        hpLabelNum.setText("Health: " + health);
        goldLabelNum.setText("Gold: " + gold);

    }


    public class TitleScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            createGameScreen();

        }
    }

}
