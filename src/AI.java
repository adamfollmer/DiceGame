import java.util.Random;
import java.util.Scanner;

public class AI extends Player {
	boolean computerTurn = true;

	public AI(String name, int health) {
		super(name, health);
	}

	public void selectAttack(Enemy enemy) {
		if (limitBreakStatus >= 100) {
			limitBreak(enemy);
		} else if (playerDice[2].roll >= 6) {
			physicalAttack(enemy);
		} else if (playerDice[3].roll >= 8) {
			magicAttack(enemy);
		} else if (playerDice[2].roll > 3) {
			physicalAttack(enemy);
		} else {
			magicAttack(enemy);
		}
	}

	public void CheckTreasure(Chest chest) {
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

	public void UseItem() {
		if (health <= 50 && backpack.isEmpty() == false) {
			for (Item item : backpack) {
				if (item.name.toUpperCase().equals("POTION")) {
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
				} else if (item.name.toUpperCase().equals("HI-POTION")) {
					System.out.println(name + " healed back to full health");
					backpack.remove(item);
					break;
				} else {
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

	public void movement() {
	}

	public void ComputerControl(AI computer, Map map, GamePlay gamePlay) {
		boolean isTurn = true;
		Random rand = new Random();
		int computerMove = rand.nextInt(4);
		boolean atTopEdge = false;
		boolean atBottomEdge = false;
		boolean atleftEdge = false;
		boolean atRightEdge = false;
		boolean atTopLeftCorner = false;
		boolean atTopRightCorner = false;
		boolean atBottomLeftCorner = false;
		boolean atBottomRightCorner = false;
		int moveCounter = computer.playerDice[1].roll;

		System.out.println("computer move rolled : " + computer.playerDice[1].roll);
		while (isTurn) {
			if (moveCounter <= 1) {
				isTurn = false;
			}
			atTopEdge = map.CheckIfTopEdgeOfMap(map.getXCoordinate(), map.getYCoordinate());
			atBottomEdge = map.CheckIfBottomEdgeOfMap(map.getXCoordinate(), map.getYCoordinate());
			atleftEdge = map.CheckIfLeftEdgeOfMap(map.getXCoordinate(), map.getYCoordinate());
			atRightEdge = map.CheckIfRightEdgeOfMap(map.getXCoordinate(), map.getYCoordinate());
			atTopLeftCorner = map.CheckIfTopLeftCornerOfMap(map.getXCoordinate(), map.getYCoordinate());
			atTopRightCorner = map.CheckIfTopRightCornerOfMap(map.getXCoordinate(), map.getYCoordinate());
			atBottomLeftCorner = map.CheckIfBottomLeftCornerOfMap(map.getXCoordinate(), map.getYCoordinate());
			atBottomRightCorner = map.CheckIfBottomRightCornerOfMap(map.getXCoordinate(), map.getYCoordinate());
			if (computerMove == 0) {
				if (atTopLeftCorner) {
					map.PrintMap();
					System.out.println("You can't move up anymore");
				} else if (atTopRightCorner) {
					map.PrintMap();
					System.out.println("You can't move up anymore");
				} else if (atBottomRightCorner) {
					ComputerMoveUp(map, computer, gamePlay);
					moveCounter--;
				} else if (atBottomLeftCorner) {
					ComputerMoveUp(map, computer, gamePlay);
					moveCounter--;
				} else if (atTopEdge) {
					map.PrintMap();
					System.out.println("You can't move up anymore");
				} else if (atBottomEdge) {
					ComputerMoveUp(map, computer, gamePlay);
					moveCounter--;
				} else if (atleftEdge) {
					ComputerMoveUp(map, computer, gamePlay);
					moveCounter--;
				} else if (atRightEdge) {
					ComputerMoveUp(map, computer, gamePlay);
					moveCounter--;
				} else {
					ComputerMoveUp(map, computer, gamePlay);
					moveCounter--;
				}
			} else if (computerMove == 1) {
				if (atTopLeftCorner) {
					computer.MoveDown(map);
					map.PrintMap();
					ComputerEnterDoor(computer, gamePlay, map);
					moveCounter--;
				} else if (atTopRightCorner) {
					computer.MoveDown(map);
					map.PrintMap();
					ComputerEnterDoor(computer, gamePlay, map);
					moveCounter--;
				} else if (atBottomRightCorner) {
					map.PrintMap();
					System.out.println("You can't move down anymore");
				} else if (atBottomLeftCorner) {
					map.PrintMap();
					System.out.println("You can't move down anymore");
				} else if (atTopEdge) {
					computer.MoveDown(map);
					map.PrintMap();
					ComputerEnterDoor(computer, gamePlay, map);
					moveCounter--;
				} else if (atBottomEdge) {
					map.PrintMap();
					System.out.println("You can't move down anymore");
				} else if (atleftEdge) {
					computer.MoveDown(map);
					map.PrintMap();
					ComputerEnterDoor(computer, gamePlay, map);
					moveCounter--;
				} else if (atRightEdge) {
					computer.MoveDown(map);
					map.PrintMap();
					ComputerEnterDoor(computer, gamePlay, map);
					moveCounter--;
				} else {
					computer.MoveDown(map);
					map.PrintMap();
					ComputerEnterDoor(computer, gamePlay, map);
					moveCounter--;
				}
			} else if (computerMove == 2) {
				if (atTopLeftCorner) {
					map.PrintMap();
					System.out.println("You can't move left anymore");
				} else if (atTopRightCorner) {
					computer.MoveLeft(map);
					map.PrintMap();
					ComputerEnterDoor(computer, gamePlay, map);
					moveCounter--;
				} else if (atBottomRightCorner) {
					computer.MoveLeft(map);
					map.PrintMap();
					ComputerEnterDoor(computer, gamePlay, map);
					moveCounter--;
				} else if (atBottomLeftCorner) {
					map.PrintMap();
					System.out.println("You can't move left anymore");
				} else if (atTopEdge) {
					map.PrintMap();
					System.out.println("You can't move left anymore");
				} else if (atBottomEdge) {
					computer.MoveLeft(map);
					map.PrintMap();
					ComputerEnterDoor(computer, gamePlay, map);
					moveCounter--;
				} else if (atleftEdge) {
					map.PrintMap();
					System.out.println("You can't move left anymore");
				} else if (atRightEdge) {
					computer.MoveLeft(map);
					map.PrintMap();
					ComputerEnterDoor(computer, gamePlay, map);
					moveCounter--;
				} else {
					computer.MoveLeft(map);
					map.PrintMap();
					ComputerEnterDoor(computer, gamePlay, map);
					moveCounter--;
				}
			} else if (computerMove == 3) {
				if (atTopLeftCorner) {
					computer.MoveRight(map);
					map.PrintMap();
					ComputerEnterDoor(computer, gamePlay, map);
					moveCounter--;
				} else if (atTopRightCorner) {
					map.PrintMap();
					System.out.println("You can't move right anymore");
				} else if (atBottomRightCorner) {
					map.PrintMap();
					System.out.println("You can't move right anymore");
				} else if (atBottomLeftCorner) {
					computer.MoveRight(map);
					map.PrintMap();
					ComputerEnterDoor(computer, gamePlay, map);
					moveCounter--;
				} else if (atTopEdge) {
					computer.MoveRight(map);
					map.PrintMap();
					ComputerEnterDoor(computer, gamePlay, map);
					moveCounter--;
				} else if (atBottomEdge) {
					computer.MoveRight(map);
					map.PrintMap();
					ComputerEnterDoor(computer, gamePlay, map);
					moveCounter--;
				} else if (atleftEdge) {
					computer.MoveRight(map);
					map.PrintMap();
					ComputerEnterDoor(computer, gamePlay, map);
					moveCounter--;
				} else if (atRightEdge) {
					map.PrintMap();
					System.out.println("You can't move right anymore");
				} else {
					computer.MoveRight(map);
					map.PrintMap();
					ComputerEnterDoor(computer, gamePlay, map);
					moveCounter--;
				}
			} else {
				map.PrintMap();
				System.out.println("Invalid Entry");
			}
			computer.status();
		}
	}

	public void ComputerEnterDoor(AI computer, GamePlay gamePlay, Map map) {
		Random rand = new Random();
		int value = rand.nextInt(3);
		switch (value) {
		case 0:
			gamePlay.battleSequence(computer, gamePlay.randomEnemy(), map);
			break;
		case 1:
			System.out.println("You found a treasure chest!");
			computer.CheckTreasure(gamePlay.randomTreasure());
			break;
		default:
			System.out.println("You entered an empty room.");
			// System.out.println();
			break;
		}
	}

	public void ComputerMoveUp(Map map, AI computer, GamePlay gamePlay) {
		computer.MoveUp(map);
		map.PrintMap();
		ComputerEnterDoor(computer, gamePlay, map);
	}
}
