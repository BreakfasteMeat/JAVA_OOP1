package MIDTERM_Practice_GW2;

public class Revenant extends Player{
	public Revenant(String username, String className, int MAX_hp){
		super(username, className, MAX_hp);
	}
	public static class Vindicator extends Revenant implements DPS{
		public Vindicator(String username){
			super(username,"Vindicator",16200);
		}

		@Override
		public int damageType(){
			return 1;
		}

		@Override
		public int attack(){
			return 3552;
		}
	}
	public static class Renegade extends Revenant implements DPS, BoonGiver{
		public Renegade(String username){
			super(username, "Renegade",17200);
		}

		@Override
		public int attack(){
			return 4020;
		}

		@Override
		public int damageType(){
			return 2;
		}

		@Override
		public int boons(){
			return 1;
		}
	}
	public static class Herald extends Revenant implements Kiter{
		public Herald(String username){
			super(username,"Herald",16700);
		}

		@Override
		public int kiteEnemy(){
			return 3000;
		}
	}
}
