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
    Font panelFont = new Font("Helvetica", Font.PLAIN,23);
    Font mainTextAreaFont = new Font("Helvetica", Font.PLAIN,20);
    JButton playButton, enterB;
    JTextArea mainTextArea;
    JTextField userInputTextField;
    String text;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args){

        new Game();
    }

    public Game() {

        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();

        titlePagePanel = new JPanel();
        titlePagePanel.setBounds(100, 100, 600, 150);
        titlePagePanel.setBackground(Color.black);
        titlePageLabel = new JLabel("Bandit Trail");
        titlePageLabel.setForeground(Color.WHITE);
        titlePageLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,400,180,50);
        startButtonPanel.setBackground(Color.black);

        playButton = new JButton("PLAY");
        playButton.setBackground(Color.black);
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
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(mainTextAreaFont);
        mainTextArea.setLineWrap(true); //allows to text to lap automatically
        mainTextPanel.add(mainTextArea);

        inputPanel = new JPanel();
        inputPanel.setBounds(150,400,500,50);
        inputPanel.setBackground(Color.black);
        inputPanel.setLayout(new GridLayout(1,2));

        userInputTextField = new JTextField();
        inputPanel.add(userInputTextField);

        enterB = new JButton("ENTER");
        enterB.setForeground(Color.black);
        enterB.setBackground(Color.white);
        enterB.addActionListener(choiceHandler);
        inputPanel.add(enterB);
        con.add(inputPanel);

        playerPanel = new JPanel();
        playerPanel.setBounds(100,20,600,50);
        playerPanel.setBackground(Color.black);
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

        playerSetup();

    }

    public void playerSetup(){
        weaponLabelName.setText("Weapon: "+ weapon);
        hpLabelNum.setText("Health: " + health);
        goldLabelNum.setText("Gold: " + gold);

        town();
    }

    public void town(){
        userInputTextField.setText(null);
        position = "First Town";
        mainTextArea.setText("You have just been released from jail, with just 50 gold to your\nname you head into town\n\nWhat would you like to do?" +
                "\n1) Shop\n2) Rob Someone\n3) Rob a Bank\n4) Go to another Town");
        mainTextArea.setFont(mainTextAreaFont);
    }

    public void shop(){
        userInputTextField.setText(null);
        position = "Shop";
        mainTextArea.setText("Hello welcome to the shop please select your items\n\n1) Revolver     20G\n2) Rifle     40G\n3) Health     10G\n4) Leave Shop");

    }

    public void robSomeone(){
        userInputTextField.setText(null);
        position = "Rob Someone";
        if(weapon != "Knife"){
            mainTextArea.setText("You successfully rob someone due to having an intimidating weapon as well as gaining some gold\n(Gained 10 Gold)\nEnter 1 to go back");
            gold += 10;
        } else{
            mainTextArea.setText("The person fought back and you got hurt\n(You received 10 damage)\nEnter 1 to go back");
            health -= 10;
        }
        weaponLabelName.setText("Weapon: "+ weapon);
        hpLabelNum.setText("Health: " + health);
        goldLabelNum.setText("Gold: " + gold);
    }

    public void robBank(){


    }

    public void anotherTown(){
        userInputTextField.setText(null);
        position = "Another Town";
        mainTextArea.setText("You travel to another Town\n1) To go back\n2) Continue on your adventure");
        weaponLabelName.setText("Weapon: "+ weapon);
        hpLabelNum.setText("Health: " + health);
        goldLabelNum.setText("Gold: " + gold);
    }


    public class TitleScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            createGameScreen();

        }
    }

    public class ChoiceHandler implements ActionListener{
        public  void actionPerformed(ActionEvent event){

            text = userInputTextField.getText();

            switch (position){
                case "First Town":
                    switch (text){
                        case "1": shop(); break;
                        case "2": robSomeone(); break;
                        case "3": robBank(); break;
                        case "4": anotherTown(); break;
                    }
                    break;
                case "Shop":
                    switch (text){
                        case "1":
                            weapon = "Revolver";
                            gold -= 20;
                            weaponLabelName.setText("Weapon: "+ weapon);
                            hpLabelNum.setText("Health: " + health);
                            goldLabelNum.setText("Gold: " + gold);
                            break;
                        case "2":
                            weapon = "Rifle";
                            gold -= 40;
                            weaponLabelName.setText("Weapon: "+ weapon);
                            hpLabelNum.setText("Health: " + health);
                            goldLabelNum.setText("Gold: " + gold);
                            break;
                        case "3":
                            health += 10;
                            gold -= 10;
                            weaponLabelName.setText("Weapon: "+ weapon);
                            hpLabelNum.setText("Health: " + health);
                            goldLabelNum.setText("Gold: " + gold);
                            break;
                        case "4": town(); break;
                    }
                    break;
                case "Rob Someone":
                    switch (text){
                        case "1": town(); break;
                    }
                    break;
            }
        }
    }

}
