import java.util.ArrayList;

import java.util.Scanner;

public class Player extends Character {
	ArrayList<Item> backpack = new ArrayList<Item>();
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
	boolean isAI = false;
	boolean playerOneTurn = true;
	boolean playerTwoTurn = true;
	
	String player1 ="1";
	String player2 = "2";
	
	
	public Player(String name, int health) {
		super(name, health);
		backpack.add(new Item("Potion", 50, "ITEM"));
	}

	public void status() {
		System.out.println("Your character's name is: " + name);
		System.out.println("Your health is at " + health + "/100");
		System.out.println("Your weapon: " + weapon.name + ". It has a bonus attack of " + weapon.generalStatBoost
				+ "\n Your armor: " + armor.name + ". It has bonus defense of " + armor.generalStatBoost);
		System.out.println("Your limit break meter is at " + limitBreakStatus);
		BackPackContents();
		System.out.println();
	}

	public void selectAttack(Enemy enemy) {
		System.out.println("Which attack will you use: PHYSICAL, MAGIC, or LIMITBREAK? (P, M, or L)");
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine().toUpperCase();
		switch (userInput) {
		case "PHYSICAL": 
		case "P":
			physicalAttack(enemy);
			break;
		case "MAGIC":
		case "M":
			magicAttack(enemy);
			break;
		case "LIMITBREAK":
		case "L":
			limitBreak(enemy);
			break;
		default:
			System.out.println("You shouldn't see this");
			break;
		}
	}

	public void physicalAttack(Enemy enemy) {
		enemy.health = enemy.health - (playerDice[2].roll * playerDice[0].roll + weapon.generalStatBoost);
		System.out.println(name + " did " + (playerDice[2].roll * playerDice[0].roll + weapon.generalStatBoost) + " damage to " + enemy.name);
	}

	public void magicAttack(Enemy enemy) {
		if (playerDice[3].roll <= 3) {
			enemy.health = enemy.health - (spells[0].spellDamage * playerDice[0].roll);
			System.out.println(name + " used " + spells[0].spellName + " and did " +(spells[0].spellDamage * playerDice[0].roll) + " damage.");
		} else if (playerDice[3].roll <= 7) {
			enemy.health = enemy.health - (spells[1].spellDamage * playerDice[0].roll);
			System.out.println(name + " used " + spells[1].spellName + " and did " +(spells[1].spellDamage * playerDice[1].roll) + " damage.");
		} else {
			enemy.health = enemy.health - (spells[2].spellDamage * playerDice[0].roll);
			System.out.println(name + " used " + spells[2].spellName + " and did " +(spells[2].spellDamage * playerDice[2].roll) + " damage.");
		}
	}

	public void limitBreak(Enemy enemy) {
		if (limitBreakStatus >= 100) {
			enemy.health = enemy.health - (50 * playerDice[0].roll + weapon.generalStatBoost);
			System.out.println(name + " used Limit Break! And did " + (50 * playerDice[0].roll + weapon.generalStatBoost) + " damage to " + enemy.name);
		} else {
			System.out.println(name + " doesn't have enough energy.");
		}
	}

	public boolean playerIsDead() {
		if (health > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void MoveUp(Map map) {
		xCoordiante = ((Map) map).getXCoordinate();
		yCoordinate = ((Map) map).getYCoordinate();

		
		map.map[xCoordiante][yCoordinate ]= "X";
		map.map[xCoordiante - 1][yCoordinate]= "O";
		
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
		map.map[xCoordiante+1][yCoordinate]= "O";
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
		map.map[xCoordiante][yCoordinate] = "X";
		map.map[xCoordiante][yCoordinate - 1] = "O";

	}

	public void MoveRight(Map map) {
		xCoordiante = map.getXCoordinate();
		yCoordinate = map.getYCoordinate();
		map.map[xCoordiante][yCoordinate] = "X";
		map.map[xCoordiante][yCoordinate + 1] = "O";
	}

	public void getDice() {
		DiceCup diceCup = new DiceCup();
		for (int i = 0; i < playerDice.length; i++) {
			playerDice[i] = diceCup.diceArray[i];
		}
		limitBreakStatus += playerDice[5].roll;
	}

	public void whatDidIRoll() {
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

	public void CheckTreasure(Chest chest, Map map) {
		Scanner scanner = new Scanner(System.in);
		if (chest.itemType.equals("ITEM")) {
			System.out.println(name + " found a " + chest.name + " that returns " + chest.generalStatBoost
					+ " health when used in battle.");
			backpack.add((Item) chest);
		} else {
			System.out.println(name + " found a " + chest.name + " that has a bonus of " + chest.generalStatBoost + ".");
			System.out.println("Do you want to keep it? YES or NO");
			if (scanner.nextLine().toUpperCase().equals("YES")) {
				EquipNew(chest);
			} else {
				System.out.println("You're keeping your old item.");
			}
		}
		map.PrintMap();
		System.out.println();
	}

	public void EquipNew(Chest chest) {
		if (chest.itemType.equals("WEAPON")) {
			weapon = (Weapon) chest;
			System.out.println(name +" equipped the " + weapon.name + ".");
		} else {
			armor = (Armor) chest;
			System.out.println(name + " equipped the " + armor.name + ".");
		}
	}
	
	public void BackPackContents() {
		System.out.print(name + " backpack's contains: ");
		for (Item item : backpack) {
			System.out.println(item.name);
		}
	}

	public void UseItem() {
		BackPackContents();
		if (backpack.isEmpty() == true) {
			System.out.println("There is nothing in your backpack to use");
		} else {
			System.out.println("What do you want to use?");
			Scanner scanner = new Scanner(System.in);
			String userInput = scanner.nextLine().toUpperCase();
			for (Item item : backpack) {
				if (item.name.toUpperCase().equals(userInput)) {
					if (item.generalStatBoost + health >= 100) {
						health = 100;
						System.out.println(name + " used a " + item.name);
						System.out.println(name + " healed back to full health");
					} else {
						health = item.generalStatBoost + health;
						System.out.println(name + " healed to " + health);
					}
					backpack.remove(item);
					break;
				}
			}
		}
	}
	
	public void CheckTreasureAI(Chest chest) {
		if (chest.itemType.equals("ITEM")) {
			System.out.println(
					name + " found a " + chest.name + " that returns " + chest.generalStatBoost + " health when used.");
			backpack.add((Item) chest);
		} else {
			System.out
					.println(name + " found a " + chest.name + " that has a bonus of " + chest.generalStatBoost + ".");
			if (chest.itemType.equals("WEAPON")) {
				if (chest.generalStatBoost > weapon.generalStatBoost) {
					EquipNew(chest);
				} else {
					System.out.println(name + " is keeping its old item.");
				}
			} else {
				if (chest.generalStatBoost > armor.generalStatBoost) {
					EquipNew(chest);
				} else {
					System.out.println(name + " is keeping its old item.");
				}
			}
		}
	}
}
