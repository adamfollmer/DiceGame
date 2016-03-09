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
			System.out.println("You found a Buster Sword");
			return new Weapon("Buster Sword", 1);
		case 1:
			System.out.println("You found a Mythril Saber");
			return new Weapon("Mythril Saber", 2);
		case 2:
			System.out.println("You found a Hardedge");
			return new Weapon("Hardedge", 3);
		case 3:
			System.out.println("You found an Organics");
			return new Weapon("Organics", 3);
		case 4:
			System.out.println("You found a Force Stealer");
			return new Weapon("Force Stealer", 4);
		case 5:
			System.out.println("You found a Nail Bat");
			return new Weapon("Nail Bat", 4);
		case 6:
			System.out.println("You found an Apocalyse");
			return new Weapon("Apocalypse", 5);
		case 7:
			System.out.println("You found a Heaven's Cloud");
			return new Weapon("Heaven's Cloud", 5);
		case 8:
			System.out.println("You found a Ragnarok");
			return new Weapon("Ragnarok", 6);
		case 9:
			System.out.println("You found an Ultima Weapon");
			return new Weapon("Ultima Weapon", 10);
		default:
			System.out.println("You found a Starter Sword");
			return new Weapon("Starter Sword", 1);
		}
	}

	public Armor randomArmor() {
		Random rand = new Random();
		int value = rand.nextInt(10);
		switch (value) {
		case 0:
			System.out.println("You found a Bronze Bangle");
			return new Armor("Bronze Bangle", 1);
		case 1:
			System.out.println("You found an Iron Bangle");
			return new Armor("Iron Bangle", 2);
		case 2:
			System.out.println("You found a Titan Bangle");
			return new Armor("Titan Bangle", 3);
		case 3:
			System.out.println("You found a Mythril Armlet");
			return new Armor("Mythril Armlet", 3);
		case 4:
			System.out.println("You found a Carbon Bangle");
			return new Armor("Carbon Bangle", 4);
		case 5:
			System.out.println("You found a Silver Armlet");
			return new Armor("Silver Armlet", 4);
		case 6:
			System.out.println("You found a Gold Armlet");
			return new Armor("Gold Armlet", 5);
		case 7:
			System.out.println("You found a Diamond Bangle");
			return new Armor("Diamond Bangle", 5);
		case 8:
			System.out.println("You found a Crystal Bangle");
			return new Armor("Crystal Bangle", 6);
		case 9:
			System.out.println("You found a Platinum Bangle");
			return new Armor("Platinum Bangle", 10);
		default:
			System.out.println("You gound a Starter Bangle");
			return new Armor("Starter Bangle", 1);
		}
	}

	public Item randomItem() {
		Random rand = new Random();
		int value = rand.nextInt(3);
		switch (value) {
		case 0:
			System.out.println("You found a Potion");
			return new Item("Potion", 50);
		case 1:
			System.out.println("You found a Hi-Potion");
			return new Item("Hi-Potion", 100);
		default:
			System.out.println("You found a Muster Potion");
			return new Item("Myster Potion", -25);
		}
	}

}
