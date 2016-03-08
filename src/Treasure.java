import java.util.Random;

public class Treasure {

	public Treasure() {
		this.populateTreasure();
	}

	public void populateTreasure() {
		Random rand = new Random();
		int value = rand.nextInt(3);
		if (value == 0) {
			this.randomWeapon();
		} else if (value == 1) {
			this.randomArmor();
		} else {
			this.randomItem();
		}
	}

	public Weapon randomWeapon() {
		Random rand = new Random();
		int value = rand.nextInt(10);
		switch (value) {
		case 0:
			return new Weapon("Buster Sword", 1);
		case 1:
			return new Weapon("Mythril Saber", 2);
		case 2:
			return new Weapon("Hardedge", 3);
		case 3:
			return new Weapon("Organics", 3);
		case 4:
			return new Weapon("Force Stealer", 4);
		case 5:
			return new Weapon("Nail Bat", 4);
		case 6:
			return new Weapon("Apocalypse", 5);
		case 7:
			return new Weapon("Heaven's Cloud", 5);
		case 8:
			return new Weapon("Ragnarok", 6);
		case 9:
			return new Weapon("Ultima Weapon", 10);
		default:
			return new Weapon("Starter Sword", 1);
		}
	}

	public Armor randomArmor() {
		Random rand = new Random();
		int value = rand.nextInt(10);
		switch (value) {
		case 0:
			return new Armor("Bronze Bangle", 1);
		case 1:
			return new Armor("Iron Bangle", 2);
		case 2:
			return new Armor("Titan Bangle", 3);
		case 3:
			return new Armor("Mythril Armlet", 3);
		case 4:
			return new Armor("Carbon Bangle", 4);
		case 5:
			return new Armor("Silver Armlet", 4);
		case 6:
			return new Armor("Gold Armlet", 5);
		case 7:
			return new Armor("Diamond Bangle", 5);
		case 8:
			return new Armor("Crystal Bangle", 6);
		case 9:
			return new Armor("Platinum Bangle", 10);
		default:
			return new Armor("Starter Bangle", 1);
		}
	}

	public Item randomItem() {
		Random rand = new Random();
		int value = rand.nextInt(3);
		switch (value) {
		case 0:
			return new Item("Potion", 50);
		case 1:
			return new Item("Hi-Potion", 100);
		default:
			return new Item("Myster Potion", -25);
		}
	}

}
