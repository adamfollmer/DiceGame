import java.util.ArrayList;

import java.util.Scanner;

public class Player extends Character {
	ArrayList<String> backpack = new ArrayList<String>();
	Weapon weapon = new Weapon("Starter Sword", 1, "WEAPON");
	Armor armor = new Armor("Starter Armor", 1, "ARMOR");
	Spell arcaneBlast = new Spell("Arcane Blast", 1);
	Spell frostbolt = new Spell("Frostbolt", 2);
	Spell fireball = new Spell("Fireball", 3);
	Spell[] spells = { arcaneBlast, frostbolt, fireball };
	int limitBreakStatus = 0;
	int health = 100;
	int xCoordiante = 0;
	int yCoordinate = 0;
	Dice[] playerDice = new Dice[6];

	boolean playerOneTurn = true;
	boolean playerTwoTurn = true;
	
	String player1 ="1";
	String player2 = "2";
	
	
	public Player(String name, int health) {
		super(name, health);
	}

	public void status() {
		System.out.println("Your character's name is: " + name);
		System.out.println("Your health is at " + health + "/100");
		System.out.println("Your weapon: " + weapon.name + ". It has a bonus attack of " + weapon.generalStatBoost
				+ "\n Your armor: " + armor.name + ". It has bonus defense of " + armor.generalStatBoost);
		System.out.println("Your limit break meter is at " + limitBreakStatus);
	}

	public void selectAttack(Enemy enemy) {
		System.out.println("Which attack will you use: PHYSICAL, MAGIC, or LIMITBREAK?");
		Scanner scanner = new Scanner(System.in);
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

	public void physicalAttack(Enemy enemy) {
		enemy.health = enemy.health - (playerDice[2].roll * playerDice[0].roll + weapon.generalStatBoost);
	}

	public void magicAttack(Enemy enemy) {
		if (playerDice[3].roll <= 3) {
			enemy.health = enemy.health - (spells[0].spellDamage * playerDice[0].roll);
		} else if (playerDice[3].roll <= 7) {
			enemy.health = enemy.health - (spells[1].spellDamage * playerDice[0].roll);
		} else {
			enemy.health = enemy.health - (spells[2].spellDamage * playerDice[0].roll);
		}
	}

	public void limitBreak(Enemy enemy) {
		if (limitBreakStatus >= 100) {
			enemy.health = enemy.health - (50 * playerDice[0].roll);
		}
	}

	public boolean playerIsDead() {
		if (health > 0) {
			return true;
		} else {
			return false;
		}
	}

	/*-----------------------------------------------------------------------*/
	public void MoveUp(Map map) {
		xCoordiante = ((Map) map).getXCoordinate();
		yCoordinate = ((Map) map).getYCoordinate();
		
		map.map[xCoordiante][yCoordinate ]= "X";
		map.map[xCoordiante - playerDice[1].roll][yCoordinate]= "O";
		
/*		
		if(playerOneTurn){
			map.map[xCoordiante][yCoordinate ]= "X";
			map.map[xCoordiante - playerDice[1].roll][yCoordinate ]= "1";
		}
		else if(playerTwoTurn){
			map.map[xCoordiante][yCoordinate ]= "X";
			map.map[xCoordiante - playerDice[1].roll][yCoordinate ]= "2";
		}
*/

	}

	public void MoveDown(Map map) {
		xCoordiante = map.getXCoordinate();
		yCoordinate = map.getYCoordinate();
		
		
		map.map[xCoordiante][yCoordinate ]= "X";
		map.map[xCoordiante+playerDice[1].roll][yCoordinate]= "O";
		/*
		if(playerOneTurn){
			map.map[xCoordiante][yCoordinate ]= "X";
			map.map[xCoordiante + playerDice[1].roll][yCoordinate ]= "1";
		}
		else if(playerTwoTurn){
			map.map[xCoordiante][yCoordinate ]= "X";
			map.map[xCoordiante + playerDice[1].roll][yCoordinate ]= "2";
		}
*/
	}

	public void MoveLeft(Map map) {
		xCoordiante = map.getXCoordinate();
		yCoordinate = map.getYCoordinate();
		map.map[xCoordiante][yCoordinate ]= "X";
		map.map[xCoordiante][yCoordinate-playerDice[1].roll]= "O";
	
	}

	public void MoveRight(Map map) {
		xCoordiante = map.getXCoordinate();
		yCoordinate = map.getYCoordinate();
		map.map[xCoordiante][yCoordinate ]= "X";
		map.map[xCoordiante][yCoordinate+playerDice[1].roll]= "O";
	}

	public void getDice() {
		DiceCup diceCup = new DiceCup();
		for (int i = 0; i < playerDice.length; i++) {
			playerDice[i] = diceCup.diceArray[i];
		}
		limitBreakStatus += playerDice[5].roll;
	}
	
	public void whatDidIRoll () {
		System.out.println("Your ATTACK MULTIPLIER die: " + playerDice[0].roll);
		System.out.println("Your MOVEMENT die: " + playerDice[1].roll);
		System.out.println("Your PHYSICAL ATTACK die: " + playerDice[2].roll);
		System.out.println("Your MAGIC ATTACK die: " + playerDice[3].roll);
		System.out.println("Your DEFENSE BONUS die: " + playerDice[4].roll);
		System.out.println("Your LIMIT BREAK die: " + playerDice[5].roll);
	}

	public void combatRollAndStats(Enemy enemy) {
		System.out.println("Your ATTACK MULTIPLIER die: " + playerDice[0].roll);
		System.out.println("Your PHYSICAL ATTACK die: " + playerDice[2].roll);
		System.out.println("Your MAGIC ATTACK die: " + playerDice[3].roll);
		System.out.println("Your DEFENSE BONUS die: " + playerDice[4].roll);
		System.out.println("Your LIMIT BREAK die: " + playerDice[5].roll);
		System.out.println();
		System.out.println("Health: " + health + "/100");
		System.out.println("Limit Break: " + limitBreakStatus + "/100");
		System.out.println("Enemy health remaining: " + enemy.health);
	}


	public void BottomRightCorner(Player player, Map map) {
		player.MoveUp(map);
		player.MoveLeft(map);
	}

	public void CheckTreasure(Chest chest) {
		Scanner scanner = new Scanner(System.in);
		if (chest.itemType.equals("ITEM")) {
			System.out.println("You found a " + chest.name + " that returns " + chest.generalStatBoost
					+ " health when used in battle.");
			// addItem to backpack
		} else {
			System.out.println("You found a " + chest.name + " that has a bonus of " + chest.generalStatBoost + ".");
			System.out.println("Do you want to keep it?");
			if (scanner.nextLine().toUpperCase().equals("YES")) {
				// EquipGear Function
			} else {
				System.out.println("You're keeping your current item.");
			}

		}
		System.out.println();
	}
	
	public void EquipNew (Chest chest){
		if (chest.itemType.equals("WEAPON")) {
			weapon = (Weapon) chest;
		} else {
			armor = (Armor) chest;
		}
	}
}
