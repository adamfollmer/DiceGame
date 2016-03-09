
public class AI extends Player{

	public AI(String name, int health) {
		super(name, health);
		
	}
	
	public void selectAttack (Enemy enemy){
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
	
	public void movement () {
		
	}
}
