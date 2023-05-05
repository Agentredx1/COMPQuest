import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener {
	FightSequence fightGUI = new FightSequence();
	Character user = new Character("Player init Main");
	Shop shopGUI;
	//FightSequence fightGUI = new FightSequence(this);

	//UI elemenets
	JButton btnFight = new JButton("Fight");
	JButton btnShop = new JButton("Shop");
	JButton btnSave = new JButton("Save");
	JPanel pnlMenu = new JPanel();
	JLabel lblHeader = new JLabel();

	JLabel lblSpacerEast = new JLabel();
	JLabel lblSpacerWest = new JLabel();
	JPanel pnlEast = new JPanel();
	JPanel pnlWest = new JPanel();
  	//
	

    public static void main(String args[]) {
	  
}

  
  //Constructor
  //Building menu UI, Recieves user info
    public MainMenu(Character currentPlayer){
	super("COMPQuest");
	fightGUI = new FightSequence(this);
        user = currentPlayer;
	shopGUI = new Shop(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setDefaultLookAndFeelDecorated(true);
        Container menuBuild = this.getContentPane();
        menuBuild.setLayout(new BorderLayout());
	lblHeader.setText("<html><span style=:'font-size:15;'>" + "Welcome " + user.getName() + "  Gold:" + user.getGold() + "</span></html>" );     
	menuBuild.add(lblHeader, BorderLayout.NORTH);
	btnFight.setBackground(Color.LIGHT_GRAY);
	btnShop.setBackground(Color.LIGHT_GRAY);
	btnSave.setBackground(Color.LIGHT_GRAY);
	pnlMenu.setLayout(new GridLayout(0,1));
        pnlMenu.add(btnFight);
        pnlMenu.add(btnShop);
        pnlMenu.add(btnSave);

        btnFight.addActionListener(this);
        btnShop.addActionListener(this);
        btnSave.addActionListener(this);
        menuBuild.add(pnlMenu, BorderLayout.CENTER);
	lblSpacerWest.setText("        ");
	pnlWest.setBackground(Color.GRAY);
	pnlWest.add(lblSpacerWest);
	lblSpacerEast.setText("        ");
	pnlEast.setBackground(Color.GRAY);
	pnlEast.add(lblSpacerEast);
	menuBuild.add(pnlEast, BorderLayout.EAST);
	menuBuild.add(pnlWest, BorderLayout.WEST);
        this.setSize(350, 450);
        this.setVisible(false);
    }//end constructor


    public void actionPerformed(ActionEvent e){
	if (e.getSource() == btnFight){
	    fightGUI.refresh(this.user);
	    this.setVisible(false);
	} else if (e.getSource() == btnShop){
	    shopGUI.setUser(this.user);
	    shopGUI.setVisible(true);
	    this.setVisible(false);
	} else if (e.getSource() == btnSave){
	    this.save();
    	}      
    }//end actionPerfomed


    public void setUser(Character playerCharacter){
	user = playerCharacter;
    }//end setUser

    public void save(){
	    try {
		    FileOutputStream fileOut = new FileOutputStream("player.dat");
		    ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
		    objOut.writeObject(user);
	    } catch (Exception e){
		   System.out.println(e.getMessage());
		 }
	    } 

    public Character getUser(){
        return user;
    }//end getCharacter

    public void refresh(){
	lblHeader.setText("Welcome " + user.getName() + "  Gold:" + user.getGold());
    }//end refresh
}
