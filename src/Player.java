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
	Dice[] playerDice = new Dice[6];

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

	public void selectAttack (Enemy enemy) {
		System.out.println("Which attack will you use: PHYSICAL, MAGIC, or LIMITBREAK?");
		Scanner scanner = new Scanner (System.in);
		String userInput = scanner.nextLine().toUpperCase();
		switch (userInput) {
		case "PHYSICAL":
			physicalAttack(enemy);
			break;
		case "MAGIC":
			magicAttack(enemy);
			break;
		case ("LIMITBREAK"):
			limitBreak(enemy);
		break;
		default:
			System.out.println("You shouldn't see this");
			break;
		}
	}

	public void physicalAttack (Enemy enemy) {
		enemy.health = enemy.health - (playerDice[2].roll * playerDice[0].roll + weapon.attackDamage);
	}

	public void magicAttack (Enemy enemy) {
		if (playerDice[3].roll <= 3) {
			enemy.health = enemy.health - (spells[0].spellDamage * playerDice[0].roll);
		  } else if (playerDice[3].roll <= 7) {
			  enemy.health = enemy.health - (spells[1].spellDamage * playerDice[0].roll);
		  } else {
			  enemy.health = enemy.health - (spells[2].spellDamage * playerDice[0].roll);
		  } 
	}

	public void limitBreak (Enemy enemy) {
		if (limitBreakStatus >= 100) {
			enemy.health = enemy.health - (50 * playerDice[0].roll);
		}
	}

	public boolean playerIsDead () {
		if (health > 0){
			return true;
		} else {
			return false;
		}
	}
/*-----------------------------------------------------------------------*/
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
	
/*----------------------------------------------------------------*/
	/*public void roll (DiceCup diceCup) {
		for (int i = 0; i < diceCup.diceArray.length; i++){
<<<<<<< HEAD
			diceCup.diceArray[i].Roll();
		
=======
			diceCup.diceArray[i].Roll();*/
	//I don't think we need the above function anymore, will use getDice for rolling.


		public void getDice () {
		DiceCup diceCup = new DiceCup();
		for (int i = 0; i < playerDice.length; i++){
			playerDice[i] = diceCup.diceArray[i];
		}
	}
	
	public void whatDidIRoll () {
		System.out.println("Your FOUR sided die: " + playerDice[0]);
		System.out.println("Your SIX sided die: " + playerDice[1]);
		System.out.println("Your EIGHT sided die: " + playerDice[2]);
		System.out.println("Your TEN sided die: " + playerDice[3]);
		System.out.println("Your TWELVE sided die: " + playerDice[4]);
		System.out.println("Your TWENTY sided die: " + playerDice[5]);
			
	}
	
	public void OpenTreasure(){
		
	}


	

	public void BottomRightCorner(Player player, Map map){
		player.MoveUp(map);
		player.MoveLeft(map);
	}
	
}

