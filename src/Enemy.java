
public class Enemy extends Character{
	int attack;
	String treasure;
	
	Enemy(String Name, int Health, int Attack, String Treasure) {
		super(Name, Health);
		attack = Attack;
		treasure = Treasure;
	}

	
	
}
