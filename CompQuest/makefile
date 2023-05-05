CompQuest.class: CompQuest.java MainMenu.class Login.class FightSequence.class Character.class Stat.class Shop.class 
	javac -g CompQuest.java

FightSequence.class: FightSequence.java MainMenu.class Character.class Stat.class
	javac -g FightSequence.java

Shop.class: Shop.java MainMenu.class Character.class Stat.class
	javac -g Shop.java


MainMenu.class: MainMenu.java Login.class Character.class Stat.class
	javac -g MainMenu.java

Login.class: Login.java Character.class Stat.class
	javac -g Login.java

Monster.class: Monster.java Character.class Stat.class
	javac -g Monster.java

Character.class: Character.java Stat.class
	javac -g Character.java

Stat.class: Stat.java
	javac -g Stat.java

run: CompQuest.class
	java CompQuest

clean:
	rm *.class
	rm *.dat
