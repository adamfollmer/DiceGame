
public class Enemy extends Character{
	int attack;
	String treasure;
	
	Enemy(String Name, int Health, int Attack, String Treasure) {
		super(Name, Health);
		attack = Attack;
		treasure = Treasure;
	}

	public void attackPlayer (Player player) {
		player.health = player.health - attack;
	}
	
	public boolean enemyIsDead () {
		if (health > 0) {
			return true;
		} else {
			return false;
		}
	}
}
