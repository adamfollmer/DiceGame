import java.util.Random;

public class Treasure {
		Chest chest;
	public Treasure() {
		chest = this.populateTreasure();
	}

	public Chest populateTreasure() {
		Random rand = new Random();
		int value = rand.nextInt(3);
		if (value == 0) {
			return this.randomWeapon();
		} else if (value == 1) {
			return this.randomArmor();
		} else {
			return this.randomItem();
		}
	}

	public Chest randomWeapon() {
		Random rand = new Random();
		int value = rand.nextInt(10);
		switch (value) {
		case 0:
			return new Weapon("Buster Sword", 1, "WEAPON");
		case 1:
			return new Weapon("Mythril Saber", 2, "WEAPON");
		case 2:
			return new Weapon("Hardedge", 3, "WEAPON");
		case 3:
			return new Weapon("Organics", 3, "WEAPON");
		case 4:
			return new Weapon("Force Stealer", 4, "WEAPON");
		case 5:
			return new Weapon("Nail Bat", 4, "WEAPON");
		case 6:
			return new Weapon("Apocalypse", 5, "WEAPON");
		case 7:
			return new Weapon("Heaven's Cloud", 5, "WEAPON");
		case 8:
			return new Weapon("Ragnarok", 6, "WEAPON");
		case 9:
			return new Weapon("Ultima Weapon", 10, "WEAPON");
		default:
			return new Weapon("Starter Sword", 1, "WEAPON");
		}
	}

	public Chest randomArmor() {
		Random rand = new Random();
		int value = rand.nextInt(10);
		switch (value) {
		case 0:
			return new Armor("Bronze Bangle", 1, "ARMOR");
		case 1:
			return new Armor("Iron Bangle", 2, "ARMOR");
		case 2:
			return new Armor("Titan Bangle", 3, "ARMOR");
		case 3:
			return new Armor("Mythril Armlet", 3, "ARMOR");
		case 4:
			return new Armor("Carbon Bangle", 4, "ARMOR");
		case 5:
			return new Armor("Silver Armlet", 4, "ARMOR");
		case 6:
			return new Armor("Gold Armlet", 5, "ARMOR");
		case 7:
			return new Armor("Diamond Bangle", 5, "ARMOR");
		case 8:
			return new Armor("Crystal Bangle", 6, "ARMOR");
		case 9:
			return new Armor("Platinum Bangle", 10, "ARMOR");
		default:
			return new Armor("Starter Bangle", 1, "ARMOR");
		}
	}

	public Chest randomItem() {
		Random rand = new Random();
		int value = rand.nextInt(3);
		switch (value) {
		case 0:
			return new Item("Potion", 50, "ITEM");
		case 1:
			return new Item("Hi-Potion", 100, "ITEM");
		default:
			return new Item("Myster Potion", -25, "ITEM");
		}
	}

	public void PrintTreasure(){
		System.out.println(chest.name);
	}
}
