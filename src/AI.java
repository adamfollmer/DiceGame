
public class AI extends Player {

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
}
