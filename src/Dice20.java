
public class Dice20 extends Dice{
	double numSides = 20;
	
	public void Roll(){
		if(rand > ((1/numSides)*(numSides-1))){
			System.out.println("You rolled a 20");
		}
		else if(rand > ((1/numSides)*(numSides-2))){
			System.out.println("You rolled a 19");
		}
		else if(rand > ((1/numSides)*(numSides-3))){
			System.out.println("You rolled a 18");
		}
		else if(rand > ((1/numSides)*(numSides-4))){
			System.out.println("You rolled a 17");
		}
		else if(rand > ((1/numSides)*(numSides-5))){
			System.out.println("You rolled a 16");
		}
		else if(rand > ((1/numSides)*(numSides-6))){
			System.out.println("You rolled a 15");
		}
		else if(rand > ((1/numSides)*(numSides-7))){
			System.out.println("You rolled a 14");
		}
		else if(rand > ((1/numSides)*(numSides-8))){
			System.out.println("You rolled a 13");
		}
		else if(rand > ((1/numSides)*(numSides-9))){
			System.out.println("You rolled a 12");
		}
		else if(rand > ((1/numSides)*(numSides-10))){
			System.out.println("You rolled a 11");
		}
		else if(rand > ((1/numSides)*(numSides-11))){
			System.out.println("You rolled a 10");
		}
		else if(rand > ((1/numSides)*(numSides-12))){
			System.out.println("You rolled a 9");
		}
		else if(rand > ((1/numSides)*(numSides-13))){
			System.out.println("You rolled a 8");
		}
		else if(rand > ((1/numSides)*(numSides-14))){
			System.out.println("You rolled a 7");
		}
		else if(rand > ((1/numSides)*(numSides-15))){
			System.out.println("You rolled a 6");
		}
		else if(rand > ((1/numSides)*(numSides-16))){
			System.out.println("You rolled a 5");
		}
		else if(rand > ((1/numSides)*(numSides-17))){
			System.out.println("You rolled a 4");
		}
		else if(rand > ((1/numSides)*(numSides-18))){
			System.out.println("You rolled a 3");
		}
		else if(rand > ((1/numSides)*(numSides-19))){
			System.out.println("You rolled a 2");
		}
		else{
			System.out.println("You rolled a 1");
		}
	}

}
