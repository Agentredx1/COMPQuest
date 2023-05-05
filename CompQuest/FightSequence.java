//FightSequence class


import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class FightSequence extends JFrame implements ActionListener{


	ArrayList<String> log = new ArrayList<String>(6);
 

	Character user;
	Monster monster = new Monster();
	MainMenu menuGUI;
	boolean battleWon = false;
	int turn = 0;
	//UI elements
	JLabel log1 = new JLabel();
       	JLabel log2 = new JLabel();
	JLabel log3 = new JLabel();
	JLabel log4 = new JLabel();
	JLabel log5 = new JLabel();
	JLabel log6 = new JLabel();
	JLabel userHP = new JLabel();
	JLabel monsterHP = new JLabel();
	JButton btnAttack = new JButton("Attack");
	JLabel txtWin = new JLabel("");
	JButton btnHeavy = new JButton("Charged Attack");
	
	JButton btnRun = new JButton("Run");
	JPanel pnlMenu = new JPanel();
	JPanel pnlBottom = new JPanel();
	JPanel pnlHeader = new JPanel();
	ImageIcon img = new ImageIcon("enemy.png");
	JLabel enemyImage = new JLabel(img);
	JPanel pnlCenter = new JPanel();
	
    public static void main(String args[]){
    }//end main


    public FightSequence(){
	super("hold on");
    }

    public FightSequence(MainMenu menu){
	super("Fight");
	menuGUI = menu;
	monster = new Monster(30);
	this.user = menuGUI.getUser();
	//returns user object from our menu
	Container pnlFight = this.getContentPane();
	pnlFight.setLayout(new BorderLayout());
	pnlCenter.setLayout(new GridLayout(0,1));
	pnlCenter.add(enemyImage);
	txtWin.setHorizontalAlignment(SwingConstants.CENTER);
	log1.setForeground(Color.GREEN);
	log2.setForeground(Color.RED);
	log3.setForeground(Color.GREEN);
	log4.setForeground(Color.RED);
	log5.setForeground(Color.GREEN);
	log6.setForeground(Color.RED);
	pnlCenter.setBackground(Color.LIGHT_GRAY);
	pnlFight.setBackground(Color.LIGHT_GRAY);
	
	pnlBottom.setLayout(new GridLayout(8,1));
	pnlBottom.add(pnlHeader);
	pnlBottom.add(pnlMenu);
	this.refresh(this.user);
	this.updateLog();
	pnlBottom.setBackground(Color.BLACK);
	pnlBottom.add(log1);
	pnlBottom.add(log2);
	pnlBottom.add(log3);
	pnlBottom.add(log4);
	pnlBottom.add(log5);
	pnlBottom.add(log6);
	

		
	pnlMenu.setLayout(new GridLayout(1,0));
	pnlMenu.add(btnAttack);
	pnlMenu.add(btnHeavy);
	pnlMenu.add(btnRun);
	btnAttack.addActionListener(this);
	btnHeavy.addActionListener(this);
	btnRun.addActionListener(this);
	userHP.setText("<html><span style =:'font-style:bold;font-size:14'>" + user.getName() + ": " + user.getHealth() + "/" + user.getStat("health") +("       ")+ "</span></html>");
	monsterHP.setText(monster.getName() + ": " + monster.getHealth() + "/" + monster.getStat("health"));
	pnlHeader.setLayout(new GridLayout(1,0));
	pnlHeader.add(userHP);
	pnlHeader.add(monsterHP);
	this.setSize(450, 550);
	this.setVisible(false);
	pnlFight.add(txtWin, BorderLayout.NORTH);
	pnlFight.add(pnlBottom, BorderLayout.SOUTH);
	pnlFight.add(pnlCenter, BorderLayout.CENTER);
    }//end constructor, formatting swing UI


    public void actionPerformed(ActionEvent e){
	if(e.getSource() == btnAttack){
	    if (user.rollHit() > monster.getStat("defense")){
		int dmg = user.rollDamage();
		dmg = dmg / 2;
		monster.takeDamage(dmg);				//1 = dmg
		log.add( 0, "You struck " + monster.getName() + " for " + dmg);
	    } else {
		log.add(0, "Your attack missed");
	    }
	} else if (e.getSource() == btnHeavy){
		int roll = user.rollHit() - 5;
		if (roll > monster.getStat("defense")){
			int dmg = user.rollDamage() * 2;
			log.add(0, "You attack recklessly, dealing " + dmg);
			monster.takeDamage(dmg);	
		}else{
			log.add(0, "Your attack was too slow and misses.");
		}
	} else if (e.getSource() == btnRun){
		user.loot(-3);
		this.updateUser();
	}


	if (monster.rollHit() > user.getStat("defense")){
		int dmg = monster.rollDamage();
		dmg = dmg - (user.getStat("defense")/2);
		user.takeDamage(dmg);
		log.add(0, monster.getName() + " hit you for " + dmg );
	} else {
		log.add(0, monster.getName() + " missed");
	}

        userHP.setText(user.getName() + ": " + user.getHealth() + "/" + user.getStat("health"));
        monsterHP.setText(monster.getName() + ": " + monster.getHealth() + "/" + monster.getStat("health"));
	
	this.updateLog();
	if ( battleWon ){
	    this.updateUser();
	} else if ( monster.getHealth() < 1 ){
	    txtWin.setText("You won! You earned " + monster.getGold() + " coins");
	    btnAttack.setText("continue");
	    btnRun.setText("continue");
	    btnHeavy.setText("continue");
	    battleWon = true;
            user.loot(monster.getGold());
	//check if enemy is dead
	} else if ( user.getHealth() < 1){
	    txtWin.setText("You have been defeated! You lost 2 coins");
	    btnAttack.setText("continue");
	    btnRun.setText("continue");
	    btnHeavy.setText("continue");
	    battleWon = true;
	    user.loot(-2);
	}//end if user is dead

    }//end actionPerformed








    public void updateUser(){
	    this.setVisible(false);
	    menuGUI.setUser(this.user);
	    menuGUI.refresh();
	    menuGUI.setVisible(true);
    }//return user to mainMenu


    public void refresh(Character userNew){
	    this.user = userNew;
	    battleWon = false;
	    user.setHealth();
	    monster = new Monster(30);
	    enemyImage.setIcon(monster.getIcon());
	    monster.setHealth();
	    txtWin.setText("");
	    userHP.setText(user.getName() + ": " + user.getHealth() + "/" + user.getStat("health"));
	    monsterHP.setText(monster.getName() + ": " + monster.getHealth() + "/" + monster.getStat("health"));
	    btnAttack.setText("Attack");
	    btnRun.setText("Run");
	    btnHeavy.setText("Charged Attack");
	    log.clear();
	    log.add(0, " ");
	    log.add(0, " ");
	    log.add(0, " ");
	    log.add(0, " ");
	    log.add(0, " ");
	    log.add(0, " ");
	    turn = 0;
	    this.updateLog();
	    this.setVisible(true);

    }

    public void updateLog(){
	    this.log1.setText(turn + ": " + log.get(1));
	    this.log2.setText(turn + ": " + log.get(0));
	    if (turn -1 <= 0) {
		this.log3.setText("0: ");
		this.log4.setText("0: ");
	    } else {
		this.log3.setText((turn - 1) + ": " + log.get(3));
	        this.log4.setText((turn - 1) + ": " + log.get(2));
	    }
	    if (turn - 2 <= 0){
	    	this.log5.setText("0: ");
		this.log6.setText("0: ");
	    } else {
		this.log5.setText((turn - 2) + ": " + log.get(5));
		this.log6.setText((turn - 2) + ": " + log.get(4));
	    }//end if else
	    turn = turn + 1;
    }//responible for log and turn count

}//end FightSequence
