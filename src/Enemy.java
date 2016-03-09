
public class Enemy extends Character{
	int attack;
	Treasure treasure = new Treasure();
	
	Enemy(String Name, int Health, int Attack) {
		super(Name, Health);
		attack = Attack;
		
	}
	//Likely need to inflate enemy attack values because defense is so high
	public void attackPlayer (Player player) {
		int defense = player.playerDice[4].roll + player.armor.armorBonus;
		if (attack - defense < 1) {
			System.out.println(player.name + "'s defense is so high," + name + "'s attack did no damage.");
			System.out.println();
		} else{
			player.health = player.health - (attack - defense);
			System.out.println(name + " did " + (attack - defense) + " damage to " + player.name);
			System.out.println();
		}
	}
	
	public boolean enemyIsDead () {
		if (health > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
