//Simon Greenaway
//Comp Quest main

import javax.swing.*;
import java.io.*;

public class CompQuest extends JFrame{
	
	Character user = new Character();

	public static void main(String args[]){

		CompQuest cQ = new CompQuest();
		cQ.setDefaultLookAndFeelDecorated(true);
		try {
		    FileInputStream fileIn = new FileInputStream("player.dat");
		    ObjectInputStream objIn = new ObjectInputStream(fileIn);
		    cQ.setUser((Character)objIn.readObject());
		    MainMenu menu = new MainMenu(cQ.getUser());
		    menu.setVisible(true);
		} catch (Exception e){
		    Login login = new Login();
	            login.setVisible(true);
		}
/*
		CompQuest cQ = new CompQuest();
		MainMenu menuGUI = new MainMenu(cQ.loadPlayers());
		menuGUI.setDefaultLookAndFeelDecorated(true);
*/

	}//end main/test harness



    public Character loadPlayers(){
        try {
            FileInputStream fileIn = new FileInputStream("player.dat");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            this.user = (Character)objIn.readObject();
        } catch (Exception e){
           System.out.println(e.getMessage());
        }//loading players array
	return user;
    }//end loadPlayers

    public Character getUser(){
	    return this.user;
    }//end get User

    public void setUser(Character user){
	    this.user = user;
    }//end setUser

}
