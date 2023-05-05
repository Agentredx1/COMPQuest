Simon Greenaway
Final Project algorithm

export DISPLAY=:10 (for when things stop working)

Objective:
	Create a turn based fighter game (think something like pokemon), that implements a UI -
and demonstrates key aspects of OOP. 

User information:
	Having a way to serialize seperate users so they can save and reload their game.

Steps:
	1. Get user information. Verify and load corresponding user
	2. Display home menu. Options: (Fight, Shop, Save)
	3. if they chose fight:
	4. display fight UI, hide menu UI
	5. fight options: attack, ability, run
	6. Each "turn" the user choses something and the enemy attacks back.
	7. if either user or enemy have <=0, fight has been won
	8. add/subtract coins to  player total
	9. hide fight ui, display menu

	10. if they chose shop
	11. display shop, hide menu ui
	12. if user has enough gold, they can buy an item/upgrade
	13. subtract gold from their total and increase stats
	14. back to menu
	
	15. if they select save,
	16. serialize the character object into player.dat
