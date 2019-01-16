import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.*;

import java.util.Random;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class Game extends Player {

    JFrame window;
    Container con;
    JPanel titlePagePanel, startButtonPanel, mainTextPanel, inputPanel, playerPanel,inputPanelTwo;
    JLabel imageLabel, titlePageLabel, hpLabelNum, weaponLabelName, goldLabelNum, strengthLabelNum, notorietyLabelNum;
    Font titleFont = new Font("PixelMPlus10", Font.PLAIN, 80);
    Font defaultFont = new Font("PixelMPlus10", Font.PLAIN, 30);
    Font panelFont = new Font("PixelMPlus10", Font.PLAIN,20);
    Font gameOver = new Font("Times New Roman", Font.PLAIN,80);
    Font mainTextAreaFont = new Font("PixelMPlus10", Font.PLAIN,20);
    JButton playButton, enterB, attack, defend, run;
    JTextArea mainTextArea;
    JTextField userInputTextField;
    String yourChoice;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    FightHandler fightHandler = new FightHandler();

    Random rand = new Random(); //RANDOM UTIL

    private ImageIcon horseBanditImage;

    public static void main(String[] args){

        new Game();
    }

    public Game() {

        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.decode("#90806C"));
        window.setLayout(null);
        con = window.getContentPane();

        titlePagePanel = new JPanel();
        titlePagePanel.setBounds(100, 100, 600, 115);
        titlePagePanel.setBackground(Color.decode("#90806C"));

        titlePageLabel = new JLabel("Bandit Trail");
        titlePageLabel.setForeground(Color.WHITE);
        titlePageLabel.setFont(titleFont);

        horseBanditImage = new ImageIcon(getClass().getResource("BanditTrail.png"));
        imageLabel = new JLabel(horseBanditImage);
        imageLabel.setBounds(265,220,300,153);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,400,180,50);
        startButtonPanel.setBackground(Color.decode("#90806C"));

        playButton = new JButton("PLAY");
        playButton.setFocusPainted(false);
        playButton.setBackground(Color.blue);
        playButton.setForeground(Color.decode("#8D2011"));
        playButton.setFont(defaultFont);
        playButton.addActionListener(tsHandler);

        titlePagePanel.add(titlePageLabel);
        startButtonPanel.add(playButton);

        con.add(startButtonPanel);
        con.add(titlePagePanel);
        con.add(imageLabel);

        window.setVisible(true);
    }

    public void createGameScreen(){

        titlePagePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        imageLabel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.decode("#90806C"));
        con.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.decode("#90806C"));
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(mainTextAreaFont);
        mainTextArea.setLineWrap(true); //allows to yourChoice to lap automatically
        mainTextPanel.add(mainTextArea);

        inputPanel = new JPanel();
        inputPanel.setBounds(150,400,500,50);
        inputPanel.setBackground(Color.decode("#90806C"));
        inputPanel.setLayout(new GridLayout(1,2));

        userInputTextField = new JTextField();
        inputPanel.add(userInputTextField);

        enterB = new JButton("ENTER");
        enterB.setFocusPainted(false);
        enterB.setForeground(Color.black);
        enterB.setBackground(Color.decode("#8D2011"));
        enterB.addActionListener(choiceHandler);
        inputPanel.add(enterB);
        con.add(inputPanel);

        playerPanel = new JPanel();
        playerPanel.setBounds(50,30,700,50);
        playerPanel.setBackground(Color.decode("#90806C"));
        playerPanel.setLayout(new GridLayout(1,5));
        playerPanel.setBorder(new TitledBorder(new LineBorder(Color.white, 4),
                "Player Stats"));
        con.add(playerPanel);

        hpLabelNum = new JLabel();
        hpLabelNum.setFont(panelFont);
        hpLabelNum.setForeground(Color.white);
        playerPanel.add(hpLabelNum);

        goldLabelNum = new JLabel();
        goldLabelNum.setFont(panelFont);
        goldLabelNum.setForeground(Color.white);
        playerPanel.add(goldLabelNum);

        strengthLabelNum = new JLabel("");
        strengthLabelNum.setFont(panelFont);
        strengthLabelNum.setForeground(Color.white);
        playerPanel.add(strengthLabelNum);

        notorietyLabelNum = new JLabel("");
        notorietyLabelNum.setFont(panelFont);
        notorietyLabelNum.setForeground(Color.white);
        playerPanel.add(notorietyLabelNum);

        weaponLabelName = new JLabel("");
        weaponLabelName.setFont(panelFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        con.revalidate();
        con.repaint();

        playerSetup();

    }

    public void playerSetup(){
        updateStats();
        town();
    }

    public void updateStats(){
        weaponLabelName.setText("WPN: "+ weapon);
        hpLabelNum.setText("HP: " + health);
        goldLabelNum.setText("GOLD: " + gold);
        strengthLabelNum.setText("STR: " + strength);
        notorietyLabelNum.setText("NOTR: " + notoriety);

        if(health <= 0){

            mainTextArea.setForeground(Color.red);
            mainTextArea.setFont(gameOver);
            mainTextArea.setText("YOU ARE\nDEAD");


        } else if(notoriety >= 100){

            mainTextArea.setForeground(Color.red);
            mainTextArea.setFont(gameOver);
            mainTextArea.setText("YOU WERE\nCAUGHT");

        }
    }

    public static void infoBox(String infoMessage)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void errorBox(String infoMessage)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "Inane error", JOptionPane.ERROR_MESSAGE);
    }


    public void town(){
        updateStats();
        userInputTextField.setText(null);
        position = "First Town";
        mainTextArea.setText("You have just been released from jail, with just 50 gold to your\nname you head into town\n\nWhat would you like to do?" +
                "\n1) Shop\n2) Barber Shop\n3) Rob a Bank\n4) Rob Someone\n5) Browse the Stables\n6) Go to another Town");
        mainTextArea.setFont(mainTextAreaFont);
    }

    public void shop(){
        updateStats();
        userInputTextField.setText(null);
        position = "Shop";
        mainTextArea.setText("Howdy welcome to the shop please select your items\n\n" +
                "\n1) Revolver - 20 gold\n2) Shotgun - 40 gold" + "\n3) Mask - 30 gold\n4) Clothes - 10 gold" +
                "\n5) Syringe - 15 gold\n6) Exit");

    }

    public void robSomeone(){
        updateStats();
        userInputTextField.setText(null);
        position = "Rob Someone";
        int outcome = rand.nextInt(10);
        if (outcome >= 8) {

            mainTextArea.setText("ou were hurt robbing the someone!\n( - 10 health)\n1) Cowardly limp away");
            health -= 10;

        } else if (outcome < 8) {

            gold += 15;
            if(mask==false){
                mainTextArea.setText("You robbed someone!\n( + 15 gold & + 40 notoriety)\n1) Runaway");
                notoriety += 40;
            } else {
                mainTextArea.setText("You robbed someone!\n( + 15 gold & + 40 notoriety)\n" +
                        "You did not gain notoriety as you were wearing a mask\n1) Slink into the shadows");
                mask = false;
            }

        }

        updateStats();
    }

    public void robBank(){
        updateStats();
        userInputTextField.setText(null);
        position = "Bank";

        enterB.setVisible(false);
        userInputTextField.setVisible(false);
        inputPanel.setVisible(false);

        attack = new JButton("Attack");
        attack.setForeground(Color.red);
        attack.setFont(defaultFont);
        attack.setFocusPainted(false);
        attack.addActionListener(fightHandler);
        attack.setActionCommand("attack");

        defend = new JButton("Defend");
        defend.setForeground(Color.green);
        defend.setFont(defaultFont);
        defend.setFocusPainted(false);
        defend.addActionListener(fightHandler);
        defend.setActionCommand("defend");

        run = new JButton("Run");
        run.setForeground(Color.blue);
        run.setFont(defaultFont);
        run.setFocusPainted(false);
        run.addActionListener(fightHandler);
        run.setActionCommand("run");

        inputPanelTwo = new JPanel();
        inputPanelTwo.setBackground(Color.decode("#90806C"));
        inputPanelTwo.setBounds(250,350,300,150);
        inputPanelTwo.setLayout(new GridLayout(3,1));
        inputPanelTwo.add(attack);
        inputPanelTwo.add(defend);
        inputPanelTwo.add(run);
        con.add(inputPanelTwo);
        mainTextArea.setText("You have entered the bank and come across a Guard defeat the guard to gain the loot" +
                "\nGuard HP");

    }

    public void barberShop() {
        updateStats();
        userInputTextField.setText(null);
        position = "Barber";
        mainTextArea.setText("You enter a Barbershop in town\nBarber: Would you like a trim?" +
                "\n1) Get a hair cut - 20 gold\n2) Go back to Town");
    }

    public void stables() {
        updateStats();
        userInputTextField.setText(null);
        position = "Stable";
        mainTextArea.setText("Stablemaster: Welcome sir would you like to buy a horse?"+
                "\n1) Purchase stallion - 50 gold\n2) Go back");
    }


    public void anotherTown(){
        userInputTextField.setText(null);
        position = "Another Town";
        mainTextArea.setText("You are outside the Town Gates\n What do you want to do?\n1) To go back\n2) Continue on your adventure");
        updateStats();
    }


    public class TitleScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            createGameScreen();

        }
    }

    public class ChoiceHandler implements ActionListener{
        public  void actionPerformed(ActionEvent event){

            yourChoice = userInputTextField.getText();

            switch (position){
                case "First Town":
                    switch (yourChoice){
                        case "1": shop(); break;
                        case "2": barberShop(); break;
                        case "3": robBank(); break;
                        case "4": robSomeone(); break;
                        case "5": stables(); break;
                        case "6": anotherTown(); break;
                    }
                    break;
                case "Shop":
                    switch (yourChoice){
                        case "1":
                            userInputTextField.setText(null);
                            if (gold >= 20) {
                                gold -= 20;
                                Game.infoBox("You bought a Revolver\n(Your strength is now 2)");
                                strength = 2;
                                weapon = "Revolver";

                            } else Game.errorBox("You are unable to afford a Revolver");
                            updateStats();
                            break;
                        case "2":
                            userInputTextField.setText(null);
                            if (gold >= 40) {
                                gold -= 40;
                                Game.infoBox("You bought a Shotgun\n(Your strength is now 3)");
                                strength = 3;
                                weapon = "Shotgun";

                            } else Game.errorBox("You are unable to afford a Shotgun");
                            updateStats();
                            break;
                        case "3":
                            userInputTextField.setText(null);
                            if (maskBought == true) {
                                Game.errorBox("Sorry, we are all out of masks, try the next town over.");
                            } else if (gold >= 30) {

                                if (mask == false) {

                                    gold -= 30;
                                    Game.infoBox("You have bought a mask " +
                                            "\n(this will hide your identity when committing crimes)");
                                    mask = true;
                                    maskBought = true;

                                } else Game.errorBox("You already own a mast.");

                            } else Game.errorBox("You cannot afford a mask");
                            updateStats();
                            break;
                        case "4":
                            userInputTextField.setText(null);
                            if (gold >= 10) {

                                if (freshClothes == false) {

                                    gold -= 10;
                                    Game.infoBox("You have bought a fresh set of clothes.\n( - 40% notoriety)");
                                    notoriety -= 40;
                                    freshClothes = true;

                                } else Game.errorBox("You have already bought clothes in this town.");

                            } else Game.errorBox("You cannot afford clothes");
                            updateStats();
                            break;
                        case "5":
                            userInputTextField.setText(null);
                            if (amountOfSyringes <= 0) {

                                Game.errorBox("Shopkeeper: There are no syringes left");

                            } else if (amountOfSyringes > 0) {

                                Game.infoBox("You bought then injected yourself with the dirty syringe." +
                                        "\n( - 15 gold & + 10 health)");
                                amountOfSyringes = amountOfSyringes - 1;
                                gold -= 15;
                                health += 10;
                            }
                            updateStats();
                            break;
                        case "6":
                            userInputTextField.setText(null);
                            updateStats(); town();
                            break;
                    }
                    break;
                case "Rob Someone":
                    switch (yourChoice){
                        case "1": updateStats(); town(); break;
                    }
                    break;
                case "Barber":
                    switch (yourChoice) {
                        case "1":
                            userInputTextField.setText(null);
                            if (gold < 20) {
                                Game.errorBox("Barber: You do not have enough money buster.");
                            } else if (haircut == false) {
                                Game.infoBox("You have got a hair cut\n( - 60% notoriety)");
                                notoriety -= 60;
                                gold -= 20;
                                haircut = true;
                            } else Game.errorBox("Your hair is not long enough, try travelling.");
                            updateStats();
                            break;
                        case "2":
                            updateStats();
                            town();
                            break;
                    }
                    break;
                case "Bank":
                    switch (yourChoice) {
                        case "1": updateStats(); town(); break;
                    }
                    break;
                case "Stable":
                    switch (yourChoice){
                        case "1":
                            userInputTextField.setText(null);
                            if (gold >= 50) {
                                gold -= 50;
                                Game.infoBox("You bought a Stallion\n(You are able to travel)");
                                playerOwnsHorse = true;
                            } else Game.errorBox("You are unable to afford a Stallion");
                            updateStats();
                            break;
                        case "2":
                            updateStats(); town();break;
                    }
                    break;
                case "Another Town":
                    switch (yourChoice){
                        case "1":
                            userInputTextField.setText(null);
                            updateStats(); town(); break;
                        case "2":
                            if (playerOwnsHorse) {

                                System.out.println("You start your journey to the next town..." +
                                        "\n(Your hair grows)\n NEW AREA STILL IN DEVELOPMENT");
                                freshClothes = false;
                                haircut = false;
                                maskBought = false;

                            } else mainTextArea.setText("You have to own a horse to travel. " +
                                    "\n(go to the stables to buy one)\n1) Go back to Town");
                            break;

                    }
                    break;
            }
        }
    }
    public class FightHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();

            switch (position){
                case "Bank":
                    switch (yourChoice){
                        case "run":
                            attack.setVisible(false);
                            defend.setVisible(false);
                            run.setVisible(false);
                            inputPanelTwo.setVisible(false);
                            inputPanelTwo.setEnabled(false);
                            attack.setEnabled(false);
                            defend.setEnabled(false);
                            run.setEnabled(false);

                            inputPanel.setVisible(true);
                            enterB.setVisible(true);
                            userInputTextField.setVisible(true);
                            updateStats();
                            town();
                            break;
                        case "attack":
                            break;
                        case "defend":
                            break;
                    }
                    break;
            }

        }
    }
}