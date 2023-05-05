//Simon Greenaway Item for CompQuest

public class Item {

	String name;
	Stat bonus;


	public Item(String itemName, String statName, int statBuff){
		this.name = itemName;
		this.bonus = new Stat(statName);
	        this.bonus.setStat(statBuff);	
	}


	public initItem(){



