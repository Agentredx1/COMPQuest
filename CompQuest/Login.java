//Simon Greenaway

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
	
	//Array for serializing different users, maybe
	public ArrayList<Character> players = new ArrayList<Character>(1);;
	Character user = new Character();
	//user is passed between swing elements
	
	//UI elements
	JButton btnSubmit = new JButton("Continue");
	JLabel lblLogin = new JLabel("Enter your characters name");
	JLabel lblSpacer = new JLabel("");
	JPanel pnlLogin = new JPanel();	
	JTextField txtName = new JTextField("");


    public static void main(String args[]){
	new Login();
    }//end main


    public Login(){
	super("Login");
	//this.loadUser();
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setDefaultLookAndFeelDecorated(true);
	Container loginBuild = this.getContentPane();
	loginBuild.setLayout(new BorderLayout());
	pnlLogin.setLayout(new GridLayout(0,1));
	pnlLogin.add(lblSpacer);
	pnlLogin.add(lblLogin);
	loginBuild.add(txtName, BorderLayout.CENTER);
	loginBuild.add(pnlLogin, BorderLayout.NORTH);
	loginBuild.add(btnSubmit, BorderLayout.SOUTH);
	btnSubmit.addActionListener(this);
	this.setSize(300,100);
	this.setVisible(false);
    }//end constructor


    public void actionPerformed(ActionEvent e){
	String name = txtName.getText();
	this.user = new Character(name);
	MainMenu menu = new MainMenu(user);
	menu.setUser(this.user);
	menu.refresh();
	menu.setVisible(true);
	this.setVisible(false);
    }//end actionPerformed    "closes" itself and would load the user given their name 


    public void loadUser(){
	    try {
		FileInputStream fileIn = new FileInputStream("player.dat");
		ObjectInputStream objIn = new ObjectInputStream(fileIn);
		user = (Character)objIn.readObject();
	      } catch (Exception e){
	      	System.out.println(e.getMessage());
	      }
    }	    


 /*   
    public void loadPlayers(){
	try {	
	    FileInputStream fileIn = new FileInputStream("player.dat");
	    ObjectInputStream objIn = new ObjectInputStream(fileIn);
	    players = (ArrayList<Character>)objIn.readObject();
	} catch (Exception e){
	   System.out.println(e.getMessage() + "sad");
	}//loading players array
    }//end loadPlayers
*/


   public Character getLogin(){
	String name = txtName.getText();
	boolean playerExists = false;
	int i = 0;
	for (i = 0; i < players.size(); i++){
	    String playerName = (players.get(i)).getName();
	    if (name.equals(playerName)){
		this.user =  players.get(i);
		playerExists = true;
		i = players.size();
	    }//if name exists, set user to that Character
	}
	if(playerExists = false){
	    this.user = new Character(name);
	}//if name does not exist, make new character
	return this.user;
    }//end getLogin	


   public Character getUser() {
	return user;
   }//end get User


}//end Login swing UI


