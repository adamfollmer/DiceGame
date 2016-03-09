import java.util.Random;
import java.util.Scanner;

public class GamePlay {

	public void printInstructions() {
		System.out.println("Welcome to Dragon Slayer");
		System.out.println();
		System.out.println("Your character will enter the maze, fight monsters, and collect gear.");
		System.out.println("Your goal is to get to the Dragon before your foe and slay it.");
		System.out.println();
		System.out.println("Here is an explanation of each dice: ");
		System.out.println("The 4 side dice controls your attack multiplier. \nThe 6 sided dice controls your movement"
				+ "\nThe 8 sided dice is your physical attack. \nThe 10 sided dice selects your magic spell."
				+ "\nThe 12 sided dice decides your defense against enemy attacks. \n The 20 sided dice adds to your Limit Break");
		System.out.println();
		System.out.println("For magic spells - you have three. If you roll less than a 4 it is your weakest spell."
				+ "\nIf you roll between a 4 and a 7 is a medium spell. \nIf you roll an 8 or more it is your most powerful spell.");
		System.out.println("All three spells become more powerful based on the attack multiplier.");
		System.out.println(
				"For physical attacks - your current weapon, the amount you roll, and the attack multiplier equal your total damage");
		System.out
				.println("Once your Limit Break hits 100, you can perform a special attack that does a lot of damage");
		System.out.println();
	}

	// The below function is meant to be used for both players if a two player
	// game
	public String playerName() {
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is your characters name?");
		String userInput = scanner.nextLine().toUpperCase();
		return userInput;
	}

	public int humanOrAI() {
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Do you want to play against another person or the computer?");
		System.out.println("Enter 1 for person or 2 for AI");
		int userInput = scanner.nextInt();
		return userInput;
	}

	public void battleSequence(Player player, Enemy enemy) {
		Random rand = new Random();
		while (player.playerIsDead() == false && enemy.enemyIsDead() == false) {
			if (rand.nextInt(1) == 0) {
				enemy.attackPlayer(player);
			} else {
				player.selectAttack(enemy);
			}
			System.out.println("Rerolling to set up a new attack!");
			player.getDice();
			player.combatRollAndStats(enemy);
		}
	}

