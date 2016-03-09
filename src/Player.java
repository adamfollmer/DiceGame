import java.util.ArrayList;

import java.util.Scanner;

public class Player extends Character{
	ArrayList<String> backpack = new ArrayList<String>();
	Weapon weapon = new Weapon ("Starter Sword", 1);
	Armor armor = new Armor ("Starter Armor", 1);
	Spell arcaneBlast = new Spell ("Arcane Blast", 1);
	Spell frostbolt = new Spell ("Frostbolt", 2);
	Spell fireball = new Spell ("Fireball", 3);
	Spell[] spells = {arcaneBlast, frostbolt, fireball};
	int limitBreakStatus = 0;
	int health = 100;

	int xCoordiante = 0;
	int yCoordinate = 0;

	public Player (String name, int health) {
		super(name, health);
	}

	public void status () {
		System.out.println("Your character's name is: " + name);
		System.out.println("Your health is at " + health + "/100");
		System.out.println("Your weapon: " + weapon.weaponName + ". It has a bonus attack of " + weapon.attackDamage +
				"\n Your armor: " + armor.armorName + ". It has bonus defense of " + armor.armorBonus);
		System.out.println("Your limit break meter is at " + limitBreakStatus);
	}

	public void selectAttack () {
		Scanner scanner = new Scanner (System.in);
		String userInput = scanner.nextLine().toUpperCase();
		switch (userInput) {
		case "PHYSICAL":
			physicalAttack();
			break;
		case "MAGIC":
			magicAttack();
			break;
		case ("LIMITBREAK"):
			limitBreak();
		break;
		default:
			System.out.println("You shouldn't see this");
			break;
		}
	}

	public void physicalAttack () {
		//totalDamage = dice8 * dice4 + player.weapon.attackDamage
	}

	public void magicAttack () {
		/*if (dice10 <= 3) {
		 * totalDamage = spells[0].spellDamage * dice4;
		 * } else if (dice 10 <= 7) {
		 * totalDamage = spells[1].spellDamage * dice4;
		 * } else {
		 * totalDamage = spells[2].spellDamage * dice4;
		 * } */
	}

	public void limitBreak () {
		//totalDamage = 50 * dice4;
	}



	public boolean playerIsDead () {
		if (health > 0){
			return true;
		} else {
			return false;
		}
	}

	public void MoveUp(Map map){
		xCoordiante = ((Map) map).getXCoordinate();
		yCoordinate = ((Map) map).getYCoordinate();

		map.map[xCoordiante][yCoordinate ]= "X";
		map.map[xCoordiante-1][yCoordinate ]= "O";

	}

	public void MoveDown(Map map){
		xCoordiante = map.getXCoordinate();
		yCoordinate = map.getYCoordinate();
		
		map.map[xCoordiante][yCoordinate ]= "X";
		map.map[xCoordiante+1][yCoordinate ]= "O";
	}

	public void MoveLeft(Map map){
		xCoordiante = map.getXCoordinate();
		yCoordinate = map.getYCoordinate();
		
		map.map[xCoordiante][yCoordinate ]= "X";
		map.map[xCoordiante][yCoordinate-1]= "O";
	}

	public void MoveRight(Map map){
		xCoordiante = map.getXCoordinate();
		yCoordinate = map.getYCoordinate();
		
		map.map[xCoordiante][yCoordinate ]= "X";
		map.map[xCoordiante][yCoordinate+1]= "O";
	}
	
	public void roll (DiceCup diceCup) {
		for (int i = 0; i < diceCup.diceArray.length; i++){
			diceCup.diceArray[i].Roll();
		}
			
	}




}

