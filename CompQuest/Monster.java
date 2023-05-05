
import java.util.*;
import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class Monster extends Character{

	Random rand = new Random();
	
	ImageIcon icon = new ImageIcon("enemy.png");
	


	public Monster(){
	    this.name = "Bug";
	    this.health.setStat(15);
	    this.defense.setStat(15);
	    this.attack.setStat(15);
	}



	public Monster(int level){
	    int enemyType = rand.nextInt(3);
	    level = level/3;
	    this.gold = level;

	    if (enemyType == 1){
		this.name = "Malware Bot";
	        this.health.setStat(level + 2);
	        this.defense.setStat(level + 1);
	        this.attack.setStat(level - 1);
		this.icon = (new ImageIcon("enemy.png"));
	    } else if (enemyType == 2){
		this.name = "Swarm of Bugs";
		this.health.setStat(level);
		this.attack.setStat(level);
		this.defense.setStat(level);
		this.icon = (new ImageIcon("enemy2.png"));
	    } else if (enemyType == 0){
		this.name = "Rogue AI";
		this.health.setStat(level + 1);
		this.attack.setStat(level + 3);
		this.defense.setStat(level + 2);
		this.icon = (new ImageIcon("enemy3.png"));
	    }
	}

	public ImageIcon getIcon(){
		return icon;
	}//end getIcon
	    
	
}
