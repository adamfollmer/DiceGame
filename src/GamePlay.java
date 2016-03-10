import java.util.Random;
import java.util.Scanner;

public class GamePlay {

	public void printInstructions(Player player1, Player player2, AI computer) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to Dragon Slayer");

		boolean gameStartMenu = true;
		;
		while (gameStartMenu) {
			System.out.println("Play [p], Instructions [i]");
			String answer = scan.next();

			if (answer.equals("i")) {
				System.out.println("Your character will enter the maze, fight monsters, and collect gear.");
				System.out.println("Your goal is to get to the Dragon before your foe and slay it.");
				System.out.println();
				System.out.println("Here is an explanation of each dice: ");
				System.out.println(
						"The 4 side dice controls your attack multiplier. \nThe 6 sided dice controls your movement"
								+ "\nThe 8 sided dice is your physical attack. \nThe 10 sided dice selects your magic spell."
								+ "\nThe 12 sided dice decides your defense against enemy attacks. \n The 20 sided dice adds to your Limit Break");
				System.out.println();
				System.out.println(
						"For magic spells - you have three. If you roll less than a 4 it is your weakest spell."
								+ "\nIf you roll between a 4 and a 7 is a medium spell. \nIf you roll an 8 or more it is your most powerful spell.");
				System.out.println("All three spells become more powerful based on the attack multiplier.");
				System.out.println(
						"For physical attacks - your current weapon, the amount you roll, and the attack multiplier equal your total damage");
				System.out.println(
						"Once your Limit Break hits 100, you can perform a special attack that does a lot of damage");
				System.out.println();
			} else if (answer.equals("p")) {
				int option = humanOrAI();

				if (option == 1) {
					player1.name = playerName();
					player2.name = playerName();
					player2.playerTwoTurn = true;
					computer.computerTurn = false;

				} else if (option == 2) {
					player1.name = playerName();
					computer.name = "Computer";
					player2.playerTwoTurn = false;
					computer.computerTurn = true;

				}

				gameStartMenu = false;
			}
		}

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
		Scanner scanner = new Scanner(System.in);
		System.out.println("Do you want to play against another person or the computer?");
		System.out.println("Enter [1] for person or [2] for AI");
		int userInput = scanner.nextInt();
		return userInput;
	}

	public void battleSequence(Player player, Enemy enemy, Map map) {
		System.out.println("You encountered a " + enemy.name);
		Random rand = new Random();
		while (player.health >= 0 && enemy.health >= 0) {
			player.combatRollAndStats(enemy);
			if (rand.nextInt(1) == 0) {
				enemy.attackPlayer(player);
				player.selectAttack(enemy);
			} else {
				player.selectAttack(enemy);
				enemy.attackPlayer(player);
			}
			if (enemy.health >= 0) {
				System.out.println("Rerolling to set up a new attack!");
				player.getDice();
			}
		}
		if (enemy.enemyIsDead() == true) {
			Chest chest = enemy.treasure.chest;
			System.out.println("The enemy dropped a chest!");
			player.CheckTreasure(chest, map);

		}
	}

	public void PlayerControl(Player player, Map map) {
		boolean isTurn = true;

		boolean atTopEdge = false;
		boolean atBottomEdge = false;
		boolean atleftEdge = false;
		boolean atRightEdge = false;

		boolean atTopLeftCorner = false;
		boolean atTopRightCorner = false;
		boolean atBottomLeftCorner = false;
		boolean atBottomRightCorner = false;

		Scanner scan = new Scanner(System.in);
		int moveCounter = player.playerDice[1].roll;

		System.out.println("Moves left " + moveCounter);
		while (isTurn) {
			if(moveCounter <= 1){

				isTurn = false;
			}

			System.out.println("Up [w] Down [s] Left [a] Right [d] Character [c] Use Items [i]");
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
					map.PrintMap();
					System.out.println(player.name + " can't move up anymore");
				
				} else if (atTopRightCorner) {
					map.PrintMap();
					System.out.println(player.name + " can't move up anymore");
				} else if (atBottomRightCorner) {
					player.MoveUp(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				} else if (atBottomLeftCorner) {
					player.MoveUp(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				} else if (atTopEdge) {
					map.PrintMap();
					System.out.println(player.name + " can't move up anymore");
				} else if (atBottomEdge) {
					player.MoveUp(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				} else if (atleftEdge) {
					player.MoveUp(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				} else if (atRightEdge) {
					player.MoveUp(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				}

				else {
					player.MoveUp(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				}

			} else if (playerMove.equals("s")) {

				if (atTopLeftCorner) {
					player.MoveDown(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				} else if (atTopRightCorner) {
					player.MoveDown(map);
					map.PrintMap();
					moveCounter--;
					enterDoor(player, map);
				} else if (atBottomRightCorner) {
					map.PrintMap();
					System.out.println(player.name + " can't move up anymore");
				} else if (atBottomLeftCorner) {
					map.PrintMap();
					System.out.println(player.name + " can't move up anymore");
				} else if (atTopEdge) {
					player.MoveDown(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				} else if (atBottomEdge) {
					map.PrintMap();
					System.out.println(player.name + " can't move up anymore");
				} else if (atleftEdge) {
					player.MoveDown(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				} else if (atRightEdge) {
					player.MoveDown(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				} else {
					player.MoveDown(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				}
			} else if (playerMove.equals("a")) {
				if (atTopLeftCorner) {
					map.PrintMap();
					System.out.println(player.name + " can't move up anymore");
				} else if (atTopRightCorner) {
					player.MoveLeft(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;

				} else if (atBottomRightCorner) {
					player.MoveLeft(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				} else if (atBottomLeftCorner) {
					map.PrintMap();
					System.out.println(player.name + " can't move up anymore");
				} else if (atTopEdge) {
					map.PrintMap();
					System.out.println(player.name + " can't move up anymore");
				} else if (atBottomEdge) {
					player.MoveLeft(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				} else if (atleftEdge) {
					map.PrintMap();
					System.out.println(player.name + " can't move up anymore");
				} else if (atRightEdge) {
					player.MoveLeft(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				} else {
					player.MoveLeft(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				}

			} else if (playerMove.equals("d")) {

				if (atTopLeftCorner) {
					player.MoveRight(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				} else if (atTopRightCorner) {
					map.PrintMap();
					System.out.println(player.name + " can't move up anymore");
				} else if (atBottomRightCorner) {
					map.PrintMap();
					System.out.println(player.name + " can't move up anymore");
				} else if (atBottomLeftCorner) {
					player.MoveRight(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				} else if (atTopEdge) {
					player.MoveRight(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				} else if (atBottomEdge) {
					player.MoveRight(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				} else if (atleftEdge) {
					player.MoveRight(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				} else if (atRightEdge) {
					map.PrintMap();
					System.out.println(player.name + " can't move up anymore");
				} else {
					player.MoveRight(map);
					map.PrintMap();
					enterDoor(player, map);
					moveCounter--;
				}
			} 
			else if(playerMove.equals("c")){
				player.status();
			}
			else if(playerMove.equals("i")){
				player.UseItem();
			}
			else {
				map.PrintMap();
				System.out.println("Invalid Entry");
			}
			System.out.println("Moves left : " + moveCounter);
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

	public Chest randomTreasure() {
		return new Treasure().chest;
	}

	public void enterDoor(Player player, Map map) {
		Random rand = new Random();
		int value = rand.nextInt(3);
		switch (value) {
		case 0:
			battleSequence(player, randomEnemy(), map);
			break;
		case 1:
			System.out.println(player.name + " found a treasure chest!");
			player.CheckTreasure(randomTreasure(), map);

			break;
		default:
			System.out.println(player.name + " entered an empty room.");
			// System.out.println();
			break;
		}
	}

	/*
	 * public void CreatePlayer(){ Player player1 = new Player("Player1", 100);
	 * }
	 */

	public void PlayerTurn(Player player, Map map) {

		player.getDice();
		System.out.println(player.name + ":");
		player.whatDidIRoll();
		System.out.println();
		map.PrintMap();
		PlayerControl(player, map);
	}

	public void ComputerTurn(AI computer, Map map, GamePlay gamePlay) {
		computer.getDice();
		System.out.println(computer.name + ":");
		computer.whatDidIRoll();
		System.out.println();
		computer.ComputerControl(computer, map, gamePlay);
	}

	public void GameTurn(Player player1, Player player2, AI computerPlayer, Map map, GamePlay gamePlay) {
		boolean stillPlay = true;

		while (player1.playerOneTurn || player2.playerTwoTurn || stillPlay || computerPlayer.computerTurn) {
			if (player1.playerOneTurn) {
				System.out.println();
				PlayerTurn(player1, map);
				player1.playerOneTurn = false;
			} else if (player2.playerTwoTurn) {
				System.out.println();
				PlayerTurn(player2, map);
				player1.playerOneTurn = true;
				player2.playerTwoTurn = false;
				computerPlayer.computerTurn = false;
			} else if (computerPlayer.computerTurn) {
				System.out.println();
				ComputerTurn(computerPlayer, map, gamePlay);
				player1.playerOneTurn = true;
				player2.playerTwoTurn = false;
				computerPlayer.computerTurn = false;
			}
		}
	}
}
