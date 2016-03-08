
public class Enemy extends Character{
	int attack;
	Treasure treasure = new Treasure();
	
	Enemy(String Name, int Health, int Attack) {
		super(Name, Health);
		attack = Attack;
		
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
