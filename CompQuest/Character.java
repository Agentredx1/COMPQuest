//Simon Greenaway Character class

import java.util.*;
import java.util.Random;
import java.io.*;

public class Character implements Serializable {

	String name = "Anon";
	Stat health = new Stat("health");
	Stat attack = new Stat("attack");
	Stat defense = new Stat("defense");
	int currentHealth = 0;
	int gold = 0;
	Random rand = new Random();


    public Character(String name){
	this.name = name;
    }//end constructor taking name

    public Character(){
	this.currentHealth = health.getStat();
    }//empty constructor


    public Character(int level){
	this.setGold(level);
	this.makeStats(level);
	this.currentHealth = health.getStat();
    }//end constructor taking the users level, to create enemies


    public void setName(String name){
	this.name = name;
    }//end set name


    public String getName(){
	return this.name;
    }//end getName


    public int getHealth(){
	return this.currentHealth;
    }//end getHealth, returning current health

    public void setHealth(){
	this.currentHealth = this.health.getStat();
    }//end setHealth


    public void setStat(String statName, int level){
	if (statName.equals("attack")){
	    attack.setStat(level);
	} else if (statName.equals("defense")){
	    defense.setStat(level);
	} else if (statName.equals("health")){
	    health.setStat(level);
	}
    }//end set stat


    public int getStat(String statName){
	int statValue = 0;
	if (statName.equals("attack")){
	    statValue =  attack.getStat();
	} else if (statName.equals("defense")){
	    statValue =  defense.getStat();
	} else if (statName.equals("health")){
	    statValue = health.getStat();
	}// end if else. Returning different values based on parameter
	
	return statValue;
    }//end get stat	
	

    public int getLevel(){
	int level = this.attack.getStat() + this.defense.getStat() + this.health.getStat();
    	//level doesnt mean much, but its all stats added together
	return level;
    }//end getLevel	


    public void makeStats(int level){
	level = level / 3 ;
	int high = level + 5;
	int low = level - 5;
	this.attack.setStat(level);
	this.defense.setStat(level);
	this.health.setStat(level);
    }//end makeStats


    public int rollHit(){
	int roll = attack.getStat() / 5;
	roll = rand.nextInt(20) + roll;
	return roll;
    }//end rollHit, seeing if attack hits


    public int rollDamage(){
	return  attack.getStat();
    }//end rollDamage, returns attack stat currently

   
    public void takeDamage(int dmg){
	this.currentHealth = this.currentHealth - dmg;
    }//end takeDamage


    public int getGold(){
	return this.gold;
    }//end getGold


    public int setGold(int level){
	int addGold = level;
	return addGold;
    }//end setGold

    public void loot(int gold){
	    this.gold = this.gold + gold;
    }//end loot

}//end Character


