import java.util.Random;
import java.util.Scanner;

public class GamePlay {

	public void printInstructions() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to Dragon Slayer");

		boolean gameStartMenu = true;;
		while (gameStartMenu){
			System.out.println("Play [p], Instructions [i]");
			String answer = scan.next();

			if(answer.equals("i")){
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
			else if(answer.equals("p")){
				gameStartMenu = false;
			}
		}

	}
	//The below function is meant to be used for both players if a two player game
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
		while (player.playerIsDead() == false && enemy.enemyIsDead() == false) {

		}
	}

	public void PlayerControl(Player player, Map map){
		boolean control = true;

		boolean atTopEdge = false;
		boolean atBottomEdge = false;
		boolean atleftEdge =false;
		boolean atRightEdge = false;

		boolean atTopLeftCorner = false;
		boolean atTopRightCorner = false;
		boolean atBottomLeftCorner = false;
		boolean atBottomRightCorner = false;

		Scanner scan = new Scanner(System.in);
		while(control){
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


			if(playerMove.equals("w")){
				if(atTopLeftCorner){
					map.PrintMap();
					System.out.println("You can't move up anymore");
					
				}
				else if(atTopRightCorner){
					map.PrintMap();
					System.out.println("You can't move up anymore");
				}
				else if (atBottomRightCorner){
					player.MoveUp(map);
					map.PrintMap();
					enterDoor();
				}
				else if (atBottomLeftCorner){
					player.MoveUp(map);
					map.PrintMap();
					enterDoor();
				}
				else if (atTopEdge){
					map.PrintMap();
					System.out.println("You can't move up anymore");
				}
				else if(atBottomEdge){
					player.MoveUp(map);
					map.PrintMap();
					enterDoor();
				}
				else if (atleftEdge){
					player.MoveUp(map);
					map.PrintMap();
					enterDoor();
				}
				else if (atRightEdge){
					player.MoveUp(map);	
					map.PrintMap();
					enterDoor();
				}

				else{
					player.MoveUp(map);
					map.PrintMap();
					enterDoor();
				}

			}
			else if(playerMove.equals("s")){
		
				if(atTopLeftCorner){
					player.MoveDown(map);
					map.PrintMap();
					enterDoor();
				}
				else if(atTopRightCorner){
					player.MoveDown(map);
					map.PrintMap();
					enterDoor();
				}
				else if (atBottomRightCorner){
					map.PrintMap();
					System.out.println("You can't move down anymore (bottomRightCorner)");			
				}
				else if (atBottomLeftCorner){
					map.PrintMap();
					System.out.println("You can't move down anymore (bottomLeftCorner)");		
				}
				else if (atTopEdge){
					player.MoveDown(map);
					map.PrintMap();
					enterDoor();
				}
				else if(atBottomEdge){
					map.PrintMap();
					System.out.println("You can't move down anymore (BottomEdge)");
				}
				else if (atleftEdge){
					player.MoveDown(map);
					map.PrintMap();
					enterDoor();
				}
				else if (atRightEdge){
					player.MoveDown(map);	
					map.PrintMap();
					enterDoor();
				}
				else{
					player.MoveDown(map);
					map.PrintMap();
					enterDoor();
				}
			}
			else if(playerMove.equals("a")){
				if(atTopLeftCorner){
					map.PrintMap();
					System.out.println("You can't move left anymore");
				}
				else if(atTopRightCorner){
					player.MoveLeft(map);
					map.PrintMap();
					enterDoor();

				}
				else if (atBottomRightCorner){
					player.MoveLeft(map);
					map.PrintMap();
					enterDoor();
				}
				else if (atBottomLeftCorner){
					map.PrintMap();
					System.out.println("You can't move left anymore");
				}
				else if (atTopEdge){
					map.PrintMap();
					System.out.println("You can't move left anymore");
				}
				else if(atBottomEdge){
					player.MoveLeft(map);
					map.PrintMap();
					enterDoor();
				}
				else if (atleftEdge){
					map.PrintMap();
					System.out.println("You can't move left anymore");
				}
				else if (atRightEdge){
					player.MoveLeft(map);
					map.PrintMap();
					enterDoor();
				}
				else{
					player.MoveLeft(map);
					map.PrintMap();
					enterDoor();
				}

			}
			else if(playerMove.equals("d")){
		
				if(atTopLeftCorner){
					player.MoveRight(map);
					map.PrintMap();
					enterDoor();
				}
				else if(atTopRightCorner){
					map.PrintMap();
					System.out.println("You can't move right anymore");
				}
				else if (atBottomRightCorner){
					map.PrintMap();
					System.out.println("You can't move right anymore");
				}
				else if (atBottomLeftCorner){
					player.MoveRight(map);
					map.PrintMap();
					enterDoor();
				}
				else if (atTopEdge){
					player.MoveRight(map);
					map.PrintMap();
					enterDoor();
				}
				else if(atBottomEdge){
					player.MoveRight(map);
					map.PrintMap();
					enterDoor();
				}
				else if (atleftEdge){
					player.MoveRight(map);
					map.PrintMap();
					enterDoor();
				}
				else if (atRightEdge){
					map.PrintMap();
					System.out.println("You can't move right anymore");
				}
				else{
					player.MoveRight(map);
					map.PrintMap();
					enterDoor();
				}
			}
			else{
				System.out.println("Invalid Entry");
			}

		}
	}

	public Enemy randomEnemy() {
		Random rand = new Random();
		int value = rand.nextInt(10);
		switch (value) {
		case 0:
			System.out.println("You encounted a Bandit!");
			return new Enemy("Bandit", 10, 3);
		case 1:
			System.out.println("You encounted a Gremlin!");
			return new Enemy("Gremlin", 15, 4);
		case 2:
			System.out.println("You encounted a Smogger!");
			return new Enemy("Smogger", 20, 4);
		case 3:
			System.out.println("You encounted a Wolf!");
			return new Enemy("Wolf", 25, 5);
		case 4:
			System.out.println("You encounted a Golem!");
			return new Enemy("Golem", 30, 6);
		case 5:
			System.out.println("You encounted a Aerostiker!");
			return new Enemy("Aerostriker", 5, 40);
		case 6:
			System.out.println("You encounted a Zombie!");
			return new Enemy("Zombie", 50, 5);
		case 7:
			System.out.println("You encounted a Gargoyle!");
			return new Enemy("Gargoyle", 40, 10);
		case 8:
			System.out.println("You encounted a Behemoth!");
			return new Enemy("Behemoth", 50, 10);
		case 9:
			System.out.println("You encounted a Diablo!");
			return new Enemy("Diablo", 100, 20);
		default:
			System.out.println("You encounted a Cactuar!");
			return new Enemy("Cactuar", 100, 1);
		}
	}
	public Treasure randomTreasure(){
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





