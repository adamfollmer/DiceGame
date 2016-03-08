import java.util.ArrayList;

public class Player extends Character{
	ArrayList<String> backpack; //= new ArrayList<String>();
	Weapon weapon = new Weapon ("Starter Sword", 1);
	Armor armor = new Armor ("Starter Armor", 1);
	Spell arcaneBlast = new Spell ("Arcane Blast", 1);
	Spell frostbolt = new Spell ("Frostbolt", 2);
	Spell fireball = new Spell ("Fireball", 3);
	Spell[] spells = {arcaneBlast, frostbolt, fireball};
	int LimitBreakStatus = 0;
	
	public Player (String name, int health) {
		super(name, health);
	}
}
