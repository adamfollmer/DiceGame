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
		Scanner scan = new Scanner(System.in);
		while(control){
			System.out.println("Up [w] Down [s] Left [a] Right [d]");
			String playerMove = scan.next();
			
			if(playerMove.equals("w")){
				player.MoveUp(map);
				map.PrintMap();
			}
			else if(playerMove.equals("s")){
				player.MoveDown(map);
				map.PrintMap();
			}
			else if(playerMove.equals("a")){
				player.MoveLeft(map);
				map.PrintMap();
			}
			else if(playerMove.equals("d")){
				player.MoveRight(map);
				map.PrintMap();
			}
			else{
				System.out.println("Invalid Entry");
			}
			
		}
	}
}	

	



