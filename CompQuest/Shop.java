//Simon G 
//Shop swing
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Shop extends JFrame implements ActionListener{

	int levelup = 100;
	Character user = new Character();
	MainMenu menuGUI;
	JPanel pnlItems = new JPanel();
	JPanel pnlFirstItem = new JPanel();
	JPanel pnlHeader = new JPanel();
	JPanel pnlHealth = new JPanel();
	JPanel pnlAttack = new JPanel();
	

	
	JLabel lblHealth = new JLabel();
	JLabel lblAttack = new JLabel();
	JLabel stats = new JLabel();
	JLabel coin = new JLabel();
	JLabel itemName1 = new JLabel();
	JLabel itemDesc1 = new JLabel();
	JButton btnItem1 = new JButton();
	JButton btnMenu = new JButton();
	JButton btnAttack = new JButton();
	JButton btnHealth = new JButton();


	public Shop(MainMenu menu){
		super();
		this.menuGUI = menu;
		this.setUser(menu.getUser());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container shopBuild = this.getContentPane();
		shopBuild.setLayout(new BorderLayout());
		shopBuild.setBackground(Color.LIGHT_GRAY);
			
		pnlItems.setLayout(new GridLayout(0,1));
		pnlItems.add(pnlFirstItem);

		pnlItems.add(pnlAttack);
		pnlItems.add(pnlHealth);
		pnlHeader.setLayout(new GridLayout(0,1));
		pnlHeader.add(stats);
		pnlHeader.add(coin);
		coin.setText("coins: " + user.getGold());
		stats.setText("attack: " + user.getStat("attack") + "  defense: " + user.getStat("defense") + "  health: " + user.getStat("health"));
		pnlFirstItem.setLayout(new GridLayout(1,0));
		pnlFirstItem.add(itemDesc1);
		pnlAttack.setLayout(new GridLayout(1,0));
		pnlHealth.setLayout(new GridLayout(1,0));
		pnlAttack.add(lblAttack);
		pnlAttack.add(btnAttack);
		pnlHealth.add(lblHealth);
		pnlHealth.add(btnHealth);
		shopBuild.add(pnlHeader, BorderLayout.NORTH);
		shopBuild.add(pnlItems, BorderLayout.CENTER);
		shopBuild.add(btnMenu, BorderLayout.SOUTH);
		
		btnItem1.setText(levelup + "c");
		btnAttack.setText(levelup + "c");
		btnHealth.setText(levelup + "c");

		btnMenu.setText("Back to Menu");
		btnItem1.addActionListener(this);
		btnMenu.addActionListener(this);
		btnAttack.addActionListener(this);
		btnHealth.addActionListener(this);
		pnlFirstItem.add(btnItem1);
		lblHealth.setText("Increase durability: +1 health ");  
		lblAttack.setText("Bigger Hammer: +1 attack       ");
		itemDesc1.setText("Upgrade Firewall: +1 defense   ");
		this.setVisible(false);
		this.pack();
	}



	public void actionPerformed(ActionEvent e){
		if (e.getSource() == btnItem1){
		    if(user.getGold() > levelup){
			    this.user.setStat("defense", (user.getStat("defense") + 1) );
			    user.loot(-(levelup));
			    levelup = levelup + 5;
		    }	
		    
		} else if (e.getSource() == btnAttack){
			if(user.getGold() > levelup){
				user.setStat("attack", (user.getStat("attack") + 1) );
				user.loot(-(levelup));
				levelup = levelup + 5;
			}
		}else if (e.getSource() == btnHealth){
			if (user.getGold() > levelup){
				user.setStat("health", (user.getStat("health") + 1));
				user.loot(-(levelup));
				levelup = levelup + 5;
			}
		}else if (e.getSource() == btnMenu){
			this.setVisible(false);
			this.menuGUI.setUser(this.user);
			this.menuGUI.refresh();
			this.menuGUI.setVisible(true);
		}
		btnItem1.setText(levelup + "c");
		btnAttack.setText(levelup + "c");
		btnHealth.setText(levelup + "c");
		coin.setText("coins: " + user.getGold());
		stats.setText("Attack: " + user.getStat("attack") + "  Defense: " + user.getStat("defense") + "  Health: " + user.getStat("health"));

	}		
			


/*
	public Shop(){
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container shopBuild = this.getContentPane();
		shopBuild.setLayout(new BorderLayout());
		shopBuild.add(pnlItems);
		pnlItems.setLayout(new GridLayout(0, 1));
		pnlItem1.setLayout(new GridLayout(0, 1));
		this.setVisible(false);
		pnlItems.add(pnlItem1);
		pnlItem1.add(itemName1);
		pnlItem1.add(itemDesc1);
		itemName1.setText("Fire Wall");
		itemDesc1.setText("+5 defense. 100 gold");
		this.setSize(350, 450);

	} //end constructor 

*/
	public void setUser(Character userNew){
		this.user = userNew;
	}//end getUser

}














