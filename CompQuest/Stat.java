//Simon Greenaway  Stat interface

import java.io.*;

public  class Stat implements Serializable{
	String name = "";
	int currentValue = 10;


    public Stat(){
    }//empty constructor


    public Stat(String name){
	this.name = name;
    }


    public int getStat(){
	return currentValue;
    }//end getStat


    public void setStat(int level){
	this.currentValue = level;
    }//end if greater than 0

}//end setStat