	public void PlayerControl(Player player, Map map) {
		boolean control = true;

		boolean atTopEdge = false;
		boolean atBottomEdge = false;
		boolean atleftEdge = false;
		boolean atRightEdge = false;

		boolean atTopLeftCorner = false;
		boolean atTopRightCorner = false;
		boolean atBottomLeftCorner = false;
		boolean atBottomRightCorner = false;

		Scanner scan = new Scanner(System.in);
		while (control) {
			System.out.println("Up [w] Down [s] Left [a] Right [d]");
			String playerMove = scan.next();

			atTopEdge = map.CheckIfTopEdgeOfMap(map.getXCoordinate(), map.getYCoordinate());
			atBottomEdge = map.CheckIfBottomEdgeOfMap(map.getXCoordinate(), map.getYCoordinate());
			atleftEdge = map.CheckIfLeftEdgeOfMap(map.getXCoordinate(), map.getYCoordinate());
			atRightEdge = map.CheckIfRightEdgeOfMap(map.getXCoordinate(), map.getYCoordinate());

			atTopLeftCorner = map.CheckIfTopLeftCornerOfMap(map.getXCoordinate(), map.getYCoordinate());
			atTopRightCorner = map.CheckIfTopRightCornerOfMap(map.getXCoordinate(), map.getYCoordinate());
			atBottomLeftCorner = map.CheckIfBottomLeftCornerOfMap(map.getXCoordinate(), map.getYCoordinate());
			atBottomRightCorner = map.CheckIfBottomRightCornerOfMap(map.getXCoordinate(), map.getYCoordinate());

			if (playerMove.equals("w")) {
				if (atTopLeftCorner) {
					System.out.println("You can't move up anymore");
				} else if (atTopRightCorner) {
					System.out.println("You can't move up anymore");
				} else if (atBottomRightCorner) {
					player.MoveUp(map);
				} else if (atBottomLeftCorner) {
					player.MoveUp(map);
				} else if (atTopEdge) {
					System.out.println("You can't move up anymore");
				} else if (atBottomEdge) {
					player.MoveUp(map);
				} else if (atleftEdge) {
					player.MoveUp(map);
				} else if (atRightEdge) {
					player.MoveUp(map);
				}

				else {
					player.MoveUp(map);
				}
				map.PrintMap();

			} else if (playerMove.equals("s")) {
				/*
				 * player.MoveDown(map); map.PrintMap();
				 * map.CheckIfEdgeOfMap(map.getXCoordinate(),
				 * map.getYCoordinate());
				 */
				if (atTopLeftCorner) {
					player.MoveDown(map);
				} else if (atTopRightCorner) {
					player.MoveDown(map);
				} else if (atBottomRightCorner) {
					System.out.println("You can't move down anymore (bottomRightCorner)");
				} else if (atBottomLeftCorner) {
					System.out.println("You can't move down anymore (bottomLeftCorner)");
				} else if (atTopEdge) {
					player.MoveDown(map);
				} else if (atBottomEdge) {
					System.out.println("You can't move down anymore (BottomEdge)");
				} else if (atleftEdge) {
					player.MoveDown(map);
				} else if (atRightEdge) {
					player.MoveDown(map);
				} else {
					player.MoveDown(map);
				}
				map.PrintMap();

			} else if (playerMove.equals("a")) {
				/*
				 * player.MoveLeft(map); map.PrintMap();
				 * map.CheckIfEdgeOfMap(map.getXCoordinate(),
				 * map.getYCoordinate());
				 */
				if (atTopLeftCorner) {
					System.out.println("You can't move left anymore");
				} else if (atTopRightCorner) {
					player.MoveLeft(map);

				} else if (atBottomRightCorner) {
					player.MoveLeft(map);
				} else if (atBottomLeftCorner) {
					System.out.println("You can't move left anymore");
				} else if (atTopEdge) {
					System.out.println("You can't move left anymore");
				} else if (atBottomEdge) {
					player.MoveLeft(map);
				} else if (atleftEdge) {
					System.out.println("You can't move left anymore");
				} else if (atRightEdge) {
					player.MoveLeft(map);
				} else {
					player.MoveLeft(map);
				}
				map.PrintMap();

			} else if (playerMove.equals("d")) {
				/*
				 * player.MoveRight(map); map.PrintMap();
				 * map.CheckIfEdgeOfMap(map.getXCoordinate(),
				 * map.getYCoordinate());
				 */

				if (atTopLeftCorner) {
					player.MoveRight(map);
				} else if (atTopRightCorner) {
					System.out.println("You can't move right anymore");
				} else if (atBottomRightCorner) {
					System.out.println("You can't move right anymore");
				} else if (atBottomLeftCorner) {
					player.MoveRight(map);
				} else if (atTopEdge) {
					player.MoveRight(map);
				} else if (atBottomEdge) {
					player.MoveRight(map);
				} else if (atleftEdge) {
					player.MoveRight(map);
				} else if (atRightEdge) {
					System.out.println("You can't move right anymore");
				} else {
					player.MoveRight(map);
				}
				map.PrintMap();

			} else {
				System.out.println("Invalid Entry");
			}

		}
	}

	public Enemy randomEnemy() {
		Random rand = new Random();
		int value = rand.nextInt(10);
		switch (value) {
		case 0:
			return new Enemy("Bandit", 10, 3);
		case 1:
			return new Enemy("Gremlin", 15, 4);
		case 2:
			return new Enemy("Smogger", 20, 4);
		case 3:
			return new Enemy("Wolf", 25, 5);
		case 4:
			return new Enemy("Golem", 30, 6);
		case 5:
			return new Enemy("Aerostriker", 5, 40);
		case 6:
			return new Enemy("Zombie", 50, 5);
		case 7:
			return new Enemy("Gargoyle", 40, 10);
		case 8:
			return new Enemy("Behemoth", 50, 10);
		case 9:
			return new Enemy("Diablo", 100, 20);
		default:
			return new Enemy("Cactuar", 100, 1);
		}
	}

	public Treasure randomTreasure() {
		return new Treasure();
	}

	public void enterDoor() {
		Random rand = new Random();
		int value = rand.nextInt(3);
		switch (value) {
		case 0:
			randomEnemy();
			break;
		case 1:
			randomTreasure();
			break;
		default:
			System.out.println("You entered an empty room.");
			System.out.println();
			break;
		}
	}
}
